package com.flc.service;

import java.util.List;
import java.util.Map;



import com.flc.entity.PostReturn;


public interface ReplyPostService {
	
	
	/**
	 * 新增回复
	 * @param post
	 * @return
	 */
	public int addReply(PostReturn post);
	
	
	
	/**
	 * 根据帖子id查询出楼主的回复
	 * @param postid
	 * @return
	 */
	List<PostReturn> findPostreturnFloor(String postid);
	
	//查询热门回复
	List<PostReturn> checkhostrep();
	
	/**
	 * 根据帖子id查询楼主对应回复数
	 * @param postid
	 * @return
	 */
	int findFloorPostreturns(String postid);
	
	/**
	 * 根据帖子id查询出所有楼层以及回复数
	 * @param map
	 * @return
	 */
	List<PostReturn> findPostreturnbottomFloor(Map<String, Object> map);
	
	/**
	 * 根据帖子id查询出所有楼层对应的回复
	 * @param map
	 * @return
	 */
	List<PostReturn> findbottomPostreturns(Map<String, Object> map);
	
	/**
	 * 查询回帖数量
	 * @param postid
	 * @return
	 */
	int countReply(String postid);  
}
