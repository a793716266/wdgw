package com.flc.dao;

import java.util.List;

import com.flc.entity.Flowpath;

public interface FlowpathDao {
	//首页就业区域
	public List<Flowpath> flowpathall();
	//就业流程页面
    public List<Flowpath> flowpathye();
}
