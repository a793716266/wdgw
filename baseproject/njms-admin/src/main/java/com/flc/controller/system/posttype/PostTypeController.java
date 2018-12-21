package com.flc.controller.system.posttype;

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
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
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
import com.flc.util.PriUpLoadFile;
import com.flc.util.Jurisdiction;
import com.google.gson.Gson;
import com.flc.service.system.posttype.PostTypeManager;
import com.flc.service.system.wd_users.WD_UsersManager;

/** 
 * 说明：帖子类型
 * 创建人：王尧宇
 * 创建时间：2018-08-23
 */
@Controller
@RequestMapping(value="/posttype")
public class PostTypeController extends BaseController {
	
	String menuUrl = "posttype/list.do"; //菜单地址(权限用)
	@Resource(name="posttypeService")
	private PostTypeManager posttypeService;
	@Resource(name="wd_usersService")
	private WD_UsersManager wd_usersService;
	private String saveFileName="posttype";
	/**保存
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/save")
	public ModelAndView save(HttpServletRequest myrequest, HttpSession session,
			@ModelAttribute("PageData") @Validated PageData pd, BindingResult br) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"新增PostType");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		if (br.hasErrors()) {
			mv.setViewName("save_result");
			return mv;
		}
		// 页面的file的name myfile
		String picture = PriUpLoadFile.uploadFile(myrequest,session,"myfile");
		pd = this.getPageData();
		pd.put("POSTTYPE_ID", this.get32UUID());	//主键
		Date date = new Date();
		String createTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
		pd.put("CREATETIME", createTime);
		Session s = Jurisdiction.getSession();
		User user = (User) s.getAttribute(Const.SESSION_USER); // 读取session中的用户信息(单独用户信息)
		pd.put("CREATEUSER", user.getUSERNAME());
		pd.put("NAME", myrequest.getParameter("NAME"));
		pd.put("THEME", 0);
		pd.put("REPLYCARD", 0);
		pd.put("SYNOPSIS", 	myrequest.getParameter("SYNOPSIS"));
		pd.put("PICTURE",  picture);
		pd.put("MANAGER",  myrequest.getParameter("MANAGER"));
		pd.put("PLATE",  myrequest.getParameter("PLATE"));
		pd.put("REMARKS",  myrequest.getParameter("REMARKS"));
		posttypeService.save(pd);
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}
	
	
	@RequestMapping(value="/ajax")
	@ResponseBody
	public String ajax(HttpServletRequest request){
		String plate=request.getParameter("plate");
		try {
			String num=posttypeService.findByPlate(plate);
			if(Integer.valueOf(num)>0){
				Gson g=new Gson();
				return g.toJson("false");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "true";
	}
	
	/**删除
	 * @param out
	 * @throws Exception
	 */
	@RequestMapping(value="/delete")
	public void delete(PrintWriter out,HttpServletRequest request) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"删除PostType");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return;} //校验权限
		PageData pd = new PageData();
		pd = this.getPageData();
		PageData pageDate=posttypeService.findById(pd);
		request.setAttribute("kind", "posttype");
		RemoveController.deleteOne(request, pageDate.get("PICTURE").toString());
		posttypeService.delete(pd);
		out.write("success");
		out.close();
	}
	
	/**修改
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/edit")
	public ModelAndView edit(HttpServletRequest myrequest, HttpSession session,
			@ModelAttribute("PageData") @Validated PageData pd, BindingResult br) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"修改PostType");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		if (br.hasErrors()) {
			mv.setViewName("save_result");
			return mv;
		}
		String picture = PriUpLoadFile.uploadFile(myrequest,session,"myfile");
		pd = this.getPageData();
		myrequest.setAttribute("kind", saveFileName);
		if(picture!=""&&picture!=null&&picture!=session.getAttribute("oldPicture")){
			RemoveController.deleteOne(myrequest, session.getAttribute("oldPicture").toString());
			session.setAttribute("oldPicture", picture);
		}
		pd.put("POSTTYPE_ID",myrequest.getSession().getAttribute("changeId"));
		pd.put("PICTURE",  session.getAttribute("oldPicture"));
		pd.put("NAME", myrequest.getParameter("NAME"));
		pd.put("SYNOPSIS", 	myrequest.getParameter("SYNOPSIS"));
		pd.put("MANAGER",  myrequest.getParameter("MANAGER"));
		pd.put("PLATE",  myrequest.getParameter("PLATE"));
		pd.put("REMARKS",  myrequest.getParameter("REMARKS"));
		posttypeService.edit(pd);
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
		logBefore(logger, Jurisdiction.getUsername()+"列表PostType");
		//if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;} //校验权限(无权查看时页面会有提示,如果不注释掉这句代码就无法进入列表页面,所以根据情况是否加入本句代码)
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		List<PageData> allAdmin=wd_usersService.listAllAdmin(pd);
		Map<String, Object> maps=new HashMap<String, Object>();
		request.getSession().setAttribute("allAdmin", allAdmin);
		String keywords = pd.getString("keywords");				//关键词检索条件
		if(null != keywords && !"".equals(keywords)){
			pd.put("keywords", keywords.trim());
			maps.put("keywords", keywords.trim());
		}
		String lastStart = pd.getString("lastStart");
		if (null != lastStart && !"".equals(lastStart)) {
			pd.put("lastStart", lastStart.trim());
			maps.put("lastStart", lastStart.trim());
		}
		String lastEnd = pd.getString("lastEnd");
		if (null != lastEnd && !"".equals(lastEnd)) {
			pd.put("lastEnd", lastEnd.trim());
			maps.put("lastEnd", lastStart.trim());
		}
		request.getSession().setAttribute("posttypeMap", maps);
		page.setPd(pd);
		List<PageData>	varList = posttypeService.list(page);	//列出PostType列表
		request.setAttribute("kind", saveFileName);
		String path=UploadController.getPath(request);
		mv.addObject("path", path);
		mv.setViewName("system/posttype/posttype_list");
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
	public ModelAndView goAdd(HttpServletRequest request)throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		mv.addObject("allAdmin",request.getSession().getAttribute("allAdmin"));
		mv.setViewName("system/posttype/posttype_edit");
		mv.addObject("msg", "save");
		mv.addObject("pd", pd);
		return mv;
	}	
	
	 /**去修改页面
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/goEdit")
	public ModelAndView goEdit(HttpServletRequest request)throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd = posttypeService.findById(pd);	//根据ID读取
		request.getSession().setAttribute("oldPicture", pd.get("PICTURE"));
		request.setAttribute("kind", saveFileName);
		request.getSession().setAttribute("changeId",pd.get("POSTTYPE_ID"));
		mv.addObject("picture",UploadController.getPath(request)+pd.get("PICTURE"));
		mv.addObject("allAdmin",request.getSession().getAttribute("allAdmin"));
		mv.setViewName("system/posttype/posttype_edit");
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
		logBefore(logger, Jurisdiction.getUsername()+"批量删除PostType");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return null;} //校验权限
		PageData pd = new PageData();		
		Map<String,Object> map = new HashMap<String,Object>();
		pd = this.getPageData();
		List<PageData> pdList = new ArrayList<PageData>();
		String DATA_IDS = pd.getString("DATA_IDS");
		request.setAttribute("kind", "posttype");
		if(null != DATA_IDS && !"".equals(DATA_IDS)){
			String ArrayDATA_IDS[] = DATA_IDS.split(",");
			for (String id : ArrayDATA_IDS) {
				pd.put("POSTTYPE_ID", id);
				PageData pageDate=posttypeService.findById(pd);
				RemoveController.deleteOne(request, pageDate.get("PICTURE").toString());
			}
			posttypeService.deleteAll(ArrayDATA_IDS);
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
		logBefore(logger, Jurisdiction.getUsername()+"导出PostType到excel");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;}
		ModelAndView mv = new ModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		Map<String,Object> dataMap = new HashMap<String,Object>();
		List<String> titles = new ArrayList<String>();
		titles.add("名称");	//1
		titles.add("主题");	//2
		titles.add("回帖");	//3
		titles.add("简介");	//4
		titles.add("图片");	//5
		titles.add("管理员");	//6
		titles.add("版块");	//7
		titles.add("创建时间");	//8
		titles.add("创建人");	//9
		titles.add("备注");	//10
		dataMap.put("titles", titles);
		Map<String, Object> maps=(Map<String, Object>) session.getAttribute("posttypeMap");
		if (maps.get("keywords")!=null&&!"".equals(maps.get("keywords").toString())) {
			pd.put("keywords", maps.get("keywords"));
		}if (maps.get("lastStart")!=null&&!"".equals(maps.get("lastStart").toString())) {
			pd.put("lastStart", maps.get("lastStart"));
		}if (maps.get("lastEnd")!=null&&!"".equals(maps.get("lastEnd").toString())) {
			pd.put("lastEnd", maps.get("lastEnd"));
		}if (maps.get("course")!=null&&!"".equals(maps.get("course").toString())) {
			pd.put("course", maps.get("course"));
		}
		List<PageData> varOList = posttypeService.listAll(pd);
		List<PageData> varList = new ArrayList<PageData>();
		for(int i=0;i<varOList.size();i++){
			PageData vpd = new PageData();
			vpd.put("var1", varOList.get(i).getString("NAME"));	    //1
			vpd.put("var2", varOList.get(i).get("THEME").toString());	    //2
			vpd.put("var3", varOList.get(i).get("REPLYCARD").toString());	    //3
			vpd.put("var4", varOList.get(i).getString("SYNOPSIS"));	    //4
			vpd.put("var5", varOList.get(i).getString("PICTURE"));	    //5
			vpd.put("var6", varOList.get(i).getString("MANAGER"));	    //6
			vpd.put("var7", varOList.get(i).get("PLATE").toString());	//7
			vpd.put("var8", varOList.get(i).getString("CREATETIME"));	    //8
			vpd.put("var9", varOList.get(i).getString("CREATEUSER"));	    //9
			vpd.put("var10", varOList.get(i).getString("REMARKS"));	    //10
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
