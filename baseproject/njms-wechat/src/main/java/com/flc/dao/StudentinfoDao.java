package com.flc.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.flc.entity.Studentinfo;
@Repository
public interface StudentinfoDao {

	/**
	 * 查询前十的高薪就业学生
	 * @return 返回前十的高薪就业学生集合
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
	public int countJobStudent(String time);
}
