package com.flc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.flc.dao.ClassOpeningDao;
import com.flc.entity.ClassOpening;
import com.flc.service.ClassOpeningService;

@Service
public class ClassOpeningServiceImpl implements ClassOpeningService{

	@Resource
	private ClassOpeningDao dao;
	
	
	@Override
	public List<ClassOpening> findByCtype_union(List<Object> parm) {
		return dao.findByCtype_union(parm);
	}

	@Override
	public List<String> findByC_type() {
		return dao.findByC_type();
	}

}
