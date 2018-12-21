package com.flc.entity;

import java.io.Serializable;

public class Replypost implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String postreturn_id;//表id
	private String postid;//帖子Id
	private String userid;//用户Id
	private String usernickname;//用户id
	private String userpictrue;//用户图片
	private String commencontent;//评论内容
	private int commentfloor;//评论楼层
	private String commenttime	;//评论时间
	private String replierid;//回复人id
	private int level;//回复层级
	private String replyfloormath;//查询子回复数量
	//private String CREATEUSER;
	//private Date CREATETIME;	
	//private String REMARKS;
	private Object type;
	
	public String getPostreturn_id() {
		return postreturn_id;
	}
	public void setPostreturn_id(String postreturn_id) {
	    
		this.postreturn_id = postreturn_id;
	}
	public String getPostid() {
		return postid;
	}
	public void setPostid(String postid) {
		this.postid = postid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getCommencontent() {
		return commencontent;
	}
	public void setCommencontent(String commencontent) {
		this.commencontent = commencontent;
	}
	public int getCommentfloor() {
		return commentfloor;
	}
	public void setCommentfloor(int commentfloor) {
		this.commentfloor = commentfloor;
	}
	public String getCommenttime() {
		return commenttime;
	}
	public void setCommenttime(String commenttime) {
		this.commenttime = commenttime;
	}
	public String getReplierid() {
		return replierid;
	}
	public void setReplierid(String replierid) {
		this.replierid = replierid;
	}
	public int getLeveL() {
		return level;
	}
	public void setLeveL(int leveL) {
		this.level = leveL;
	}
	
	public String getUserpictrue() {
		return userpictrue;
	}
	public void setUserpictrue(String userpictrue) {
		this.userpictrue = userpictrue;
	}
	public String getUsernickname() {
		return usernickname;
	}
	public void setUsernickname(String usernickname) {
		this.usernickname = usernickname;
	}
	public Object getType() {
		return type;
	}
	public void setType(Object type) {
		this.type = type;
	}
	public String getReplyfloormath() {
		return replyfloormath;
	}
	public void setReplyfloormath(String replyfloormath) {
		this.replyfloormath = replyfloormath;
	}
	
	
	
}
