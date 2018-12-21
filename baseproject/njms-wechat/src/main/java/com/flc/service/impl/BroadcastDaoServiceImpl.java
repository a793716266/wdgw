package com.flc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.flc.dao.BroadcastDao;
import com.flc.entity.Broadcast;
import com.flc.service.BroadcastDaoService;
@Service
public class BroadcastDaoServiceImpl implements BroadcastDaoService{

	@Resource
	public BroadcastDao dao;
	@Override
	public List<Broadcast> findPicture(Integer broadcastPage) {
		return dao.findPicture(broadcastPage);
	}

}
