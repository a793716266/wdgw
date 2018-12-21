package com.flc.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.flc.entity.User;

public interface UsersDao {
	/**
	 * 根据账号查询
	 * @param accountNumber 账号
	 * @return 
	 */
	User finduser(@Param(value="phonenumber")String phonenumber);
	/**
	 * 新增用户
	 * @return
	 */
	int insert(User user);
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
	 * 改变用户头像
	 * @param wd_users_id
	 * @return
	 */
	int updapictrue(@Param(value="pictrue")String pictrue,@Param(value="wd_users_id")String wd_users_id);
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
