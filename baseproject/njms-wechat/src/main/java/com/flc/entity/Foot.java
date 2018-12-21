package com.flc.entity;

import java.io.Serializable;

public class Foot implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2065343432625826167L;
	private String FOOT_ID;
	private String LOGO;
	private String COUNT;
	private String NAME;
	private String REMARKS;
	private String CREATETIME;
	private String CREATEUSER;
	private String RESPATH;
	public String getFOOT_ID() {
		return FOOT_ID;
	}
	public void setFOOT_ID(String fOOT_ID) {
		FOOT_ID = fOOT_ID;
	}
	public String getLOGO() {
		return LOGO;
	}
	public void setLOGO(String lOGO) {
		LOGO = lOGO;
	}
	public String getCOUNT() {
		return COUNT;
	}
	public void setCOUNT(String cOUNT) {
		COUNT = cOUNT;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getREMARKS() {
		return REMARKS;
	}
	public void setREMARKS(String rEMARKS) {
		REMARKS = rEMARKS;
	}
	public String getCREATETIME() {
		return CREATETIME;
	}
	public void setCREATETIME(String cREATETIME) {
		CREATETIME = cREATETIME;
	}
	public String getCREATEUSER() {
		return CREATEUSER;
	}
	public void setCREATEUSER(String cREATEUSER) {
		CREATEUSER = cREATEUSER;
	}
	public String getRESPATH() {
		return RESPATH;
	}
	public void setRESPATH(String rESPATH) {
		RESPATH = rESPATH;
	}
	public Foot(String fOOT_ID, String lOGO, String cOUNT, String nAME, String rEMARKS, String cREATETIME,
			String cREATEUSER, String rESPATH) {
		super();
		FOOT_ID = fOOT_ID;
		LOGO = lOGO;
		COUNT = cOUNT;
		NAME = nAME;
		REMARKS = rEMARKS;
		CREATETIME = cREATETIME;
		CREATEUSER = cREATEUSER;
		RESPATH = rESPATH;
	}
	public Foot() {
		// TODO Auto-generated constructor stub
	}
	
}
