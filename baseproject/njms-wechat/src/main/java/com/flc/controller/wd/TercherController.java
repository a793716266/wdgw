package com.flc.controller.wd;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flc.controller.base.BaseController;
import com.flc.entity.Teacher;
import com.flc.service.TeacherinfoService;
import com.flc.util.WdUtil;
@Controller
@RequestMapping(value="/wd/")
public class TercherController extends BaseController{
	 //教师集合
	@Resource
	private TeacherinfoService wdgw_teacherinfoService;
	@RequestMapping(value="toIndexk.do")
	@ResponseBody
	public String toIndexk(){ 
		List<Teacher> teacherinfoList =wdgw_teacherinfoService.findteacher("教员", 9);
		List<Teacher> banzhurenlist =wdgw_teacherinfoService.findteacher("班主任", 9);
		return WdUtil.convertToJson("teacherlist,banzhurenlist", new Object[] {teacherinfoList,banzhurenlist});
	}
}
