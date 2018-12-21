package com.flc.controller.system.wybj;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.json.JSONArray;
import javax.annotation.Resource;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.flc.controller.base.BaseController;
import com.flc.entity.Page;
import com.flc.util.AppUtil;
import com.flc.util.ObjectExcelView;
import com.flc.util.PageData;
import com.flc.util.Jurisdiction;
import com.flc.util.Tools;
import com.flc.service.system.posthost.PosthostManager;
import com.flc.service.system.wybj.WybjManager;

/** 
 * 说明：文案编辑
 * 创建人：FLC
 * 创建时间：2018-10-05
 */
@Controller
@RequestMapping(value="/wybj")
public class WybjController extends BaseController {
	
	String menuUrl = "wybj/list.do"; //菜单地址(权限用)
	@Resource(name="wybjService")
	private WybjManager wybjService;
	
	@Resource(name="posthostService")
	private PosthostManager posthostService;
	
	/**保存
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/save")
	public ModelAndView save() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"新增Wybj");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("WYBJ_ID", this.get32UUID());	//主键
		wybjService.save(pd);
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}
	
	/**删除
	 * @param out
	 * @throws Exception
	 */
	@RequestMapping(value="/delete")
	@ResponseBody
	public Object delete(@RequestParam String WYBJ_ID) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"删除Wybj");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return null;} 					//校验权限
		Map<String,String> map = new HashMap<String,String>();
		PageData pd = new PageData();
		pd.put("WYBJ_ID", WYBJ_ID);
		String errInfo = "success";
		if(wybjService.listByParentId(WYBJ_ID).size() > 0){		//判断是否有子级，是：不允许删除
			errInfo = "false";
		}else{
			wybjService.delete(pd);	//执行删除
		}
		map.put("result", errInfo);
		return AppUtil.returnObject(new PageData(), map);
	}
	
	/**修改
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/edit")
	public ModelAndView edit() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"修改Wybj");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		wybjService.edit(pd);
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
		logBefore(logger, Jurisdiction.getUsername()+"列表Wybj");
		//if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;} 	//校验权限(无权查看时页面会有提示,如果不注释掉这句代码就无法进入列表页面,所以根据情况是否加入本句代码)
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String keywords = pd.getString("keywords");								//关键词检索条件
		if(null != keywords && !"".equals(keywords)){
			pd.put("keywords", keywords.trim());
		}
		String WYBJ_ID = null == pd.get("WYBJ_ID")?"":pd.get("WYBJ_ID").toString();
		if(null != pd.get("id") && !"".equals(pd.get("id").toString())){
			WYBJ_ID = pd.get("id").toString();
		}
		pd.put("WYBJ_ID", WYBJ_ID);					//上级ID
		page.setPd(pd);
		List<PageData>	varList = wybjService.list(page);			//列出Wybj列表
		if(varList.size()==0){
			List<PageData>	varList1 = posthostService.list(page);	//列出Posthost列表
			
			mv.setViewName("system/posthost/posthost_list");
			mv.addObject("varList", varList1);
			
			mv.addObject("pd", pd);
			mv.addObject("QX",Jurisdiction.getHC());	//按钮权限
		}else{
			mv.setViewName("system/wybj/wybj_list");
			mv.addObject("pd", wybjService.findById(pd));				//传入上级所有信息
			mv.addObject("WYBJ_ID", WYBJ_ID);			//上级ID
			mv.addObject("varList", varList);
			mv.addObject("QX",Jurisdiction.getHC());								//按钮权限
		}
		
		return mv;
	}

	/**
	 * 显示列表ztree
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/listTree")
	public ModelAndView listTree(Model model,String WYBJ_ID)throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		try{
			JSONArray arr = JSONArray.fromObject(wybjService.listTree("0"));
			 
			String json = arr.toString();
			json = json.replaceAll("WYBJ_ID", "id").replaceAll("PARENT_ID", "pId").replaceAll("NAME", "name").replaceAll("subWybj", "nodes").replaceAll("hasWybj", "checked").replaceAll("treeurl", "url").replaceAll("MODULTYPE", "moduletype");
			model.addAttribute("zTreeNodes", json);
			mv.addObject("WYBJ_ID",WYBJ_ID);
			mv.addObject("pd", pd);	
			mv.setViewName("system/wybj/wybj_tree");
		} catch(Exception e){
			logger.error(e.toString(), e);
		}
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
		String WYBJ_ID = null == pd.get("WYBJ_ID")?"":pd.get("WYBJ_ID").toString();
		pd.put("WYBJ_ID", WYBJ_ID);					//上级ID
		mv.addObject("pds",wybjService.findById(pd));				//传入上级所有信息
		mv.addObject("WYBJ_ID", WYBJ_ID);			//传入ID，作为子级ID用
		mv.setViewName("system/wybj/wybj_edit");
		mv.addObject("msg", "save");
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
		String WYBJ_ID = pd.getString("WYBJ_ID");
		pd = wybjService.findById(pd);							//根据ID读取		
		mv.addObject("pd", pd);													//放入视图容器
		pd.put("WYBJ_ID",pd.get("PARENT_ID").toString());			//用作上级信息
		mv.addObject("pds",wybjService.findById(pd));				//传入上级所有信息
		mv.addObject("WYBJ_ID", pd.get("PARENT_ID").toString());	//传入上级ID，作为子ID用
		pd.put("WYBJ_ID",WYBJ_ID);					//复原本ID
		pd = wybjService.findById(pd);							//根据ID读取
		mv.setViewName("system/wybj/wybj_edit");
		mv.addObject("msg", "edit");
		return mv;
	}	
	
	 /**导出到excel
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/excel")
	public ModelAndView exportExcel() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"导出Wybj到excel");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;}
		ModelAndView mv = new ModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		Map<String,Object> dataMap = new HashMap<String,Object>();
		List<String> titles = new ArrayList<String>();
		titles.add("模块名称");	//1
		titles.add("模块类型");	//2
		dataMap.put("titles", titles);
		List<PageData> varOList = wybjService.listAll(pd);
		List<PageData> varList = new ArrayList<PageData>();
		for(int i=0;i<varOList.size();i++){
			PageData vpd = new PageData();
			vpd.put("var1", varOList.get(i).getString("MODULENAME"));	    //1
			vpd.put("var2", varOList.get(i).getString("MODULETYPE"));	    //2
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
