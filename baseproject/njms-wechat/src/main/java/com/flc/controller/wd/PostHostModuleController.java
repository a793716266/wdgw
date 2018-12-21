package com.flc.controller.wd;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flc.controller.base.BaseController;

import com.flc.entity.PostHostModule;

import com.flc.service.PostHostModuleService;
import com.flc.util.WdUtil;

@Controller
@RequestMapping(value="/wd/")
public class PostHostModuleController  extends BaseController{
	//配置文件获取获取路径
		@Value("${upload.requestPath}")
		private String requestPath;
		@Resource
		public PostHostModuleService pms;	
		 
		@RequestMapping(value="checkposthost.do")
		@ResponseBody
		public String checkposthost(){
			List<PostHostModule> checkposthost = pms.checkposthost();
			for (PostHostModule item : checkposthost) {
				item.setPicsrc(requestPath+item.getPicsrc());
			}
			List<PostHostModule> hottopic = pms.hottopic();//热门话题
			for (PostHostModule item : hottopic) {
				item.setPicsrc(requestPath+item.getPicsrc());
			}
		
			return WdUtil.convertToJson("checkposthost,hottopic", new Object[] {checkposthost,hottopic});
		}
}

