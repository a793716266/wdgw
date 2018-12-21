package com.flc.controller.system.broadcast;

import java.io.File;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
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
import com.flc.util.Tools;
import com.flc.util.Jurisdiction;
import com.flc.service.system.broadcast.BroadcastManager;

/**
 * 说明：首页轮播管理表 创建人：FLC 创建时间：2018-07-24
 */
@Controller
@RequestMapping(value = "/broadcast")
public class BroadcastController extends BaseController {

	String menuUrl = "broadcast/list.do"; // 菜单地址(权限用)
	@Resource(name = "broadcastService")
	private BroadcastManager broadcastService;
	private String saveFileName="broadcast";//图片保存文件夹
	/**
	 * 保存
	 * 
	 * @param out
	 * @throws Exception
	 */
	@RequestMapping(value = "/save")
	public ModelAndView save(HttpServletRequest myrequest, HttpSession session,
			@ModelAttribute("PageData") @Validated PageData pd, BindingResult br) throws Exception {
		logBefore(logger, Jurisdiction.getUsername() + "新增Curriculum");
		ModelAndView mv = this.getModelAndView();
		if (!Jurisdiction.buttonJurisdiction(menuUrl, "add")) {
			return null;
		} // 校验权限
		if (br.hasErrors()) {
			mv.setViewName("save_result");
			return mv;
		}
		// 页面的file的name myfile
		String imageName = PriUpLoadFile.uploadFile(myrequest,session,"myfile");
		pd = this.getPageData();
		User user = (User) session.getAttribute("sessionUser");
		String picturestate = myrequest.getParameter("PICTURESTATE");
		String broadcastpage = myrequest.getParameter("BROADCASTPAGE");
		String remarks = myrequest.getParameter("REMARKS");
		pd.put("BROADCAST_ID", this.get32UUID()); // 主键
		if (imageName != null) {
			// 图片
		}
		pd.put("PICTUREPATH", imageName);
		pd.put("PICTURESTATE", picturestate);// 状态
		pd.put("BROADCASTPAGE", broadcastpage);// 轮播页面
		pd.put("CREATEUSER", user.getUSERNAME());// 创建人
		pd.put("REMARKS", remarks);// 备注
		pd.put("CREATETIME", Tools.date2Str(new Date())); // 添加时间
		broadcastService.save(pd);
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
		logBefore(logger, Jurisdiction.getUsername() + "删除Broadcast");
		if (!Jurisdiction.buttonJurisdiction(menuUrl, "del")) {
			return;
		} // 校验权限
		PageData pd = new PageData();
		pd = this.getPageData();
		PageData priData = broadcastService.findById(pd);//获取删除对象
		String priName=priData.getString("PICTUREPATH");
		broadcastService.delete(pd);
		PriUpLoadFile.FileDelete(session,priName);
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
		logBefore(logger, Jurisdiction.getUsername() + "修改Broadcast");
		if (!Jurisdiction.buttonJurisdiction(menuUrl, "edit")) {
			return null;
		} // 校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = (PageData) session.getAttribute("broadcast");
		PageData priData = broadcastService.findById(pd); // 根据ID获取对象
		MultipartRequest request = (MultipartRequest) myrequest;
		
		MultipartFile pageImage = request.getFile("myfile");// 获取名称
		String pri = pageImage.getOriginalFilename();// 获取上传文件的原名
		// 上传的图片是否有值
		if (pri != null && !"".equals(pri)) {
			// 还得删除原来图片File.separator文件"/"
			String priName=priData.getString("PICTUREPATH");
			PriUpLoadFile.FileDelete(session,priName);//删除
			// 获取上传的文件名称的
			String newPriName = PriUpLoadFile.uploadFile(myrequest, session, "myfile");// 上传返回文件名称
			pd.put("PICTUREPATH", newPriName);// 图片
		}else {
			pd.put("PICTUREPATH", priData.getString("PICTUREPATH"));
			session.removeAttribute("broadcast");
		}
		User user = (User) session.getAttribute("sessionUser");
		String picturestate = myrequest.getParameter("PICTURESTATE");
		String broadcastpage = myrequest.getParameter("BROADCASTPAGE");
		String remarks = myrequest.getParameter("REMARKS");
		pd.put("PICTURESTATE", picturestate);// 状态
		pd.put("BROADCASTPAGE", broadcastpage);// 轮播页面
		pd.put("CREATEUSER", user.getUSERNAME());// 创建人
		pd.put("REMARKS", remarks);// 备注
		pd.put("CREATETIME", Tools.date2Str(new Date())); // 添加时间
		broadcastService.edit(pd);
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
		logBefore(logger, Jurisdiction.getUsername() + "列表Broadcast");
		// if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;}
		// //校验权限(无权查看时页面会有提示,如果不注释掉这句代码就无法进入列表页面,所以根据情况是否加入本句代码)
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String broadcastpage = pd.getString("BROADCASTPAGE");//状态
		if (null != broadcastpage && !"".equals(broadcastpage)) {
			pd.put("broadcastpage", broadcastpage.trim());
		}
		page.setPd(pd);
		List<PageData> varList = broadcastService.list(page); // 列出Broadcast列表
		for (PageData pdata : varList) {
			if(pdata.getString("PICTUREPATH")!=null){
				pdata.put("PICTUREPATH", PriUpLoadFile.getFilePath(pdata.getString("PICTUREPATH")));
			}
		}
		mv.setViewName("system/broadcast/broadcast_list");
		mv.addObject("varList", varList);
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
		mv.setViewName("system/broadcast/broadcast_edit");
		mv.addObject("msg", "save");
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
		pd = broadcastService.findById(pd); // 根据ID读取
		if(pd.getString("PICTUREPATH")!=null){
			pd.put("PICTUREPATH", PriUpLoadFile.getFilePath( pd.getString("PICTUREPATH")));
		}
		mv.setViewName("system/broadcast/broadcast_edit");
		mv.addObject("msg", "edit");
		session.setAttribute("broadcast", pd);// 修改的对象
		mv.addObject("pd", pd);
		return mv;
	}

	/**
	 * 批量删除
	 * 
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value = "/deleteAll")
	@ResponseBody
	public Object deleteAll() throws Exception {
		logBefore(logger, Jurisdiction.getUsername() + "批量删除Broadcast");
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
			broadcastService.deleteAll(ArrayDATA_IDS);
			pd.put("msg", "ok");
		} else {
			pd.put("msg", "no");
		}
		pdList.add(pd);
		map.put("list", pdList);
		return AppUtil.returnObject(pd, map);
	}



	@InitBinder
	public void initBinder(WebDataBinder binder) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format, true));
	}
}
