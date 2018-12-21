package com.flc.dao;

import java.util.List;

import com.flc.entity.PostHostModule;


public interface PostHostModuleDao {
	/**
	 * 查询热度高的帖子
	 * @author wzz
	 *
	 */
	public List<PostHostModule> checkposthost();
	/**
	 * 查询热门话题
	 * @return
	 */
	public List<PostHostModule> hottopic();
}
