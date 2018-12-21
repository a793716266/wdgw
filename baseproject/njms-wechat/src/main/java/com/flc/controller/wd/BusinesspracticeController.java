package com.flc.controller.wd;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flc.entity.Businesspractice;
import com.flc.service.BusinesspracticeService;
import com.flc.util.WdUtil;

@Controller
@RequestMapping("/wd/")
public class BusinesspracticeController {
	@Resource
	BusinesspracticeService service;
	//配置文件获取获取路径
	@Value("upload.requestPath")
	private String requestPath;
			
	@RequestMapping("getBusinesspracticeInfo.do")
	@ResponseBody
	public String getBusinesspracticeInfo() {
		List<Businesspractice> list = service.findAll();
		return WdUtil.convertToJson("businesspracticelist", new Object[] {list});
	}
}
