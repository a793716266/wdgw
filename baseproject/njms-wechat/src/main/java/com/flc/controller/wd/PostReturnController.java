package com.flc.controller.wd;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flc.controller.base.BaseController;
import com.flc.entity.PostReturnByMe;
import com.flc.service.PostReturnService;
import com.flc.util.WdUtil;

@Controller
@RequestMapping(value="/wd/")
public class PostReturnController extends BaseController {
	@Resource
	private PostReturnService prs;
	
	
	/**
	 * 分页查询
	 * @param page
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/postReturn")
	@ResponseBody
	public String selAllPostRetrun(String page,HttpServletRequest request,HttpSession session){
		//获取用户登陆的ID作为查询条件来查询登陆用户的回帖数量
		Object object = session.getAttribute("userph");
		String[] split = object.toString().split(":");
		String wd_userId = split[split.length-1].substring(1, 33);
		Integer defaultPageNo = 0;
		Integer defaultCount = 5;
		if(null != page){
			defaultPageNo = (Integer.parseInt(page)-1)*defaultCount;
		}
		List<PostReturnByMe> findAllReturn = prs.findAllReturn(defaultPageNo, defaultCount, wd_userId);
		//查询总记录数
		Integer size = prs.findAllReturn(0, 100000, wd_userId).size();
		if((size%defaultCount)>=0){
			 size = (size/defaultCount)+1;
		}
		//记录计算出总页数
		Integer sumPage = size;
		return WdUtil.convertToJson("postReturnList,sumPage,findAllReturnSize",new Object[]{findAllReturn,sumPage,findAllReturn.size()});
	}

	
	/**
	 * 删除我的回复
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/postReturnDel.do")
	@ResponseBody
	public String delPostReturn(String id){
		int result = 0;
		String json = null;
		String msg=null;
		result= prs.delPosts(id);
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
