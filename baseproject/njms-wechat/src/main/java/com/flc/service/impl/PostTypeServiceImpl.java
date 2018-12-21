package com.flc.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flc.dao.PostTypeDao;
import com.flc.entity.PostType;
import com.flc.service.PostTypeService;

@Service
@Transactional
public class PostTypeServiceImpl implements PostTypeService {
	@Resource
	private PostTypeDao postTypeDao;
	
	@Override
	public List<PostType> findStudyAll() {
		return postTypeDao.findStudyAll();
	}

	@Override
	public List<PostType> findLifeAll() {
		return postTypeDao.findLifeAll();
	}

	@Override
	public PostType findById(String typeid) {
	
		return postTypeDao.findById(typeid);
	}
	
	/**
	 * 更新帖子类型的主题数
	 */
	@Override
	public int updPostTypeTheme(String posttype_id) {
		
		return postTypeDao.updPostTypeTheme(posttype_id);
	}

 
	@Override
	public List<PostType> findActiveman() {
		return postTypeDao.findActiveman();
	}

 
	/**
	 * 更新帖子类型的回帖数
	 */
	@Override
	public int updPostTypeReplycard(String post_id) {
		
		return postTypeDao.updPostTypeReplycard(post_id);
	}
 
}
