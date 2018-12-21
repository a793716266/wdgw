package com.flc.dao;

import java.util.List;
import java.util.Map;

import com.flc.entity.Freecourse;
public interface FreecourseDao {

	
	/**
	 * 查询免费课程
	 */
	public List<Freecourse> findfreecourse(Map<String, Object> map);
	
}
