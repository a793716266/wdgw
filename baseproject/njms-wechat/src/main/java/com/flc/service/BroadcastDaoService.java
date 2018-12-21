package com.flc.service;

import java.util.List;

import com.flc.entity.Broadcast;

public interface BroadcastDaoService {
	/**
	 * 查询图片信息  按时间降序
	 * @param broadcastPage 轮播页码
	 * @return
	 */
	public List<Broadcast> findPicture(Integer broadcastPage);
}
