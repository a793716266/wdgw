package com.flc.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.flc.entity.User;


public interface UserService {
	/**
	 * 注册
	 * @return
	 */
	int register(User user);
	/**
	 * 删除用户
	 * @return
	 */
	int del(User user);
	/**
	 * 更新用户
	 * @return
	 */
	int update(User user);
	/** 
	 * 根据手机号码查询
	 * @param phoneNumber
	 * @return
	 */
	
	/**
	 * 改变用户头像
	 * @param wd_users_id
	 * @return
	 */
	int updapictrue(@Param(value="pictrue")String pictrue,@Param(value="wd_users_id")String wd_users_id);
	
	User finduser(String phoneNumber);
	/**
	 * 查询全部
	 * @return
	 */
	List<User> finduserall();
	
	/**
	 * 新增用户
	 */
	public int adduser(Map<String, Object> map);
}
