package com.flc.controller.wd;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.flc.service.UserService;
@Controller
@RequestMapping(value="/wd/")
@Transactional
public class UserUpdatePictrueController {
	@Resource
    private UserService user;
	
	@Value("${upload.requestPath}")
	private String requestPath;
	
	//修改头像路径
	@Value("${upload.updPicPath}")
	private String updPicPath;
	
	@RequestMapping(value="/tofile.do")
	@ResponseBody
	public String upLoad(@RequestParam(value="file")MultipartFile file ,HttpServletRequest request,String wd_users_id){
		String json=null;
		String msg=null;
		if(!file.isEmpty()){
			String oldName  = file.getOriginalFilename(); //获取文件名
			String suffix = FilenameUtils.getExtension(oldName); //获取文件后缀
			//判断文件后缀
			if("jpg".equalsIgnoreCase(suffix)||
					"jpeg".equalsIgnoreCase(suffix)||
					"png".equalsIgnoreCase(suffix)||
					"pneg".equalsIgnoreCase(suffix)||
					"gif".equalsIgnoreCase(suffix)){
				///判断文件大小
				if(file.getSize()>900000){
					System.out.println("文件过大！！！");
				}else{
					//路径
					//String path = "http:\\127.0.0.1:8080\\njms-admin\\static\\login\\upload\\";
					//当前时间
					Date date = new Date();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssSSS");
					//定义文件名
					String name =  sdf.format(date)+"."+suffix;
					//System.out.println(name);
					String path1 = request.getSession(true).getServletContext().getRealPath("/");
					String path2=new File(path1).getParent()+updPicPath;
					//String path=System.getProperty("catalina.home")+"\\webapps\\njms-admin\\static\\login\\upload";
					//System.out.println(System.getProperty("catalina.home"));;
					File newFile = new File(path2,name);
					//判断文件路径是否存在
					if(!newFile.exists()){
						//创建文件夹
						newFile.mkdirs();
					}
					try {
						
						file.transferTo(newFile);
						int result = user.updapictrue(name, wd_users_id);
						if(result==0){
							msg="修改图片失败";
							json="{\"msg\":\""+msg+"\"}";
						}else{
							msg="修改图片成功";
							String newpicture=requestPath+name;
							json="{\"msg\":\""+msg+"\",\"newpicture\":\""+newpicture+"\"}";
						}
					} catch (IllegalStateException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return json;
		 
		
	}
}
