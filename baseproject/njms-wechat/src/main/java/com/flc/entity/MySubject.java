package com.flc.entity;

import java.util.Random;

/**
 * 个人中心中我的课程
 * @author 
 *
 */
public class MySubject {
	private String pictureName; //视频图片
	private String title;	//课程名
	private String url;	//视频路径
	private String video_code;//视频编号
	private Integer number;	//随机数S
	
	public MySubject() {
		super();
	}
	public MySubject(String pictureName, String title, String url) {
		super();
		this.pictureName = pictureName;
		this.title = title;
		this.url = url;
	}
			
	public MySubject(String pictureName, String title, String url, String video_code, Integer number) {
		super();
		this.pictureName = pictureName;
		this.title = title;
		this.url = url;
		this.video_code = video_code;
		this.number = number;
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getVideo_code() {
		return video_code;
	}
	public void setVideo_code(String video_code) {
		this.video_code = video_code;
	}
	public Integer getNumber() {
		int max=10000;
		int min=1000;
		Random random = new Random();
		int number = random.nextInt(max)%(max-min+1) + min;
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	
	
}
