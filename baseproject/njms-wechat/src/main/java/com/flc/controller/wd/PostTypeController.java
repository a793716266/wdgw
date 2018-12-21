package com.flc.controller.wd;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flc.entity.PostType;
import com.flc.service.PostTypeService;
import com.flc.util.WdUtil;

@Controller
@RequestMapping(value="/wd/")
public class PostTypeController {
	@Resource
	private PostTypeService postTypeService;
	
	@Value("${upload.requestPath}")
	private String requestPath;
	/**
	 * 显示学习模块
	 * @return
	 */
	@RequestMapping(value="postStudyList.do")
	@ResponseBody
	public String postShowStudy(){
		List<PostType> studyAll = postTypeService.findStudyAll();
		return WdUtil.convertToJson("postTypeStudyList", new Object[]{studyAll});
	}
	
	/**
	 * 显示生活模块
	 * @return
	 */
	@RequestMapping(value="postLifeList.do")
	@ResponseBody
	public String postShowLife(){
		List<PostType> lifeAll = postTypeService.findLifeAll();
		return WdUtil.convertToJson("postTypeLifeList", new Object[]{lifeAll});
	}
	
	/**
	 * 查询活跃达人
	 * @return
	 */
	@RequestMapping(value="postActiveman.do")
	@ResponseBody
	public String Activeman(){
		List<PostType> Activeman = postTypeService.findActiveman();
		int count=1;
		for (PostType item : Activeman) {
			String pic=item.getUserpicture();
			
			//Integer cnt=item.getCount();
			item.setCount(count);
			count++;
			item.setUserpicture(requestPath+pic);
			
		}
		return WdUtil.convertToJson("Activeman", new Object[]{Activeman});
	}
}
