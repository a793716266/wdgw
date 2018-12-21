package com.flc.controller.wd;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flc.service.MySubjectService;
import com.flc.util.WdUtil;

@Controller
@RequestMapping(value="/wd/")
public class MySubjectController {
	@Resource
	private MySubjectService mss;
	//配置文件获取获取路径
	@Value("${upload.requestPath}")
	private String requestPath;
	
	/**
	 * 查看个人中心中我的课程
	 * @return
	 */
	@RequestMapping(value="/mySubject")
	@ResponseBody
	public String selMySubject(HttpSession session){
		Object object = session.getAttribute("userph");
		String[] split = object.toString().split(":");
		String wd_userId = split[split.length-1].substring(1, 33);
		return WdUtil.convertToJson("mySubjectList,requestPath",new Object[]{mss.findMySubject(wd_userId),requestPath});
	}

}
