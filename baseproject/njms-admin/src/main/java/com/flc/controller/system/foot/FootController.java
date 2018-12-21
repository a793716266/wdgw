package com.flc.controller.system.foot;

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
import com.flc.util.Jurisdiction;
import com.flc.util.Tools;
import com.flc.service.system.foot.FootManager;

/** 
 * 说明：学习资源设置
 * 创建人：FLC
 * 创建时间：2018-08-10
 */
@Controller
@RequestMapping(value="/foot")
public class FootController extends BaseController {
	
	String menuUrl = "foot/list.do"; //菜单地址(权限用)
	@Resource(name="footService")
	private FootManager footService;
	private String saveFileName = "footPri";// 图片保存文件夹
	/**保存
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/save")
	public ModelAndView save(HttpServletRequest myrequest, HttpSession session,
			@ModelAttribute("PageData") @Validated PageData pd, BindingResult br) throws Exception {
		logBefore(logger, Jurisdiction.getUsername() + "新增Foot");
		ModelAndView mv = this.getModelAndView();
		if (!Jurisdiction.buttonJurisdiction(menuUrl, "add")) {
			return null;
		} // 校验权限
		if (br.hasErrors()) {
			mv.setViewName("save_result");
			return mv;
		}
		// 页面的file的name myfile
		String imageName = PriUpLoadFile.uploadFile(myrequest, session, "myfile");
		pd = this.getPageData();
		User user = (User) session.getAttribute("sessionUser");
		String COUNT = myrequest.getParameter("COUNT");
		String NAME = myrequest.getParameter("NAME");
		String REMARKS = myrequest.getParameter("REMARKS");
		String RESPATH = myrequest.getParameter("RESPATH");
		pd.put("FOOT_ID", this.get32UUID()); // 主键
		pd.put("LOGO", imageName);
		pd.put("COUNT", COUNT); // 数量
		pd.put("NAME", NAME); // 名称
		pd.put("REMARKS", REMARKS); // 备注
		pd.put("RESPATH", RESPATH); // 资源路径
		pd.put("CREATETIME", Tools.date2Str(new Date())); // 创建时间
		pd.put("CREATEUSER", user.getNAME()); // 创建人
		footService.save(pd);
		mv.addObject("msg", "success");
		mv.setViewName("save_result");
		return mv;
	}
	
	/**删除
	 * @param out
	 * @throws Exception
	 */
	@RequestMapping(value="/delete")
	public void delete(PrintWriter out, HttpSession session) throws Exception {
		logBefore(logger, Jurisdiction.getUsername() + "删除Foot");
		if (!Jurisdiction.buttonJurisdiction(menuUrl, "del")) {
			return;
		} // 校验权限
		PageData pd = new PageData();
		pd = this.getPageData();
		PageData priData = footService.findById(pd);
		PriUpLoadFile.FileDelete(session, priData.getString("LOGO"));
		footService.delete(pd);
		out.write("success");
		out.close();
	}
	
	/**修改
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/edit")
	public ModelAndView edit(HttpServletRequest myrequest, HttpSession session) throws Exception {
		logBefore(logger, Jurisdiction.getUsername() + "修改Foot");
		if (!Jurisdiction.buttonJurisdiction(menuUrl, "edit")) {
			return null;
		} // 校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String footID =(String) session.getAttribute("footID");
		pd.put("FOOT_ID", footID);
		PageData priData = footService.findById(pd); // 根据ID获取对象
		MultipartRequest request = (MultipartRequest) myrequest;
		MultipartFile pageImage = request.getFile("myfile");
		String pri = pageImage.getOriginalFilename();// 获取上传文件的原名
		if (pri != null && !"".equals(pri)) {
			// 还得删除原来图片File.separator文件"/"
			String priName = priData.getString("LOGO");
			PriUpLoadFile.FileDelete(session,  priName);// 删除
			// 获取上传的文件名称的
			String newPriName = PriUpLoadFile.uploadFile(myrequest, session, "myfile");// 上传返回文件名称
			pd.put("LOGO", newPriName);// 图片
		} else {
			pd.put("LOGO", priData.getString("LOGO"));
			session.removeAttribute("footID");
		}
		User user = (User) session.getAttribute("sessionUser");
		String COUNT = myrequest.getParameter("COUNT");
		String NAME = myrequest.getParameter("NAME");
		String REMARKS = myrequest.getParameter("REMARKS");
		String RESPATH = myrequest.getParameter("RESPATH"); // 资源路径
		pd.put("COUNT", COUNT); // 数量
		pd.put("NAME", NAME); // 描述名
		pd.put("REMARKS", REMARKS); // 备注
		pd.put("RESPATH", RESPATH); // 资源路径
		pd.put("CREATETIME", Tools.date2Str(new Date()));// 创建时间
		pd.put("CREATEUSER", user.getNAME()); // 创建人
		footService.edit(pd);
		mv.addObject("msg", "success");
		mv.setViewName("save_result");
		return mv;
	}
	
	/**列表
	 * @param page
	 * @throws Exception
	 */
	@RequestMapping(value="/list")
	public ModelAndView list(Page page) throws Exception {
		logBefore(logger, Jurisdiction.getUsername() + "列表Foot");
		// if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;}
		// //校验权限(无权查看时页面会有提示,如果不注释掉这句代码就无法进入列表页面,所以根据情况是否加入本句代码)
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		page.setPd(pd);
		List<PageData> varList = footService.list(page); // 列出Foot列表
		for (PageData pdata : varList) {
			if (pdata.getString("LOGO") != null) {
				pdata.put("LOGO", PriUpLoadFile.getFilePath(pdata.getString("LOGO")));
			}
		}
		mv.setViewName("system/foot/foot_list");
		mv.addObject("varList", varList);
		mv.addObject("pd", pd);
		mv.addObject("QX", Jurisdiction.getHC()); // 按钮权限
		return mv;
	}
	
	/**去新增页面
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/goAdd")
	public ModelAndView goAdd() throws Exception {
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		mv.setViewName("system/foot/foot_edit");
		mv.addObject("msg", "save");
		mv.addObject("pd", pd);
		return mv;
	}
	
	 /**去修改页面
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/goEdit")
	public ModelAndView goEdit(HttpSession session) throws Exception {
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd = footService.findById(pd); // 根据ID读取
		if (pd.getString("LOGO") != null) {
			pd.put("LOGO", PriUpLoadFile.getFilePath( pd.getString("LOGO")));
		}
		mv.setViewName("system/foot/foot_edit");
		session.setAttribute("footID", pd.getString("FOOT_ID"));// 存入footID留作修改用
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
		logBefore(logger, Jurisdiction.getUsername()+"批量删除Foot");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return null;} //校验权限
		PageData pd = new PageData();		
		Map<String,Object> map = new HashMap<String,Object>();
		pd = this.getPageData();
		List<PageData> pdList = new ArrayList<PageData>();
		String DATA_IDS = pd.getString("DATA_IDS");
		if(null != DATA_IDS && !"".equals(DATA_IDS)){
			String ArrayDATA_IDS[] = DATA_IDS.split(",");
			footService.deleteAll(ArrayDATA_IDS);
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
		logBefore(logger, Jurisdiction.getUsername()+"导出Foot到excel");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;}
		ModelAndView mv = new ModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		Map<String,Object> dataMap = new HashMap<String,Object>();
		List<String> titles = new ArrayList<String>();
		titles.add("资源标志");	//1
		titles.add("资源内容");	//2
		titles.add("资源名称");	//3
		titles.add("备注");	//4
		titles.add("创建时间");	//5
		titles.add("创建人");	//6
		titles.add("资源路径");	//7
		dataMap.put("titles", titles);
		List<PageData> varOList = footService.listAll(pd);
		List<PageData> varList = new ArrayList<PageData>();
		for(int i=0;i<varOList.size();i++){
			PageData vpd = new PageData();
			vpd.put("var1", varOList.get(i).getString("LOGO"));	    //1
			vpd.put("var2", varOList.get(i).getString("COUNT"));	    //2
			vpd.put("var3", varOList.get(i).getString("NAME"));	    //3
			vpd.put("var4", varOList.get(i).getString("REMARKS"));	    //4
			vpd.put("var5", varOList.get(i).getString("CREATETIME"));	    //5
			vpd.put("var6", varOList.get(i).getString("CREATEUSER"));	    //6
			vpd.put("var7", varOList.get(i).getString("RESPATH"));	    //7
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
