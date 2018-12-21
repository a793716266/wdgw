package com.flc.service;

import java.util.List;

import com.flc.entity.MessageSys;

public interface MessageSysService {
	/**
	 * 查询系统消息
	 * @return
	 */
	List<MessageSys> MessfindAll();
}
