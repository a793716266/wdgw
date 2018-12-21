package com.flc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.flc.dao.CurriculuminfoDao;
import com.flc.entity.Curriculuminfo;
import com.flc.service.CurriculuminfoService;

@Service
public class CurriculuminfoServiceImpl implements CurriculuminfoService{

	@Resource
	private CurriculuminfoDao dao;

	@Override
	public List<Curriculuminfo> findTop4() {
		return dao.findTop4();
	}

	
	
}
