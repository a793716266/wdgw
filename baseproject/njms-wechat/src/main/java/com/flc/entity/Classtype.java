package com.flc.entity;

import java.io.Serializable;

public class Classtype implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5866579677538513076L;
	private String classtype_id;     //主键32位全球唯一号
	private String classTypeName;	//类型名称
	private String classLogo;		//类型Logo
	private String createDate;		//创建时间
	private String createUser;		//创建人
	private String remarks;			//备注
	
	public Classtype(){}
	
	public String getClasstype_id() {
		return classtype_id;
	}
	public void setClasstype_id(String classtype_id) {
		this.classtype_id = classtype_id;
	}
	public String getClassTypeName() {
		return classTypeName;
	}
	public void setClassTypeName(String classTypeName) {
		this.classTypeName = classTypeName;
	}
	public String getClassLogo() {
		return classLogo;
	}
	public void setClassLogo(String classLogo) {
		this.classLogo = classLogo;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
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
