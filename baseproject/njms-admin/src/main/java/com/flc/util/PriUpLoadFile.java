package com.flc.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

/**
 * 图片上传
 * 
 * @author 郭旗
 *
 */
public class PriUpLoadFile {

	/**
	 * 上传文件到服务器
	 * 
	 * @param HttpServletRequest
	 * @param HttpSession
	 * @return saveFileName 存放文件夹名称
	 * @param myfile
	 *            前台file的name值
	 * @return imageName 图片名称
	 */
	public static String uploadFile(HttpServletRequest myrequest, HttpSession session,
			String myfile) {
		// 需要将HttpServletRequest转换成MultipartRequest
		MultipartRequest request = (MultipartRequest) myrequest;

		// 获取服务器的绝对地址
		ServletContext application = session.getServletContext();
		String rootPath = application.getRealPath("/");
		String uploadFile = "/static/login/upload";// 统一的上传文件夹
		File upFile = new File(rootPath + uploadFile);
		// 判断是否存在不存在就创建上传upload文件夹
		if (!upFile.exists()) {
			upFile.mkdir();
		}
		String dirName = uploadFile + File.separator;// 存放文件夹
		String dirPath = rootPath + dirName;// 获取绝对路径\
		File dirFile = new File(dirPath);
		// 判断是否存在不存在就创建文件夹
		if (!dirFile.exists()) {
			dirFile.mkdir();
		}
		// 轮播图获取
		MultipartFile imagemyfile = request.getFile(myfile);
		String imageName = "";
		try {
			byte[] b = imagemyfile.getBytes();// 转成字节
			String name = imagemyfile.getOriginalFilename();// 获取上传文件的原名
			if(name!=null&&name!=""){
				imageName = UuidUtil.get32UUID() + name.substring(name.lastIndexOf("."));// 使用uuid得到唯一名称
				String filePath = dirPath + File.separator + imageName;// 存放路径
				FileOutputStream fos = new FileOutputStream(filePath);// 创建文件流
				fos.write(b);// 写入
				fos.flush();
				fos.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// System.out.println("文件在服务器上的存放位置：" + dirPath + "分割线" + imageName);
		return imageName;
	}

	/**
	 * 删除图片
	 * 
	 * @param session
	 * @param priData
	 *            //要删除的图片对象
	 * @param saveFileName
	 *            //存放文件夹名称
	 * @param priName
	 *            //删除图片名称
	 */
	public static void FileDelete(HttpSession session, String priName) {
		// 获取服务器的绝对地址
		ServletContext application = session.getServletContext();
		String rootPath = application.getRealPath("/");
		// 做文件夹
		String dirName = "/static/login/upload" + File.separator;
		String dirPath = rootPath + dirName;
		File dirFile = new File(dirPath);
		if (!dirFile.exists()) {
			dirFile.mkdir();
		}
		// 删除原来图片
		File f = new File(dirFile + File.separator + priName);
		// 如果存在删除
		if (f.exists()) {
			f.delete();
			// System.out.println("删除轮播图成功");
		}
	}

	/**
	 * @param saveFileName 存放文件夹名称
	 * @param imageName 数据库文件名
	 * @return filePath 图片所在路径
	 */
	public static String getFilePath(String imageName) {
		File tempFile =new File( imageName.trim());  
	    String fileName = tempFile.getName();
		String dirName = "static"+File.separator+"login"+File.separator+"upload" + File.separator;
		String filePath = dirName + File.separator + fileName;// 存放路径
		return filePath;

	}
}
