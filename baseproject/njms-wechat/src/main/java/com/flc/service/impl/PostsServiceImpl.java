package com.flc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.flc.dao.PostsDao;
import com.flc.entity.Posts;
import com.flc.service.PostsService;

@Service
public class PostsServiceImpl implements PostsService {

	@Resource
	private PostsDao post;

	
	/**
	 * 通过id删除贴子
	 */
	@Override
	public int delPosts(String id) {
		return post.delPosts(id);
	}

	/**
	 * 分页查询贴子
	 */
	@Override
	public List<Posts> findAllPosts(Integer pageNo,Integer count,String userId) {
		return post.findAllPosts(pageNo,count,userId);
	}
	
	

}
