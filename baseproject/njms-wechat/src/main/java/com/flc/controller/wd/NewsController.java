package com.flc.controller.wd;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.flc.controller.base.BaseController;
import com.flc.entity.News;
import com.flc.service.NewsService;
import com.flc.util.WdUtil;

@Controller
@RequestMapping(value = "/wd/")
public class NewsController extends BaseController {

	@Resource
	private NewsService newsService;
	//配置文件获取获取路径
	@Value("upload.requestPath")
	private String requestPath;
	/*
	 * 首页刷新闻数据
	 */
	@RequestMapping(value = "mainShowNews.do")
	@ResponseBody
	public String mainShowNews() {
		List<News> javaFirstNews = newsService.selectJavaFirst();
		List<News> javaListNews = newsService.selectJavaList();
		List<News> cFirstNews = newsService.selectCFirst();
		List<News> cListNews = newsService.selectCList();
		Object[] lists = { javaFirstNews, javaListNews, cFirstNews, cListNews };
		return WdUtil.convertToJson("javaFirstNews,javaListNews,cFirstNews,cListNews", lists);
	}

	/**
	 * 根据新闻类查询数据
	 * 
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "newsAll.do")
	@ResponseBody
	public String newsAll(HttpServletRequest request) {
		String newsType = (String) request.getSession().getAttribute("newsType");
		List<News> newsList = newsService.newsAll(newsType);
		Object[] lists = {newsList};
		return WdUtil.convertToJson("newslist", lists);
	}

	/**
	 * go新闻详情页面
	 */
	@RequestMapping(value = "gotoNewsDetail.do")
	public ModelAndView gotoNewsDetail(HttpServletRequest request) {
		ModelAndView mv = this.getModelAndView();
		if (updateClick(request)) {
			String newsid = request.getParameter("newsid");
			News newsInformation = newsService.getNewsInformation(newsid);
			request.getSession().setAttribute("newsTypeWhat", newsInformation.getNewsType());
			mv.addObject("newsType",newsInformation.getNewsType());
			mv.addObject("newsInformation", newsInformation);
			mv.addObject("newsid", newsid);
			mv.addObject("requestPath",requestPath);
			mv.setViewName("newsInformationContent");
		}
		return mv;
	}
	/**
	 * 点击量
	 * @param request
	 * @return
	 */
	public Boolean updateClick(HttpServletRequest request) {
		String newsid = request.getParameter("newsid");
		if (newsService.updateClick(newsid)>0) {
			return true;
		}
		return false;
	}

	/**
	 * 推荐新闻
	 * 
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value="allNewsDesc.do")
	@ResponseBody
	public String allNewsDesc(HttpServletRequest request) {
		Map<String, Object> maps = new HashMap<String, Object>();
		maps.put("newsType", request.getSession().getAttribute("newsTypeWhat"));
		maps.put("newsStart", 0);
		maps.put("newsEnd", 5);
		List<News> allNewsDesc = newsService.getNewsByType(maps);
		return WdUtil.convertToJson("allNewsDesclist,requestPath", new Object[] { allNewsDesc,requestPath});
	}
}
