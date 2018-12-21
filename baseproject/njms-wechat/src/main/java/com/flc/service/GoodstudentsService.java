package com.flc.service;

import java.util.List;

import com.flc.entity.Goodstudents;




public interface GoodstudentsService {

	/**
	 * 查询优秀学员分类
	 * @return
	 */
	public List<Goodstudents> findTop4(List<String> type);
	/**
	 * 查询优秀学员前4名信息，按月薪降序排序
	 * @return
	 */
	public List<Goodstudents> findTop5();
}
