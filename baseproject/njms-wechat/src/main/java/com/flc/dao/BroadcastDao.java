package com.flc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.flc.entity.Broadcast;
public interface BroadcastDao {
	/**
	 * 查询图片信息  按时间降序
	 * @param broadcastPage 轮播页码
	 * @return
	 */
	public List<Broadcast> findPicture(@Param(value = "broadcastPage")Integer broadcastPage);

}
