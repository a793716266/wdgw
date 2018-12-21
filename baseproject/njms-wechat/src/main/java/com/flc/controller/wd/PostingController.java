package com.flc.controller.wd;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aliyuncs.http.HttpRequest;
import com.flc.controller.base.BaseController;
import com.flc.controller.upload.RemoveController;
import com.flc.entity.Posting;
import com.flc.service.PostTypeService;
import com.flc.service.PostingService;
import com.flc.util.WdUtil;

@Controller
@RequestMapping(value="/wd/")
public class PostingController extends BaseController{
	@Resource
	private PostingService postingService;
	
 
	
	@Value("${upload.requestPath}")
	private String requestPath;
	
	
 
	@Resource
	private PostTypeService postTypeService;
	/**
	 * 查询热门帖子
	 * @return
	 */
 
	@RequestMapping(value="postHotList.do")
	@ResponseBody
	public String postHotShow(){
		List<Posting> postList = postingService.postList();
		return WdUtil.convertToJson("postHotList", new Object[]{postList});
	}
	
	/**
	 * 根据帖子的id查询出相应的帖子的具体内容
	 * @param pid
	 * @return
	 */
	@RequestMapping(value="postHotListByid.do")
	@ResponseBody
	public String postListID(String pid){
		
		List<Posting> postList = postingService.postList(pid);
		return WdUtil.convertToJson("postingByIdList", new Object[]{postList});
	}
 
 
	
	/**
	 * 帖子分页
	 * @param posttypeid 帖子类型id
	 * @param pageNo 页数
	 * @return
	 */
	@RequestMapping(value="postListByPageNo.do")
	@ResponseBody
	public String postListByPageNo(String posttypeid,Integer pageNo){
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("posttypeid", posttypeid);
		map.put("pageFirst", (pageNo-1)*10);
		map.put("pageEnd", 10);
		List<Posting> postList = postingService.findPostingList(map);
		
		
		return WdUtil.convertToJson("postingByIdList",new Object[]{postList} );
	}
 
		
	/**
	 * 添加帖子
	 * @param userSession
	 * @param posting
	 * @param req
	 * @return
	 */
	@RequestMapping(value="addPost.do")
	@ResponseBody
	public String addPost(HttpSession userSession,Posting posting,HttpRequest req){
		posting.setReleaseCVersion("电脑板");
		posting.setPost_id(this.get32UUID());
		int result = postingService.insert(posting);
		//添加帖子成功后更新帖子类型回贴数
		if(result==1){
			postTypeService.updPostTypeTheme(posting.getPostType_id());
		}
		
//		Object object = userSession.getAttribute("userph");
//		System.out.println(object.toString());
//		String[] split = object.toString().split(":");
//		String wd_userId = split[split.length-1].substring(1, 33);
//		System.out.println(wd_userId);
		//更新帖子类型的主题数(type==1:表示发帖)
		
		return WdUtil.convertToJson("addPostResult",new Object[]{result} );
	}
	
	
	/**
	 * 删除上传图片
	 * @param request
	 * @return
	 */
	@RequestMapping(value="removeImg.do")
	@ResponseBody
	public String addPost(HttpServletRequest request){
		
		String img = (String) request.getSession().getAttribute("imageName");
		String result = "0";
		if(RemoveController.deleteOne(request,img)){
			result="1";
		}
		return WdUtil.convertToJson("result",new Object[]{result} );
	}
	
	/**
	 * 更新帖子热度和浏览次数
	 * @param post_id
	 * @param userid
	 * @param heat
	 * @return
	 */
	@RequestMapping(value="updatePost.do")
	public String updatePost(String post_id){
		
		//更新帖子热度和浏览次数
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("post_id", post_id);
		int result = postingService.updatePostH_R(map);
		if(result==0){
			return "";
		}
		return "redirect:toNode.do?post_id="+post_id;
	} 
	
	
	
}
