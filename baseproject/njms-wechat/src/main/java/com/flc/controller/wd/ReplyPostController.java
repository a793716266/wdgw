package com.flc.controller.wd;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flc.controller.base.BaseController;
import com.flc.entity.PostReturn;
import com.flc.service.PostTypeService;
import com.flc.service.PostingService;
import com.flc.service.ReplyPostService;
import com.flc.util.WdUtil;

@Controller
@RequestMapping(value="/wd")
public class ReplyPostController extends BaseController{
	//回帖
	@Autowired
	 ReplyPostService replyservice;
	
	//帖子
	@Autowired
	 PostingService postingService;
	
	//配置文件获取获取路径
	@Value("${upload.requestPath}")
	private String requestPath;
	
	@Resource
	private PostTypeService postTypeService;
	
	/**
	 * 帖子分页
	 * @param postid
	 * @param pageNo
	 * @return
	 */
	@RequestMapping(value="toReplyPost.do")
	@ResponseBody
	public String toReplyPost(String postid,Integer pageNo){
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("postid", postid);
		map.put("pageStart", (pageNo-1)*10);
		map.put("pageEnd", 10);
		List<PostReturn> replys = replyservice.findPostreturnbottomFloor(map);
		
		for (int i = 0; i < replys.size(); i++) {
			map = new HashMap<String,Object>();
			map.put("postid", postid);
			map.put("commentfloor", replys.get(i).getCommentFloor());
			replys.get(i).setPostReturns(replyservice.findbottomPostreturns(map));
		}
		return WdUtil.convertToJson("replys", new Object[]{replys});
	}
	
	@RequestMapping(value="checkpostrep.do")
	@ResponseBody
	public String checkpostrep(){
		List<PostReturn> checkhostrep = replyservice.checkhostrep();
			for (PostReturn item : checkhostrep) {
				item.setPicture(requestPath+item.getPicture());
			}
		return WdUtil.convertToJson("checkhostrep", new Object[]{checkhostrep});
	}
	
	/**
	 * 添加帖子回复回复
	 * @param postReturn
	 * @return
	 */
	@RequestMapping(value="addReplyPost.do")
	@ResponseBody
	public String addReplyPost(PostReturn postReturn){
		
		postReturn.setPostReturn_id(this.get32UUID());
		postReturn.setCommentTime(new Date());
		postReturn.setCreatetime(new Date());
		
		int result = replyservice.addReply(postReturn);
		if(result ==1){
			//更新帖子类型回帖数
			postTypeService.updPostTypeReplycard(postReturn.getPostId());
			//更新帖子帖子数
			postingService.updatePostRestorenumber(postReturn.getPostId());
		}
		return WdUtil.convertToJson("result", new Object[]{result});

	}
	
}
