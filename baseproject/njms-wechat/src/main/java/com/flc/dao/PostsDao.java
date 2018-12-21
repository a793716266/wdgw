package com.flc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.flc.entity.Posts;

public interface PostsDao {
	/**
	 * 分页显示贴子
	 * @param pageNo 从第几条显示
	 * @param count 每页显示的条数
	 * @param userid 用于查询用户的ID
	 * */
	List<Posts> findAllPosts(@Param("pageNo") Integer pageNo,@Param("count")Integer count,@Param("userId")String userId);
	/**
	 * 通过贴子id删除贴子
	 * @param id
	 * @return
	 */
	int delPosts(String id);
}
