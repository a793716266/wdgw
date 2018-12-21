package com.flc.controller.wd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flc.controller.base.BaseController;
import com.flc.entity.Goodstudents;
import com.flc.entity.Studentinfo;
import com.flc.service.GoodstudentsService;
import com.flc.service.StudentinfoService;
import com.flc.util.WdUtil;
@Controller
@RequestMapping(value="/wd/")
public class StudentController extends BaseController{
	@Resource
	private GoodstudentsService goodstudentsService;
	
	@Resource
	private StudentinfoService studentinfoService;
	
	//请求优秀学员列表信息
		@RequestMapping(value="reqStuList.do")
		@ResponseBody
		public String reqStuList(){
			List<String> type =  new ArrayList<>();
			type.add("JAVA");
			type.add("WEB");
			type.add("UI");
			List<Goodstudents> list = goodstudentsService.findTop4(type);//查询出每个课程的前4条课程信息
			List<Goodstudents> goodjavaListto = new ArrayList<>();
			List<Goodstudents> goodwebListto =  new ArrayList<>();
			List<Goodstudents> gooduiListto = new ArrayList<>();
			//根据课程名称分别存入不同的集合
			for (Goodstudents l : list) {
				if (l.getC_type().equals(type.get(0))) {
					goodjavaListto.add(l);
				}else if (l.getC_type().equals(type.get(1))) {
					goodwebListto.add(l);
				}else if (l.getC_type().equals(type.get(2))) {
					gooduiListto.add(l);
				}
			}
			return WdUtil.convertToJson("gooduiListto,goodjavaListto,goodwebListto", new Object[] {gooduiListto,goodjavaListto,goodwebListto});
		}
		
		//请求优秀学员列表信息
		@RequestMapping(value="findGoodStudent.do")
		@ResponseBody
		public String findGoodStudent() {
			List<Goodstudents> stulist = goodstudentsService.findTop5();
			for (Goodstudents wdgw_goodstudents : stulist) {
				String url = wdgw_goodstudents.getVideoName();
				wdgw_goodstudents.setVideoName(WdUtil.getVideoUrl(url));
			}
			return WdUtil.convertToJson("stulist", new Object[] {stulist});
		}
		
		//请求近期就业学员列表信息
		@RequestMapping(value="findJobStudent.do")
		@ResponseBody
		public String findJobStudent(Integer pageNo) {
			Map<String, Object> map = new HashMap<String,Object>();
			map.put("pageFirst", (pageNo-1)*8);
			map.put("pageEnd", 8);
			
			List<Studentinfo> stulist = studentinfoService.findJobStudent(map);
			
			return WdUtil.convertToJson("findJobStudent", new Object[] {stulist});
		}
}
