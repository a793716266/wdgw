package com.flc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.flc.dao.FreecourseDao;
import com.flc.entity.Freecourse;
import com.flc.service.FreecourseService;
@Service
public class FreecourseServiceimpl implements FreecourseService{
	@Resource
	public FreecourseDao dao;

	@Override
	public List<Freecourse> findfreecourse(String course,Integer page) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("course", course);
		map.put("page", page);
		return dao.findfreecourse(map);
	}
	

}
