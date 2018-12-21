package com.flc.entity;

import java.io.Serializable;

/**
 * 新闻表
 * @author 郑高
 *
 */
public class News implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7273020377109310009L;
	private String news_id; 		//主键32位全球唯一号
	private String pictureName;		//图片
	private String newTitle;		//标题
	private String newContent;		//内容
	private String newsType;		//新闻类型
	private String createTime;		//创建时间
	private String createUser;		//创建人
	private String remarks;			//备注
	private String ORIGIN;
	private String AUTHOR;
	private String CLICKS;
	
	
	public String getORIGIN() {
		return ORIGIN;
	}

	public void setORIGIN(String oRIGIN) {
		ORIGIN = oRIGIN;
	}

	public String getAUTHOR() {
		return AUTHOR;
	}

	public void setAUTHOR(String aUTHOR) {
		AUTHOR = aUTHOR;
	}

	public String getCLICKS() {
		return CLICKS;
	}

	public void setCLICKS(String cLICKS) {
		CLICKS = cLICKS;
	}

	public News(){};
	
	public String getNews_id() {
		return news_id;
	}
	public void setNews_id(String news_id) {
		this.news_id = news_id;
	}
	public String getPictureName() {
		return pictureName;
	}
	public void setPictureName(String pictureName) {
		this.pictureName = pictureName;
	}
	public String getNewTitle() {
		return newTitle;
	}
	public void setNewTitle(String newTitle) {
		this.newTitle = newTitle;
	}
	public String getNewContent() {
		return newContent;
	}
	public void setNewContent(String newContent) {
		this.newContent = newContent;
	}
	public String getNewsType() {
		return newsType;
	}
	public void setNewsType(String newsType) {
		this.newsType = newsType;
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
