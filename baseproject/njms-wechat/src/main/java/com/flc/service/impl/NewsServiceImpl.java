package com.flc.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flc.dao.NewsDao;
import com.flc.entity.News;
import com.flc.service.NewsService;

@Service
@Transactional
public class NewsServiceImpl implements NewsService{

	@Resource
	private NewsDao dao;
	
	@Override
	public List<News> selectJavaFirst() {
		return dao.selectJavaFirst();
	}

	@Override
	public List<News> selectJavaList() {
		return dao.selectJavaList();
	}

	@Override
	public List<News> selectCFirst() {
		return dao.selectCFirst();
	}

	@Override
	public List<News> selectCList() {
		return dao.selectCList();
	}

	@Override
	public List<News> newsAll(String newsType) {
		return dao.newsAll(newsType);
	}

	@Override
	public News getNewsInformation(String newsId) {
		return dao.newsInformation(newsId);
	}

	@Override
	public List<News> getNewsByType(Map<String, Object> maps) {
		return dao.recommendedNews(maps);
	}


	@Override
	public List<News> newsindexAll(String newsType) {
		// TODO Auto-generated method stub
		return dao.newsindexAll(newsType);
	}
	


	@Override
	public int updateClick(String newsId){
		return dao.updateClick(newsId);
	}

}
