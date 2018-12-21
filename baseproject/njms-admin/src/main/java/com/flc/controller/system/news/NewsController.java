package com.flc.controller.system.news;

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
import com.flc.service.system.news.NewsManager;
import com.flc.service.system.newtype.NewTypeManager;

/** 
 * 说明：新闻表
 * 创建人：FLC
 * 创建时间：2018-07-24
 */
@Controller
@RequestMapping(value="/news")
public class NewsController extends BaseController {
	
	String menuUrl = "news/list.do"; //菜单地址(权限用)
	@Resource(name="newsService")
	private NewsManager newsService;
	
	@Resource(name="newtypeService")
	private NewTypeManager newtypeService;
	private String saveFileName = "news";
	
	/**保存
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/save")
	public ModelAndView save(HttpServletRequest req,HttpSession session, @ModelAttribute("PageData") @Validated PageData pd , BindingResult br) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"新增News");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		if(br.hasErrors()){
			mv.setViewName("save_result");
			return mv;
		}
		//image file的name值
		String ipath = PriUpLoadFile.uploadFile(req, session, "myfile");
		User u = (User)session.getAttribute("sessionUser");
		pd = this.getPageData();
		String type = req.getParameter("type");		//获取下拉框值
		String NEWTITLE = req.getParameter("NEWTITLE");
		String NEWCONTENT = req.getParameter("NEWCONTENT");
		String REMARKS = req.getParameter("REMARKS");
		String CREATETIME = req.getParameter("CREATETIME");
		String AUTHOR = req.getParameter("AUTHOR");
		String ORIGIN = req.getParameter("ORIGIN");
		String CLICKS = req.getParameter("CLICKS");
		pd.put("PICTURENAME",ipath);
		pd.put("NEWTITLE",NEWTITLE);
		pd.put("NEWCONTENT",NEWCONTENT);
		pd.put("REMARKS",REMARKS);
		pd.put("NEWS_ID", this.get32UUID());	//主键
		
		pd.put("CREATETIME", CREATETIME);	//发布时间
		pd.put("AUTHOR", AUTHOR);	
		pd.put("ORIGIN", ORIGIN);	
		pd.put("CLICKS", CLICKS);	//点击量
		pd.put("CREATEUSER",u.getUSERNAME());
		pd.put("NEWSTYPE",type);
		newsService.save(pd);
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}
	
	/**删除
	 * @param out
	 * @throws Exception
	 */
	@RequestMapping(value="/delete")
	public void delete(PrintWriter out,HttpSession session) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"删除News");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return;} //校验权限
		PageData pd = new PageData();
		pd = this.getPageData();
		PageData priData = newsService.findById(pd);//获取删除对象
		String priName=priData.getString("PICTURENAME");
		newsService.delete(pd);
		PriUpLoadFile.FileDelete(session,priName);
		out.write("success");
		out.close();
	}
	
	/**修改
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/edit")
	public ModelAndView edit(HttpServletRequest req,HttpSession session) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"修改News");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String id = (String) session.getAttribute("id");//获取修改的对象id
		pd.put("NEWS_ID", id);
		session.removeAttribute("id");
		PageData priData = newsService.findById(pd);//获取修改的对象
		MultipartRequest request = (MultipartRequest) req;
		MultipartFile pageImage = request.getFile("myfile");
		String name1 = pageImage.getOriginalFilename();
		//上传的图片是否有值
		if(name1 != null && ! "".equals(name1)){
			//还得删除原来图片
			String priName=priData.getString("PICTURENAME");
			PriUpLoadFile.FileDelete(session,  priName);
			//获取上传的文件名称的
			String newPri=PriUpLoadFile.uploadFile(req, session, "myfile");//上传返回文件名称
			pd.put("PICTURENAME",newPri);
		}else {
			pd.put("PICTURENAME", priData.getString("PICTURENAME"));
			session.removeAttribute("id");
		}
		User u = (User) session.getAttribute("sessionUser");
		String type = req.getParameter("type");		//获取下拉框值
		String NEWTITLE = req.getParameter("NEWTITLE");
		String NEWCONTENT = req.getParameter("NEWCONTENT");
		String REMARKS = req.getParameter("REMARKS");
		String CREATETIME = req.getParameter("CREATETIME");
		String AUTHOR = req.getParameter("AUTHOR");
		String ORIGIN = req.getParameter("ORIGIN");
		String CLICKS = req.getParameter("CLICKS");
		pd.put("NEWTITLE",NEWTITLE);
		pd.put("NEWCONTENT",NEWCONTENT);
		pd.put("REMARKS",REMARKS);
		pd.put("CREATETIME", CREATETIME);	//发布时间
		pd.put("AUTHOR", AUTHOR);	
		pd.put("ORIGIN", ORIGIN);
		pd.put("CLICKS", CLICKS);
		pd.put("CREATEUSER",u.getUSERNAME());
		pd.put("NEWSTYPE",type);
		newsService.edit(pd);
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
		logBefore(logger, Jurisdiction.getUsername()+"列表News");
		//if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;} //校验权限(无权查看时页面会有提示,如果不注释掉这句代码就无法进入列表页面,所以根据情况是否加入本句代码)
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		List<PageData> list = newtypeService.listAll(pd);
		pd = this.getPageData();
		String keywords = pd.getString("keywords");				//关键词检索条件
		if(null != keywords && !"".equals(keywords)){
			pd.put("keywords", keywords.trim());
		}
		String lastStart = pd.getString("lastStart");			//开始时间检索
		if(null != lastStart && !"".equals(lastStart)){
			pd.put("lastStart", lastStart.trim());
		}
		String lastEnd = pd.getString("lastEnd");				//结束时间检索
		if(null != lastEnd && !"".equals(lastEnd)){
			pd.put("lastEnd", lastEnd.trim());
		}
		String type = pd.getString("type");						//根据类型检索
		if(null != type && !"".equals(type)){
			pd.put("type", type.trim());
		}
		page.setPd(pd);
		List<PageData>	varList = newsService.list(page);	//列出News列表
		for (PageData pdata : varList) {
			if(pdata.getString("PICTURENAME")!=null){
				pdata.put("PICTURENAME", PriUpLoadFile.getFilePath( pdata.getString("PICTURENAME")));
			}
		}
		mv.setViewName("system/news/news_list");
		mv.addObject("varList", varList);
		mv.addObject("list",list);
		mv.addObject("type",type);
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
		List<PageData> list = newtypeService.listAll(pd);
		mv.setViewName("system/news/news_edit");
		mv.addObject("msg", "save");
		mv.addObject("list",list);
		mv.addObject("pd", pd);
		return mv;
	}	
	
	 /**去修改页面
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/goEdit")
	public ModelAndView goEdit(HttpSession s)throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		List<PageData> list = newtypeService.listAll(pd);
		pd = this.getPageData();
		pd = newsService.findById(pd);	//根据ID读取
		s.setAttribute("id",pd.getString("NEWS_ID"));
		if(pd.getString("PICTURENAME")!=null){
			pd.put("PICTURENAME", PriUpLoadFile.getFilePath( pd.getString("PICTURENAME")));
		}
		mv.setViewName("system/news/news_edit");
		mv.addObject("msg", "edit");
		mv.addObject("list",list);
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
		logBefore(logger, Jurisdiction.getUsername()+"批量删除News");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return null;} //校验权限
		PageData pd = new PageData();		
		Map<String,Object> map = new HashMap<String,Object>();
		pd = this.getPageData();
		List<PageData> pdList = new ArrayList<PageData>();
		String DATA_IDS = pd.getString("DATA_IDS");
		if(null != DATA_IDS && !"".equals(DATA_IDS)){
			String ArrayDATA_IDS[] = DATA_IDS.split(",");
			newsService.deleteAll(ArrayDATA_IDS);
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
		logBefore(logger, Jurisdiction.getUsername()+"导出News到excel");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;}
		ModelAndView mv = new ModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String keywords = pd.getString("keywords");				//关键词检索条件
		if(null != keywords && !"".equals(keywords)){
			pd.put("keywords", keywords.trim());
		}
		String lastStart = pd.getString("lastStart");			//开始时间检索
		if(null != lastStart && !"".equals(lastStart)){
			pd.put("lastStart", lastStart.trim());
		}
		String lastEnd = pd.getString("lastEnd");				//结束时间检索
		if(null != lastEnd && !"".equals(lastEnd)){
			pd.put("lastEnd", lastEnd.trim());
		}
		String type = pd.getString("type");						//根据类型检索
		if(null != type && !"".equals(type)){
			pd.put("type", type.trim());
		}
		Map<String,Object> dataMap = new HashMap<String,Object>();
		List<String> titles = new ArrayList<String>();
		titles.add("图片");	//1
		titles.add("新闻标题");	//2
		titles.add("新闻内容");	//3
		titles.add("新闻类型");	//4
		titles.add("发布时间");	//5
		titles.add("创建人");	//6
		titles.add("备注");	//7
		titles.add("总记录数");//8
		dataMap.put("titles", titles);
		List<PageData> varOList = newsService.listAll(pd);
		String index = String.valueOf(varOList.size());
		List<PageData> varList = new ArrayList<PageData>();
		for(int i=0;i<varOList.size();i++){
			PageData vpd = new PageData();
			vpd.put("var1", varOList.get(i).getString("PICTURENAME"));	    //1
			vpd.put("var2", varOList.get(i).getString("NEWTITLE"));	    //2
			vpd.put("var3", varOList.get(i).getString("NEWCONTENT"));	    //3
			vpd.put("var4", varOList.get(i).getString("NEWSTYPE"));	    //4
			vpd.put("var5", varOList.get(i).getString("CREATETIME"));	    //5
			vpd.put("var6", varOList.get(i).getString("CREATEUSER"));	    //6
			vpd.put("var7", varOList.get(i).getString("REMARKS"));	    //7
			if(i==0){
				vpd.put("var8", index);
			}
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
