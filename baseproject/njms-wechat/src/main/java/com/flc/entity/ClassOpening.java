package com.flc.entity;

import java.io.Serializable;

/**
 * 开班信息表
 * @author 郑高
 *
 */
public class ClassOpening implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9032909572686077020L;
	private String classopening_id; //主键32位全球唯一号
	private String ctype;			//课程类型
	private String classState;		//班级状态
	private String classTypeName;	//班级类型
	private int classNumber;		//班级编号
	private int totalNumber;		//班级总名额
	private int currentNumber;		//现有人数
	private String reservsState;	//预定状态
	private String createTime;		//创建时间
	private String createUser;		//创建人
	private String remarks;			//备注
	
	public ClassOpening(){}

	public String getClassopening_id() {
		return classopening_id;
	}

	public void setClassopening_id(String classopening_id) {
		this.classopening_id = classopening_id;
	}

	public String getCtype() {
		return ctype;
	}

	public void setCtype(String ctype) {
		this.ctype = ctype;
	}

	public String getClassState() {
		return classState;
	}

	public void setClassState(String classState) {
		this.classState = classState;
	}

	public String getClassTypeName() {
		return classTypeName;
	}

	public void setClassTypeName(String classTypeName) {
		this.classTypeName = classTypeName;
	}

	public int getClassNumber() {
		return classNumber;
	}

	public void setClassNumber(int classNumber) {
		this.classNumber = classNumber;
	}

	public int getTotalNumber() {
		return totalNumber;
	}

	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
	}

	public int getCurrentNumber() {
		return currentNumber;
	}

	public void setCurrentNumber(int currentNumber) {
		this.currentNumber = currentNumber;
	}

	public String getReservsState() {
		return reservsState;
	}

	public void setReservsState(String reservsState) {
		this.reservsState = reservsState;
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
