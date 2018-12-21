package com.flc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.flc.dao.TeacherDao;
import com.flc.entity.Teacher;
import com.flc.service.TeacherinfoService;

@Service
public class TeacherinfoServiceImpl implements TeacherinfoService{

	@Resource
	private TeacherDao dao;

	@Override
	public List<Teacher> findteacher(String identity,Integer page) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("identity", identity);
		map.put("page", page);
		return dao.findteacher(map);
	}


}
