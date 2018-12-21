package com.flc.service;

import java.util.List;

import com.flc.entity.ClassOpening;

public interface ClassOpeningService {

	/**
	 * 根据班级类型联合查询
	 * @return
	 */
	public List<ClassOpening> findByCtype_union(List<Object> parm);
	
	/**
	 * 查询所有班级类型，去重复
	 * @return
	 */
	public List<String> findByC_type();
}
