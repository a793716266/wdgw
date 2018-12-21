package com.flc.controller.system.posthost;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.flc.controller.base.BaseController;
import com.flc.entity.Page;
import com.flc.util.AppUtil;
import com.flc.util.ObjectExcelView;
import com.flc.util.PageData;
import com.flc.util.Jurisdiction;
import com.flc.util.Tools;
import com.flc.service.system.posthost.PosthostManager;
import com.flc.service.system.posthostresult.PostHostResultManager;

/** 
 * 说明：关注度最高帖子列表
 * 创建人：FLC
 * 创建时间：2018-09-28
 */
@Controller
@RequestMapping(value="/posthost")
public class PosthostController extends BaseController {
	
	String menuUrl = "posthost/list.do"; //菜单地址(权限用)
	@Resource(name="posthostService")
	private PosthostManager posthostService;
	
	@Resource(name="posthostresultService")
	private PostHostResultManager posthostresultService;

	/**保存
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/save")
	public ModelAndView save() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"新增Posthost");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		Date date = new Date();
		
		pd.put("CREATEDATA", date);
		pd.put("CREATEUSER", Jurisdiction.getUsername());
		pd.put("POSTHOST_ID", this.get32UUID());	//主键
		posthostService.save(pd);
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
		logBefore(logger, Jurisdiction.getUsername()+"删除Posthost");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return;} //校验权限
		PageData pd = new PageData();
		pd = this.getPageData();
		posthostService.delete(pd);
		posthostService.deleteposthostresult(pd);
		out.write("success");
		out.close();
	}
	
	/**修改
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/edit")
	public ModelAndView edit() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"修改Posthost");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		posthostService.edit(pd);
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}
	@RequestMapping(value="/checkdata")
	@ResponseBody
	public String checkSize(Page page) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"查询是否有数据");
      
		String json="";
		String result="";
		 
		PageData pd = new PageData();
		pd = this.getPageData();
		String POSTHOST_ID = pd.getString("POSTHOST_ID");
		if(null != POSTHOST_ID && !"".equals(POSTHOST_ID)){
			pd.put("POSTHOST_ID", POSTHOST_ID.trim());
		}
		page.setPd(pd);
		List<PageData> list = posthostresultService.list(page);
		
		if(list.size()==0){
			result="0";
		}else{
			result="1";
		}
		json="{\"result\":\""+result+"\",\"datasize\":\""+list.size()+"\"}";
		return json;
	}
	@RequestMapping(value="/editanimation")
	@ResponseBody
	public String editanimation(Page page) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"修改动画");
		//POSTHOST_ID
		PageData pd = new PageData();
		pd = this.getPageData();
		String json="";
		String result="";
		String ISTRUE = pd.getString("istrue");
		if(null != ISTRUE && !"".equals(ISTRUE)){
			pd.put("ISTRUE", ISTRUE.trim());
		}
		String POSTHOST_ID = pd.getString("POSTHOST_ID");
		if(null != POSTHOST_ID && !"".equals(POSTHOST_ID)){
			pd.put("POSTHOST_ID", POSTHOST_ID.trim());
		}
		page.setPd(pd);
		posthostService.editAnimation(pd);
		if(ISTRUE.equals("1")){
			result="开启成功";
		}else{
			result="关闭成功";
		}
		
		 
		json="{\"result\":\""+result+"\"}";
		return json;
	}
	@RequestMapping(value="/editstatus")
	@ResponseBody
	public String editstatus(Page page) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"修改状态");
		 
		PageData pd = new PageData();
		pd = this.getPageData();
		String status = pd.getString("status");
		if(null != status && !"".equals(status)){
			pd.put("STATUS", status.trim());
		}
		String CONTENTTYPE = pd.getString("CONTENTTYPE");
		if(null != CONTENTTYPE && !"".equals(CONTENTTYPE)){
			pd.put("CONTENTTYPE", CONTENTTYPE.trim());
		}
		String POSTHOST_ID = pd.getString("POSTHOST_ID");
		if(null != POSTHOST_ID && !"".equals(POSTHOST_ID)){
			pd.put("POSTHOST_ID", POSTHOST_ID.trim());
		}
		page.setPd(pd);
		String json="";
		String result="";
		posthostService.editstatusiszero(pd);
		posthostService.editStatus(pd);
		result="发布成功";
		json="{\"result\":\""+result+"\"}";
		return json;
	}
	/**列表
	 * @param page
	 * @throws Exception
	 */
	@RequestMapping(value="/list")
	public ModelAndView list(Page page) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"列表Posthost");
		//if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;} //校验权限(无权查看时页面会有提示,如果不注释掉这句代码就无法进入列表页面,所以根据情况是否加入本句代码)
		ModelAndView mv = this.getModelAndView();
		 
		PageData pd = new PageData();
		pd = this.getPageData();
		String keywords = pd.getString("keywords");				//关键词检索条件moduletype
		String CONTENTTYPE=pd.getString("CONTENTTYPE");	
		if(null != CONTENTTYPE && !"".equals(CONTENTTYPE)){
			pd.put("CONTENTTYPES", CONTENTTYPE.trim());
		}
		if(null != keywords && !"".equals(keywords)){
			pd.put("keywords", keywords.trim());
		}
		page.setPd(pd);
		List<PageData>	varList = posthostService.list(page);	//列出Posthost列表
		 
		mv.setViewName("system/posthost/posthost_list");
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
		mv.setViewName("system/posthost/posthost_edit");
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
		pd = posthostService.findById(pd);	//根据ID读取
		mv.setViewName("system/posthost/posthost_edit");
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
		logBefore(logger, Jurisdiction.getUsername()+"批量删除Posthost");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return null;} //校验权限
		PageData pd = new PageData();		
		Map<String,Object> map = new HashMap<String,Object>();
		pd = this.getPageData();
		List<PageData> pdList = new ArrayList<PageData>();
		String DATA_IDS = pd.getString("DATA_IDS");
		if(null != DATA_IDS && !"".equals(DATA_IDS)){
			String ArrayDATA_IDS[] = DATA_IDS.split(",");
			posthostService.deleteAll(ArrayDATA_IDS);
			posthostService.deleteAllposthostresult(ArrayDATA_IDS);;
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
		@RequestMapping(value="/sql")
		public ModelAndView sql() throws Exception{
			logBefore(logger, Jurisdiction.getUsername()+"导出Posthost到excel");
			if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;}
			ModelAndView mv = new ModelAndView();
			PageData pd = new PageData();
			pd = this.getPageData();
			Map<String,Object> dataMap = new HashMap<String,Object>();
			List<String> titles = new ArrayList<String>();
			String contenttype=null;
			String describe=null;
		    String cp = pd.getString("contenttype");
		    String de = pd.getString("describe");
		    if(cp!=null&&de!=null){
		    	describe=de;
		    	contenttype=cp;
		    }
		    titles.add(describe);	//1
			dataMap.put("titles", titles);
			List<PageData> varList = new ArrayList<PageData>();
			String sql="SELECT  PICSRC ,POSTURL ,TITLE ,ISTRUE FROM `WDGW_POSTSRCTABLE`";
					sql+="JOIN `wdgw_posthost` ";
					sql+="ON `wdgw_postsrctable`.`POSTHOST_ID`=`wdgw_posthost`.`POSTHOST_ID`";
					sql+=" WHERE `wdgw_posthost`.`STATUS`='1' AND `wdgw_posthost`.`CONTENTTYPE`="+contenttype+"";
			 
				PageData vpd = new PageData();
				vpd.put("var1",sql);	    //1
				varList.add(vpd);
		 
			dataMap.put("varList", varList);
			ObjectExcelView erv = new ObjectExcelView();
			mv = new ModelAndView(erv,dataMap);
			return mv;
		}
	 /**导出到excel
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/excel")
	public ModelAndView exportExcel() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"导出Posthost到excel");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;}
		ModelAndView mv = new ModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		Map<String,Object> dataMap = new HashMap<String,Object>();
		List<String> titles = new ArrayList<String>();
		titles.add("表自身id");	//1
		titles.add("postsrctable表id");	//2
		titles.add("创建人");	//3
		titles.add("创建时间");	//4
		dataMap.put("titles", titles);
		List<PageData> varOList = posthostService.listAll(pd);
		List<PageData> varList = new ArrayList<PageData>();
		for(int i=0;i<varOList.size();i++){
			PageData vpd = new PageData();
			vpd.put("var1", varOList.get(i).getString("POSTHOSTID"));	    //1
			vpd.put("var2", varOList.get(i).getString("POSTSRCTABLEID"));	    //2
			vpd.put("var3", varOList.get(i).getString("CREATEUSER"));	    //3
			vpd.put("var4", varOList.get(i).getString("CREATEDATA"));	    //4
			vpd.put("var5", varOList.get(i).getString("DESCRIBE"));	    //4
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
