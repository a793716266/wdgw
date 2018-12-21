package com.flc.service;

import java.util.List;

import com.flc.entity.Teacher;


public interface TeacherinfoService {

	/**
	 * 查询前十个老师
	 */
	public List<Teacher> findteacher(String identity,Integer page);
	
}
