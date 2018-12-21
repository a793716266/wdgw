package com.flc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.flc.dao.BusinesspracticeDao;
import com.flc.entity.Businesspractice;
import com.flc.service.BusinesspracticeService;

@Service
public class BusinesspracticeServiceImpl implements BusinesspracticeService {
	@Resource
	BusinesspracticeDao dao;
	@Override
	public List<Businesspractice> findAll() {
		return dao.findAll();
	}
}
