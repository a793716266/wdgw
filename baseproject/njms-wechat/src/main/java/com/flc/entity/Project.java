package com.flc.entity;

import java.io.Serializable;

/**
 * 展示的项目
 * @author Jason
 *
 */
public class Project implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2992901771972715480L;
	private String project_id;   //编号
	private String projectName;  //项目名称
	private String projectPic;   //项目图片路径
	private String course;       //项目课程名称
	public String getProject_id() {
		return project_id;
	}
	public void setProject_id(String project_id) {
		this.project_id = project_id;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectPic() {
		return projectPic;
	}
	public void setProjectPic(String projectPic) {
		this.projectPic = projectPic;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	@Override
	public String toString() {
		return "Wdgw_Project [project_id=" + project_id + ", projectName=" + projectName + ", projectPic=" + projectPic
				+ ", course=" + course + "]";
	}
}
