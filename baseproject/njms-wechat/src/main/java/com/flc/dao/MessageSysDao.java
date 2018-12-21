package com.flc.dao;

import java.util.List;

import com.flc.entity.MessageSys;

public interface MessageSysDao {
	/**
	 * 查询系统消息
	 * @return
	 */
	List<MessageSys> MessfindAll();
	
}
