package com.flc.controller.wd;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.flc.entity.ClassOpening;
import com.flc.service.ClassOpeningService;
import com.flc.service.LearnApplyPersonalService;
import com.flc.util.PageData;
import com.flc.util.UuidUtil;
import com.flc.util.WdUtil;

@Controller
@RequestMapping(value="/wd/")
public class ClassOpeningController {

	@Resource
	private ClassOpeningService ClassOpeningService;
	@Resource
	private LearnApplyPersonalService learnApply;
	//配置文件获取获取路径
	@Value("upload.requestPath")
	private String requestPath;
			
	/**
	 * 根据班级类型请求开班信息列表
	 */
	@RequestMapping(value="reqClassOPeningList.do")
	@ResponseBody
	public String reqClassOPeningList(){
		List<Object> parm =  new ArrayList<>();
		parm.add("JAVA");
		parm.add("WEB");
		parm.add("UI");
		List<ClassOpening> list = ClassOpeningService.findByCtype_union(parm);
		List<ClassOpening> javalist = new ArrayList<>(); 	//java班级开班信息集合
		List<ClassOpening> weblist = new ArrayList<>();	//web班级开班信息集合
		List<ClassOpening> uilist = new ArrayList<>();		//ui班级开班信息集合
		
		//根据班级类型名称分别存入不同的集合
		for (ClassOpening l : list) {
			if(l.getCtype().equals(parm.get(0))){
				javalist.add(l);
			}else if(l.getCtype().equals(parm.get(1))){
				weblist.add(l);
			}else if(l.getCtype().equals(parm.get(2))){
				uilist.add(l);
			}
		}
		return WdUtil.convertToJson("ui_class,java_class,web_class", new Object[]{uilist,javalist,weblist});
	}
	
	/**
	 * ajax用户点击报名进班保存信息
	 * @param typeName 班级类型
	 * @param ctype+number 班级编号
	 * */
	@RequestMapping(value="clas.do")
	@ResponseBody
	public String saveApplyPersonal(String typeName,String number,String ctype,HttpSession session){
		String json=null;
		String phoneNumber = "";
		if(null == getUserPhone(session)) return "";
		else phoneNumber =  getUserPhone(session);
		 PageData pd = new PageData();
		 pd.put("LEARNTYPE", ctype);
		 pd.put("APPLYCLASS", typeName+number);
		 pd.put("APPLYPHONE", phoneNumber);
		 pd.put("APPLYDATE", new Date());
		 pd.put("LEARNAPPLYPERSONAL_ID", UuidUtil.get32UUID());
		 Integer saveApplyPersonal = learnApply.saveApply(pd);
		 json="{\"msg\":\""+saveApplyPersonal+"\"}";
		 return json;	
	}
	
	//获取用户登陆手机号
	private String getUserPhone(HttpSession session){
		if(null == session.getAttribute("userph")){
			return null;
		}
		Object object = session.getAttribute("userph");
		 String[] split = object.toString().split(",");
		 String phoneNumber = split[3].split(":")[1].replace("'", "");
		 return phoneNumber;
	}
	
	/**
	 * ajax验证用户是否申请抢名额
	 * */
	@RequestMapping(value="checkApply.do")
	@ResponseBody
	public String checkApply(HttpSession session){
		String json=null;
		String phoneNumber = "";
		if(null == getUserPhone(session)) return "";
		else phoneNumber =  getUserPhone(session);
		PageData pd = new PageData();
		pd.put("APPLYPHONE",phoneNumber);
		Integer findApplyByPhone = learnApply.ApplyByPhone(pd);
		json = "{\"findPhone\":\""+findApplyByPhone+"\"}";
		return json;	
	}
}
