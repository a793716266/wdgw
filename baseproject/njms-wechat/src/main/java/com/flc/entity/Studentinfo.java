package com.flc.entity;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 最近就业学生表
 * @author 郑高
 *
 */
public class  Studentinfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2789578656104468513L;
	private String studentinfo_id;		//主键32位全球唯一号
	private String name;				//学员姓名
	private String companyName;			//公司名称
	private double salary;				//就业薪资
	private String createTime;			//创建时间
	private String createUser;			//创建人
	private String remarks;				//备注
	private Date getjobtime;			//就业时间
	
	public String getGetjobtime() {
		String date = "";
		if(null!=getjobtime){
			SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd"); 
			date=sDateFormat.format(this.getjobtime);
		}
		return date;
	}

	public void setGetjobtime(Date getjobtime) {
		this.getjobtime = getjobtime;
	}

	public Studentinfo(){}

	public String getStudentinfo_id() {
		return studentinfo_id;
	}

	public void setStudentinfo_id(String studentinfo_id) {
		this.studentinfo_id = studentinfo_id;
	}

	public String getName() {
		String name = "";
		if(null != this.name){
			if(this.name.length()>=3){
				name = this.name.substring(0,1);
				for (int i = 0; i < this.name.length()-1; i++) {
					name += "*";
				}
			}else{
				name = this.name.substring(0,1)+"*";
			}
		}
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompanyName() {
		String prefix = companyName.substring(0,3);
		String suffix = companyName.substring(companyName.length()-2,companyName.length());
		this.companyName = prefix+"*"+suffix; 
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		
		this.companyName = companyName; 
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
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
