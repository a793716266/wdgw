package com.flc.controller.wd;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flc.controller.base.BaseController;
import com.flc.entity.Posts;
import com.flc.service.PostsService;
import com.flc.util.WdUtil;

@Controller
@RequestMapping(value="/wd/")
public class PostsController extends BaseController {
	@Resource
	private PostsService ps;
	
	/**
	 * 分页查询
	 * @param page
	 * @param request
	 * @return   
	 */
	@RequestMapping(value="/post")
	@ResponseBody	
	public String selAllPosts(String page,HttpServletRequest request,HttpSession session){
		//获取用户登陆的ID作为查询条件来查询登陆用户的回帖数量
		Object object = session.getAttribute("userph");
		//{'accountnumber':'18751631389','nickname':'林豪','password':'','phonenumber':'18751631389','picture':'a001c7592f454f168cfa4af4491c263a.jpg','wd_users_id':'5dce314996d2480c9b821b8987473ea1'}
		 
		String[] split = object.toString().split(":");
		String wd_userId = split[split.length-1].substring(1, 33);
		Integer defaultPageNo = 0;
		Integer defaultCount = 6;
		if(null != page && !"undefined".equalsIgnoreCase(page)){
			defaultPageNo = (Integer.parseInt(page)-1)*defaultCount;
		}
		List<Posts> findAllPosts = ps.findAllPosts(defaultPageNo,defaultCount,wd_userId);
		//查询总记录数
		Integer size = ps.findAllPosts(0,100000,wd_userId).size();
		if((size%defaultCount)>0){
			 size = (size/defaultCount)+1;
		}
		//记录计算出总页数
		Integer sumPage = size;
		return WdUtil.convertToJson("postsList,sumPage,findAllPostsSize",new Object[]{findAllPosts,sumPage,findAllPosts.size()});
	}
	
	
	/**
	 * 删除我的贴子
	 * @param post_id
	 * @return
	 */
	@RequestMapping(value="/del.do")
	@ResponseBody
	public String delPosts(String post_id){
		int result=0;
		String json=null;
		String msg=null;
		result= ps.delPosts(post_id);
		if(result==0){
			msg="删除失败";
			json="{\"msg\":\""+msg+"\"}";
		}else{
			msg="删除成功";
			json="{\"msg\":\""+msg+"\"}";
		}
	
		return json;
	}
}
