package com.flc.controller.wd;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flc.controller.base.BaseController;
import com.flc.entity.Broadcast;
import com.flc.service.BroadcastDaoService;
import com.flc.util.WdUtil;

@Controller
@RequestMapping(value="/wd/")
public class BroadcastController extends BaseController{
	@Resource
	private BroadcastDaoService broadcastDaoService;
	//配置文件获取获取路径
	@Value("upload.requestPath")
	private String requestPath;
			
	/**
	 * 查询轮播图信息
	 * @return
	 */
	@RequestMapping(value="findbroadcasts.do")
	@ResponseBody
	public String findbroadcasts(HttpServletRequest req){
		String broadcastName = req.getParameter("broadcastName");
		Integer broadcastPage = Integer.parseInt(req.getParameter("broadcastPage"));
		List<Broadcast> broadcastList = broadcastDaoService.findPicture(broadcastPage);
		return WdUtil.convertToJson(broadcastName,new Object[] {broadcastList});
	}
}
