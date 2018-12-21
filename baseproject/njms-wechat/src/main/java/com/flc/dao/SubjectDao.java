package com.flc.dao;

import java.util.List;
import java.util.Map;
import com.flc.entity.Subject;
public interface SubjectDao {

	/**
	 * 查询免费干货课程类型的 top 4
	 * @param type
	 * @return
	 */
	public List<Subject> findTop4(Map<String,Object> map);
	
}
