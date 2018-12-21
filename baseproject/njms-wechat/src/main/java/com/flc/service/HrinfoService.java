package com.flc.service;

import java.util.List;

import com.flc.entity.Hrinfo;

public interface HrinfoService {
	/*
	 * 查询所有HR信息
	 */
	public List<Hrinfo> selectAllHRInfo();
}
