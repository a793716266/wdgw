package com.flc.controller.wd;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flc.entity.Datadownload;
import com.flc.service.DatadownloadService;
import com.flc.util.WdUtil;

@Controller
@RequestMapping("/wd/")
public class DatadownloadController {
	@Resource
	public DatadownloadService datadownloadService;
	
	@RequestMapping(value="datadownloadByPage.do")
	@ResponseBody
	public String datadownloadByPage(Integer pageNo){
		Map<String, Object> mapDatadownload = new HashMap<String,Object>();
		mapDatadownload.put("pageFirst", (pageNo-1)*5);
		mapDatadownload.put("pageEnd", 5);
		List<Datadownload> findDatadownloadList = datadownloadService.findDatadownload(mapDatadownload);
		return WdUtil.convertToJson("findDatadownloadList", new Object[] {findDatadownloadList});
	}
}
