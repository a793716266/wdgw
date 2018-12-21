package com.flc.controller.system.classtype;

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
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.flc.controller.base.BaseController;
import com.flc.controller.system.upload.UploadController;
import com.flc.entity.Page;
import com.flc.util.AppUtil;
import com.flc.util.ObjectExcelView;
import com.flc.util.PageData;
import com.flc.util.Jurisdiction;
import com.flc.util.Tools;
import com.google.gson.Gson;
import com.flc.service.system.classtype.ClassTypeManager;
import com.flc.service.system.classtype.impl.ClassTypeService;

/** 
 * 说明：班级类型
 * 创建人：FLC
 * 创建时间：2018-07-28
 */
@Controller
@RequestMapping(value="/classtype")
public class ClassTypeController extends BaseController {
	
	String menuUrl = "classtype/list.do"; //菜单地址(权限用)
	@Resource(name="classtypeService")
	private ClassTypeManager classtypeService;
	private List<PageData> varList1 =null;//课程类型列表
	
	/**保存
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/save")
	public ModelAndView save(HttpSession s) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"新增ClassType");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("CLASSTYPE_ID", this.get32UUID());	//主键
		pd.put("CLASSLOGO", s.getAttribute("imageName"));
		classtypeService.save(pd);
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}
	
	/**删除
	 * @param out
	 * @throws Exception
	 */
	@RequestMapping(value="/delete")
	public void delete(PrintWriter out) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"删除ClassType");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return;} //校验权限
		PageData pd = new PageData();
		pd = this.getPageData();
		classtypeService.delete(pd);
		out.write("success");
		out.close();
	}
	
	/**修改
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/edit")
	public ModelAndView edit(HttpSession session) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"修改ClassType");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("CLASSLOGO", session.getAttribute("imageName"));
		classtypeService.edit(pd);
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}
	
	/**列表
	 * @param page
	 * @throws Exception
	 */
	@RequestMapping(value="/list")
	public ModelAndView list(Page page,HttpServletRequest request) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"列表ClassType");
		//if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;} //校验权限(无权查看时页面会有提示,如果不注释掉这句代码就无法进入列表页面,所以根据情况是否加入本句代码)
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String keywords = pd.getString("keywords");	//关键词检索条件
		request.getSession().setAttribute("keywords", keywords);
		String lastStart = pd.getString("lastStart");
		String lastEnd = pd.getString("lastEnd");
		if(null != keywords && !"".equals(keywords)){
			keywords = keywords.replaceAll(" ", "");
			pd.put("keywords", keywords.trim());
		}else{
			varList1 = classtypeService.list(page);//获取课程类型
		}
		if(null != lastStart && !"".equals(lastStart)){
			pd.put("lastStart", lastStart.trim());
		}
		if(null != lastEnd && !"".equals(lastEnd)){
			pd.put("lastEnd", lastEnd.trim());
		}
		page.setPd(pd);
		List<PageData>	varList = classtypeService.list(page);	//列出ClassType列表
		mv.setViewName("system/classtype/classtype_list");
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
		Date date = new Date();
		 String da = new SimpleDateFormat("yyyy-MM-dd").format(date); 
		 pd.put("CREATETIME", da);
		mv.setViewName("system/classtype/classtype_edit");
		mv.addObject("msg", "save");
		mv.addObject("pd", pd);
		mv.addObject("title", "新增");
		return mv;
	}	
	
	 /**去修改页面
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/goEdit")
	public ModelAndView goEdit(HttpSession session,HttpServletRequest request)throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd = classtypeService.findById(pd);	//根据ID读取
		
		String img=pd.get("CLASSLOGO").toString();
		session.setAttribute("imageName", img);
		request.setAttribute("kind", "classtype");
		String path=UploadController.getPath(request);
		String subjectImgPath=path+img;
		mv.addObject("upOrAdd","up");
		mv.addObject("subjectImgPath", subjectImgPath);
		
		mv.setViewName("system/classtype/classtype_edit");
		mv.addObject("msg", "edit");
		mv.addObject("pd", pd);
		mv.addObject("title", "修改");
		return mv;
	}	
	
	 /**批量删除
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/deleteAll")
	@ResponseBody
	public Object deleteAll() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"批量删除ClassType");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return null;} //校验权限
		PageData pd = new PageData();		
		Map<String,Object> map = new HashMap<String,Object>();
		pd = this.getPageData();
		List<PageData> pdList = new ArrayList<PageData>();
		String DATA_IDS = pd.getString("DATA_IDS");
		if(null != DATA_IDS && !"".equals(DATA_IDS)){
			String ArrayDATA_IDS[] = DATA_IDS.split(",");
			classtypeService.deleteAll(ArrayDATA_IDS);
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
	public ModelAndView exportExcel(HttpServletRequest request) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"导出ClassType到excel");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;}
		ModelAndView mv = new ModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		Map<String,Object> dataMap = new HashMap<String,Object>();
		List<String> titles = new ArrayList<String>();
		titles.add("班级类型名");	//1
		titles.add("班级LOGO");	//2
		titles.add("创建时间");	//3
		titles.add("创建用户");	//4
		titles.add("备注");	//5
		dataMap.put("titles", titles);
		String keywords = new String(request.getParameter("className").getBytes("ISO-8859-1"),"UTF-8"); 
		String lastStart = request.getParameter("lastStart");
		String lastEnd = request.getParameter("lastEnd");
		String name = request.getParameter("C_Type");
		if(null != keywords && !"".equals(keywords)){
			keywords = keywords.replaceAll(" ", "");
			pd.put("keywords", keywords.trim());
		}
		if(null != lastStart && !"".equals(lastStart)){
			pd.put("lastStart", lastStart.trim());
		}
		if(null != lastEnd && !"".equals(lastEnd)){
			pd.put("lastEnd", lastEnd.trim());
		}
		if(null != name && !"".equals(name)){
			pd.put("name", name.trim());
		}
		List<PageData> varOList = classtypeService.listAll(pd);
		List<PageData> varList = new ArrayList<PageData>();
		for(int i=0;i<varOList.size();i++){
			PageData vpd = new PageData();
			vpd.put("var1", varOList.get(i).getString("CLASSTYPENAME"));	    //1
			vpd.put("var2", varOList.get(i).getString("CLASSLOGO"));	    //2
			vpd.put("var3", varOList.get(i).getString("CREATETIME"));	    //3
			vpd.put("var4", varOList.get(i).getString("CREATEUSER"));	    //4
			vpd.put("var5", varOList.get(i).getString("REMARKS"));	    //5
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
	
	
	//验证班级名称是否存在
		@RequestMapping(value="/validationClassName")
		@ResponseBody
		public String validationClassName(HttpServletRequest request) throws Exception{
			String CLASSTYPE_ID = request.getParameter("CLASSTYPE_ID");
			PageData pd = new PageData();
			pd = this.getPageData();
			String title = request.getParameter("title");
			String className = request.getParameter("CLASSTYPENAME");
			Map<String,Object> map = new HashMap<String,Object>();
			if("修改".equals(title)){
				pd.put("CLASSTYPE_ID", CLASSTYPE_ID);
				PageData pageD = classtypeService.findById(pd);
				if(pageD!=null){
					map.put("errInfo", "添加班级类型名称已经存在，请重新输入！");
				}
			}else if("新增".equals(title)){
				if(className!=null){
					int count   = (Integer)classtypeService.validationClassName(className);
					if(count!=0){
						map.put("errInfo", "添加班级类型名称已经存在，请重新输入！");
					}
				}
			}
			return new Gson().toJson(map);
		};
}
