package com.flc.controller.system.employmentclass;

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

import org.apache.commons.collections.set.SynchronizedSet;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.flc.controller.base.BaseController;
import com.flc.entity.Page;
import com.flc.util.AppUtil;
import com.flc.util.ObjectExcelView;
import com.flc.util.PageData;
import com.flc.util.Jurisdiction;
import com.flc.util.Tools;
import com.google.gson.Gson;
import com.flc.service.system.classtype.impl.ClassTypeService;
import com.flc.service.system.curriculum.impl.CurriculumService;
import com.flc.service.system.employmentclass.EmploymentClassManager;

/** 
 * 说明：就业班级信息
 * 创建人：FLC
 * 创建时间：2018-07-24
 */
@Controller
@RequestMapping(value="/employmentclass")
public class EmploymentClassController extends BaseController {
	
	String menuUrl = "employmentclass/list.do"; //菜单地址(权限用)
	@Resource(name="employmentclassService")
	private EmploymentClassManager employmentclassService;
	@Resource(name="classtypeService")
	private ClassTypeService classtypeService;
	private List<PageData> varList1 =null;//班级类型列表
	
	@Resource(name="curriculumService")
	private CurriculumService curriculumService;
	private List<PageData> varList2 =null;//课程类型列表
	/**保存
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/save")
	public ModelAndView save() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"新增EmploymentClass");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("EMPLOYMENTCLASS_ID", this.get32UUID());	//主键
		pd.put("C_TYPE", pd.get("C_TYPE"));
		pd.put("SYSTEMTYPE",pd.get("SYSTEMTYPE"));
		employmentclassService.save(pd);
		mv.addObject("varList2", varList2);
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
		logBefore(logger, Jurisdiction.getUsername()+"删除EmploymentClass");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return;} //校验权限
		PageData pd = new PageData();
		pd = this.getPageData();
		employmentclassService.delete(pd);
		out.write("success");
		out.close();
	}
	
	/**修改
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/edit")
	public ModelAndView edit() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"修改EmploymentClass");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("C_TYPE", pd.get("C_TYPE"));
		pd.put("SYSTEMTYPE",pd.get("SYSTEMTYPE"));
		employmentclassService.edit(pd);
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
		logBefore(logger, Jurisdiction.getUsername()+"列表EmploymentClass");
		//if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;} //校验权限(无权查看时页面会有提示,如果不注释掉这句代码就无法进入列表页面,所以根据情况是否加入本句代码)
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String keywords = pd.getString("keywords");	//关键词检索条件
		request.getSession().setAttribute("keywords", keywords);
		String lastStart = pd.getString("lastStart");
		String lastEnd = pd.getString("lastEnd");
		String name = pd.getString("name");
		if(null != keywords && !"".equals(keywords)){
			keywords = keywords.replaceAll(" ", "");
			pd.put("keywords", keywords.trim());
		}else{
			varList1 = classtypeService.listAll(null);//获取班级类型
			varList2 = curriculumService.listAll(null);//获取课程类型
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
		request.getSession().setAttribute("C_TYPE", name);
		page.setPd(pd);
		List<PageData>	varList = employmentclassService.list(page);	//列出EmploymentClass列表
		mv.setViewName("system/employmentclass/employmentclass_list");
		mv.addObject("varList", varList);
		mv.addObject("varList1", varList1);
		mv.addObject("varList2", varList2);
		mv.addObject("pd", pd);
		mv.addObject("QX",Jurisdiction.getHC());	//按钮权限
		return mv;
	}
	
	/**去新增页面
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/goAdd")
	public ModelAndView goAdd(HttpServletRequest  request)throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String title = new String(request.getParameter("title").getBytes("ISO-8859-1"),"UTF-8"); 
		Date date = new Date();
		 String da = new SimpleDateFormat("yyyy-MM-dd").format(date); 
		 pd.put("CREATETIME", da);
		mv.setViewName("system/employmentclass/employmentclass_edit");
		mv.addObject("title", title);
		mv.addObject("msg", "save");
		mv.addObject("pd", pd);
		mv.addObject("varList1", varList1);
		mv.addObject("varList2", varList2);
		return mv;
	}	
	
	 /**去修改页面
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/goEdit")
	public ModelAndView goEdit(HttpServletRequest  request)throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd = employmentclassService.findById(pd);	//根据ID读取
		String title = new String(request.getParameter("title").getBytes("ISO-8859-1"),"UTF-8"); 
		mv.setViewName("system/employmentclass/employmentclass_edit");
		mv.addObject("msg", "edit");
		mv.addObject("title", title);
		mv.addObject("pd", pd);
		mv.addObject("varList1", varList1);
		mv.addObject("varList2", varList2);
		return mv;
	}	
	
	 /**批量删除
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/deleteAll")
	@ResponseBody
	public Object deleteAll() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"批量删除EmploymentClass");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return null;} //校验权限
		PageData pd = new PageData();		
		Map<String,Object> map = new HashMap<String,Object>();
		pd = this.getPageData();
		List<PageData> pdList = new ArrayList<PageData>();
		String DATA_IDS = pd.getString("DATA_IDS");
		if(null != DATA_IDS && !"".equals(DATA_IDS)){
			String ArrayDATA_IDS[] = DATA_IDS.split(",");
			employmentclassService.deleteAll(ArrayDATA_IDS);
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
		logBefore(logger, Jurisdiction.getUsername()+"导出EmploymentClass到excel");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;}
		ModelAndView mv = new ModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		Map<String,Object> dataMap = new HashMap<String,Object>();
		List<String> titles = new ArrayList<String>();
		titles.add("班级名称");	//1
		titles.add("班级类型");	//2
		titles.add("最高薪资");	//3
		titles.add("平均薪资");	//4
		titles.add("教员");	//5
		titles.add("班主任");	//6
		titles.add("创建日期");	//7
		titles.add("创建人");	//8
		titles.add("课程类型");	//9
		titles.add("日制类型");	//10
		titles.add("备注");	//11
		dataMap.put("titles", titles);
		String keywords = new String(request.getParameter("className").getBytes("ISO-8859-1"),"UTF-8"); 
		String lastStart = request.getParameter("lastStart");
		String lastEnd = request.getParameter("lastEnd");
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
		List<PageData> varOList = employmentclassService.listAll(pd);
		List<PageData> varList = new ArrayList<PageData>();
		for(int i=0;i<varOList.size();i++){
			PageData vpd = new PageData();
			vpd.put("var1", varOList.get(i).getString("CLASSNAME"));	    //1
			vpd.put("var2", varOList.get(i).getString("CLASSTYPE"));	    //2
			vpd.put("var3", varOList.get(i).get("MAXSALARY").toString());	//3
			vpd.put("var4", varOList.get(i).get("AVGSALARY").toString());	//4
			vpd.put("var5", varOList.get(i).getString("TEACHERS"));	    //5
			vpd.put("var6", varOList.get(i).getString("CLASSCHARGE"));	    //6
			vpd.put("var7", varOList.get(i).getString("CREATETIME"));	    //7
			vpd.put("var8", varOList.get(i).getString("C_TYPE"));	    //8
			vpd.put("var9", varOList.get(i).getString("SYSTEMTYPE"));	    //9
			vpd.put("var10", varOList.get(i).getString("CREATEUSER"));	    //10
			vpd.put("var11", varOList.get(i).getString("REMARKS"));	    //11
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
		String EMPLOYMENTCLASS_ID = request.getParameter("EMPLOYMENTCLASS_ID");
		PageData pd = new PageData();
		pd = this.getPageData();
		String title = request.getParameter("title");
		String className = request.getParameter("CLASSNAME");
		Map<String,Object> map = new HashMap<String,Object>();
		if("修改".equals(title)){
			pd.put("EMPLOYMENTCLASS_ID", EMPLOYMENTCLASS_ID);
			PageData pageD = employmentclassService.findById(pd);
			if(pageD!=null){
				map.put("errInfo", "添加班级名称已经存在，请重新输入！");
			}
		}else if("新增".equals(title)){
			if(className!=null){
				int count   = (Integer)employmentclassService.validationClassName(className);
				if(count!=0){
					map.put("errInfo", "添加班级名称已经存在，请重新输入！");
				}
			}
		}
		return new Gson().toJson(map);
	};
}
