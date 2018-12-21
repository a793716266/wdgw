package com.flc.controller.system.posthostresult;

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

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import com.flc.controller.base.BaseController;
import com.flc.entity.Page;
import com.flc.util.AppUtil;
import com.flc.util.ObjectExcelView;
import com.flc.util.PageData;
import com.flc.util.PictureUpload;
import com.flc.util.Jurisdiction;

import com.flc.service.system.posthostresult.PostHostResultManager;

/** 
 * 说明：帖子热度维护
 * 创建人：FLC
 * 创建时间：2018-09-29
 */
@Controller
@RequestMapping(value="/posthostresult")
public class PostHostResultController extends BaseController {
	
	String menuUrl = "posthostresult/list.do"; //菜单地址(权限用)
	@Resource(name="posthostresultService")
	private PostHostResultManager posthostresultService;
	
	/**保存
	 * @param
	 * @throws Exception
	 */
	private String POSTHOST_ID;
	private MultipartHttpServletRequest mRequest;
	private static String  status=null;
	@Value("${upload.requestPath1}")
	private String requestPath;
	
	@RequestMapping(value="/save")
	public ModelAndView save(MultipartFile file,HttpServletRequest request) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"新增PostHostResult");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
		String msg="success";
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String status=pd.getString("status");//获取状态值
		if(status!=null){
			mv.addObject("status", status);
		}
        	mRequest = (MultipartHttpServletRequest)request;
        	PictureUpload.upLoad(file, mRequest);//调用图片文件上传
    		String PICSRC = PictureUpload.getPicName();//获取上传图片名称
    		String POSTURL = mRequest.getParameter("POSTURL");
        	String TITLE = mRequest.getParameter("TITLE");
        	String POSTHOST_ID = mRequest.getParameter("POSTHOST_ID");	//id
        	String [] str={PICSRC,POSTURL,TITLE,POSTHOST_ID};
        	String  strkey="PICSRC,POSTURL,TITLE,POSTHOST_ID";
        	boolean stringNull = isStringNull(str);
        	if(stringNull){
        		msg="error";
        	}else{
        		putKeys(pd, strkey, str);
        		pd.put("POSTHOSTRESULT_ID", this.get32UUID());	//主键
        		posthostresultService.save(pd);
        	}
    		mv.addObject("msg",msg);
    		mv.setViewName("save_result");
        return mv;
	}
	//验证传入的String类型是否为空
	public boolean isStringNull(String [] str){
			boolean isNull=false;
			for (String item : str) {
				if(item==null&&"".equals(item)){
					isNull=true;
					return isNull;
				}
			}
		return isNull;
	}
	//动态添加pd键值
	public void putKeys(PageData pd,String strkey,String [] str){
		int index=0;
		String [] sky=strkey.split(",");
		for (String item : sky) {
			pd.put(item, str[index]);
			index++;
		}
	}
	/**删除
	 * @param out
	 * @throws Exception
	 */
	@RequestMapping(value="/delete")
	public void delete(PrintWriter out) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"删除PostHostResult");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return;} //校验权限
		PageData pd = new PageData();
		pd = this.getPageData();
		
		posthostresultService.delete(pd);
		out.write("success");
		out.close();
	}
	
	/**修改
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/edit")
	public ModelAndView edit(MultipartFile file,HttpServletRequest request) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"修改PostHostResult");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String msg="success";
		String status=pd.getString("status");//获取状态值
		if(status!=null){
			mv.addObject("status", status);
		}
		mRequest = (MultipartHttpServletRequest)request;
		String PICSRC=null;
    	PictureUpload.upLoad(file, mRequest);//调用图片文件上传
    	String newpicsrc=PictureUpload.getPicName();
    	String pic=mRequest.getParameter("PICSRC");
    	if(pic!=null&&pic.equals("change")){
    		PICSRC=newpicsrc;
    	}else{
    		PICSRC=pic;
    	}
		 
		String POSTURL = mRequest.getParameter("POSTURL");
    	String TITLE = mRequest.getParameter("TITLE");
    	String POSTHOSTRESULT_ID = mRequest.getParameter("POSTHOSTRESULT_ID");	//id
    	String [] str={PICSRC,POSTURL,TITLE,POSTHOSTRESULT_ID};
    	String  strkey="PICSRC,POSTURL,TITLE,POSTHOSTRESULT_ID";
    	boolean stringNull = isStringNull(str);
    	if(stringNull){
    		msg="error";
    	}else{
    		putKeys(pd, strkey, str);
    		posthostresultService.edit(pd);
    	}
		
		mv.addObject("msg",msg);
		mv.addObject("POSTHOST_ID",POSTHOST_ID);
		mv.setViewName("save_result");
		return mv;
	}
	
	/**列表
	 * @param page
	 * @throws Exception
	 */
	@RequestMapping(value="/list")
	public ModelAndView list(Page page) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"列表PostHostResult");
		//if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;} //校验权限(无权查看时页面会有提示,如果不注释掉这句代码就无法进入列表页面,所以根据情况是否加入本句代码)
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String keywords = pd.getString("keywords");	//关键词检索条件
		String statuse=pd.getString("status");//获取状态值
		if(status==null||(statuse!=null&&status!=statuse&&!statuse.equals(""))){
			status=statuse;//获取状态值
		}
		mv.addObject("status", status);
		String posthostid=pd.getString("POSTHOST_ID");
		if(POSTHOST_ID==null||(posthostid!=null&&POSTHOST_ID!=posthostid)){
			POSTHOST_ID = pd.getString("POSTHOST_ID");	//id
		}
		
		if(null != keywords && !"".equals(keywords)){
			pd.put("keywords", keywords.trim());
		}
		if(null != POSTHOST_ID && !"".equals(POSTHOST_ID)){
			mv.addObject("POSTHOST_ID", POSTHOST_ID);
			pd.put("POSTHOST_ID", POSTHOST_ID.trim());
		}
		page.setPd(pd);
		List<PageData>	varList = posthostresultService.list(page);	//列出PostHostResult列表
		for (PageData pageData : varList) {
			pageData.put("PICSRC", requestPath+pageData.getString("PICSRC"));
		}
		mv.setViewName("system/posthostresult/posthostresult_list");
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
		String POSTHOST_ID = pd.getString("POSTHOST_ID");
		String status=pd.getString("status");//获取状态值
		if(status!=null){
			mv.addObject("status", status);
		}
		if(null != POSTHOST_ID && !"".equals(POSTHOST_ID)){
			mv.addObject("POSTHOST_ID", POSTHOST_ID);
		}
		mv.setViewName("system/posthostresult/posthostresult_edit");
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
		String status=pd.getString("status");//获取状态值
		if(status!=null){
			mv.addObject("status", status);
		}
		pd = posthostresultService.findById(pd);	//根据ID读取
		mv.setViewName("system/posthostresult/posthostresult_edit");
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
		logBefore(logger, Jurisdiction.getUsername()+"批量删除PostHostResult");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return null;} //校验权限
		PageData pd = new PageData();		
		Map<String,Object> map = new HashMap<String,Object>();
		pd = this.getPageData();
		List<PageData> pdList = new ArrayList<PageData>();
		String DATA_IDS = pd.getString("DATA_IDS");
		if(null != DATA_IDS && !"".equals(DATA_IDS)){
			String ArrayDATA_IDS[] = DATA_IDS.split(",");
			posthostresultService.deleteAll(ArrayDATA_IDS);
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
		logBefore(logger, Jurisdiction.getUsername()+"导出PostHostResult到excel");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;}
		ModelAndView mv = new ModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		Map<String,Object> dataMap = new HashMap<String,Object>();
		List<String> titles = new ArrayList<String>();
		titles.add("备注1");	//1
		titles.add("备注2");	//2
		titles.add("备注3");	//3
		titles.add("备注4");	//4
		titles.add("备注5");	//5
		dataMap.put("titles", titles);
		List<PageData> varOList = posthostresultService.listAll(pd);
		List<PageData> varList = new ArrayList<PageData>();
		for(int i=0;i<varOList.size();i++){
			PageData vpd = new PageData();
			vpd.put("var1", varOList.get(i).getString("POSTSRCTABLEID"));	    //1
			vpd.put("var2", varOList.get(i).getString("POSTHOST_ID"));	    //2
			vpd.put("var3", varOList.get(i).getString("PICSRC"));	    //3
			vpd.put("var4", varOList.get(i).getString("POSTURL"));	    //4
			vpd.put("var5", varOList.get(i).getString("TITLE"));	    //5
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
