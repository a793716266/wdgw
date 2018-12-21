package com.flc.dao;

import java.util.List;

import com.flc.entity.Curriculuminfo;
public interface CurriculuminfoDao {

	/**
	 * 查询课程就业起薪前4名信息，就业起薪降序排序
	 */
	public List<Curriculuminfo> findTop4();
}
