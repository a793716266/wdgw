package com.flc.entity;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author Lenovo
 * 帖子类型类
 *
 */
public class PostType {
	

	
	private String posttype_id;		//ID
	private String name;			//标题名字
	private Integer theme;			//主题
	private Integer replycard;		//回帖
	private String synopsis;		//简介
	private String picture;			//图片
	private String manager;			//管理员
	private Integer plate;			//模块
	private String createtime;		//创建时间
	private String createuser;		//创建人
	private String remarks;			//备注
	private Integer num;			//总帖数
	private Integer todaynum;		//今日帖数
	private String username;		//用户昵称
	private Integer postcount;		//活跃达人帖子数
	private String userpicture;//用户头像
	private Integer count;//排行
			
	

	public PostType() {
		super();
	}
	
	public PostType(String posttype_id, String name, Integer theme, Integer replycard, String synopsis, String picture,
			String manager, Integer plate, String createtime, String createuser, String remarks, Integer num,
			Integer todaynum) {
		super();
		this.posttype_id = posttype_id;
		this.name = name;
		this.theme = theme;
		this.replycard = replycard;
		this.synopsis = synopsis;
		this.picture = picture;
		this.manager = manager;
		this.plate = plate;
		this.createtime = createtime;
		this.createuser = createuser;
		this.remarks = remarks;
		this.num = num;
		this.todaynum = todaynum;
	}
	
	public String getPosttype_id() {
		return posttype_id;
	}

	public void setPosttype_id(String posttype_id) {
		this.posttype_id = posttype_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getTheme() {
		return theme;
	}

	public void setTheme(Integer theme) {
		this.theme = theme;
	}

	public Integer getReplycard() {
		return replycard;
	}

	public void setReplycard(Integer replycard) {
		this.replycard = replycard;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public Integer getPlate() {
		return plate;
	}

	public void setPlate(Integer plate) {
		this.plate = plate;
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
	
	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Integer getTodaynum() {
		return todaynum;
	}

	public void setTodaynum(Integer todaynum) {
		this.todaynum = todaynum;
	}
	

 
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getPostcount() {
		return postcount;
	}

	public void setPostcount(Integer postcount) {
		this.postcount = postcount;
	}

	public String getUserpicture() {
		return  userpicture;
	}

	public void setUserpicture(String userpicture) {
		this.userpicture = userpicture;
	}
		
	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "PostType [posttype_id=" + posttype_id + ", name=" + name + ", theme=" + theme + ", replycard="
				+ replycard + ", synopsis=" + synopsis + ", picture=" + picture + ", manager=" + manager + ", plate="
				+ plate + ", createtime=" + createtime + ", createuser=" + createuser + ", remarks=" + remarks + "]";
	}
 
	
	
	
	
}
