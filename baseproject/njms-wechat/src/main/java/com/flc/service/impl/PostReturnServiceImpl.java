package com.flc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.flc.dao.PostReturnDao;
import com.flc.entity.PostReturnByMe;
import com.flc.service.PostReturnService;


@Service
public class PostReturnServiceImpl implements PostReturnService{
	@Resource
	private PostReturnDao pr;
	
	/**
	 * 分页查询贴子回复
	 */
	@Override
	public List<PostReturnByMe> findAllReturn(Integer pageNo, Integer count, String userId) {
		return pr.findAllReturn(pageNo, count, userId);
	}	

	/**
	 * 通过id删除贴子回复
	 */
	@Override
	public int delPosts(String id) {
		return pr.delPosts(id);
	}

}
