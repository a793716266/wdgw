package com.flc.service;

import java.util.List;

import com.flc.entity.Posts;

public interface PostsService {
	/**
	 * 分页查询贴子
	 * @param pageNo 从第几条显示
	 * @param count 每页显示的条数
	 * @param userid 用于查询用户的ID
	 * @return
	 */
	List<Posts> findAllPosts(Integer pageNo,Integer count,String userId);
	/**
	 * 通过id删除我的贴子
	 * @param id
	 * @return
	 */
	int delPosts(String id);
}
