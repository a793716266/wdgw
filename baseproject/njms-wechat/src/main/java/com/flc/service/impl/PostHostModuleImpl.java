package com.flc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.flc.entity.PostHostModule;
import com.flc.service.PostHostModuleService;
import com.flc.dao.PostHostModuleDao;
@Service
public class PostHostModuleImpl implements PostHostModuleService{
	@Resource
	private PostHostModuleDao pmd;

	@Override
	public List<PostHostModule> checkposthost() { 
		return pmd.checkposthost();
	}

	@Override
	public List<PostHostModule> hottopic() {
		return pmd.hottopic();
	}
	
}
