package com.flc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.flc.dao.CampusinfoDao;
import com.flc.entity.Campusinfo;
import com.flc.service.CampusinfoService;
@Service
public class CampusinfoServiceImpl implements CampusinfoService {
	@Resource
	private CampusinfoDao wdgw_campusinfoDao;
	@Override
	public List<Campusinfo> getAllWdgw_campusinfo() {
		return wdgw_campusinfoDao.getAllWdgw_campusinfo();
	}

}
