package com.flc.controller.wd;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flc.entity.Foot;
import com.flc.service.FootService;
import com.flc.util.WdUtil;

@Controller
@RequestMapping("/wd/")
public class FootController{
	@Resource
	private FootService wdgw_footService;
	/**
	 * 查询所有的foot信息
	 *
	 */
	@RequestMapping(value="getAllWdgw_foot.do")
	@ResponseBody
	public String getAllWdgw_foot(){
		List<Foot> newsList = wdgw_footService.getAllWdgw_foot();
		Object[] lists = {newsList};
		return WdUtil.convertToJson("footlist", lists);
	}
}
