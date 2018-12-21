package com.flc.controller.wd;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flc.controller.base.BaseController;
import com.flc.entity.Flowpath;
import com.flc.service.FlowpathService;
import com.flc.util.WdUtil;
@Controller
@RequestMapping(value="/wd/")
public class FlowpathController  extends BaseController {
	@Resource
	private FlowpathService flowpathService ;
	
	@RequestMapping(value="flowpathInfo.do")
	@ResponseBody
	public String mainShowHRInfo(){
		List<Flowpath> flowpathlist = flowpathService.flowpathall();
		
		return WdUtil.convertToJson("flowpathlist",new Object[] {flowpathlist});
	}
	@RequestMapping(value="flowpathye.do")
	@ResponseBody
	public String mainShowHRye(){
		List<Flowpath> flowpathye = flowpathService.flowpathye();
		return WdUtil.convertToJson("flowpathye",new Object[] {flowpathye});
	}
}
 