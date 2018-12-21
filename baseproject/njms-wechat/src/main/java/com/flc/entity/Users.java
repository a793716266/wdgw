package com.flc.entity;

import java.io.Serializable;

/**
 * 用户表
 * @author 郑高
 *
 */
public class Users implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6177951963902575493L;
	private String wd_users_id; 		//主键32位全球唯一号
	private String accountNumber;		//用户账户
	private String password;			//用户密码
	private String nickName;			//用户昵称
	private String picture;				//用户头像
	private String phoneNumber;			//用户手机号
	private String mailBox;				//用户邮箱
	private String createTime;			//创建时间
	private String createUser;			//创建人
	private String remarks;				//备注
	
	public Users(){}

	public String getWd_users_id() {
		return wd_users_id;
	}

	public void setWd_users_id(String wd_users_id) {
		this.wd_users_id = wd_users_id;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getMailBox() {
		return mailBox;
	}

	public void setMailBox(String mailBox) {
		this.mailBox = mailBox;
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
