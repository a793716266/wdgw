package com.flc.entity;

import java.io.Serializable;

/**
 * 优秀学生表
 * @author 郑高
 *
 */
public class Goodstudents implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1155501616616763466L;
	private String goodstudents_id; 	//主键32位全球唯一号
	private String videoName;			//视频名
	private String stuName;				//学生姓名
	private Double empWage;				//就业薪资
	private String c_type;				//课程类型
	private String speech;				//学习感言
	private String empCompany;			//就业公司
	private String empTime;				//就业时间
	private String studentimg;           //学员照片
	private String createTime;			//创建时间
	private String createUser;			//创建人
	private String remarks;				//备注
	public Goodstudents(){}

	public String getStudentimg() {
		return studentimg;
	}

	public void setStudentimg(String studentimg) {
		this.studentimg = studentimg;
	}

	public String getGoodstudents_id() {
		return goodstudents_id;
	}

	public void setGoodstudents_id(String goodstudents_id) {
		this.goodstudents_id = goodstudents_id;
	}

	public String getVideoName() {
		return videoName;
	}

	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public Double getEmpWage() {
		return empWage;
	}

	public void setEmpWage(Double empWage) {
		this.empWage = empWage;
	}

	public String getC_type() {
		return c_type;
	}

	public void setC_type(String c_type) {
		this.c_type = c_type;
	}

	public String getSpeech() {
		return speech;
	}

	public void setSpeech(String speech) {
		this.speech = speech;
	}

	public String getEmpCompany() {
		return empCompany;
	}

	public void setEmpCompany(String empCompany) {
		String prefix = empCompany.substring(0,3);
		String suffix = empCompany.substring(empCompany.length()-2,empCompany.length());
		this.empCompany = prefix+"*"+suffix; 
	}

	public String getEmpTime() {
		return empTime;
	}

	public void setEmpTime(String empTime) {
		this.empTime = empTime;
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
