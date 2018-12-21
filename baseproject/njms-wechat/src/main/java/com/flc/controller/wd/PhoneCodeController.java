package com.flc.controller.wd;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flc.controller.base.BaseController;
import com.flc.entity.PhoneCode;
import com.flc.entity.User;
import com.flc.service.PhoneCodeService;
import com.flc.service.UserService;
import com.flc.util.PageData;
@Controller
@RequestMapping("/wd/")
public class PhoneCodeController extends BaseController {
	@Resource
	private PhoneCodeService phoneCodeService;
	@Resource
	private UserService wdgw_userService;
	
	@RequestMapping("sendCode.do")
	@ResponseBody
	public int sendCode(String phone_number) {
		PhoneCode phoneCode = new PhoneCode();
		phoneCode.setPhone_number(phone_number);
		int result = phoneCodeService.sendCode(phoneCode);
		return result;
	}
	
	@RequestMapping("isRegister.do")
	@ResponseBody
	public int isRegister(String phone_number) {
		int result = 0;
		User user =  wdgw_userService.finduser(phone_number);
		// 不存在
		if (user != null) {
			result  = -1;
		}
		return result;
	} 	
	
	@RequestMapping("codeVerification.do")
	@ResponseBody
	public String codeVerification(String phone_number) {
		PhoneCode wdgw_phonecode = new PhoneCode();
		wdgw_phonecode.setPhone_number(phone_number);
		PhoneCode phoneCode = phoneCodeService.select(wdgw_phonecode);
		if(phoneCode == null){
			return null;  //不存在于数据库，请选获取验证码
		}
		Long mesc = phoneCode.getCreatetime().getTime();
		Long dvalue = new Date().getTime() - mesc;
		if (dvalue > 300000){
			//验证码失效 并删除记录
			phoneCodeService.delete(phone_number);
			return "-1";
		}
		String code = phoneCode.getPhone_code();
		return code;   //返回验证码
	} 	
	@RequestMapping("registeruser.do")
	public String register() {
		PageData pd = this.getPageData();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String createtime =sdf.format(new Date());
		pd.put("CREATETIME", createtime); //创建时间
		String NICKNAME = "学员"+(int) (Math.random() * 900000);
		pd.put("NICKNAME", NICKNAME); //默认用户昵称
		String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
		pd.put("WD_USERS_ID", uuid);
		phoneCodeService.delete(pd.getString("phonenumber")); //删除手机验证码记录
		@SuppressWarnings("unchecked")
		int count = wdgw_userService.adduser(pd); //注册
		if(count > 0){
			return "forward:/wd/userList.do"; 
		}
		return "toRegister";   
	} 
}
