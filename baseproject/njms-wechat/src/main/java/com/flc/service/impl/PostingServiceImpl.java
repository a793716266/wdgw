package com.flc.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flc.dao.PostingDao;
import com.flc.entity.Posting;
import com.flc.service.PostingService;
@Service
@Transactional
public class PostingServiceImpl implements PostingService {
	@Resource
	private PostingDao postingDao;
	/**
	 * 查询热门话题页面
	 */
	@Override
	public List<Posting> postList() {
		return postingDao.postList();
	}

	@Override
	public List<Posting> list(Map<String, Object> condition) {
		return postingDao.list(condition);
	}

	@Override
	public int delete(Map<String, Object> condition) {
		return postingDao.delete(condition);
	}

	@Override
	public int update(Posting posting) {
		return postingDao.update(posting);
	}

	@Override
	public int insert(Posting posting) {
		return postingDao.insert(posting);
	}

	@Override
	public int findCount(Map<String, Object> condition) {
		return postingDao.findCount(condition);
	}

	@Override
	public List<Posting> postList(String pid) {
		// TODO Auto-generated method stub
		return postingDao.postList(pid);
	}
	
	/**
	 * 根据帖子类型id查询对应的所有帖子
	 * @return
	 */
	public List<Posting> findPostingList(Map<String, Object> mapCondition){
		
		return postingDao.findPostingList(mapCondition);
	}
	
	/**
	 * 更新帖子浏览次数和帖子热度
	 * @param map
	 * @return
	 */
	public int updatePostH_R(Map<String, Object> map){
		
		return postingDao.updatePostH_R(map);
	}
	
	/**
	 * 更新帖子回帖数
	 * @param post_id
	 * @return
	 */
	public int updatePostRestorenumber(String post_id){
		return postingDao.updatePostRestorenumber(post_id);
	}
	
	/**
	 * 根据帖子id查询发帖信息
	 * @param postid
	 * @return
	 */
	public Posting findFloorInfo(String post_id){
		return postingDao.findFloorInfo(post_id);
	}
	
}
