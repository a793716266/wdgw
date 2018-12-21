package com.flc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.flc.dao.GoodstudentsDao;
import com.flc.entity.Goodstudents;
import com.flc.service.GoodstudentsService;

@Service
public class GoodstudentsServiceImpl implements GoodstudentsService{

	@Resource
	private GoodstudentsDao dao;
	
	




	@Override
	public List<Goodstudents> findTop5() {
		// TODO Auto-generated method stub
		return dao.findTop5();
	}


	@Override
	public List<Goodstudents> findTop4(List<String> type) {
		// TODO Auto-generated method stub
		return dao.findTop4(type);
	}

}
