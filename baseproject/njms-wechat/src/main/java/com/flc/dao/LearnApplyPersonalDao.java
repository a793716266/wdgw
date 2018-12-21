package com.flc.dao;


import com.flc.util.PageData;

public interface LearnApplyPersonalDao {
	
	/**
	 * 申请进班名额
	 */
	Integer saveApplyPersonal(PageData pd);
	
	/**
	 * 验证用户是否已经申请抢名额
	 * */
	Integer findApplyByPhone(PageData pd);
}
