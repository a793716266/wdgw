package com.flc.entity;

import java.io.Serializable;

/**
 * 视频表
 * @author 郑高
 *
 */
public class Video implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1143889700147376095L;
	private String video_id; 	//主键32位全球唯一号
	private String pictureName;	//照片名
	private String title;		//视频标题
	private String course;		//课程类型
	private String isfree;		//否是免费
	private String teacher;		//老师
	private String url;			//视频路径	
	private String createTime;	//创建时间
	private String createUser;	//创建人
	private String remarks;		//备注
	
	public Video(){}

	public String getVideo_id() {
		return video_id;
	}

	public void setVideo_id(String video_id) {
		this.video_id = video_id;
	}

	public String getPictureName() {
		return pictureName;
	}

	public void setPictureName(String pictureName) {
		this.pictureName = pictureName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getIsfree() {
		return isfree;
	}

	public void setIsfree(String isfree) {
		this.isfree = isfree;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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
