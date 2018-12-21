package com.flc.controller.system.teacher;


import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.ModelAndView;
import com.flc.controller.base.BaseController;
import com.flc.entity.Page;
import com.flc.entity.system.User;
import com.flc.util.AppUtil;
import com.flc.util.ObjectExcelView;
import com.flc.util.PageData;
import com.flc.util.PriUpLoadFile;
import com.flc.util.Jurisdiction;
import com.flc.util.Tools;
import com.flc.service.system.curriculum.CurriculumManager;
import com.flc.service.system.teacher.TeacherManager;

/** 
 * 说明：教员表
 * 创建人：FLC
 * 创建时间：2018-07-25
 */
@Controller
@RequestMapping(value="/teacher")
public class TeacherController extends BaseController {

	String menuUrl = "teacher/list.do"; //菜单地址(权限用)
	@Resource(name="teacherService")
	private TeacherManager teacherService;

	@Resource(name="curriculumService")
	private CurriculumManager curriculumService;
	private String saveFileName="teacher";//图片保存文件夹

	/**保存
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/save")
	public ModelAndView save(HttpServletRequest req,HttpSession session, @ModelAttribute("PageData") @Validated PageData pd , BindingResult br) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"新增Teacher");
		ModelAndView mv = this.getModelAndView();
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
		if(br.hasErrors()){
			mv.setViewName("save_result");
			return mv;
		}
		//image file的name值
		String ipath = PriUpLoadFile.uploadFile(req, session, "myfile");
		pd = this.getPageData();
		User u = (User) session.getAttribute("sessionUser");
		String curriculumtype = req.getParameter("curriculumtype");
		String identity = req.getParameter("identity");
		String NAME = req.getParameter("NAME");
		String INFO = req.getParameter("INFO");
		String REMARKS = req.getParameter("REMARKS");
		String NUMBEROFYEARS = req.getParameter("NUMBEROFYEARS");
		pd.put("NAME",NAME);
		pd.put("HEADPORTRAIT",  ipath);
		pd.put("INFO",INFO);
		pd.put("REMARKS",REMARKS);
		pd.put("NUMBEROFYEARS",NUMBEROFYEARS);//开发经验
		pd.put("IDENTITY", identity);
		if("教员".equals(identity)){
			pd.put("CURRICULUMTYPE", curriculumtype);
		}else if("班主任".equals(identity)){
			pd.put("CURRICULUMTYPE", "");
		}
		pd.put("TEACHER_ID", this.get32UUID());	//主键
		pd.put("CREATETIME", Tools.date2Str(new Date()));	//添加时间
		pd.put("CREATEUSER",u.getUSERNAME());
		teacherService.save(pd);
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}


	/**删除
	 * @param out
	 * @throws Exception
	 */
	@RequestMapping(value="/delete")
	public void delete(PrintWriter out,HttpSession session) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"删除Teacher");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return;} //校验权限
		PageData pd = new PageData();
		pd = this.getPageData();
		PageData priData = teacherService.findById(pd);//获取删除对象
		String priName=priData.getString("HEADPORTRAIT");
		
		teacherService.delete(pd);
		PriUpLoadFile.FileDelete(session,priName);
		out.write("success");
		out.close();
	}

	/**修改
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/edit")
	public ModelAndView edit(HttpServletRequest req,HttpSession session) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"修改Teacher");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String  teacherID=(String) session.getAttribute("teacherID");
		pd.put("TEACHER_ID", teacherID);
		PageData tepd=teacherService.findById(pd);
		MultipartRequest request = (MultipartRequest) req;
		MultipartFile pageImage = request.getFile("myfile");
		String name1 = pageImage.getOriginalFilename();
		//上传的图片是否有值
		if(name1 != null && ! "".equals(name1)){
			//还得删除原来图片
			String priName=tepd.getString("HEADPORTRAIT");
			PriUpLoadFile.FileDelete(session,priName);
			//获取上传的文件名称的
			String newPri=PriUpLoadFile.uploadFile(req, session,"myfile");//上传返回文件名称
			pd.put("HEADPORTRAIT",newPri);
		}else {
			pd.put("HEADPORTRAIT",tepd.getString("HEADPORTRAIT"));
			session.removeAttribute("teacherID");
		}
		User u = (User) session.getAttribute("sessionUser");
		String curriculumtype = req.getParameter("curriculumtype");
		String identity = req.getParameter("identity");
		String NAME = req.getParameter("NAME");
		String INFO = req.getParameter("INFO");
		String REMARKS = req.getParameter("REMARKS");
		String NUMBEROFYEARS = req.getParameter("NUMBEROFYEARS");
		pd.put("IDENTITY", identity);
		if("教员".equals(identity)){
			pd.put("CURRICULUMTYPE", curriculumtype);
		}else if("班主任".equals(identity)){
			pd.put("CURRICULUMTYPE", "");
		}
		pd.put("NAME",NAME);
		pd.put("INFO",INFO);
		pd.put("NUMBEROFYEARS",NUMBEROFYEARS);//开发经验
		pd.put("REMARKS",REMARKS);
		pd.put("CREATEUSER",u.getUSERNAME());
		teacherService.edit(pd);
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}

	/**列表
	 * @param page
	 * @throws Exception
	 */
	@RequestMapping(value="/list")
	public ModelAndView list(Page page) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"列表Teacher");
		//if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;} //校验权限(无权查看时页面会有提示,如果不注释掉这句代码就无法进入列表页面,所以根据情况是否加入本句代码)
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String keywords = pd.getString("keywords");				//关键词检索条件
		if(null != keywords && !"".equals(keywords)){
			pd.put("keywords", keywords.trim());
		}
		String lastStart = pd.getString("lastStart");			//开始时间检索
		if(null != lastStart && !"".equals(lastStart)){
			pd.put("lastStart", lastStart.trim());
		}
		String lastEnd = pd.getString("lastEnd");				//结束时间检索
		if(null != lastEnd && !"".equals(lastEnd)){
			pd.put("lastEnd", lastEnd.trim());
		}
		String identity = pd.getString("type");						//课程类型检索
		if(null != identity && !"".equals(identity)){
			pd.put("IDENTITY",identity);
		}
		page.setPd(pd);
		List<PageData>	varList = teacherService.list(page);	//列出Teacher列表
		for (PageData pdata : varList) {
			if(pdata.getString("HEADPORTRAIT")!=null){
				pdata.put("HEADPORTRAIT", PriUpLoadFile.getFilePath( pdata.getString("HEADPORTRAIT")));
			}
		}
		mv.setViewName("system/teacher/teacher_list");
		mv.addObject("varList", varList);
		mv.addObject("pd", pd);
		mv.addObject("QX",Jurisdiction.getHC());	//按钮权限
		return mv;
	}

	/**去新增页面
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/goAdd")
	public ModelAndView goAdd()throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		List<PageData> list = curriculumService.listAll(pd);
		mv.setViewName("system/teacher/teacher_edit");
		mv.addObject("list",list);
		mv.addObject("msg", "save");
		mv.addObject("pd", pd);
		return mv;
	}	

	/**去修改页面
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/goEdit")
	public ModelAndView goEdit(HttpSession session)throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd=teacherService.findById(pd);
		List<PageData> list = curriculumService.listAll(pd);
		if(pd.getString("HEADPORTRAIT")!=null){
			pd.put("HEADPORTRAIT", PriUpLoadFile.getFilePath( pd.getString("HEADPORTRAIT")));
		}
		mv.setViewName("system/teacher/teacher_edit");
		mv.addObject("msg", "edit");
		mv.addObject("list",list);
		mv.addObject("pd", pd);
		session.setAttribute("teacherID", pd.getString("TEACHER_ID"));
		return mv;
	}	

	/**批量删除
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/deleteAll")
	@ResponseBody
	public Object deleteAll() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"批量删除Teacher");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return null;} //校验权限
		PageData pd = new PageData();		
		Map<String,Object> map = new HashMap<String,Object>();
		pd = this.getPageData();
		List<PageData> pdList = new ArrayList<PageData>();
		String DATA_IDS = pd.getString("DATA_IDS");
		if(null != DATA_IDS && !"".equals(DATA_IDS)){
			String ArrayDATA_IDS[] = DATA_IDS.split(",");
			teacherService.deleteAll(ArrayDATA_IDS);
			pd.put("msg", "ok");
		}else{
			pd.put("msg", "no");
		}
		pdList.add(pd);
		map.put("list", pdList);
		return AppUtil.returnObject(pd, map);
	}

	/**导出到excel
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/excel")
	public ModelAndView exportExcel() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"导出Teacher到excel");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;}
		ModelAndView mv = new ModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String keywords = pd.getString("keywords");				//关键词检索条件
		if(null != keywords && !"".equals(keywords)){
			pd.put("keywords", keywords.trim());
		}
		String lastStart = pd.getString("lastStart");			//开始时间检索
		if(null != lastStart && !"".equals(lastStart)){
			pd.put("lastStart", lastStart.trim());
		}
		String lastEnd = pd.getString("lastEnd");				//结束时间检索
		if(null != lastEnd && !"".equals(lastEnd)){
			pd.put("lastEnd", lastEnd.trim());
		}
		String type = pd.getString("type");						//身份类型检索
		if(null != type && !"".equals(type)){
			pd.put("type",type);
		}
		Map<String,Object> dataMap = new HashMap<String,Object>();
		List<String> titles = new ArrayList<String>();
		titles.add("头像");	//1
		titles.add("姓名");	//2
		titles.add("课程类型");	//3
		titles.add("评价");	//4
		titles.add("从业年数");	//6
		titles.add("身份");//7
		titles.add("添加时间");	//8
		titles.add("创建人");	//9
		titles.add("备注");	//10
		titles.add("总记录数");//11
		dataMap.put("titles", titles);
		List<PageData> varOList = teacherService.listAll(pd);
		List<PageData> varList = new ArrayList<PageData>();
		String index = String.valueOf(varOList.size());
		for(int i=0;i<varOList.size();i++){
			PageData vpd = new PageData();
			vpd.put("var1", varOList.get(i).getString("HEADPORTRAIT"));	    //1
			vpd.put("var2", varOList.get(i).getString("NAME"));	    //2
			vpd.put("var3", varOList.get(i).getString("CURRICULUMTYPE"));	    //3
			vpd.put("var4", varOList.get(i).getString("INFO"));	    //5
			vpd.put("var5", varOList.get(i).getString("NUMBEROFYEARS"));//6
			vpd.put("var6", varOList.get(i).getString("IDENTITY"));//7
			vpd.put("var7", varOList.get(i).getString("CREATETIME"));	    //8
			vpd.put("var8", varOList.get(i).getString("CREATEUSER"));	    //9
			vpd.put("var9", varOList.get(i).getString("REMARKS"));	    //10
			if(i==0){
				vpd.put("var10",index);//11
			}
			varList.add(vpd);
		}
		dataMap.put("varList", varList);
		ObjectExcelView erv = new ObjectExcelView();
		mv = new ModelAndView(erv,dataMap);
		return mv;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder){
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format,true));
	}
}
