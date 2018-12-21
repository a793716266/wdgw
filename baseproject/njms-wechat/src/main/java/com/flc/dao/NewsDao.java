package com.flc.dao;

import java.util.List;
import java.util.Map;

import com.flc.entity.News;
public interface NewsDao {
	/*
	 * 主页JAVA新闻数据详情显示
	 */
	public List<News> selectJavaFirst();
	
	/*
	 * 主页JAVA新闻数据简介列表部分
	 */
	public List<News> selectJavaList();
	
	/*
	 * 主页C#新闻数据详情显示
	 */
	public List<News> selectCFirst();
	
	/*
	 * 主页C#新闻数据简介列表部分
	 */
	public List<News> selectCList();
	
	/**
	 * 根据新闻类型查询信息
	 */
	
	public List<News> newsAll(String newsType);
	public List<News> newsindexAll(String newsType);
	
	public News newsInformation(String newsId);
	
	public List<News> recommendedNews(Map<String, Object> maps);
	
	public int updateClick(String newsId);
}
