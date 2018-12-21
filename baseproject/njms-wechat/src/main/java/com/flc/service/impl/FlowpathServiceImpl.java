package com.flc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flc.dao.FlowpathDao;
import com.flc.entity.Flowpath;
import com.flc.service.FlowpathService;

@Service
@Transactional
public class FlowpathServiceImpl implements FlowpathService {
	@Resource
	private FlowpathDao dao;
	@Override
	public List<Flowpath> flowpathall() {
		// TODO Auto-generated method stub
		return dao.flowpathall();
	}
	@Override
	public List<Flowpath> flowpathye() {
		// TODO Auto-generated method stub
		return dao.flowpathye();
	}


	
}
