package com.flc.controller.wd;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flc.entity.Academy;
import com.flc.service.AcademyService;
import com.flc.util.WdUtil;

@Controller
@RequestMapping(value="/wd")
public class AcademyController {
	@Resource
	private AcademyService academyService;
	//配置文件获取获取路径
	@Value("upload.requestPath")
	private String requestPath;
			
	
	@RequestMapping("/getAllAcademy.do")
	@ResponseBody
	public String getAllAcademy(){
		List<Academy> getAllAcademy=academyService.getAllAcademy();
		return WdUtil.convertToJson("academylist",new Object[]{getAllAcademy});
	}
}
