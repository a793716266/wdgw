package com.flc.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.flc.dao.UsersDao;
import com.flc.entity.User;
import com.flc.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	public UsersDao dao;
	@Override
	public List<User> finduserall() {
		return dao.finduserall();
	}
	@Override
	public User finduser(String phoneNumber) {
		return dao.finduser(phoneNumber);
	}

	@Override
	public int register(User user) {
		String phoneNumber = user.getPhonenumber();
		User tempUser = dao.finduser(phoneNumber);
		if (tempUser == null)
			return dao.insert(user);
		else
			return -1;
	}

	@Override
	public int del(User user) {
		return dao.del(user);
	}

	@Override
	public int adduser(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.adduser(map);
	}

	@Override
	public int update(User user) {
		return dao.update(user);
	}

	@Override
	public int updapictrue(String pictrue, String wd_users_id) {
		// TODO Auto-generated method stub
		return dao.updapictrue(pictrue, wd_users_id);
	}

}
