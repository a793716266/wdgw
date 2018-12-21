package com.flc.entity;

import java.io.Serializable;

/**
 * 合作院校
 * 
 * @author 王尧宇
 *
 */
public class Academy implements Serializable {
	private static final long serialVersionUID = -1952436932760039990L;
	private String academy_id; // 主键32位全球唯一号
	private String name;// 名字
	private String picture;// 图片
	private String createTime; // 创建时间
	private String createUser; // 创建人
	private String remarks; // 备注
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
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
	public String getAcademy_id() {
		return academy_id;
	}
	
	public Academy() {}
}
