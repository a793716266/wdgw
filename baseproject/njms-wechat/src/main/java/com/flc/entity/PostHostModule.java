package com.flc.entity;

public class PostHostModule {
	private String picsrc;//图片地址
	private String posturl;//图片跳转链接
	private String title;//图片标题
	private String istrue;//是否开启动画
	
	public String getIstrue() {
		return istrue;
	}
	public void setIstrue(String istrue) {
		this.istrue = istrue;
	}
	public String getPicsrc() {
		return picsrc;
	}
	public void setPicsrc(String picsrc) {
		this.picsrc = picsrc;
	}
	public String getPosturl() {
		return posturl;
	}
	public void setPosturl(String posturl) {
		this.posturl = posturl;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
