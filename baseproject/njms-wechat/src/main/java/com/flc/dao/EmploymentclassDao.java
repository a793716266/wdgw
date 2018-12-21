package com.flc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.flc.entity.Employmentclass;
@Repository
public interface EmploymentclassDao {


	/**
	 * 查询前十的高薪就业班级
	 * @return List集合
	 */
	public List<Employmentclass> findTop10();
	
}
