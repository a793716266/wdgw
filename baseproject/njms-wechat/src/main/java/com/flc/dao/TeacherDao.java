package com.flc.dao;

import java.util.List;
import java.util.Map;

import com.flc.entity.Teacher;
public interface TeacherDao {

	
	/**
	 * 查询前十个老师
	 */
	public List<Teacher> findteacher(Map<String, Object> map);
	
}
