package com.flc.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.flc.dao.LearnApplyPersonalDao;
import com.flc.service.LearnApplyPersonalService;
import com.flc.util.PageData;
@Service
public class LearnApplyPersonalServiceImpl implements LearnApplyPersonalService {
	@Resource
	private LearnApplyPersonalDao dao;
	
	/**
	 * 申请进班名额
	 */
	@Override
	public Integer saveApply(PageData pd){
		return dao.saveApplyPersonal(pd);
	};
	
	/**
	 * 验证用户是否已经申请抢名额
	 * */
	@Override
	public Integer ApplyByPhone(PageData pd){
		return dao.findApplyByPhone(pd);
	};

}
