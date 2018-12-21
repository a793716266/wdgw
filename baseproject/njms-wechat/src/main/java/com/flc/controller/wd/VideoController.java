package com.flc.controller.wd;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flc.entity.Freecourse;
import com.flc.entity.Video;
import com.flc.service.VideoService;
import com.flc.util.WdUtil;

@Controller
@RequestMapping(value="/wd/")
public class VideoController {

	@Resource
	private VideoService videoService;
	
	/**
	 * 根据课程类型请求视频列表
	 */
	@RequestMapping(value="reqVidList.do")
	@ResponseBody
	public String reqVidList(Freecourse wdgwfree){
//		List<String> parm = videoService.findCourse(); //查询出所有课程名称，去重复
		List<String> parm =  new ArrayList<>();
		parm.add("JAVA");
		parm.add("WEB");
		parm.add("UI");
		List<Video> list = videoService.findByCourse(parm);//查询出每个课程的前4条课程信息
		List<Video> javalist = new ArrayList<>();
		List<Video> weblist = new ArrayList<>();
		List<Video> uilist = new ArrayList<>();
		
		//根据课程名称分别存入不同的集合
		for (Video l : list) {
			if (l.getCourse().equals(parm.get(0))) {
				javalist.add(l);
			}else if (l.getCourse().equals(parm.get(1))) {
				weblist.add(l);
			}else if (l.getCourse().equals(parm.get(2))) {
				uilist.add(l);
			}
		}
		return WdUtil.convertToJson("uilist,javalist,weblist", new Object[]{uilist,javalist,weblist});
	}
	
	@RequestMapping(value="findVideoByType.do")
	@ResponseBody
	public String findVideoByType(HttpServletRequest req){
		List<String> videolist =  new ArrayList<>();
		String type = req.getParameter("type");
		videolist.add(type);
		List<Video> videolistall = videoService.findByCourse(videolist);
		for (Video wdgw_video : videolistall) {
			String url = WdUtil.getVideoUrl(wdgw_video.getUrl());
			wdgw_video.setUrl(url);
		}
		return WdUtil.convertToJson("videolistall", new Object[]{videolistall});
	}
}
