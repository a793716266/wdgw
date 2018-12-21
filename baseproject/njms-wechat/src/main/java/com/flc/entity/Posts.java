package com.flc.entity;


/**
 * 我的贴子
 * @author 
 *
 */

public class Posts {
	private String post_id; //贴子id
	private String name;	//贴子板块名
	private String title;	//贴子标题
	private int viewnumber;	//浏览数
	private String postType_id;	//帖子类型id
	private int restorenumber;	//回复数
	private String createtime;	//创建时间
	public Posts() {
		super();
	}
	public Posts(String post_id, String name, String title, int viewnumber, int restorenumber, String createtime) {
		super();
		this.post_id = post_id;
		this.name = name;
		this.title = title;
		this.viewnumber = viewnumber;
		this.restorenumber = restorenumber;
		this.createtime = createtime;
	}
	public String getPost_id() {
		return post_id;
	}
	public void setPost_id(String post_id) {
		this.post_id = post_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPostType_id() {
		return postType_id;
	}
	public void setPostType_id(String postType_id) {
		this.postType_id = postType_id;
	}
	public int getViewnumber() {
		return viewnumber;
	}
	public void setViewnumber(int viewnumber) {
		this.viewnumber = viewnumber;
	}
	public int getRestorenumber() {
		return restorenumber;
	}
	public void setRestorenumber(int restorenumber) {
		this.restorenumber = restorenumber;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	
}
