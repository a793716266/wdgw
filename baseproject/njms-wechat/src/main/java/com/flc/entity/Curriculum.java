package com.flc.entity;

import java.io.Serializable;

/**
 * 课程类型表
 * @author 郑高
 *
 */
public class Curriculum implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8459097736236260122L;
	private String curriculum_id; 	//主键32位全球唯一号
	private String c_type;			//课程类型
	private String createTime;		//创建时间
	private String createUser;		//创建人
	private String remarks;			//备注
	
	public Curriculum(){};
	
	public String getCurriculum_id() {
		return curriculum_id;
	}

	public void setCurriculum_id(String curriculum_id) {
		this.curriculum_id = curriculum_id;
	}

	public String getC_type() {
		return c_type;
	}

	public void setC_type(String c_type) {
		this.c_type = c_type;
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
