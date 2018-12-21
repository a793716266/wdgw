package com.flc.controller.system.curriculum;

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
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.flc.controller.base.BaseController;
import com.flc.entity.Page;
import com.flc.entity.system.User;
import com.flc.service.system.curriculum.CurriculumManager;
import com.flc.util.AppUtil;
import com.flc.util.Jurisdiction;
import com.flc.util.ObjectExcelView;
import com.flc.util.PageData;
import com.flc.util.Tools;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/** 
 * 说明：课程类型表
 * 创建人：FLC
 * 创建时间：2018-07-24
 */
@Controller
@RequestMapping(value="/curriculum")
public class CurriculumController extends BaseController {
	
	String menuUrl = "curriculum/list.do"; //菜单地址(权限用)
	@Resource(name="curriculumService")
	private CurriculumManager curriculumService;
	
	/**保存
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/save")
	public ModelAndView save(HttpServletRequest myrequest,HttpSession session) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"新增Curriculum");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		User user = (User) session.getAttribute("sessionUser");
		PageData pd = new PageData();
		String remarks = myrequest.getParameter("REMARKS");//备注
		pd = this.getPageData();
		pd.put("CURRICULUM_ID", this.get32UUID());	//主键
		pd.put("CREATEUSER",user.getUSERNAME());//创建人
		pd.put("REMARKS",remarks);//备注
		pd.put("CREATETIME", Tools.date2Str(new Date()));	//添加时间
		curriculumService.save(pd);
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
		logBefore(logger, Jurisdiction.getUsername()+"删除Curriculum");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return;} //校验权限
		PageData pd = new PageData();
		pd = this.getPageData();
		curriculumService.delete(pd);
		out.write("success");
		out.close();
	}
	
	/**修改
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/edit")
	public ModelAndView edit(HttpSession session) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"修改Curriculum");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		User user = (User) session.getAttribute("sessionUser");
		pd.put("CREATEUSER", user.getUSERNAME());// 创建人
		pd.put("CREATETIME", Tools.date2Str(new Date())); // 修改时间
		curriculumService.edit(pd);
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
		logBefore(logger, Jurisdiction.getUsername()+"列表Curriculum");
		//if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;} //校验权限(无权查看时页面会有提示,如果不注释掉这句代码就无法进入列表页面,所以根据情况是否加入本句代码)
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String c_type = pd.getString("c_type");				//关键词检索条件
		if(null != c_type && !"".equals(c_type)){
			pd.put("c_type", c_type.trim());
		}
		page.setPd(pd);
		List<PageData>	varList = curriculumService.list(page);	//列出Curriculum列表
		mv.setViewName("system/curriculum/curriculum_list");
		mv.addObject("varList", varList);
		mv.addObject("allList", curriculumService.listAll(null));
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
		mv.setViewName("system/curriculum/curriculum_edit");
		mv.addObject("msg", "save");
		mv.addObject("pd", pd);
		return mv;
	}	
	/**
	 * 判断类型是否为空
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/ajax",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	@ResponseBody
	public String ajax(HttpServletRequest request) throws Exception {
		List<PageData> pags=curriculumService.listAll(null);
		String type=request.getParameter("type");
		for (PageData p : pags) {
			if (type != null && type.equals(p.getString("C_TYPE"))) {
				return "1";  //存在就是1
			}
		}
		return "-1 ";  //不存在就是-1
	}
	
	 /**去修改页面
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/goEdit")
	public ModelAndView goEdit()throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd = curriculumService.findById(pd);	//根据ID读取
		mv.setViewName("system/curriculum/curriculum_edit");
		mv.addObject("msg", "edit");
		mv.addObject("pd", pd);
		return mv;
	}	
	
	 /**批量删除
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/deleteAll")
	@ResponseBody
	public Object deleteAll() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"批量删除Curriculum");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return null;} //校验权限
		PageData pd = new PageData();		
		Map<String,Object> map = new HashMap<String,Object>();
		pd = this.getPageData();
		List<PageData> pdList = new ArrayList<PageData>();
		String DATA_IDS = pd.getString("DATA_IDS");
		if(null != DATA_IDS && !"".equals(DATA_IDS)){
			String ArrayDATA_IDS[] = DATA_IDS.split(",");
			curriculumService.deleteAll(ArrayDATA_IDS);
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
		titles.add("课程类型");	//1
		titles.add(" 创建用户");	//2
		titles.add(" 备注");	//3
		titles.add(" 创建时间");	//4
		dataMap.put("titles", titles);
		page.setPd(pd);
		List<PageData> varOList = curriculumService.listAll(pd);
		List<PageData> varList = new ArrayList<PageData>();
		for(int i=0;i<varOList.size();i++){
			PageData vpd = new PageData();
			vpd.put("var1", varOList.get(i).getString("C_TYPE"));	    //1
			vpd.put("var2", varOList.get(i).getString("CREATEUSER"));	    //2
			vpd.put("var3", varOList.get(i).getString("REMARKS"));	    //3
			vpd.put("var4", varOList.get(i).getString("CREATETIME"));	    //4
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
		titles.add("课程类型");	//1
		titles.add(" 创建用户");	//2
		titles.add(" 备注");	//3
		titles.add(" 创建时间");	//4
		dataMap.put("titles", titles);
		
		String DATA_IDS = getRequest().getParameter("str");
		
		if(null != DATA_IDS && !"".equals(DATA_IDS)){
			String ArrayDATA_IDS[] = DATA_IDS.split(",");
		
		List<PageData> varOList = curriculumService.toBatchExcel(ArrayDATA_IDS);
		
		List<PageData> varList = new ArrayList<PageData>();
		
		for(int i=0;i<varOList.size();i++){
			PageData vpd = new PageData();
			vpd.put("var1", varOList.get(i).getString("C_TYPE"));	    //1
			vpd.put("var2", varOList.get(i).getString("CREATEUSER"));	    //2
			vpd.put("var3", varOList.get(i).getString("REMARKS"));	    //3
			vpd.put("var4", varOList.get(i).getString("CREATETIME"));	    //4
			varList.add(vpd);
		}
		
		dataMap.put("varList", varList);
		ObjectExcelView erv = new ObjectExcelView();
		mv = new ModelAndView(erv,dataMap);
		}
		return mv;
	}

	
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format,true));
	}
}
