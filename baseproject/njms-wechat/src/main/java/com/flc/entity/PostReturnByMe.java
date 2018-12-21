package com.flc.entity;

/**
 * 我的回复
 * @author 
 *
 */
public class PostReturnByMe {
	private String postid; //贴子id
	private String title; //贴子标题
	private String commencontent; //回复内容
	private String restorenumber; //回复数
	private String commenttime;	//时间
	private String postreturn_id; //回复贴子的id
	
	public PostReturnByMe() {
		super();
	}
	
	public PostReturnByMe(String postid, String title, String commencontent, String restorenumber, String commenttime) {
		super();
		this.postid = postid;
		this.title = title;
		this.commencontent = commencontent;
		this.restorenumber = restorenumber;
		this.commenttime = commenttime;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCommencontent() {
		return commencontent;
	}
	public void setCommencontent(String commencontent) {
		this.commencontent = commencontent;
	}
	public String getRestorenumber() {
		return restorenumber;
	}
	public void setRestorenumber(String restorenumber) {
		this.restorenumber = restorenumber;
	}
	public String getCommenttime() {
		return commenttime;
	}
	public void setCommenttime(String commenttime) {
		this.commenttime = commenttime;
	}

	public String getPostid() {
		return postid;
	}

	public void setPostid(String postid) {
		this.postid = postid;
	}

	public String getPostreturn_id() {
		return postreturn_id;
	}

	public void setPostreturn_id(String postreturn_id) {
		this.postreturn_id = postreturn_id;
	}
	
	
}
