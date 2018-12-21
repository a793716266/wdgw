package com.flc.service;

import java.util.List;
import java.util.Map;

import com.flc.entity.Studentinfo;


public interface StudentinfoService {

	/**
	 * 查询全部
	 * @return List集合
	 */
	public List<Studentinfo> findTop10();
	
	/**
	 * 查询近期就业学生
	 * @return 返回近期就业学生集合
	 */
	public List<Studentinfo> findJobStudent(Map<String, Object> map);
	
	/**
	 * 查询近期就业学生总数
	 * @return
	 */
	public int countJobStudent();
	
}
