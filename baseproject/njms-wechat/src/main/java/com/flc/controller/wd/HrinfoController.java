package com.flc.controller.wd;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flc.controller.base.BaseController;
import com.flc.entity.Hrinfo;
import com.flc.service.HrinfoService;
import com.flc.util.WdUtil;
@Controller
@RequestMapping(value="/wd/")
public class HrinfoController  extends BaseController {
	@Resource
	private HrinfoService hrinfoService ;
	/*
	 * 首页刷HRInfo数据
	 */
	@RequestMapping(value="mainShowHRInfo.do")
	@ResponseBody
	public String mainShowHRInfo(){
		List<Hrinfo> ratelist = hrinfoService.selectAllHRInfo();
		return WdUtil.convertToJson("ratelist", new Object[] {ratelist});
	}
	
}
