package com.flc.service;

import java.util.List;

import com.flc.entity.PostReturnByMe;

public interface PostReturnService {
	/**
	 * 分页查询贴子回复
	 * @param pageNo 从第几条显示
	 * @param count 每页显示的条数
	 * @param userid 用于查询用户的ID
	 * @return
	 */
	List<PostReturnByMe> findAllReturn(Integer pageNo,Integer count,String userId);
	/**
	 * 删除贴子回复
	 * @param id
	 * @return
	 */
	int delPosts(String id);
}
