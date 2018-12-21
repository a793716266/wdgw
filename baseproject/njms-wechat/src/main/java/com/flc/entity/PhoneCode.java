package com.flc.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 手机号+验证码
 * @author Jason
 *
 */
public class PhoneCode implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1914907656300101322L;
	private String phoneCode_id;   //uuid
	private String phone_number;   //手机号码
	private String phone_code;     //验证码
	private Date createtime;       //创建时间
	private String createuser;     //创建人
	private String remarks;        //备注
	public String getPhoneCode_id() {
		return phoneCode_id;
	}
	public void setPhoneCode_id(String phoneCode_id) {
		this.phoneCode_id = phoneCode_id;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getPhone_code() {
		return phone_code;
	}
	public void setPhone_code(String phone_code) {
		this.phone_code = phone_code;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public String getCreateuser() {
		return createuser;
	}
	public void setCreateuser(String createuser) {
		this.createuser = createuser;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
}
