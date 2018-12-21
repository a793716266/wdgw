package com.flc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.flc.entity.MySubject;
import com.flc.entity.VideoAndUser;

public interface MySubjectDao {
	/**
	 * 查看个人中心中我的课程
	 * @return
	 */
	List<MySubject> findMySubject(@Param("userId")String userId); 
	
	/**
	 * 添加我的课程
	 * @param videoAndUser
	 * @return
	 */
	int insertVideo(VideoAndUser videoAndUser);
}
