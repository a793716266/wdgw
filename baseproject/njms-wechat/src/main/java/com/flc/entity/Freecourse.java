package com.flc.entity;

import java.io.Serializable;

/**
 * 老师表
 * @author 郑高
 *
 */
public class Freecourse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1118127598943968706L;
	private String picturename; 	  //照片名
	private String title;		      //视频标题
	private String course;			  //课程类型
	private String isfree;		      //是否免费
	private String teacher;			  //老师
	private String createTime;		  //创建时间
	private String url;			      //视频路径
	private String createtime;		  //创建时间
	private String createuser;        //创建用户
	private String remarks;			  //备注
	@Override
	public String toString() {
		return "Wdgw_freecourse [picturename=" + picturename + ", title=" + title + ", course=" + course + ", isfree="
				+ isfree + ", teacher=" + teacher + ", createTime=" + createTime + ", url=" + url + ", createtime="
				+ createtime + ", createuser=" + createuser + ", remarks=" + remarks + "]";
	}
	public String getPicturename() {
		return picturename;
	}
	public void setPicturename(String picturename) {
		this.picturename = picturename;
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
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getCreateuser() {
		return createuser;
	}
	public void setCreateuser(String createuser) {
		this.createuser = createuser;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}



}
