package com.flc.controller.wd;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.flc.controller.base.BaseController;
import com.flc.entity.User;
import com.flc.service.UserService;

import net.sf.json.JSONObject;
@Controller
@RequestMapping(value="/wd/")
public class UserController extends BaseController{
	@Resource
	private UserService wdgw_userService;
	
	@Value("${upload.requestPath}")
	private String requestPath;
	
	private String json;
	//登录
	@RequestMapping(value="userList.do")
	public String userList(HttpSession session, User user,HttpServletRequest request){
		String userphone = user.getPhonenumber();
		String userPwd  = user.getPassword();
		String is =(String) session.getAttribute("is");
		if("error".equals(is)){
			session.removeAttribute("is");
			return "redirect:/wd/toLogin.do";
		}
         //获取用户
		User userph =  wdgw_userService.finduser(userphone);
		String userphPwd = null;
		if(userph != null){
			userphPwd = userph.getPassword();
			userph.setPassword("");
			String picture=requestPath+userph.getPicture();
			userph.setPicture(picture);
			session.setAttribute("userph",JSON.toJSONString(userph).replace('\"', '\''));
			String nickname=userph.getNickname();
			session.setAttribute("wd_users_id", userph.getWd_users_id());
			session.setAttribute("userNickName",nickname);
			session.setAttribute("userphone", userph.getPhonenumber());
			session.setAttribute("picture",picture);
		}
		
		if(userph==null || !userPwd.equals(userphPwd)){
			session.setAttribute("is", "error");
			return "forward:/wd/toLogin.do";
		}else{
			//将用户名放入Session
			session.removeAttribute("is");
			return "redirect:/wd/toIndex.do";
		}
	}
	
	
	/**
	 * 个人中心修改昵称
	 * @param session
	 * @param nickName
	 * @return
	 */
	@RequestMapping(value="updateNickName.do")
	public String updateNickName(HttpSession session,User user){
		String nickname="";
		try {
			nickname = URLDecoder.decode(user.getNickname(),"UTF-8");
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String userphone = "";
		String name = (String) this.getRequest().getSession().getAttribute("userph");
		if(null != name){
			JSONObject data = JSONObject.fromObject(name); 
			String id = data.getString("wd_users_id");
			userphone = data.getString("phonenumber");
			user.setWd_users_id(id);
			user.setNickname(nickname);
			int result = wdgw_userService.update(user);
		}

		String is =(String) session.getAttribute("is");
		//账号或密码错误，跳回登录
		if("error".equals(is)){
			session.removeAttribute("is");
			return "redirect:/wd/toLogin.do";
		}
		//获取用户
		User userph =  wdgw_userService.finduser(userphone);

		String userphPwd = null;
		if(userph != null){
			userphPwd = userph.getPassword();
			userph.setPassword("");
			String picture=requestPath+userph.getPicture();
			userph.setPicture(picture);
			json = JSON.toJSONString(userph).replace('\"', '\'');
			session.setAttribute("userph",json);
			
			session.setAttribute("userNickName",nickname);
			session.setAttribute("picture",picture);

		}

		if(userph==null ){
			session.setAttribute("is", "error");
			return "forward:/wd/toLogin.do";
		}else{
			//将用户名放入Session
			session.removeAttribute("is");
			return "redirect:/wd/toUpdPicture.do";
		}
		
	}
	
	@RequestMapping("picture.do")
	public String redirect(HttpSession session,String userphone){
		User userph =  wdgw_userService.finduser(userphone);

		String userphPwd = null;
		if(userph != null){
			userphPwd = userph.getPassword();
			userph.setPassword("");
			String picture=requestPath+userph.getPicture();
			userph.setPicture(picture);
			json = JSON.toJSONString(userph).replace('\"', '\'');
			session.setAttribute("userph",json);
			session.setAttribute("picture",picture);
		}

		if(userph==null ){
			session.setAttribute("is", "error");
			return "forward:/wd/toLogin.do";
		}else{
			//将用户名放入Session
			session.removeAttribute("is");
			return "redirect:/wd/toUpdPicture.do";
		}
	}
	
	
	
}
