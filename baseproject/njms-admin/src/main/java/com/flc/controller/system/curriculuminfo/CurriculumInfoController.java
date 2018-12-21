package com.flc.controller.system.curriculuminfo;

import java.io.PrintWriter;
import java.lang.reflect.Type;
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
import org.springframework.web.bind.annotation.PathVariable;
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
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.flc.service.system.curriculum.CurriculumManager;
import com.flc.service.system.curriculuminfo.CurriculumInfoManager;

/**
 * 说明：课程详情表 创建人：FLC 创建时间：2018-07-24
 */
@Controller
@RequestMapping(value = "/curriculuminfo")
public class CurriculumInfoController extends BaseController {

	String menuUrl = "curriculuminfo/list.do"; // 菜单地址(权限用)
	@Resource(name = "curriculuminfoService")
	private CurriculumInfoManager curriculuminfoService;
	@Resource(name = "curriculumService")
	private CurriculumManager curriculumService;// 获取课程类型
	
	private String saveFileName="curriculuminfo";//图片保存文件夹

	/**
	 * 保存
	 * 
	 * @param out
	 * @throws Exception
	 */
	@RequestMapping(value = "/save")
	public ModelAndView save(HttpServletRequest myrequest, HttpSession session,
			@ModelAttribute("PageData") @Validated PageData pd, BindingResult br) throws Exception {
		logBefore(logger, Jurisdiction.getUsername() + "新增CurriculumInfo");
		if (!Jurisdiction.buttonJurisdiction(menuUrl, "add")) {
			return null;
		} // 校验权限
		ModelAndView mv = this.getModelAndView();
		if (br.hasErrors()) {
			mv.setViewName("save_result");
			return mv;
		}
		// myfile file的name值
		String imageName = PriUpLoadFile.uploadFile(myrequest, session, "myfile");
		pd = this.getPageData();
		User user = (User) session.getAttribute("sessionUser");
		String infoname = myrequest.getParameter("INFONAME");
		String wages = myrequest.getParameter("WAGES");
		String studytime = myrequest.getParameter("STUDYTIME");
		String remarks = myrequest.getParameter("REMARKS");
		pd.put("CURRICULUMINFO_ID", this.get32UUID()); // 主键
		pd.put("PICTURE",  imageName);
		pd.put("INFONAME", infoname);// 类型
		pd.put("WAGES", wages);// 就业工资
		pd.put("STUDYTIME", studytime);// 学习总时间
		pd.put("CREATEUSER", user.getUSERNAME());// 创建人
		pd.put("REMARKS", remarks);// 备注
		pd.put("CREATETIME", Tools.date2Str(new Date())); // 添加时间
		curriculuminfoService.save(pd);
		mv.addObject("msg", "success");
		mv.setViewName("save_result");
		return mv;
	}

	/**
	 * 删除
	 * 
	 * @param out
	 * @throws Exception
	 */
	@RequestMapping(value = "/delete")
	public void delete(PrintWriter out, HttpSession session) throws Exception {
		logBefore(logger, Jurisdiction.getUsername() + "删除CurriculumInfo");
		if (!Jurisdiction.buttonJurisdiction(menuUrl, "del")) {
			return;
		} // 校验权限
		PageData pd = new PageData();
		pd = this.getPageData();
		PageData priData=curriculuminfoService.findById(pd);
		String priName=priData.getString("PICTURE");
		curriculuminfoService.delete(pd);
		PriUpLoadFile.FileDelete(session, priName);
		out.write("success");
		out.close();
	}

	/**
	 * 修改
	 * 
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value = "/edit")
	public ModelAndView edit(HttpServletRequest myrequest, HttpSession session) throws Exception {
		logBefore(logger, Jurisdiction.getUsername() + "修改CurriculumInfo");
		if (!Jurisdiction.buttonJurisdiction(menuUrl, "edit")) {
			return null;
		} 
		// 校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = (PageData) session.getAttribute("curriculumInfo");// 要修改的对象
		PageData priData = curriculuminfoService.findById(pd); // 根据ID获取对象
		MultipartRequest request = (MultipartRequest) myrequest;
		
		MultipartFile pageImage = request.getFile("myfile");//获取名称
		String pri = pageImage.getOriginalFilename();//获取上传文件的原名
		//上传的图片是否有值
		if(pri != null && ! "".equals(pri)){
			// 还得删除原来图片File.separator文件"/"
			PriUpLoadFile.FileDelete(session,priData.getString("PICTURE"));//删除
			//获取上传的文件名称的
			String newPri=PriUpLoadFile.uploadFile(myrequest, session, "myfile");//上传返回文件名称
			pd.put("PICTURE",newPri);//图片
		}else {
			pd.put("PICTURE", priData.getString("PICTURE"));
			session.removeAttribute("curriculumInfo");
		}
		User user = (User) session.getAttribute("sessionUser");
		String infoname = myrequest.getParameter("INFONAME");
		String wages = myrequest.getParameter("WAGES");
		String studytime = myrequest.getParameter("STUDYTIME");
		String remarks = myrequest.getParameter("REMARKS");
		pd.put("INFONAME", infoname);// 类型
		pd.put("WAGES", wages);// 就业工资
		pd.put("STUDYTIME", studytime);// 学习总时间
		pd.put("CREATEUSER", user.getUSERNAME());// 创建人
		pd.put("REMARKS", remarks);// 备注
		pd.put("CREATETIME", Tools.date2Str(new Date())); // 添加时间
		curriculuminfoService.edit(pd);
		mv.addObject("msg", "success");
		mv.setViewName("save_result");
		return mv;
	}

	/**
	 * 列表
	 * 
	 * @param page
	 * @throws Exception
	 */
	@RequestMapping(value = "/list")
	public ModelAndView list(Page page) throws Exception {
		logBefore(logger, Jurisdiction.getUsername() + "列表CurriculumInfo");
		// if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;}
		// //校验权限(无权查看时页面会有提示,如果不注释掉这句代码就无法进入列表页面,所以根据情况是否加入本句代码)
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String c_type = pd.getString("c_type"); // 关键词检索条件
		if (null != c_type && !"".equals(c_type)) {
			pd.put("c_type", c_type.trim());
		}
		page.setPd(pd);
		List<PageData> varList = curriculuminfoService.list(page); // 列出CurriculumInfo列表
		for (PageData pdata : varList) {
			if(pdata.getString("PICTURE")!=null){
				pdata.put("PICTURE", PriUpLoadFile.getFilePath(pdata.getString("PICTURE")));
			}
		}
		mv.setViewName("system/curriculuminfo/curriculuminfo_list");
		mv.addObject("varList", varList);
		mv.addObject("allList", curriculumService.listAll(null));
		mv.addObject("pd", pd);
		mv.addObject("QX", Jurisdiction.getHC()); // 按钮权限
		return mv;
	}

	/**
	 * 去新增页面
	 * 
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value = "/goAdd")
	public ModelAndView goAdd() throws Exception {
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		mv.setViewName("system/curriculuminfo/curriculuminfo_edit");
		mv.addObject("msg", "save");
		mv.addObject("listAllC_Types", curriculumService.listAll(null));
		mv.addObject("pd", pd);
		return mv;
	}

	/**
	 * 去修改页面
	 * 
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value = "/goEdit")
	public ModelAndView goEdit(HttpSession session) throws Exception {
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd = curriculuminfoService.findById(pd); // 根据ID读取
		if(pd.getString("PICTURE")!=null){
			pd.put("PICTURE", PriUpLoadFile.getFilePath(pd.getString("PICTURE")));
		}
		mv.setViewName("system/curriculuminfo/curriculuminfo_edit");
		mv.addObject("msg", "edit");
		mv.addObject("pd", pd);
		mv.addObject("listAllC_Types", curriculumService.listAll(null));
		session.setAttribute("curriculumInfo", pd);// 修改的对象
		return mv;
	}

	/**
	 * 批量删除
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value = "/deleteAll")
	@ResponseBody
	public Object deleteAll() throws Exception {
		logBefore(logger, Jurisdiction.getUsername() + "批量删除CurriculumInfo");
		if (!Jurisdiction.buttonJurisdiction(menuUrl, "del")) {
			return null;
		} // 校验权限
		PageData pd = new PageData();
		Map<String, Object> map = new HashMap<String, Object>();
		pd = this.getPageData();
		List<PageData> pdList = new ArrayList<PageData>();
		String DATA_IDS = pd.getString("DATA_IDS");
		if (null != DATA_IDS && !"".equals(DATA_IDS)) {
			String ArrayDATA_IDS[] = DATA_IDS.split(",");
			curriculuminfoService.deleteAll(ArrayDATA_IDS);
			pd.put("msg", "ok");
		} else {
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
	@RequestMapping(value="/{json}/excel")
	public ModelAndView exportExcel(Page page,@PathVariable String json) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"导出NewsInformation到excel");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;}
		ModelAndView mv = new ModelAndView();
		PageData pd = new PageData();
		Type type=new TypeToken<Map<String, Object>>(){}.getType(); //解析后台传入的json
		Map<String,Object> map = new Gson().fromJson(json, type);	//打成map集合
		pd = this.getPageData();		
		pd.put("c_type", map.get("name"));		  //把下拉框匹配进去
		System.out.println("拿到名字是："+ map.get("name"));
		Map<String,Object> dataMap = new HashMap<String,Object>();
		List<String> titles = new ArrayList<String>();
		titles.add("课程展示图片"); // 1
		titles.add("详细课程名称"); // 2
		titles.add("就业工资"); // 3
		titles.add("课程学习总时间"); // 4
		titles.add("创建用户"); // 5
		titles.add(" 备注"); // 6
		titles.add(" 创建时间"); // 7
		dataMap.put("titles", titles);
		page.setPd(pd);
		List<PageData> varOList = curriculuminfoService.listAll(pd);
		List<PageData> varList = new ArrayList<PageData>();
		for (int i = 0; i < varOList.size(); i++) {
			PageData vpd = new PageData();
			vpd.put("var1", varOList.get(i).getString("PICTURE")); // 1
			vpd.put("var2", varOList.get(i).getString("INFONAME")); // 2
			vpd.put("var3", varOList.get(i).get("WAGES").toString()); // 3
			vpd.put("var4", varOList.get(i).getString("STUDYTIME")); // 4
			vpd.put("var5", varOList.get(i).getString("CREATEUSER")); // 5
			vpd.put("var6", varOList.get(i).getString("REMARKS")); // 6
			vpd.put("var7", varOList.get(i).getString("CREATETIME")); // 7
			varList.add(vpd);
		}
		dataMap.put("varList", varList);
		ObjectExcelView erv = new ObjectExcelView();
		mv = new ModelAndView(erv,dataMap);
		return mv;
	}
	/**批量下载
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/toBatchExcel")
	public ModelAndView toBatchExcel() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"导出Student到excel");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;}
		ModelAndView mv = new ModelAndView();
		Map<String,Object> dataMap = new HashMap<String,Object>();
		List<String> titles = new ArrayList<String>();
		titles.add("课程展示图片"); // 1
		titles.add("详细课程名称"); // 2
		titles.add("就业工资"); // 3
		titles.add("课程学习总时间"); // 4
		titles.add("创建用户"); // 5
		titles.add(" 备注"); // 6
		titles.add(" 创建时间"); // 7
		dataMap.put("titles", titles);
		
		String DATA_IDS = getRequest().getParameter("str");
		
		if(null != DATA_IDS && !"".equals(DATA_IDS)){
			String ArrayDATA_IDS[] = DATA_IDS.split(",");
		
		List<PageData> varOList = curriculuminfoService.toBatchExcel(ArrayDATA_IDS);
		
		List<PageData> varList = new ArrayList<PageData>();
		
		for(int i=0;i<varOList.size();i++){
			PageData vpd = new PageData();
			vpd.put("var1", varOList.get(i).getString("PICTURE")); // 1
			vpd.put("var2", varOList.get(i).getString("INFONAME")); // 2
			vpd.put("var3", varOList.get(i).get("WAGES").toString()); // 3
			vpd.put("var4", varOList.get(i).getString("STUDYTIME")); // 4
			vpd.put("var5", varOList.get(i).getString("CREATEUSER")); // 5
			vpd.put("var6", varOList.get(i).getString("REMARKS")); // 6
			vpd.put("var7", varOList.get(i).getString("CREATETIME")); // 7
			varList.add(vpd);
		}
		
		dataMap.put("varList", varList);
		ObjectExcelView erv = new ObjectExcelView();
		mv = new ModelAndView(erv,dataMap);
		}
		return mv;
	}
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format, true));
	}
}
