package com.flc.entity;

import java.util.Date;

public class VideoAndUser {
	
	private String RELATION_ID;
    private String USER_ID;
    private String VIDEO_ID;
    private Date CREATETIME;
    
	public String getRELATION_ID() {
		return RELATION_ID;
	}
	public void setRELATION_ID(String rELATION_ID) {
		RELATION_ID = rELATION_ID;
	}
	public String getUSER_ID() {
		return USER_ID;
	}
	public void setUSER_ID(String uSER_ID) {
		USER_ID = uSER_ID;
	}
	public String getVIDEO_ID() {
		return VIDEO_ID;
	}
	public void setVIDEO_ID(String vIDEO_ID) {
		VIDEO_ID = vIDEO_ID;
	}
	public Date getCREATETIME() {
		return CREATETIME;
	}
	public void setCREATETIME(Date cREATETIME) {
		CREATETIME = cREATETIME;
	}
    
    

}
