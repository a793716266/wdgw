package com.flc.dao;

import java.util.List;

import com.flc.entity.Project;

public interface ProjectDao {
	/**
	 * 查询前15个项目，每个类型5个
	 * @param param 课程名称集合
	 * @return
	 */
	List<Project> getTop15(List<String> param);
}
