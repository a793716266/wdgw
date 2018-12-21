package com.flc.controller.system.post;

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
import com.flc.entity.Page;
import com.flc.entity.system.User;
import com.flc.util.AppUtil;
import com.flc.util.Const;
import com.flc.util.ObjectExcelView;
import com.flc.util.PageData;
import com.flc.util.Jurisdiction;
import com.flc.util.Tools;
import com.flc.service.system.post.PostManager;
import com.flc.service.system.posttype.PostTypeManager;
import com.flc.service.system.wd_users.WD_UsersManager;

/** 
 * 说明：帖子
 * 创建人：王尧宇
 * 创建时间：2018-08-23
 */
@Controller
@RequestMapping(value="/post")
public class PostController extends BaseController {
	
	String menuUrl = "post/list.do"; //菜单地址(权限用)
	@Resource(name="postService")
	private PostManager postService;
	@Resource(name="posttypeService")
	private PostTypeManager posttypeService;
	@Resource(name="wd_usersService")
	private WD_UsersManager wd_usersService;
	/**保存
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/save")
	public ModelAndView save(HttpServletRequest request) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"新增Post");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("POST_ID", this.get32UUID());	//主键
		Date date = new Date();
		String createTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
		pd.put("CREATETIME", createTime);
		Session s = Jurisdiction.getSession();
		User user = (User) s.getAttribute(Const.SESSION_USER); // 读取session中的用户信息(单独用户信息)
		pd.put("CREATEUSER", user.getUSERNAME());
		pd.put("VIEWNUMBER", 0);
		pd.put("HEAT", 0);
		pd.put("RESTORENUMBER", 0);
		postService.save(pd);
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
		logBefore(logger, Jurisdiction.getUsername()+"删除Post");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return;} //校验权限
		PageData pd = new PageData();
		pd = this.getPageData();
		postService.delete(pd);
		out.write("success");
		out.close();
	}
	
	/**修改
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/edit")
	public ModelAndView edit(HttpServletRequest request) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"修改Post");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("VIEWNUMBER", request.getSession().getAttribute("VIEWNUMBER"));
		pd.put("HEAT", request.getSession().getAttribute("HEAT"));
		pd.put("RESTORENUMBER", request.getSession().getAttribute("RESTORENUMBER"));
		postService.edit(pd);
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
		logBefore(logger, Jurisdiction.getUsername()+"列表Post");
		//if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;} //校验权限(无权查看时页面会有提示,如果不注释掉这句代码就无法进入列表页面,所以根据情况是否加入本句代码)
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		List<PageData> allPostType=posttypeService.listAll(null);
		List<PageData> allUser=wd_usersService.listAll(null);
		request.getSession().setAttribute("allPostType", allPostType);
		request.getSession().setAttribute("allUser", allUser);
		pd = this.getPageData();
		Map<String, Object> maps=new HashMap<String, Object>();
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
		String changePostType = pd.getString("changePostType");
		if (null != changePostType && !"".equals(changePostType)) {
			pd.put("changePostType", changePostType.trim());
			maps.put("changePostType", changePostType.trim());
		}
		request.getSession().setAttribute("posttypeMap", maps);
		page.setPd(pd);
		List<PageData>	varList = postService.list(page);	//列出Post列表
		mv.setViewName("system/post/post_list");
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
		mv.setViewName("system/post/post_edit");
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
		pd = postService.findById(pd);	//根据ID读取
		request.getSession().setAttribute("VIEWNUMBER", pd.get("VIEWNUMBER").toString());
		request.getSession().setAttribute("HEAT", pd.get("HEAT").toString());
		request.getSession().setAttribute("RESTORENUMBER", pd.get("RESTORENUMBER").toString());
		mv.setViewName("system/post/post_edit");
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
		logBefore(logger, Jurisdiction.getUsername()+"批量删除Post");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return null;} //校验权限
		PageData pd = new PageData();		
		Map<String,Object> map = new HashMap<String,Object>();
		pd = this.getPageData();
		List<PageData> pdList = new ArrayList<PageData>();
		String DATA_IDS = pd.getString("DATA_IDS");
		if(null != DATA_IDS && !"".equals(DATA_IDS)){
			String ArrayDATA_IDS[] = DATA_IDS.split(",");
			postService.deleteAll(ArrayDATA_IDS);
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
	public ModelAndView exportExcel(HttpSession session) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"导出Post到excel");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;}
		ModelAndView mv = new ModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		Map<String,Object> dataMap = new HashMap<String,Object>();
		List<String> titles = new ArrayList<String>();
		titles.add("帖子类型");	
		titles.add("标题");	
		titles.add("内容");	
		titles.add("用户");	
		titles.add("浏览次数");	
		titles.add("热度");	
		titles.add("下载附件");	
		titles.add("发布版本");	
		titles.add("回复数");	
		titles.add("创建时间");	
		titles.add("创建人");	
		titles.add("备注");	
		dataMap.put("titles", titles);
		Map<String, Object> maps=(Map<String, Object>) session.getAttribute("posttypeMap");
		if (maps.get("keywords")!=null&&!"".equals(maps.get("keywords").toString())) {
			pd.put("keywords", maps.get("keywords"));
		}if (maps.get("lastStart")!=null&&!"".equals(maps.get("lastStart").toString())) {
			pd.put("lastStart", maps.get("lastStart"));
		}if (maps.get("lastEnd")!=null&&!"".equals(maps.get("lastEnd").toString())) {
			pd.put("lastEnd", maps.get("lastEnd"));
		}if (maps.get("changePostType")!=null&&!"".equals(maps.get("changePostType").toString())) {
			pd.put("changePostType", maps.get("changePostType"));
		}
		List<PageData> varOList = postService.listAll(pd);
		List<PageData> varList = new ArrayList<PageData>();
		for(int i=0;i<varOList.size();i++){
			PageData vpd = new PageData();
			vpd.put("var1", varOList.get(i).getString("NAME"));	    
			vpd.put("var2", varOList.get(i).getString("TITLE"));	   
			vpd.put("var3", varOList.get(i).getString("CONTENT"));	   
			vpd.put("var4", varOList.get(i).getString("NICKNAME"));	    
			vpd.put("var5", varOList.get(i).get("VIEWNUMBER").toString());	
			vpd.put("var6", varOList.get(i).get("HEAT").toString());	
			vpd.put("var7", varOList.get(i).getString("DOWNLOADATTACHMENT"));	    
			vpd.put("var8", varOList.get(i).getString("RELEASEVERSION"));	    
			vpd.put("var9", varOList.get(i).get("RESTORENUMBER").toString());	
			vpd.put("var10", varOList.get(i).getString("CREATETIME"));	    
			vpd.put("var11", varOList.get(i).getString("CREATEUSER"));	   
			vpd.put("var12", varOList.get(i).getString("REMARKS"));	    
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
