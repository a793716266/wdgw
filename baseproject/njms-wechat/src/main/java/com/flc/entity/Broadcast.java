package com.flc.entity;

import java.io.Serializable;

/**
 * 轮播表
 * @author 郑高
 *
 */
public class Broadcast implements Serializable {
	private static final long serialVersionUID = 4697411588578116141L;
	private String broadcast_id; 	//主键32位全球唯一号
	private String picturePath;		//图片
	private Integer pictureState;   //是否隐藏
	private Integer broadcastPage;  //轮播页码 
	private String createTime;		//创建时间
	private String createUser;		//创建人
	private String remarks;			//备注
	public Broadcast(){}

	public String getBroadcast_id() {
		return broadcast_id;
	}

	public Integer getBroadcastPage() {
		return broadcastPage;
	}

	public void setBroadcastPage(Integer broadcastPage) {
		this.broadcastPage = broadcastPage;
	}
	public void setBroadcast_id(String broadcast_id) {
		this.broadcast_id = broadcast_id;
	}

	public String getPicturePath() {
		return picturePath;
	}

	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}

	public Integer getPictureState() {
		return pictureState;
	}

	public void setPictureState(Integer pictureState) {
		this.pictureState = pictureState;
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
	};
	
}
