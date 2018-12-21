package com.flc.service;

import java.util.List;

import com.flc.entity.PostType;

public interface PostTypeService {
	/**
	 * 查询所有学习区域模块
	 * @return
	 */
	public List<PostType> findStudyAll();
	/**
	 * 查询生活区域模块
	 * @return
	 */
	public List<PostType> findLifeAll();
	
	/**
	 * 通过id查询类型
	 * @param typeid
	 * @return
	 */
	public PostType findById(String typeid);
 
	
	//查询活跃达人
	public List<PostType> findActiveman();
 
	
	/**
	 * 更新帖子类型的主题数 
	 * @param posttype_id
	 * @return
	 */
	int updPostTypeTheme(String posttype_id);
	
	/**
	 * 更新帖子类型的回帖数
	 * @param posttype_id
	 * @return
	 */
	int updPostTypeReplycard(String post_id);
 
}
