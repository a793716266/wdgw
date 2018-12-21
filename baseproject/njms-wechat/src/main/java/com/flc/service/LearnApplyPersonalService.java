package com.flc.service;


import com.flc.util.PageData;

public interface LearnApplyPersonalService {
	
	/**
	 * 申请进班名额
	 */
	Integer saveApply(PageData pd);
	
	/**
	 * 验证用户是否已经申请抢名额
	 * */
	Integer ApplyByPhone(PageData pd);
}
