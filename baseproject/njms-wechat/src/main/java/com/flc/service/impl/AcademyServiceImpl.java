package com.flc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.flc.dao.AcademyDao;
import com.flc.entity.Academy;
import com.flc.service.AcademyService;
@Service
public class AcademyServiceImpl implements AcademyService {
	@Resource
	private AcademyDao dao;
	
	@Override
	public List<Academy> getAllAcademy() {
		return dao.getAllAcademy();
	}

}
