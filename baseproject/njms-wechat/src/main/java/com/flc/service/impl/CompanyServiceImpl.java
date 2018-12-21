package com.flc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.flc.dao.CompanyDao;
import com.flc.entity.Company;
import com.flc.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {
	@Resource
	private CompanyDao dao;
	
	@Override
	public List<Company> getAllCompany() {
		return dao.getAllCompany();
	}

}
