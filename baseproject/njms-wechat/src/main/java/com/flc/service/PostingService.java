package com.flc.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.flc.entity.Posting;

public interface PostingService {
	/**
	 * 查询当前页面的帖子信息
	 */
	List<Posting> postList();
	
	/**
	 * 根据id查询帖子类型
	 */
	List<Posting> postList(@Param(value="pid") String pid);
	
	/**
	 * 按条件查询帖子
	 * @param condition 条件
	 * @return
	 */
	List<Posting> list(Map<String,Object> condition);
	/**
	 * 删除指定帖子
	 * @param condition 条件
	 * @return
	 */
	int delete(Map<String,Object> condition);
	/**
	 * 更新指定帖子
	 * @param posting
	 * @return
	 */
	int update(Posting posting);
	/**
	 * 新增帖子
	 * @param posting
	 * @return
	 */
	int insert(Posting posting);
	/**
	 * 根据条件查询帖子数量
	 * @param condition
	 * @return
	 */
	int findCount(Map<String,Object> condition);
	/**
	 * 根据帖子类型id查询对应的所有帖子
	 * @return
	 */
	List<Posting> findPostingList(Map<String, Object> mapCondition);

	/**
	 * 更新帖子浏览次数和帖子热度
	 * @param map
	 * @return
	 */
	int updatePostH_R(Map<String, Object> map);
	
	/**
	 * 更新帖子回帖数
	 * @param post_id
	 * @return
	 */
	int updatePostRestorenumber(String post_id);
	
	/**
	 * 根据帖子id查询发帖信息
	 * @param postid
	 * @return
	 */
	Posting findFloorInfo(String post_id);
}
