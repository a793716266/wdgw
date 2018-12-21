package com.flc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flc.dao.FootDao;
import com.flc.entity.Foot;
import com.flc.service.FootService;

@Service
@Transactional
public class FootServiceImpl implements FootService {
	@Resource
	private FootDao wdgw_footDao;
	
	public List<Foot> getAllWdgw_foot(){
		return wdgw_footDao.getAllWdgw_foot();
	}
	
}
