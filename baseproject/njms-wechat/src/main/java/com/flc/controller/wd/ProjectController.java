package com.flc.controller.wd;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flc.controller.base.BaseController;
import com.flc.entity.Project;
import com.flc.service.ProjectService;
import com.flc.util.WdUtil;

@Controller
@RequestMapping(value = "/wd/")
public class ProjectController extends BaseController  {
	@Resource
	private ProjectService projectService;
	
	
	@RequestMapping(value = "getProjectList.do")
	@ResponseBody
	public String getProjectList() {
		List<String> params = new ArrayList<>();	
		//设置参数
		params.add("ui");
		params.add("java");
		params.add("web");
		//获取所有元素
		List<Project> list = projectService.getTop15(params);
		//创建三个集合分组
		List<Project> uiprojectlist = new ArrayList<>();
		List<Project> javaprojectlist = new ArrayList<>();
		List<Project> webprojectlist = new ArrayList<>();
		for (Project wdgw_Project : list) {
			if("ui".equals(wdgw_Project.getCourse().toLowerCase())) 
				uiprojectlist.add(wdgw_Project);
			else if("java".equals(wdgw_Project.getCourse().toLowerCase()))
				javaprojectlist.add(wdgw_Project);
			else if("web".equals(wdgw_Project.getCourse().toLowerCase()))
				webprojectlist.add(wdgw_Project);
		}
		return WdUtil.convertToJson("uiprojectlist,javaprojectlist,webprojectlist", new Object[] {uiprojectlist,javaprojectlist,webprojectlist});
	}
}
