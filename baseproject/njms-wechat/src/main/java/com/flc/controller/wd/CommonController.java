package com.flc.controller.wd;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.JSONObject;
import com.flc.controller.base.BaseController;
import com.flc.entity.PostReturn;
import com.flc.entity.PostType;
import com.flc.entity.Posting;
import com.flc.entity.VideoAndUser;
import com.flc.service.DatadownloadService;
import com.flc.service.MySubjectService;
import com.flc.service.PostTypeService;



import com.flc.util.WdUtil;
import com.flc.service.ReplyPostService;
import com.flc.service.PostingService;
import com.flc.service.StudentinfoService;
import com.flc.service.VideoService;

@Controller
@RequestMapping(value="/wd/")
public class CommonController extends BaseController {
	@Resource  
	PostTypeService posttypeService;		//帖子类型
	@Resource
	 ReplyPostService replyservice;
	@Resource
	PostingService postingService;			//帖子详情
	@Resource
	DatadownloadService datadownloadService;//网盘下载
	@Resource
	StudentinfoService studentinfoService;	//近期就业学员
	@Resource
	VideoService videoService;				//视频
	@Resource
	MySubjectService mySubjectService;		//添加我的课程
	@Resource
	ReplyPostService replyPostService;		//帖子回复
	
	
	//配置文件获取获取路径
	@Value("${upload.requestPath}")
	private String requestPath;
	

	
	@RequestMapping(value="toIndex.do")
	public ModelAndView toIndex(HttpServletRequest req){
		ModelAndView mv = this.getModelAndView();
		if(req.getParameter("newsInfoMation")!=null && req.getParameter("newsInfoMation")!=""){
			mv.addObject("newsInfoMation","miao");
		}	
		mv.addObject("requestPath",requestPath);
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping(value="toFreecourse.do")
	public ModelAndView toFreecourse(){
		ModelAndView mv = this.getModelAndView();
		mv.setViewName("freecourse");
		mv.addObject("requestPath",requestPath);
		return mv;
	}
	
	@RequestMapping(value="toTeacher.do")
	public ModelAndView toTeacher(){
		ModelAndView mv = this.getModelAndView();
		mv.setViewName("teacher");
		mv.addObject("requestPath",requestPath);
		return mv;
	}
	
	@RequestMapping(value="toStudent.do")
	public ModelAndView toStudent(){
		ModelAndView mv = this.getModelAndView();
		mv.setViewName("student");
		mv.addObject("requestPath",requestPath);
		return mv;
	}
	
	@RequestMapping(value="toProcessPage.do")
	public ModelAndView toProcessPage(){
		ModelAndView mv = this.getModelAndView();
		mv.setViewName("processPage");
		mv.addObject("requestPath",requestPath);
		return mv;
	}

	@RequestMapping(value="toVideo.do")
	public ModelAndView toVideo(HttpServletRequest req){
		ModelAndView mv = this.getModelAndView();
		String videoId = req.getParameter("id");
		//调用添加个人课程视频
		insert(videoId);
		String vtype = req.getParameter("vtype");
		String videoUrl = WdUtil.getVideoUrl(videoId);  //获取视频实际路径
		mv.addObject("videoUrl", videoUrl);   //将视频地址传到前台
		mv.addObject("vtype", vtype);   //将视频地址传到前台
		mv.setViewName("video");
		mv.addObject("requestPath",requestPath);
		return mv;
	}
	
	//添加个人课程视频
	public void insert(String videoId){
		String name = (String) this.getRequest().getSession().getAttribute("userph");
		if(null != name){
			JSONObject data = JSONObject.parseObject(name);
			String uSER_ID = data.getString("wd_users_id");
			String video_id = videoService.findToId(videoId);
			VideoAndUser videoAndUser = new VideoAndUser();
			videoAndUser.setRELATION_ID(this.get32UUID());
			videoAndUser.setUSER_ID(uSER_ID);
			videoAndUser.setVIDEO_ID(video_id);
			videoAndUser.setCREATETIME(new Date());
			mySubjectService.insertVideo(videoAndUser);
		}
		
		
	}
	
	/**
	 * 登录页面
	 * @param session
	 * @param request
	 * @return
	 */
	@RequestMapping(value="toLogin.do")
	public ModelAndView toLogin(HttpSession session,HttpServletRequest request){
		ModelAndView mv = this.getModelAndView();
		
		if(session.getAttribute("loginUser") == null)
			mv.setViewName("login");
		else
			mv.setViewName("userinfo");
		
		mv.addObject("requestPath",requestPath);
		return mv;
	}
	
	/**
	 * 注册页面
	 * @return
	 */
	@RequestMapping(value="toRegister.do")
	public ModelAndView toRegister(){
		ModelAndView mv = this.getModelAndView();
		mv.setViewName("register");
		mv.addObject("requestPath",requestPath);
		return mv;
	}
	
	/**
	 *去Java新闻页面
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value="javaNews.do")
	public ModelAndView javaNews(HttpServletRequest request) throws UnsupportedEncodingException{
		String newsType = java.net.URLDecoder.decode(request.getParameter("newsText"), "utf-8");
		ModelAndView mv = this.getModelAndView();
		mv.addObject("newsType",newsType);
		request.getSession().setAttribute("newsType", newsType);
		mv.addObject("index","首页");
		mv.addObject("news","新闻资讯");
		mv.addObject("newsType",newsType);
		mv.addObject("requestPath",requestPath);
		mv.setViewName("news");
		
		return mv;
	}
	/**
	 * 从帖子类型跳转到该帖子类型下的所有帖子
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "luntanbytype.do")
	public ModelAndView luntanbytype(HttpServletRequest req) {
		//查询帖子类型详情
		String typeid = req.getParameter("typeid");
		
		PostType pt = posttypeService.findById(typeid);
		//按帖子类型查询所有帖子详情内容
		Map<String, Object> mapCondition = new HashMap<String,Object>();
		mapCondition.put("posttypeid", typeid);
		//按帖子类型查询所有帖子总数
		int count = postingService.findCount(mapCondition);
		//按帖子类型查询所有帖子总数进行分页（默认10条一页）
		int totalPage = count%10==0?count/10:(count/10)+1;

		ModelAndView mv = this.getModelAndView();
		mv.addObject("luntanType",pt);
		//帖子总页数
		mv.addObject("countAndtotalPage", count+"&"+totalPage);
		//网盘总页数
		mv.addObject("totalPageDatadownload", datadownloadService.countDatadownload());
		//网盘总页数
		mv.addObject("totalJobStudent", studentinfoService.countJobStudent());
		
		mv.setViewName("luntanbytype");
		mv.addObject("requestPath",requestPath);
		return mv;
	}
	
	/*技术论坛跳转*/
	@RequestMapping(value = "forum.do")
	public ModelAndView forum() {
		ModelAndView mv = this.getModelAndView();
		mv.setViewName("forum");
		mv.addObject("requestPath",requestPath);
		return mv;
	}
	
	/*帖子详情跳转*/
	@RequestMapping(value="toNode.do")
	public ModelAndView toNode(String post_id){
		ModelAndView mv = this.getModelAndView();
		Integer pageCount = replyPostService.countReply(post_id);
		Posting posting = postingService.findFloorInfo(post_id);
		List<PostReturn> postReturns = replyPostService.findPostreturnFloor(post_id);
		int countPostReturns = replyPostService.findFloorPostreturns(post_id);
		mv.addObject("pid",post_id);
		mv.addObject("posting",posting);
		mv.addObject("userid", posting.getUserid()); 
		//父帖子数量（添加帖子楼层用）
		mv.addObject("countReply",pageCount+1);
		//父帖子的数量（分页记录数用）
		mv.addObject("countReplys",pageCount);
		mv.addObject("postReturns",postReturns);
		mv.addObject("countPostReturns",countPostReturns);
		mv.addObject("requestPath",requestPath);
		mv.setViewName("node");
		return mv;
	}
	

	/**
	 * 跳转到个人中心
	 * @param binder 
	 * */
	@RequestMapping(value="/toPerson.do")
	public ModelAndView toPersonal(HttpServletRequest request){
		String towhere=request.getParameter("towhere");
		ModelAndView mv = this.getModelAndView();
		mv.addObject("towhere", towhere);
		mv.setViewName("Personal");
		return mv;
	}
	
	/**
	 * 跳转到修改头像页面
	 */
	@RequestMapping(value="/toUpdPicture.do")
	public ModelAndView toUpdPicture(HttpServletRequest request){
		ModelAndView mv = this.getModelAndView();
		mv.setViewName("updPicture");
		return mv;
	}
	

}
