package com.flc.controller.wd;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flc.controller.base.BaseController;
import com.flc.entity.Freecourse;
import com.flc.service.FreecourseService;
import com.flc.util.WdUtil;

@Controller
@RequestMapping(value="/wd/")
public class FreecoursetController extends BaseController {
	@Resource
	private FreecourseService freecourseService;
	@RequestMapping(value="findfreecourse.do")
	@ResponseBody
	public String findbroadcasts(Freecourse wdgwfree){
		
		List<Freecourse> freecoursejavalist = freecourseService.findfreecourse("JAVA",12);
		List<Freecourse> freecourseuilist = freecourseService.findfreecourse("UI",12);
		List<Freecourse> freecoursehalist = freecourseService.findfreecourse("WEB",12);
		return WdUtil.convertToJson("freecoursejavalist,freecourseuilist,freecoursehalist",new Object[] {freecoursejavalist,freecourseuilist,freecoursehalist});
	}
}
