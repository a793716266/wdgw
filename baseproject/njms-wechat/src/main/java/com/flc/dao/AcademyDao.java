package com.flc.dao;

import java.util.List;

import com.flc.entity.Academy;

public interface AcademyDao {
	/**
	 * 得到所有合作院校信息
	 */
	List<Academy> getAllAcademy();
}
