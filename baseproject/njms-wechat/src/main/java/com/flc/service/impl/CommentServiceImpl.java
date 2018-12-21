package com.flc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.flc.dao.CommentDao;
import com.flc.entity.Comment;
import com.flc.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService{

	@Resource
	private CommentDao dao;
	
	@Override
	public List<Comment> findTop3(String type) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("type", type);
		return dao.findTop3(map);
	}
}
