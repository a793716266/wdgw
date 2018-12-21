package com.flc.entity;

import java.io.Serializable;

/**
 * 轮播表
 * @author 郑高
 *
 */
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4635820150021848292L;
	private String wd_users_id; 	//主键32位全球唯一号
	private String accountnumber;	//用户账户
	private String password;		    //用户密码
	private String nickname;		//用户昵称
	private String picture;		     //用户头像
	private String phonenumber;		//用户手机号
	private String mailbox;			//用户邮箱
	private String createuser;			//创建用户
	private Integer loginStatus;     //登录状态
	private String projectNum;		//课程数量提醒
	private Integer sysNum;			//系统消息数量提醒
	private Integer postNum;		//帖子数量提醒
	
	
	public User() {
		super();
	}
	public User(String wd_users_id, String accountnumber, String password, String nickname, String picture,
			String phonenumber, String mailbox, String createuser) {
		super();
		this.wd_users_id = wd_users_id;
		this.accountnumber = accountnumber;
		this.password = password;
		this.nickname = nickname;
		this.picture = picture;
		this.phonenumber = phonenumber;
		this.mailbox = mailbox;
		this.createuser = createuser;
	}

	public Integer getLoginStatus() {
		return loginStatus;
	}
	public void setLoginStatus(Integer loginStatus) {
		this.loginStatus = loginStatus;
	}
	public String getWd_users_id() {
		return wd_users_id;
	}
	public void setWd_users_id(String wd_users_id) {
		this.wd_users_id = wd_users_id;
	}
	public String getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getMailbox() {
		return mailbox;
	}
	public void setMailbox(String mailbox) {
		this.mailbox = mailbox;
	}
	public String getCreateuser() {
		return createuser;
	}
	public void setCreateuser(String createuser) {
		this.createuser = createuser;
	}
	public String getProjectNum() {
		if(Integer.parseInt(this.projectNum)>0){
			return "新";
		}
		return null;
	}
	public void setProjectNum(String projectNum) {
		this.projectNum = projectNum;
	}
	
	public Integer getSysNum() {
		return sysNum;
	}
	public void setSysNum(Integer sysNum) {
		this.sysNum = sysNum;
	}
	public Integer getPostNum() {
		return postNum;
	}
	public void setPostNum(Integer postNum) {
		this.postNum = postNum;
	}
	
	
	
}
