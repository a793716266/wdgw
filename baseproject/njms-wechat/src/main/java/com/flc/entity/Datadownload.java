package com.flc.entity;

import java.util.Date;

public class Datadownload {
	
	private String datadownload_id;		//主键32位全球唯一号
	private String dataname;			//资料名称		
	private String datasize;			//资料大小	
	private String kanboxurl;			//网盘下载	
	private String lookintroduceurl;	//查看介绍
	private Integer downloadcount;		//下载次数
	private String createuser;			//创建人	
	private Date createtime;			//创建时间
	private String remarks;				//备注
	
	public String getDatadownload_id() {
		return datadownload_id;
	}
	public void setDatadownload_id(String datadownload_id) {
		this.datadownload_id = datadownload_id;
	}
	public String getDataname() {
		return dataname;
	}
	public void setDataname(String dataname) {
		this.dataname = dataname;
	}
	public String getDatasize() {
		return datasize;
	}
	public void setDatasize(String datasize) {
		this.datasize = datasize;
	}
	public String getKanboxurl() {
		return kanboxurl;
	}
	public void setKanboxurl(String kanboxurl) {
		this.kanboxurl = kanboxurl;
	}
	public String getLookintroduceurl() {
		return lookintroduceurl;
	}
	public void setLookintroduceurl(String lookintroduceurl) {
		this.lookintroduceurl = lookintroduceurl;
	}
	public Integer getDownloadcount() {
		return downloadcount;
	}
	public void setDownloadcount(Integer downloadcount) {
		this.downloadcount = downloadcount;
	}
	public String getCreateuser() {
		return createuser;
	}
	public void setCreateuser(String createuser) {
		this.createuser = createuser;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	
}
