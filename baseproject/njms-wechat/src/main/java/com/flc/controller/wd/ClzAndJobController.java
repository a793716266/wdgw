package com.flc.controller.wd;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flc.controller.base.BaseController;
import com.flc.entity.Curriculuminfo;
import com.flc.entity.Employmentclass;
import com.flc.entity.Studentinfo;
import com.flc.service.CurriculuminfoService;
import com.flc.service.EmploymentclassService;
import com.flc.service.StudentinfoService;
import com.flc.util.WdUtil;
@Controller
@RequestMapping(value="/wd/")
public class ClzAndJobController extends BaseController{
	@Resource
	private EmploymentclassService employmentclassService;
	@Resource
	private StudentinfoService studentinfoService;
	@Resource
	private CurriculuminfoService curriculuminfoService;
	/**
	 * 带数据前往首页
	 * @return
	 */
	@RequestMapping(value="reqClzAndJob.do")
	@ResponseBody
	public String reqClzAndJob(){
		List<Employmentclass> employmentclassList = employmentclassService.findALL();//高薪就业班级信息集合
		List<Studentinfo> studentinfoList = studentinfoService.findTop10();//高薪就业学生信息集合
		List<Curriculuminfo> curriculuminfoList = curriculuminfoService.findTop4();
		return WdUtil.convertToJson("clzlist,joblist,curlist", new Object[] {employmentclassList,studentinfoList,curriculuminfoList});
	}
}
