package com.flc.controller.wd;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flc.controller.base.BaseController;
import com.flc.entity.Curriculuminfo;
import com.flc.service.CurriculuminfoService;
import com.flc.util.WdUtil;

@Controller
@RequestMapping(value = "/wd/")
public class CurController extends BaseController {
	@Resource
	private CurriculuminfoService curriculuminfoService;
	//配置文件获取获取路径
	@Value("upload.requestPath")
	private String requestPath;
		
	// 请求课程列表信息
	@RequestMapping(value = "reqCurList.do")
	@ResponseBody
	public String reqCurList() {
		List<Curriculuminfo> curriculuminfoList = curriculuminfoService.findTop4();
		return WdUtil.convertToJson("courselist", new Object[] { curriculuminfoList });
	}
}
