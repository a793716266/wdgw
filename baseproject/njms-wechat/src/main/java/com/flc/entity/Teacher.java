package com.flc.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 老师表
 * @author 郑高
 *
 */
public class Teacher implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1214513109029889824L;
	private String teacher_id; 			//主键32位全球唯一号
	private String headPortrait;		//头像
	private String name;				//姓名
	private String curriculumType;		//课程类型
	private String info;				//简介
	private String createTime;			//创建时间
	private String identity;			//身份：教员/班主任
	private String createUser;			//创建人
	private String remarks;				//备注
	private List<Teacherevaluation> content;//评论	

	public List<Teacherevaluation> getContent() {
		return content;
	}

	public void setContent(List<Teacherevaluation> content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Wdgw_teacher [teacher_id=" + teacher_id + ", headPortrait=" + headPortrait + ", name=" + name
				+ ", curriculumType=" + curriculumType + ", info=" + info + ", createTime=" + createTime + ", identity="
				+ identity + ", createUser=" + createUser + ", remarks=" + remarks + ", content=" + content
				+ ", numberofyears=" + numberofyears + "]";
	}

	private Integer numberofyears;				//备注
	
	public Integer getNumberofyears() {
		return numberofyears;
	}

	public void setNumberofyears(Integer numberofyears) {
		this.numberofyears = numberofyears;
	}

	public Teacher(){}

	public String getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(String teacher_id) {
		this.teacher_id = teacher_id;
	}

	
	public String getHeadPortrait() {
		return headPortrait;
	}

	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = headPortrait;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCurriculumType() {
		return curriculumType;
	}

	public void setCurriculumType(String curriculumType) {
		this.curriculumType = curriculumType;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
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
