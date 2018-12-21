package com.flc.entity;

import java.io.Serializable;

/**
 * 课程表
 * @author 郑高
 *
 */
public class Curriculuminfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7051732252705882435L;
	private String curriculuminfo_id; 	//主键32位全球唯一号
	private String picture;				//课程展示图片
	private String infoName;			//详细课程名称
	private String wages;				//就业工资
	private String studyTime;			//课程学习总时间
	private String createTime;			//创建时间
	private String createUser;			//创建人
	private String remarks;				//备注
	
	public Curriculuminfo(){}

	public String getCurriculuminfo_id() {
		return curriculuminfo_id;
	}

	public void setCurriculuminfo_id(String curriculuminfo_id) {
		this.curriculuminfo_id = curriculuminfo_id;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getInfoName() {
		return infoName;
	}

	public void setInfoName(String infoName) {
		this.infoName = infoName;
	}

	public String getWages() {
		return wages;
	}

	public void setWages(String wages) {
		this.wages = wages;
	}

	public String getStudyTime() {
		return studyTime;
	}

	public void setStudyTime(String studyTime) {
		this.studyTime = studyTime;
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
