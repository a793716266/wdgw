package com.flc.controller.wd;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flc.entity.Campusinfo;
import com.flc.service.CampusinfoService;
import com.flc.util.WdUtil;

@Controller
@RequestMapping("/wd/")
public class CampusinfoControlelr {
	@Resource
	private CampusinfoService wdgw_campusinfoService;
	//配置文件获取获取路径
	@Value("upload.requestPath")
	private String requestPath;
			
	
	@RequestMapping("getAllWdgw_campusinfo.do")
	@ResponseBody
	public String getAllWdgw_campusinfo(){
		List<Campusinfo> campusinfo = wdgw_campusinfoService.getAllWdgw_campusinfo();
		Object[] lists = {campusinfo};
		return WdUtil.convertToJson("campusinfo", lists);
	}
}
