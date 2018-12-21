package com.flc.controller.system.company;

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
import com.flc.service.system.company.CompanyManager;

/** 
 * 说明：合作企业
 * 创建人：王尧宇
 * 创建时间：2018-08-06
 */
@Controller
@RequestMapping(value="/company")
public class CompanyController extends BaseController {
	
	String menuUrl = "company/list.do"; //菜单地址(权限用)
	@Resource(name="companyService")
	private CompanyManager companyService;
	/**
	 * 取消
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value = "/removeit")
	public void removeit(HttpServletRequest request){
		request.setAttribute("kind", "company");
		RemoveController.removeit(request);
	}
	/**保存
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/save")
	public ModelAndView save(HttpSession s,HttpServletRequest request) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"新增Company");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("COMPANY_ID", this.get32UUID());	//主键
		pd.put("PICTURE", s.getAttribute("imageName"));
		Date date = new Date();
		String createTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
		pd.put("CREATETIME", createTime);
		Session session = Jurisdiction.getSession();
		User user = (User) session.getAttribute(Const.SESSION_USER); // 读取session中的用户信息(单独用户信息)
		pd.put("CREATEUSER", user.getUSERNAME());
		companyService.save(pd);
		request.setAttribute("kind", "company");
		RemoveController.saveOrUpdateRemove(request);
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
		logBefore(logger, Jurisdiction.getUsername()+"删除Company");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return;} //校验权限
		PageData pd = new PageData();
		pd = this.getPageData();
		PageData pageDate=companyService.findById(pd);
		request.setAttribute("kind", "company");
		RemoveController.deleteOne(request, pageDate.get("PICTURE").toString());
		companyService.delete(pd);
		out.write("success");
		out.close();
	}
	
	/**修改
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/edit")
	public ModelAndView edit(HttpSession session,HttpServletRequest request) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"修改Company");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("PICTURE", session.getAttribute("imageName"));
		companyService.edit(pd);
		request.setAttribute("kind", "company");
		RemoveController.saveOrUpdateRemove(request);
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}
	
	/**列表
	 * @param page
	 * @throws Exception
	 */
	@RequestMapping(value="/list")
	public ModelAndView list(Page page,HttpSession session,HttpServletRequest request) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"列表Company");
		//if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;} //校验权限(无权查看时页面会有提示,如果不注释掉这句代码就无法进入列表页面,所以根据情况是否加入本句代码)
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		Map<String, Object> maps=new HashMap<String, Object>();
		String keywords = pd.getString("keywords");				//关键词检索条件
		if (null != keywords && !"".equals(keywords)) {
			pd.put("keywords", keywords.trim());
			maps.put("keywords", keywords);
		}
		String lastStart = pd.getString("lastStart");
		if (null != lastStart && !"".equals(lastStart)) {
			pd.put("lastStart", lastStart.trim());
			maps.put("lastStart", lastStart);
		}
		String lastEnd = pd.getString("lastEnd");
		if (null != lastEnd && !"".equals(lastEnd)) {
			pd.put("lastEnd", lastEnd.trim());
			maps.put("lastEnd", lastEnd);
		}
		session.setAttribute("companyMap", maps);//maps包含查询条件如：项目名，时间，类型
		page.setPd(pd);
		List<PageData>	varList = companyService.list(page);	//列出Company列表
		request.setAttribute("kind", "company");
		String path=UploadController.getPath(request);
		mv.setViewName("system/company/company_list");
		mv.addObject("path", path);
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
		mv.setViewName("system/company/company_edit");
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
		pd = companyService.findById(pd);	//根据ID读取
		String img=pd.get("PICTURE").toString();
		request.setAttribute("kind", "company");
		session.setAttribute("imageName", img);
		session.setAttribute("oldImg", img);
		String path=UploadController.getPath(request);
		String companyImgPath=path+img;
		mv.addObject("upOrAdd","up");
		mv.addObject("companyImgPath", companyImgPath);
		mv.setViewName("system/company/company_edit");
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
		logBefore(logger, Jurisdiction.getUsername()+"批量删除Company");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return null;} //校验权限
		PageData pd = new PageData();		
		Map<String,Object> map = new HashMap<String,Object>();
		pd = this.getPageData();
		List<PageData> pdList = new ArrayList<PageData>();
		String DATA_IDS = pd.getString("DATA_IDS");
		request.setAttribute("kind", "company");
		if(null != DATA_IDS && !"".equals(DATA_IDS)){
			String ArrayDATA_IDS[] = DATA_IDS.split(",");
			for (String id : ArrayDATA_IDS) {
				pd.put("COMPANY_ID", id);
				PageData pageDate=companyService.findById(pd);
				RemoveController.deleteOne(request, pageDate.get("PICTURE").toString());
			}
			companyService.deleteAll(ArrayDATA_IDS);
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
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/excel")
	public ModelAndView exportExcel(HttpSession session) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"导出Company到excel");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;}
		ModelAndView mv = new ModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		Map<String,Object> dataMap = new HashMap<String,Object>();
		List<String> titles = new ArrayList<String>();
		titles.add("名字");	//1
		titles.add("图片");	//2
		titles.add("创建时间");	//3
		titles.add("创建人");	//4
		titles.add("备注");	//5
		dataMap.put("titles", titles);
		Map<String, Object> maps=(Map<String, Object>) session.getAttribute("companyMap");
		if (maps.get("keywords")!=null&&!"".equals(maps.get("keywords").toString())) {
			pd.put("keywords", maps.get("keywords"));
		}if (maps.get("lastStart")!=null&&!"".equals(maps.get("lastStart").toString())) {
			pd.put("lastStart", maps.get("lastStart"));
		}if (maps.get("lastEnd")!=null&&!"".equals(maps.get("lastEnd").toString())) {
			pd.put("lastEnd", maps.get("lastEnd"));
		}
		List<PageData> varOList = companyService.listAll(pd);
		List<PageData> varList = new ArrayList<PageData>();
		for(int i=0;i<varOList.size();i++){
			PageData vpd = new PageData();
			vpd.put("var1", varOList.get(i).getString("NAME"));	    //1
			vpd.put("var2", varOList.get(i).getString("PICTURE"));	    //2
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
}
