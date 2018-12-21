package com.flc.dao;

import java.util.List;

import com.flc.entity.Goodstudents;
public interface GoodstudentsDao {

	/**
	 * 优秀学生的分类
	 * @return
	 */
	public List<Goodstudents> findTop4(List<String> type);
	/**
	 * 查询优秀学员前4名信息，按月薪降序排序
	 * @return
	 */
	public List<Goodstudents> findTop5();
	
}
