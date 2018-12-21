package com.flc.controller.wd;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flc.entity.Company;
import com.flc.service.CompanyService;
import com.flc.util.WdUtil;

@Controller
@RequestMapping(value="/wd")
public class CompanyController {
	@Resource
	private CompanyService companyService;
	
	@RequestMapping("/getAllCompany.do")
	@ResponseBody
	public String getAllCompany(){
		List<Company> getAllCompany=companyService.getAllCompany();
		return WdUtil.convertToJson("companylist",new Object[]{getAllCompany});
	}
}