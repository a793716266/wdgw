package com.flc.entity;

import java.io.Serializable;

/**
 * 合作企业
 * 
 * @author 王尧宇
 *
 */
public class Company implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6049973693047347878L;
	private String company_id; // 主键32位全球唯一号
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
	
	public String getCompany_id() {
		return company_id;
	}
	public Company() {}
}
