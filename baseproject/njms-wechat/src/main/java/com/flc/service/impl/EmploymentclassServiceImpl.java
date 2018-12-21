package com.flc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.flc.dao.EmploymentclassDao;
import com.flc.entity.Employmentclass;
import com.flc.service.EmploymentclassService;

@Service
public class EmploymentclassServiceImpl implements EmploymentclassService{

	@Resource
	private EmploymentclassDao dao;
	
	@Override
	public List<Employmentclass> findALL() {
		return dao.findTop10();
	}

	
	
}
