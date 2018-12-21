package com.flc.controller.system.flowpath;

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
import org.apache.shiro.session.Session;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.flc.controller.base.BaseController;
import com.flc.controller.system.upload.RemoveController;
import com.flc.controller.system.upload.UploadController;
import com.flc.entity.Page;
import com.flc.entity.system.User;
import com.flc.util.AppUtil;
import com.flc.util.Const;
import com.flc.util.ObjectExcelView;
import com.flc.util.PageData;
import com.flc.util.Jurisdiction;
import com.flc.service.system.flowpath.FlowPathManager;

/** 
 * 说明：入学就业流程
 * 创建人：FLC
 * 创建时间：2018-08-15
 */
@Controller
@RequestMapping(value="/flowpath")
public class FlowPathController extends BaseController {
	
	String menuUrl = "flowpath/list.do"; //菜单地址(权限用)
	@Resource(name="flowpathService")
	private FlowPathManager flowpathService;
	
	/**
	 * 取消
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value = "/removeit")
	public void removeit(HttpServletRequest request){
		request.setAttribute("kind", "TheRegistrationProcess");
		UploadController.imgMap(request);
		RemoveController.removeMap(request);
	}
	
	/**保存
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/save")
	public ModelAndView save(HttpSession s,HttpServletRequest request) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"新增FlowPath");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("FLOWPATH_ID", this.get32UUID());//主键
		//获取当前的用户
		Session session = Jurisdiction.getSession();
		User user = (User) session.getAttribute(Const.SESSION_USER);
		pd.put("CREATEUSER", user.getUSERNAME());
		//获取新增的当前日期
		Date date = new Date();
		pd.put("CREATETIME", date);
		pd.put("TITLEIMAGE",  s.getAttribute("imageName"));
		pd.put("image1", s.getAttribute("imageName1"));
		pd.put("image2", s.getAttribute("imageName2"));
		pd.put("image3", s.getAttribute("imageName3"));
		flowpathService.save(pd);
		//一次请求
		request.setAttribute("kind", "TheRegistrationProcess");
		UploadController.imgMap(request);
		RemoveController.saveOrUpdateRemoveMap(request);
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}
	
	/**删除
	 * @param out
	 * @throws Exception
	 */
	@RequestMapping(value="/delete")
	public void delete(PrintWriter out,HttpServletRequest request) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"删除FlowPath");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return;} //校验权限
		PageData pd = new PageData();
		pd = this.getPageData();
		
		//删除图片
		PageData pageDate = flowpathService.findById(pd);
		request.setAttribute("kind", "TheRegistrationProcess");
		List<String> listAll=new ArrayList<String>();
		listAll.add(pageDate.get("TITLEIMAGE").toString());
		listAll.add(pageDate.get("image1").toString());
		listAll.add(pageDate.get("image2").toString());
		listAll.add(pageDate.get("image3").toString());
		request.setAttribute("listAllImg", listAll);
		flowpathService.delete(pd);
		RemoveController.removeitMap(request);
		out.write("success");
		out.close();
	}
	
	/**修改
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/edit")

	public ModelAndView edit(HttpSession s,HttpServletRequest request) throws Exception{

		logBefore(logger, Jurisdiction.getUsername()+"修改FlowPath");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		//获取当前的用户
		Session session = Jurisdiction.getSession();
		User user = (User) session.getAttribute(Const.SESSION_USER);
		request.setAttribute("kind", "TheRegistrationProcess");
		RemoveController.removeOldMap(request);
		pd.put("CREATEUSER", user.getUSERNAME());
		
		pd.put("TITLEIMAGE",  request.getParameter("imageName"));
		pd.put("image1", request.getParameter("imageName1"));
		pd.put("image2", request.getParameter("imageName2"));
		pd.put("image3", request.getParameter("imageName3"));
		flowpathService.edit(pd);
		request.setAttribute("kind", "TheRegistrationProcess");
		UploadController.imgMap(request);
		RemoveController.saveOrUpdateRemoveMap(request);
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}
	
	
	/**列表
	 * @param page
	 * @throws Exception
	 */
	@RequestMapping(value="/list")
	public ModelAndView list(Page page, HttpSession session,HttpServletRequest request) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"列表FlowPath");
		//if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;} //校验权限(无权查看时页面会有提示,如果不注释掉这句代码就无法进入列表页面,所以根据情况是否加入本句代码)
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String keywords = pd.getString("keywords");				//关键词检索条件
		if(null != keywords && !"".equals(keywords)){
			pd.put("keywords", keywords.trim());
		}
		
		//日期条件检索
		String lastStart = pd.getString("lastStart");
		String lastEnd = pd.getString("lastEnd");
		if (null != lastStart && !"".equals(lastStart)) {
			pd.put("lastStart", lastStart);
		}
		if (null != lastEnd && !"".equals(lastEnd)) {
			pd.put("lastEnd", lastEnd);
		}
		page.setPd(pd);
		List<PageData>	varList = flowpathService.list(page);	//列出FlowPath列表
		
		//获取图片路径
		request.setAttribute("kind", "TheRegistrationProcess");
		String path=UploadController.getPath(request);
		
		mv.setViewName("system/flowpath/flowpath_list");
		mv.addObject("varList", varList);
		mv.addObject("path",path);
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
		mv.setViewName("system/flowpath/flowpath_edit");
		mv.addObject("msg", "save");
		mv.addObject("pd", pd);
		return mv;
	}	
	
	/**
	 * 页面排序的唯一性验证
	 * @throws Exception 
	 */
	@RequestMapping("/ajaxSORTUnique")
	@ResponseBody
	public Object sortUnique() throws Exception{
		PageData pd = new PageData();
		pd= this.getPageData();
		String sort = pd.getString("SORT");
		Integer sortUnique = (Integer) flowpathService.sortUnique(sort);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("statu", sortUnique);
		return AppUtil.returnObject(pd, map);
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
		pd = flowpathService.findById(pd);	//根据ID读取
		request.setAttribute("kind", "TheRegistrationProcess");
		String img=pd.get("TITLEIMAGE").toString();
		String img1=pd.getString("image1").toString();
		String img2=pd.getString("image2").toString();
		String img3=pd.getString("image3").toString();
		session.setAttribute("oldImg", img);
		session.setAttribute("oldImg1", img1);
		session.setAttribute("oldImg2", img2);
		session.setAttribute("oldImg3", img3);
		String path=UploadController.getPath(request);
		String subjectImgPath=path+img;
		String subjectImgPath1=path+img1;
		String subjectImgPath2=path+img2;
		String subjectImgPath3=path+img3;
		mv.addObject("upOrAdd","up");
		mv.addObject("subjectImgPath", subjectImgPath);
		mv.addObject("subjectImgPath1", subjectImgPath1);
		mv.addObject("subjectImgPath2", subjectImgPath2);
		mv.addObject("subjectImgPath3", subjectImgPath3);
		mv.setViewName("system/flowpath/flowpath_edit");
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
	public Object deleteAll(HttpServletRequest request) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"批量删除FlowPath");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return null;} //校验权限
		PageData pd = new PageData();		
		Map<String,Object> map = new HashMap<String,Object>();
		pd = this.getPageData();
		List<PageData> pdList = new ArrayList<PageData>();
		String DATA_IDS = pd.getString("DATA_IDS");
		
		request.setAttribute("kind", "TheRegistrationProcess");
		
		if(null != DATA_IDS && !"".equals(DATA_IDS)){
			String ArrayDATA_IDS[] = DATA_IDS.split(",");
			
			for (String id : ArrayDATA_IDS) {
				pd.put("FLOWPATH_ID", id);
				PageData pageDate=flowpathService.findById(pd);
				System.out.println(pageDate);
				RemoveController.deleteOne(request, pageDate.get("TITLEIMAGE").toString());
				RemoveController.deleteOne(request, pageDate.get("image1").toString());
				RemoveController.deleteOne(request, pageDate.get("image2").toString());
				RemoveController.deleteOne(request, pageDate.get("image3").toString());
			}
			
			flowpathService.deleteAll(ArrayDATA_IDS);
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
		logBefore(logger, Jurisdiction.getUsername()+"导出FlowPath到excel");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;}
		ModelAndView mv = new ModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		Map<String,Object> dataMap = new HashMap<String,Object>();
		List<String> titles = new ArrayList<String>();
		titles.add("标题图片");	//1
		titles.add("文本描述");	//2
		titles.add("详情路径");	//3
		titles.add("创建人");	//4
		titles.add("创建时间");	//5
		titles.add("备注");	//6
		dataMap.put("titles", titles);
		List<PageData> varOList = flowpathService.listAll(pd);
		List<PageData> varList = new ArrayList<PageData>();
		for(int i=0;i<varOList.size();i++){
			PageData vpd = new PageData();
			vpd.put("var1", varOList.get(i).getString("TITLEIMAGE"));	    //1
			vpd.put("var2", varOList.get(i).getString("TEXTDESCRIBE"));	    //2
			vpd.put("var3", varOList.get(i).getString("DETAILSURL"));	    //3
			vpd.put("var4", varOList.get(i).getString("CREATEUSER"));	    //4
			vpd.put("var5", varOList.get(i).getString("CREATETIME"));	    //5
			vpd.put("var6", varOList.get(i).getString("REMARKS"));	    //6
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
