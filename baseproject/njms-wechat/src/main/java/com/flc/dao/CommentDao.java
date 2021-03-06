package com.flc.dao;

import java.util.List;
import java.util.Map;

import com.flc.entity.Comment;

public interface CommentDao {

	
	/**
	 * 按课程类型查询优秀学员前3名信息，按月薪降序排序
	 * @return
	 */
	public List<Comment> findTop3(Map<String, Object> map);
}
