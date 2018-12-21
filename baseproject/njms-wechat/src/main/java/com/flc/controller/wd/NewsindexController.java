package com.flc.controller.wd;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flc.controller.base.BaseController;
import com.flc.entity.News;
import com.flc.service.NewsService;
import com.flc.util.WdUtil;
@Controller
@RequestMapping(value="/wd/")
public class NewsindexController extends BaseController {

	@Resource
	private NewsService newsService;
	

	/**
	 * 根据新闻类查询数据
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value="/newsindexAll.do")
	@ResponseBody
	public String newsAll(HttpServletRequest request){

		List<News> newsListh = newsService.newsindexAll("行业动态");
		List<News> newsListx = newsService.newsindexAll("校区新闻");

		return WdUtil.convertToJson("newsListh,newsListx", new Object[] {newsListh,newsListx});
	}
}
