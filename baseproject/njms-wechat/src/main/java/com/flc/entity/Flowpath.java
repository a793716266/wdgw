package com.flc.entity;

import java.io.Serializable;

/**
 * 
 * @author 
 *
 */
public class Flowpath implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 591228237795571071L;
	 /**
	  * sort 页面排序
	  * describetext 描述文本
	  * image1 图片1
	  * image2 图片2
	  * image3 图片3
	  * textdescribe 标题描述
	  * titleimage 标题图片
	  * 
	  * **/
	private String flowpath_id; 	//主键32位全球唯一号
	private String titleimage;		//标题图片
	private String textdescribe;	//文本描述
	private String detailsurl;      //详情路径
	private Integer sort;            //页面排序
	private String describetext;    //描述文本
	private String image1;          //图片1
	public Integer getSort() {
		return sort;
	}
	public void Integer(Integer sort) {
		this.sort = sort;
	}
	public String getDescribetext() {
		return describetext;
	}
	public void setDescribetext(String describetext) {
		this.describetext = describetext;
	}
	public String getImage1() {
		return image1;
	}
	public void setImage1(String image1) {
		this.image1 = image1;
	}
	public String getImage2() {
		return image2;
	}
	public void setImage2(String image2) {
		this.image2 = image2;
	}
	public String getImage3() {
		return image3;
	}
	public void setImage3(String image3) {
		this.image3 = image3;
	}
	private String image2;          //图片2
	private String image3;          //图片3
	public Flowpath() {
		super();
	}

	public String getFlowpath_id() {
		return flowpath_id;
	}
	public void setFlowpath_id(String flowpath_id) {
		this.flowpath_id = flowpath_id;
	}
	public String getTitleimage() {
		return titleimage;
	}
	@Override
	public String toString() {
		return "Flowpath [flowpath_id=" + flowpath_id + ", titleimage=" + titleimage + ", textdescribe=" + textdescribe
				+ ", detailsurl=" + detailsurl + ", sort=" + sort + ", describetext=" + describetext + ", image1="
				+ image1 + ", image2=" + image2 + ", image3=" + image3 + "]";
	}
	public Flowpath(String flowpath_id, String titleimage, String textdescribe, String detailsurl, Integer sort,
			String describetext, String image1, String image2, String image3) {
		super();
		this.flowpath_id = flowpath_id;
		this.titleimage = titleimage;
		this.textdescribe = textdescribe;
		this.detailsurl = detailsurl;
		this.sort = sort;
		this.describetext = describetext;
		this.image1 = image1;
		this.image2 = image2;
		this.image3 = image3;
	}
	public void setTitleimage(String titleimage) {
		this.titleimage = titleimage;
	}
	public String getTextdescribe() {
		return textdescribe;
	}
	public void setTextdescribe(String textdescribe) {
		this.textdescribe = textdescribe;
	}
	public String getDetailsurl() {
		return detailsurl;
	}
	public void setDetailsurl(String detailsurl) {
		this.detailsurl = detailsurl;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
