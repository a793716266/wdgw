package com.flc.controller.system.hrinfo;

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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.flc.controller.base.BaseController;
import com.flc.controller.system.upload.UploadController;
import com.flc.entity.Page;
import com.flc.util.AppUtil;
import com.flc.util.ObjectExcelView;
import com.flc.util.PageData;
import com.flc.util.Jurisdiction;
import com.flc.util.Tools;
import com.flc.service.system.hrinfo.HRInfoManager;

/** 
 * 说明：HRInfo
 * 创建人：FLC
 * 创建时间：2018-07-24
 */
@Controller
@RequestMapping(value="/hrinfo")
public class HRInfoController extends BaseController {
	
	String menuUrl = "hrinfo/list.do"; //菜单地址(权限用)    
	@Resource(name="hrinfoService")
	private HRInfoManager hrinfoService;
	
	/**保存
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/save")
	public ModelAndView save(HttpSession s) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"新增HRInfo");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("HRINFO_ID", this.get32UUID());	//主键
		pd.put("HEADPORTRAIT", s.getAttribute("imageName"));
		pd.put("LOGO", s.getAttribute("imageName1"));
		hrinfoService.save(pd);
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
		logBefore(logger, Jurisdiction.getUsername()+"删除HRInfo");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return;} //校验权限
		PageData pd = new PageData();
		pd = this.getPageData();
		hrinfoService.delete(pd);
		out.write("success");
		out.close();
	}
	
	/**修改
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/edit")
	public ModelAndView edit(HttpSession session) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"修改HRInfo");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("HEADPORTRAIT", session.getAttribute("imageName"));
		pd.put("LOGO", session.getAttribute("imageName1"));
		hrinfoService.edit(pd);
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
		logBefore(logger, Jurisdiction.getUsername()+"列表HRInfo");
		//if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;} //校验权限(无权查看时页面会有提示,如果不注释掉这句代码就无法进入列表页面,所以根据情况是否加入本句代码)
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String keywords = pd.getString("keywords");	//关键词检索条件
		String lastStart = pd.getString("lastStart");
		String lastEnd = pd.getString("lastEnd");
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
		page.setPd(pd);
		List<PageData>	varList = hrinfoService.list(page);	//列出HRInfo列表
		
//		System.out.println(varList);
		
		mv.setViewName("system/hrinfo/hrinfo_list");
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
		mv.setViewName("system/hrinfo/hrinfo_edit");
		mv.addObject("msg", "save");
		mv.addObject("pd", pd);
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
		pd = hrinfoService.findById(pd);	//根据ID读取
		
		String img=pd.get("HEADPORTRAIT").toString();
		String img1=pd.get("LOGO").toString();
		session.setAttribute("imageName", img);
		session.setAttribute("imageName1", img1);
		request.setAttribute("kind", "hr");
		String path=UploadController.getPath(request);
		String subjectImgPath=path+img;
		String subjectImgPath1=path+img1;
		mv.addObject("upOrAdd","up");
		mv.addObject("subjectImgPath", subjectImgPath);
		mv.addObject("subjectImgPath1", subjectImgPath1);
		mv.setViewName("system/hrinfo/hrinfo_edit");
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
		logBefore(logger, Jurisdiction.getUsername()+"批量删除HRInfo");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return null;} //校验权限
		PageData pd = new PageData();		
		Map<String,Object> map = new HashMap<String,Object>();
		pd = this.getPageData();
		List<PageData> pdList = new ArrayList<PageData>();
		String DATA_IDS = pd.getString("DATA_IDS");
		if(null != DATA_IDS && !"".equals(DATA_IDS)){
			String ArrayDATA_IDS[] = DATA_IDS.split(",");
			hrinfoService.deleteAll(ArrayDATA_IDS);
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
		logBefore(logger, Jurisdiction.getUsername()+"导出HRInfo到excel");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;}
		ModelAndView mv = new ModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		Map<String,Object> dataMap = new HashMap<String,Object>();
		List<String> titles = new ArrayList<String>();
		titles.add("头像");	//1
		titles.add("HR_姓名");	//2
		titles.add("评价");	//3
		titles.add("职务");	//4
		titles.add("创建时间");	//5
		titles.add("创建用户");	//6
		titles.add("备注");	//7
		dataMap.put("titles", titles);
		String keywords = new String(request.getParameter("className").getBytes("ISO-8859-1"),"UTF-8"); //关键词检索条件
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
		List<PageData> varOList = hrinfoService.listAll(pd);
		List<PageData> varList = new ArrayList<PageData>();
		for(int i=0;i<varOList.size();i++){
			PageData vpd = new PageData();
			vpd.put("var1", varOList.get(i).getString("HEADPORTRAIT"));	    //1
			vpd.put("var2", varOList.get(i).getString("HR_NAME"));	    //2
			vpd.put("var3", varOList.get(i).getString("EVALUATION"));	    //3
			vpd.put("var4", varOList.get(i).getString("HR_POSITION"));	    //4
			vpd.put("var5", varOList.get(i).getString("CREATETIME"));	    //5
			vpd.put("var6", varOList.get(i).getString("CREATEUSER"));	    //6
			vpd.put("var7", varOList.get(i).getString("REMARKS"));	    //7
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
