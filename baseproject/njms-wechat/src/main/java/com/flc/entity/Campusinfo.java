package com.flc.entity;

import java.io.Serializable;

public class Campusinfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1086530947966240527L;
	private String CAMPUSINFO_ID;
	private String ADDRESS;
	private String ADVISORYTELEPHONE;
	private String VERSIONNUMBER;
	private String REMARKS;
	private String CREATETIME;
	private String CREATEUSER;
	public String getCAMPUSINFO_ID() {
		return CAMPUSINFO_ID;
	}
	public void setCAMPUSINFO_ID(String cAMPUSINFO_ID) {
		CAMPUSINFO_ID = cAMPUSINFO_ID;
	}
	public String getADDRESS() {
		return ADDRESS;
	}
	public void setADDRESS(String aDDRESS) {
		ADDRESS = aDDRESS;
	}
	public String getADVISORYTELEPHONE() {
		return ADVISORYTELEPHONE;
	}
	public void setADVISORYTELEPHONE(String aDVISORYTELEPHONE) {
		ADVISORYTELEPHONE = aDVISORYTELEPHONE;
	}
	public String getVERSIONNUMBER() {
		return VERSIONNUMBER;
	}
	public void setVERSIONNUMBER(String vERSIONNUMBER) {
		VERSIONNUMBER = vERSIONNUMBER;
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
	public Campusinfo(String cAMPUSINFO_ID, String aDDRESS, String aDVISORYTELEPHONE, String vERSIONNUMBER,
			String rEMARKS, String cREATETIME, String cREATEUSER) {
		super();
		CAMPUSINFO_ID = cAMPUSINFO_ID;
		ADDRESS = aDDRESS;
		ADVISORYTELEPHONE = aDVISORYTELEPHONE;
		VERSIONNUMBER = vERSIONNUMBER;
		REMARKS = rEMARKS;
		CREATETIME = cREATETIME;
		CREATEUSER = cREATEUSER;
	}
	public Campusinfo() {
		// TODO Auto-generated constructor stub
	}
}
