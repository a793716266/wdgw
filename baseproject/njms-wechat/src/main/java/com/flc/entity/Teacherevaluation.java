package com.flc.entity;

import java.io.Serializable;

/**
 * 老师表
 * @author 郑高
 *
 */
public class Teacherevaluation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -35073980708428436L;
	private String teacherevaluation_id; 			//主键32位全球唯一号
	private String studentid; //学员ID
	private String teacherid; //老师ID
	private String content; //评论内容
	private String createtime; //评论时间
	private String createuser; //创建用户
	private String remarks; //备注
	public String getTeacherevaluation_id() {
		return teacherevaluation_id;
	}
	public void setTeacherevaluation_id(String teacherevaluation_id) {
		this.teacherevaluation_id = teacherevaluation_id;
	}
	public String getStudentid() {
		return studentid;
	}
	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}
	public String getTeacherid() {
		return teacherid;
	}
	public void setTeacherid(String teacherid) {
		this.teacherid = teacherid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
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
