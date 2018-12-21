package com.flc.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 评论表
 * @author 郑高
 *
 */
public class Comment implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4579250516701526706L;
	private String comment_id; 		//主键32位全球唯一号
	private String commentUser;		//评论用户
	private String content;			//评论内容
	private String course;			//课程类型
	private String createTime;		//创建时间
	private String createUser;		//创建人
	private String remarks;			//备注
	private List<Users> users; //用户信息
	
	
	public List<Users> getUsers() {
		return users;
	}

	public void setUsers(List<Users> users) {
		this.users = users;
	}

	public Comment(){}

	public String getComment_id() {
		return comment_id;
	}

	public void setComment_id(String comment_id) {
		this.comment_id = comment_id;
	}

	public String getCommentUser() {
		return commentUser;
	}

	public void setCommentUser(String commentUser) {
		this.commentUser = commentUser;
	}

	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	
}
