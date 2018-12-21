package com.flc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.flc.entity.Company;


public interface CompanyDao {
	/**
	 * 得到所有合作院校信息
	 */
	List<Company> getAllCompany();
}
