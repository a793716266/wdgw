package com.flc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.flc.dao.MySubjectDao;
import com.flc.entity.MySubject;
import com.flc.entity.VideoAndUser;
import com.flc.service.MySubjectService;


@Service
public class MySubjectServiceImpl implements MySubjectService {
	
	@Resource
	private MySubjectDao ms;

	
	/**
	 * 查看个人中心中我的课程
	 */
	
	@Override
	public List<MySubject> findMySubject(String userId) {
		return ms.findMySubject(userId);
	}

	/**
	 * 添加我的课程
	 * @param videoAndUser
	 * @return
	 */
	@Override
	public int insertVideo(VideoAndUser videoAndUser) {
		return ms.insertVideo(videoAndUser);
	}
	
	

}
