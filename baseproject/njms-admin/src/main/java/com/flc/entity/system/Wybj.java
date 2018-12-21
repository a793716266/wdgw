package com.flc.entity.system;

import java.util.List;

/** 
 * 说明：文案编辑 实体类
 * 创建人：FLC
 * 创建时间：2018-10-05
 */
public class Wybj{ 
	
	private String WYBJ_ID;	//主键
	private String NAME;					//名称
	private String PARENT_ID;				//父类ID
	private String target;
	private Wybj wybj;
	private List<Wybj> subWybj;
	private boolean hasWybj = false;
	private String treeurl;
	
	private String MODULENAME;			//模块名称
	public String getFMODULENAME() {
		return MODULENAME;
	}
	public void setFMODULENAME(String MODULENAME) {
		this.MODULENAME = MODULENAME;
	}
	private String MODULETYPE;			//模块类型
	public String getFMODULETYPE() {
		return MODULETYPE;
	}
	public void setFMODULETYPE(String MODULETYPE) {
		this.MODULETYPE = MODULETYPE;
	}

	public String getWYBJ_ID() {
		return WYBJ_ID;
	}
	public void setWYBJ_ID(String WYBJ_ID) {
		this.WYBJ_ID = WYBJ_ID;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String NAME) {
		this.NAME = NAME;
	}
	public String getPARENT_ID() {
		return PARENT_ID;
	}
	public void setPARENT_ID(String PARENT_ID) {
		this.PARENT_ID = PARENT_ID;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public Wybj getWybj() {
		return wybj;
	}
	public void setWybj(Wybj wybj) {
		this.wybj = wybj;
	}
	public List<Wybj> getSubWybj() {
		return subWybj;
	}
	public void setSubWybj(List<Wybj> subWybj) {
		this.subWybj = subWybj;
	}
	public boolean isHasWybj() {
		return hasWybj;
	}
	public void setHasWybj(boolean hasWybj) {
		this.hasWybj = hasWybj;
	}
	public String getTreeurl() {
		return treeurl;
	}
	public void setTreeurl(String treeurl) {
		this.treeurl = treeurl;
	}
	
}
