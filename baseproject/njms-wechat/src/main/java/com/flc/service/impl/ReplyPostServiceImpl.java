package com.flc.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;


 

import com.flc.service.ReplyPostService;
import com.flc.dao.ReplypostDao;
import com.flc.entity.PostReturn;

@Service
public class ReplyPostServiceImpl implements ReplyPostService{
	@Resource
	ReplypostDao rd;

	/**
	 * 新增回复
	 * @param post
	 * @return
	 */
	@Override
	public int addReply(PostReturn post) {
		
		return rd.addReply(post);
	}

	/**
	 * 根据帖子id查询出楼主的回复
	 * @param postid
	 * @return
	 */
	@Override
	public List<PostReturn> findPostreturnFloor(String postid) {
		return rd.findPostreturnFloor(postid);
	}

	/**
	 * 根据帖子id查询楼主对应回复数
	 * @param postid
	 * @return
	 */
	@Override
	public int findFloorPostreturns(String postid) {
		return rd.findFloorPostreturns(postid);
	}

	/**
	 * 根据帖子id查询出所有楼层以及回复数
	 * @param map
	 * @return
	 */
	@Override
	public List<PostReturn> findPostreturnbottomFloor(Map<String, Object> map) {
		
		return rd.findPostreturnbottomFloor(map);
	}

	/**
	 * 根据帖子id查询出所有楼层对应的回复
	 * @param map
	 * @return
	 */
	@Override
	public List<PostReturn> findbottomPostreturns(Map<String, Object> map) {
		
		return rd.findbottomPostreturns(map);
	}

	/**
	 * 查询回帖数量
	 * @param postid
	 * @return
	 */
	@Override
	public int countReply(String postid) {
		
		return rd.countReply(postid);
	}

	@Override
	public List<PostReturn> checkhostrep() {
		return rd.checkhostrep();
	}
	
	
	
}
