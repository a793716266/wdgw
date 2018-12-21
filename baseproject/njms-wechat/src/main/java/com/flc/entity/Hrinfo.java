package com.flc.entity;

import java.io.Serializable;

/**
 * HR表
 * @author 郑高
 *
 */
public class Hrinfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4975559572624763886L;
	private String hrinfo_id; 		//主键32位全球唯一号
	private String headPortrait;	//头像
	private String hr_name;			//HR_姓名
	private String evaluation;		//评价
	private String hr_position;		//职务
	private String logo;			//公司LOGO
	private String createTime;		//创建时间
	private String createUser;		//创建人
	private String remarks;			//备注
	
	public Hrinfo(){}

	public String getHrinfo_id() {
		return hrinfo_id;
	}

	public void setHrinfo_id(String hrinfo_id) {
		this.hrinfo_id = hrinfo_id;
	}

	public String getHeadPortrait() {
		return headPortrait;
	}

	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = headPortrait;
	}
	
	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getHr_name() {
		return hr_name;
	}

	public void setHr_name(String hr_name) {
		this.hr_name = hr_name;
	}

	public String getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
	}

	public String getHr_position() {
		return hr_position;
	}

	public void setHr_position(String hr_position) {
		this.hr_position = hr_position;
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
