package com.flc.util;

import java.io.File;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;
public class PictureUpload {
	private static String picname;
	
	//获得文件名
	public static String getPicName(){
		return picname;
	}
	public static void upLoad(MultipartFile file,HttpServletRequest request){
		 
		/*String json="";
		String src="";
		String msg="0";*/
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
					 
					 //msg="2";
				}else{
					//路径
					//String path = "http:\\127.0.0.1:8080\\njms-admin\\static\\login\\upload\\";
					//当前时间
					 
					 
					//定义文件名
					picname = DateUtil.getSdfTimes()+"."+suffix;
					String path = request.getSession(true).getServletContext().getRealPath("/")+"\\static\\login\\upload";
					 
					//String path=System.getProperty("catalina.home")+"\\webapps\\njms-admin\\static\\login\\upload";
					 
					//System.out.println(System.getProperty("catalina.home"));;
					File newFile = new File(path,picname);
					//判断文件路径是否存在
					if(!newFile.exists()){
						//创建文件夹
						newFile.mkdirs();
					}
					try {
						
						file.transferTo(newFile);
						/*src=requestPath+name;
						msg="1";*/
						
					} catch (IllegalStateException e) {
						e.printStackTrace();
//						msg="0";
					} catch (IOException e) {
						e.printStackTrace();
						/*msg="0";*/
					}
					/*json="{\"src\":\""+src+"\",\"msg\":\""+msg+"\"}";*/
				}
				
				
			}
		}
		//return json;
		 
		
	}
}
