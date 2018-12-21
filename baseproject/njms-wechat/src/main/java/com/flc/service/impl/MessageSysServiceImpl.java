package com.flc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.flc.dao.MessageSysDao;
import com.flc.entity.MessageSys;
import com.flc.service.MessageSysService;
@Service
public class MessageSysServiceImpl implements MessageSysService {
	
	@Resource
	private MessageSysDao mss;

	/**
	 * 查询系统消息
	 */
	@Override
	public List<MessageSys> MessfindAll() {
		return mss.MessfindAll();
	}

}
