package com.flc.entity;

import java.io.Serializable;

/**
 * subject表
 * @author 郑高
 *
 */
public class Subject implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5132003625745740499L;
	private String subject_id; 			//主键32位全球唯一号
	private String subjectName;			//项目名
	private String pictureName;			//图片名
	private String course;				//课程类型
	private String createUser;			//创建人
	private String remarks;				//备注
	private String numberOfYears;		//开发经验
	
	public Subject(){}

	public String getSubject_id() {
		return subject_id;
	}

	public void setSubject_id(String subject_id) {
		this.subject_id = subject_id;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getPictureName() {
		return pictureName;
	}

	public void setPictureName(String pictureName) {
		this.pictureName = pictureName;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
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

	public String getNumberOfYears() {
		return numberOfYears;
	}

	public void setNumberOfYears(String numberOfYears) {
		this.numberOfYears = numberOfYears;
	}

	
}
