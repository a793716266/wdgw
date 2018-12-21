package com.flc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.flc.dao.VideoDao;
import com.flc.entity.Video;
import com.flc.service.VideoService;

@Service
public class VideoServiceImpl implements VideoService{

	@Resource
	private VideoDao dao;
	
	@Override
	public List<Video> findByCourse(List<String> parm) {
		return dao.findByCourse(parm);
	}

	@Override
	public List<String> findCourse() {
		return dao.findCourse();
	}

	@Override
	public String findToId(String videoId) {
		
		return dao.findToId(videoId);
	}

}
