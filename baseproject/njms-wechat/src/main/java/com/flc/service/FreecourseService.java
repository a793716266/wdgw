package com.flc.service;

import java.util.List;

import com.flc.entity.Freecourse;

public interface FreecourseService {
	/**
	 * 查询免费课程
	 */
	public List<Freecourse> findfreecourse(String course,Integer page);
	
}
