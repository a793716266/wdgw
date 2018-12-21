package com.flc.controller.system.datadownload;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

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
import com.mysql.fabric.xmlrpc.base.Data;
import com.flc.service.system.datadownload.DataDownloadManager;

/** 
 * 说明：论坛资料下载
 * 创建人：FLC
 * 创建时间：2018-08-22
 */
@Controller
@RequestMapping(value="/datadownload")
public class DataDownloadController extends BaseController {
	
	String menuUrl = "datadownload/list.do"; //菜单地址(权限用)
	@Resource(name="datadownloadService")
	private DataDownloadManager datadownloadService;
	
	/**保存
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/save")
	public ModelAndView save() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"新增DataDownload");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();

		String suffix = pd.getString("suffix");
		String dataSize = pd.getString("DATASIZE");
		pd.put("DATASIZE", dataSize+suffix);
		
		//获取创建人
		Session session = Jurisdiction.getSession();
		User attribute = (User) session.getAttribute(Const.SESSION_USER);
		pd.put("CREATEUSER", attribute.getUSERNAME());
		//获取当前创建时间
		pd.put("CREATETIME", new Date());
		
		pd.put("DATADOWNLOAD_ID", this.get32UUID());	//主键
		datadownloadService.save(pd);
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
		logBefore(logger, Jurisdiction.getUsername()+"删除DataDownload");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return;} //校验权限
		PageData pd = new PageData();
		pd = this.getPageData();
		datadownloadService.delete(pd);
		out.write("success");
		out.close();
	}
	
	/**修改
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/edit")
	public ModelAndView edit() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"修改DataDownload");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		datadownloadService.edit(pd);
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
		logBefore(logger, Jurisdiction.getUsername()+"列表DataDownload");
		//if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;} //校验权限(无权查看时页面会有提示,如果不注释掉这句代码就无法进入列表页面,所以根据情况是否加入本句代码)
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String keywords = pd.getString("keywords");				//关键词检索条件
		if(null != keywords && !"".equals(keywords)){
			pd.put("keywords", keywords.trim());
		}
		//模糊查询时间字段
		String lastStart = pd.getString("lastStart");
		String lastEnd = pd.getString("lastEnd");
		if (null != lastStart && !"".equals(lastStart)) {
			pd.put("lastStart", lastStart);
		}
		if (null != lastEnd && !"".equals(lastEnd)) {
			pd.put("lastEnd", lastEnd);
		}
		
		page.setPd(pd);
		List<PageData>	varList = datadownloadService.list(page);	//列出DataDownload列表
		mv.setViewName("system/datadownload/datadownload_list");
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
		mv.setViewName("system/datadownload/datadownload_edit");
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
		pd = datadownloadService.findById(pd);	//根据ID读取
		mv.setViewName("system/datadownload/datadownload_edit");
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
		logBefore(logger, Jurisdiction.getUsername()+"批量删除DataDownload");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return null;} //校验权限
		PageData pd = new PageData();		
		Map<String,Object> map = new HashMap<String,Object>();
		pd = this.getPageData();
		List<PageData> pdList = new ArrayList<PageData>();
		String DATA_IDS = pd.getString("DATA_IDS");
		if(null != DATA_IDS && !"".equals(DATA_IDS)){
			String ArrayDATA_IDS[] = DATA_IDS.split(",");
			datadownloadService.deleteAll(ArrayDATA_IDS);
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
		logBefore(logger, Jurisdiction.getUsername()+"导出DataDownload到excel");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;}
		ModelAndView mv = new ModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		Map<String,Object> dataMap = new HashMap<String,Object>();
		List<String> titles = new ArrayList<String>();
		titles.add("资料名称");	//1
		titles.add("资料大小");	//2
		titles.add("网盘下载");	//3
		titles.add("查看介绍");	//4
		titles.add("下载次数");	//5
		titles.add("创建人");	//6
		titles.add("创建时间");	//7
		titles.add("备注");	//8
		dataMap.put("titles", titles);
		List<PageData> varOList = datadownloadService.listAll(pd);
		List<PageData> varList = new ArrayList<PageData>();
		for(int i=0;i<varOList.size();i++){
			PageData vpd = new PageData();
			vpd.put("var1", varOList.get(i).getString("DATANAME"));	    //1
			vpd.put("var2", varOList.get(i).getString("DATASIZE"));	    //2
			vpd.put("var3", varOList.get(i).getString("KANBOXURL"));	    //3
			vpd.put("var4", varOList.get(i).getString("LOOKINTRODUCEURL"));	    //4
			vpd.put("var5", varOList.get(i).get("DOWNLOADCOUNT").toString());	//5
			vpd.put("var6", varOList.get(i).getString("CREATEUSER"));	    //6
			vpd.put("var7", varOList.get(i).getString("CREATETIME"));	    //7
			vpd.put("var8", varOList.get(i).getString("REMARKS"));	    //8
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
