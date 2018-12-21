package com.flc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flc.dao.HrinfoDao;
import com.flc.entity.Hrinfo;
import com.flc.service.HrinfoService;

@Service
@Transactional
public class HrinfoServiceImpl implements HrinfoService{

	@Resource
	private HrinfoDao dao;
	
	@Override
	public List<Hrinfo> selectAllHRInfo() {
		return dao.selectAllHRInfo();
	}

}
