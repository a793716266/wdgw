package com.flc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.flc.dao.SubjectDao;
import com.flc.entity.Subject;
import com.flc.service.SubjectDaoService;

@Service
public class SubjectDaoServiceImpl implements SubjectDaoService{

	@Resource
	public SubjectDao dao;

	@Override
	public List<Subject> findTop4(String type) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("type", type);
		return dao.findTop4(map);
	}
	
}
