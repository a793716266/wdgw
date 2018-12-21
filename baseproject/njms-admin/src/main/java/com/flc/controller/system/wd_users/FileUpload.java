package com.flc.controller.system.wd_users;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
@Controller
@RequestMapping(value="/wd/")
public class FileUpload {

	@RequestMapping(value="/file")
	@ResponseBody
	public void upLoad(@RequestParam(value="file")MultipartFile file ,HttpServletRequest request){
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
					String path = request.getSession(true).getServletContext().getRealPath("\\static\\login\\upload");
					//当前时间
					Date date = new Date();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssSSS");
					//定义文件名
					String name =  sdf.format(date)+"."+suffix;
					System.out.println(name);
					//String path1 = request.getSession(true).getServletContext().getRealPath("/");
		 
					//System.out.println(System.getProperty("catalina.home"));;
					File newFile = new File(path,name);
					//判断文件路径是否存在
					if(!newFile.exists()){
						//创建文件夹
						newFile.mkdirs();
					}
					try {
						file.transferTo(newFile);
					} catch (IllegalStateException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					
				}
				
				
			}
		}
		 
		
	}
}
