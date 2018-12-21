package com.flc.service;

import java.util.List;

import com.flc.entity.Subject;

public interface SubjectDaoService {

	/**
	 * 查询免费干货课程类型的 top 4
	 * @param type
	 * @return
	 */
	public List<Subject> findTop4(String type);
}
