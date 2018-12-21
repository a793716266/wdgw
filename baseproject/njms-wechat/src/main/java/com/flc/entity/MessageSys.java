package com.flc.entity;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 系统消息
 * @author 
 *
 */
public class MessageSys {
	private String mName; //系统消息名称
	private String mText; //系统消息内容
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date mCreateTime; //系统消息创建日期
	
	public MessageSys() {
		super();
	}

	public MessageSys(String mName, String mText, Date mCreateTime) {
		super();
		this.mName = mName;
		this.mText = mText;
		this.mCreateTime = mCreateTime;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getmText() {
		return mText;
	}

	public void setmText(String mText) {
		this.mText = mText;
	}

	public Date getmCreateTime() {
		return mCreateTime;
	}

	public void setmCreateTime(Date mCreateTime) {
		this.mCreateTime = mCreateTime;
	}

	


}
