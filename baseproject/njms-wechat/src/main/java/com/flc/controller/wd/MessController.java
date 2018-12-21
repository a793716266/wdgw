package com.flc.controller.wd;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flc.controller.base.BaseController;
import com.flc.service.MessageSysService;
import com.flc.util.WdUtil;

@Controller
@RequestMapping(value="/ms/")
public class MessController extends BaseController{
	@Resource
	private MessageSysService mss;
	
	/**
	 * 查询系统消息
	 * @return
	 */
	@RequestMapping(value="/text")
	@ResponseBody
	public String selMassage(){
		return WdUtil.convertToJson("postTypeStudyList",new Object[]{mss.MessfindAll()});
	}
}
