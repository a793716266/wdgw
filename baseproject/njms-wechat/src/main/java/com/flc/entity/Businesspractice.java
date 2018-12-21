package com.flc.entity;

import java.io.Serializable;

public class Businesspractice implements Serializable  {
	private static final long serialVersionUID = -4787384259581714832L;
	private String businessPractice_id;   //ID
	private String titleName;              //实战标题
	private Integer projectCount;          //实战项目数量
	private Double maxSalary;              //最高月薪
	private Double avgSalary;              //平均月薪
	private Double jobPercent;             //高新就业率
	private Integer state;                 //是否参加实战
	public String getBusinessPractice_id() {
		return businessPractice_id;
	}
	public void setBusinessPractice_id(String businessPractice_id) {
		this.businessPractice_id = businessPractice_id;
	}
	public String getTitleName() {
		return titleName;
	}
	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}
	public Integer getProjectCount() {
		return projectCount;
	}
	public void setProjectCount(Integer projectCount) {
		this.projectCount = projectCount;
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
	public Double getJobPercent() {
		return jobPercent;
	}
	public void setJobPercent(Double jobPercent) {
		this.jobPercent = jobPercent;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
