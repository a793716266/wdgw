package com.flc.service;

import java.util.List;

import com.flc.entity.Comment;

public interface CommentService {


	/**
	 * 按课程类型查询优秀学员前3名信息，按月薪降序排序
	 * @return
	 */
	public List<Comment> findTop3(String type);
}
