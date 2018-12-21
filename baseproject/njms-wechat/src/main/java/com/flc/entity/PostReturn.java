package com.flc.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
/**
 * 帖子评论表
 * @author Jason
 *
 */
public class PostReturn {
	
	private String postReturn_id;   //id
	private String postId;          //帖子ID
	private String userId;          //回复人ID
	private String commenContent;   //评论内容
	private String commentFloor;    //评论楼层
	private Date commentTime;     //评论时间
	private List<PostReturn> postReturns;       //子级评论
	private String replierid;		//回复人id
	private Integer level;          //评论级别
	private String createuser;      //创建人
	private Date createtime;      	//创建时间
	private String time;			//时间：年月日时分
	private String remark;          //备注
	private Integer replyCount;		//回复数
	
	private String nickname;		//昵称
	private String picture;			//用户头像
	
	private String rNickname;		//回复人昵称
	private String rPicture;		//回复人头像
	
	public String getPostReturn_id() {
		return postReturn_id;
	}
	public void setPostReturn_id(String postReturn_id) {
		this.postReturn_id = postReturn_id;
	}
	public String getPostId() {
		return postId;
	}
	public void setPostId(String postId) {
		this.postId = postId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCommenContent() {
		return commenContent;
	}
	public void setCommenContent(String commenContent) {
		this.commenContent = commenContent;
	}
	public String getCommentFloor() {
		return commentFloor;
	}
	public void setCommentFloor(String commentFloor) {
		this.commentFloor = commentFloor;
	}
	public Date getCommentTime() {
		return commentTime;
	}
	public void setCommentTime(Date date) {
		this.commentTime = date;
	}
	public List<PostReturn> getPostReturns() {
		return postReturns;
	}
	public void setPostReturns(List<PostReturn> postReturns) {
		this.postReturns = postReturns;
	}
	public String getReplierid() {
		return replierid;
	}
	public void setReplierid(String replierid) {
		this.replierid = replierid;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public String getCreateuser() {
		return createuser;
	}
	public void setCreateuser(String createuser) {
		this.createuser = createuser;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public String getTime() {
		return new SimpleDateFormat("yyyy-MM-dd hh:mm").format(this.createtime);
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getReplyCount() {
		return replyCount;
	}
	public void setReplyCount(Integer replyCount) {
		this.replyCount = replyCount;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getrNickname() {
		return rNickname;
	}
	public void setrNickname(String rNickname) {
		this.rNickname = rNickname;
	}
	public String getrPicture() {
		return rPicture;
	}
	public void setrPicture(String rPicture) {
		this.rPicture = rPicture;
	}
	
	@Override
	public String toString() {
		return "PostReturn [postReturn_id=" + postReturn_id + ", postId=" + postId + ", userId=" + userId
				+ ", commenContent=" + commenContent + ", commentFloor=" + commentFloor + ", commentTime=" + commentTime
				+ ", postReturns=" + postReturns + ", replierid=" + replierid + ", level=" + level + ", createuser="
				+ createuser + ", createtime=" + createtime + "]";
	}
	
	
}
