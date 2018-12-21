package com.flc.dao;

import java.util.List;

import com.flc.entity.Businesspractice;

public interface BusinesspracticeDao {
	/**
	 * 查询所有
	 * @return
	 */
	List<Businesspractice> findAll();
}
