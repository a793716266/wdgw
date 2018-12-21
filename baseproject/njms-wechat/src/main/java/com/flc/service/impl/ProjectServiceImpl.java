package com.flc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.flc.dao.ProjectDao;
import com.flc.entity.Project;
import com.flc.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {
	@Resource
	ProjectDao projectDao;
	@Override
	public List<Project> getTop15(List<String> param) {
		return projectDao.getTop15(param);
	}

}
