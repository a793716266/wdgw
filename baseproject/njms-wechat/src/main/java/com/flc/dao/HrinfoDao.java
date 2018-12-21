package com.flc.dao;

import java.util.List;

import com.flc.entity.Hrinfo;
public interface HrinfoDao {
	
	/*
	 * 查询所有HR信息
	 */
	public List<Hrinfo> selectAllHRInfo();
	
}
