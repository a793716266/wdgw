package com.flc.entity;

import java.io.Serializable;

/**
 * 就业班级表
 * @author 郑高
 *
 */
public class Employmentclass implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2925113230826305004L;
	private String employmentclass_id; 	//主键32位全球唯一号
	private String className;			//班级名称
	private String classType;			//班级类型
	private String course;              //课程类型
	private String systemType;          //日制
	private String classLogo;           //班级logo
	private Double maxSalary;			//最高薪资
	private Double avgSalary;			//平均薪资
	private String teachers;			//教员
	private String classCharge;			//班主任
	private String createTime;			//创建时间
	private String createUser;			//创建人
	private String remarks;				//备注
	
	public Employmentclass(){}

	public String getEmploymentclass_id() {
		return employmentclass_id;
	}

	public void setEmploymentclass_id(String employmentclass_id) {
		this.employmentclass_id = employmentclass_id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassType() {
		return classType;
	}

	public void setClassType(String classType) {
		this.classType = classType;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getSystemType() {
		return systemType;
	}

	public void setSystemType(String systemType) {
		this.systemType = systemType;
	}

	public String getClassLogo() {
		return classLogo;
	}

	public void setClassLogo(String classLogo) {
		this.classLogo = classLogo;
	}

	public Double getMaxSalary() {
		return maxSalary;
	}

	public void setMaxSalary(Double maxSalary) {
		this.maxSalary = maxSalary;
	}

	public Double getAvgSalary() {
		return avgSalary;
	}

	public void setAvgSalary(Double avgSalary) {
		this.avgSalary = avgSalary;
	}

	public String getTeachers() {
		return teachers;
	}

	public void setTeachers(String teachers) {
		this.teachers = teachers;
	}

	public String getClassCharge() {
		return classCharge;
	}

	public void setClassCharge(String classCharge) {
		this.classCharge = classCharge;
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
