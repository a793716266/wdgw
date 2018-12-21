package com.flc.controller.system.classopening;

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
import javax.servlet.http.HttpSession;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.flc.controller.base.BaseController;
import com.flc.entity.Page;
import com.flc.entity.system.User;
import com.flc.util.AppUtil;
import com.flc.util.ObjectExcelView;
import com.flc.util.PageData;
import com.flc.util.Jurisdiction;
import com.flc.util.Tools;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.flc.service.system.classopening.ClassOpeningManager;
import com.flc.service.system.classtype.ClassTypeManager;
import com.flc.service.system.curriculum.CurriculumManager;

/** 
 * 说明：开班信息表
 * 创建人：FLC
 * 创建时间：2018-07-31
 */
@Controller
@RequestMapping(value="/classopening")
public class ClassOpeningController extends BaseController {
	
	String menuUrl = "classopening/list.do"; //菜单地址(权限用)
	@Resource(name="classopeningService")
	private ClassOpeningManager classopeningService;
	@Resource(name="classtypeService")
	private ClassTypeManager classtypeService;//班级类型
	@Resource(name="curriculumService")
	private CurriculumManager curriculumService;//课程类型 
	
	/**保存
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/save")
	public ModelAndView save(HttpSession session) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"新增ClassOpening");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		User u = (User)session.getAttribute("sessionUser");
		pd.put("CLASSOPENING_ID", this.get32UUID());	//主键
		pd.put("CREATETIME", Tools.date2Str(new Date()));	//创建时间
		pd.put("CREATEUSER", u.getUSERNAME());	//创建人
		classopeningService.save(pd);
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
		logBefore(logger, Jurisdiction.getUsername()+"删除ClassOpening");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return;} //校验权限
		PageData pd = new PageData();
		pd = this.getPageData();
		classopeningService.delete(pd);
		out.write("success");
		out.close();
	}
	
	/**修改
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/edit")
	public ModelAndView edit(HttpSession session) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"修改ClassOpening");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		User u = (User)session.getAttribute("sessionUser");
		pd = this.getPageData();
		pd.put("CREATEUSER", u.getUSERNAME());	//创建人
		pd.put("CREATETIME", Tools.date2Str(new Date()));	//创建时间
		classopeningService.edit(pd);
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}
	
	/**列表
	 * @param page
	 * @throws Exception
	 */
	@RequestMapping(value="/list")
	public ModelAndView list(Page page,HttpSession session) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"列表ClassOpening");
		//if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;} //校验权限(无权查看时页面会有提示,如果不注释掉这句代码就无法进入列表页面,所以根据情况是否加入本句代码)
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String lastStart = pd.getString("lastStart");				//开始时间检索条件
		if(null != lastStart && !"".equals(lastStart)){
			pd.put("lastStart", lastStart.trim());
		}
		String lastEnd = pd.getString("lastEnd");					//结束时间检索条件
		if(null != lastEnd && !"".equals(lastEnd)){
			pd.put("lastEnd", lastEnd.trim());
		}
		String reservsstate = pd.getString("reservsstate");							//班级类型检索条件
		if(null != reservsstate && !"".equals("reservsstate")){
			pd.put("reservsstate", reservsstate.trim());
		}
		page.setPd(pd);
		List<PageData>	varList = classopeningService.list(page);	//列出ClassOpening列表
		mv.setViewName("system/classopening/classopening_list");
		mv.addObject("varList", varList);
		if(pd.getString("reservsstate")==null){
			pd.put("reservsstate",null);
		}
		if("".equals(pd.getString("reservsstate"))){
			pd.put("reservsstate",null);
		}
		mv.addObject("pd", pd);
		session.setAttribute("mList", curriculumService.listAll(null));//课程类型  下拉框
		session.setAttribute("cList", classtypeService.listAll(null));//班级类型 下拉框
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
		mv.setViewName("system/classopening/classopening_edit");
		mv.addObject("msg", "save");
		mv.addObject("pd", pd);
		return mv;
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
		pd = classopeningService.findById(pd);	//根据ID读取
		mv.setViewName("system/classopening/classopening_edit");
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
		logBefore(logger, Jurisdiction.getUsername()+"批量删除ClassOpening");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return null;} //校验权限
		PageData pd = new PageData();		
		Map<String,Object> map = new HashMap<String,Object>();
		pd = this.getPageData();
		List<PageData> pdList = new ArrayList<PageData>();
		String DATA_IDS = pd.getString("DATA_IDS");
		if(null != DATA_IDS && !"".equals(DATA_IDS)){
			String ArrayDATA_IDS[] = DATA_IDS.split(",");
			classopeningService.deleteAll(ArrayDATA_IDS);
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
		pd.put("lastStart", map.get("lastStart"));//开始时间检索条件
		pd.put("lastEnd",  map.get("lastEnd"));//结束时间检索条件
		pd.put("reservsstate",  map.get("reservsstate"));//状态检索条件
		Map<String,Object> dataMap = new HashMap<String,Object>();
		List<String> titles = new ArrayList<String>();
		titles.add("课程类型");	//1
		titles.add("班级状态");	//2
		titles.add("班级类型");	//3
		titles.add("班级编号");	//4
		titles.add("班级总名额");	//5
		titles.add("现有人数");	//6
		titles.add("预定状态");	//7
		titles.add("创建时间");	//8
		titles.add("创建人");	//9
		titles.add("备注");	//10
		titles.add("总记录数");//11
		dataMap.put("titles", titles);
		page.setPd(pd);
		List<PageData> varOList = classopeningService.listAll(pd);
		String index = String.valueOf(varOList.size());
		List<PageData> varList = new ArrayList<PageData>();
		for(int i=0;i<varOList.size();i++){
			PageData vpd = new PageData();
			vpd.put("var1", varOList.get(i).getString("CTYPE"));	    //1
			vpd.put("var2", varOList.get(i).getString("CLASSSTATE"));	    //2
			vpd.put("var3", varOList.get(i).getString("CLASSTYPENAME"));	    //3
			vpd.put("var4", varOList.get(i).get("CLASSNUMBER").toString());	//4
			vpd.put("var5", varOList.get(i).get("TOTALNUMBER").toString());	//5
			vpd.put("var6", varOList.get(i).get("CURRENTNUMBER").toString());	//6
			vpd.put("var7", varOList.get(i).getString("RESERVSSTATE"));	    //7
			vpd.put("var8", varOList.get(i).getString("CREATETIME"));	    //8
			vpd.put("var9", varOList.get(i).getString("CREATEUSER"));	    //9
			vpd.put("var10", varOList.get(i).getString("REMARKS"));	    //10
			if(i==0){
				vpd.put("var11", index);
			}
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
		titles.add("班级状态");	//2
		titles.add("班级类型");	//3
		titles.add("班级编号");	//4
		titles.add("班级总名额");	//5
		titles.add("现有人数");	//6
		titles.add("预定状态");	//7
		titles.add("创建时间");	//8
		titles.add("创建人");	//9
		titles.add("备注");	//10
		titles.add("总记录数");//11
		dataMap.put("titles", titles);
		
		String DATA_IDS = getRequest().getParameter("str");
		
		if(null != DATA_IDS && !"".equals(DATA_IDS)){
			String ArrayDATA_IDS[] = DATA_IDS.split(",");
		
		List<PageData> varOList = classopeningService.toBatchExcel(ArrayDATA_IDS);
		
		String index = String.valueOf(varOList.size());
		List<PageData> varList = new ArrayList<PageData>();
		for(int i=0;i<varOList.size();i++){
			PageData vpd = new PageData();
			vpd.put("var1", varOList.get(i).getString("CTYPE"));	    //1
			vpd.put("var2", varOList.get(i).getString("CLASSSTATE"));	    //2
			vpd.put("var3", varOList.get(i).getString("CLASSTYPENAME"));	    //3
			vpd.put("var4", varOList.get(i).get("CLASSNUMBER").toString());	//4
			vpd.put("var5", varOList.get(i).get("TOTALNUMBER").toString());	//5
			vpd.put("var6", varOList.get(i).get("CURRENTNUMBER").toString());	//6
			vpd.put("var7", varOList.get(i).getString("RESERVSSTATE"));	    //7
			vpd.put("var8", varOList.get(i).getString("CREATETIME"));	    //8
			vpd.put("var9", varOList.get(i).getString("CREATEUSER"));	    //9
			vpd.put("var10", varOList.get(i).getString("REMARKS"));	    //10
			if(i==0){
				vpd.put("var11", index);
			}
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
