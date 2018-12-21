package com.flc.controller.wd;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flc.controller.base.BaseController;
import com.flc.entity.Comment;
import com.flc.service.CommentService;
import com.flc.util.WdUtil;

@Controller
@RequestMapping(value="/wd/")
public class CommentController  extends BaseController{
		@Resource
		public CommentService wdgw_commentService;	
		/**
		 * 查询ui,java,web课程类型优秀学员的 top 3
		 * @param type
		 * @return
		 */
		@RequestMapping(value="findComment.do")
		@ResponseBody
		public String findComment(){
			List<Comment> commentuiList = wdgw_commentService.findTop3("UI");//UI优秀学员信息集合
			List<Comment> commentjavaList = wdgw_commentService.findTop3("JAVA");//JAVA优秀学员信息集合
			List<Comment> commentwebList = wdgw_commentService.findTop3("WEB");//WEB优秀学员信息集合
			return WdUtil.convertToJson("commentuiList,commentjavaList,commentwebList", new Object[] {commentuiList,commentjavaList,commentwebList});
		}
}

