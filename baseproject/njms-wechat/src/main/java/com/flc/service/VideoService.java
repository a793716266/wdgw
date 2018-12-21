package com.flc.service;

import java.util.List;

import com.flc.entity.Video;

public interface VideoService {

	/**
	 * 根据课程类型查询
	 */
	public List<Video> findByCourse(List<String> parm);
	
	/**
	 * 查询所有课程名称，去重复
	 * @return
	 */
	public List<String> findCourse();
	
	/**
	 * 根据视频url查询视频的id
	 */
	public String findToId(String videoId);
}
