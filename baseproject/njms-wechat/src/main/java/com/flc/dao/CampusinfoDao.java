package com.flc.dao;

import java.util.List;

import com.flc.entity.Campusinfo;

public interface CampusinfoDao {
	/**
	 * 查询校区相关信息
	 */
	List<Campusinfo> getAllWdgw_campusinfo();
}
