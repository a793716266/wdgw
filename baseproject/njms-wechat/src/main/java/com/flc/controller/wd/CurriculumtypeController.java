package com.flc.controller.wd;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flc.controller.base.BaseController;
import com.flc.entity.Subject;
import com.flc.service.SubjectDaoService;
import com.flc.util.WdUtil;
@Controller
@RequestMapping(value="/wd/")
public class CurriculumtypeController extends BaseController{
	@Resource
	public SubjectDaoService wdgw_subjectDaoService;
	@RequestMapping(value="findCurriculumtype.do")
	@ResponseBody
	public String findCurriculumtype(){
		List<Subject> uiList = wdgw_subjectDaoService.findTop4("UI");//UI信息集合
		List<Subject> javaList = wdgw_subjectDaoService.findTop4("JAVA");//JAVA信息集合
		List<Subject> webList = wdgw_subjectDaoService.findTop4("HADOOP");//WEB信息集合
		return WdUtil.convertToJson("uilist,javalist,weblist", new Object[] {uiList,javaList,webList});
	}
}
