package com.flc.entity;

import java.io.Serializable;

/**
 * 新闻类型
 * @author 郑高
 *
 */
public class Newtype implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1982667865128139580L;
	private String newType_id; //主键32位全球唯一号
	private String type;	   //新闻类型
	private String createTime; //创建时间
	private String createUser; //创建人
	private String remarks;	   //备注
	
	public Newtype(){};
	
	public String getNewType_id() {
		return newType_id;
	}
	public void setNewType_id(String newType_id) {
		this.newType_id = newType_id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
