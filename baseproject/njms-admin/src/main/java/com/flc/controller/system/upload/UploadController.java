package com.flc.controller.system.upload;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
/**
 * 封装文件上传方法
 * @author 王尧宇
 *
 */
@Controller
@RequestMapping("/upload")
public class UploadController {
	private static List<String> allImg=new ArrayList<String>();
	private static List<String> img1All= new ArrayList<String>();
	private static List<String> img2All= new ArrayList<String>();
	private static List<String> img3All= new ArrayList<String>();
	private static List<List<String>> imgMap = new ArrayList<List<String>>();
	//图片放入map集合中
	public static void imgMap(HttpServletRequest request){
		imgMap.add(allImg);
		imgMap.add(img1All);
		imgMap.add(img2All);
		imgMap.add(img3All);
		request.getSession().setAttribute("imgMap",imgMap);
	}
	/**
	 * 清空所有mapimg
	 */
	public static void clearMapImg(HttpServletRequest request){
		for (int i = 0; i < imgMap.size(); i++) {
			for (int j = 0; j < imgMap.get(i).size(); j++) {
				imgMap.get(i).clear();
			}
		}
		request.getSession().setAttribute("allImg",allImg);
		request.getSession().setAttribute("img1All",img1All);
		request.getSession().setAttribute("img2All",img2All);
		request.getSession().setAttribute("img3All",img3All);
		request.getSession().setAttribute("imgMap",imgMap);
	}
	
	
	/**
	 * @param request
	 * @return
	 * 清空所有img
	 */
	public static void clearAllImg(HttpServletRequest request){
		allImg.clear();
		request.getSession().setAttribute("allImg",allImg);
	}
	/**
	 * @param request
	 * @return
	 * 放一个kind参数为文件夹
	 */
	public static String getPath(HttpServletRequest request){
		String uploadImagePath="static\\login\\upload\\";
		return uploadImagePath;
	}
	/**
	 * @param request
	 * @return
	 * 放一个kind参数为文件夹
	 */
	public static String getRealPath(HttpServletRequest request){
		String realPath=request.getSession().getServletContext().getRealPath("\\static\\login\\upload\\");
		return realPath;
	}
	
	//上传图片
	@RequestMapping(value="/image",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> image(MultipartFile file,HttpServletRequest request){
		Map<String, Object> map=new HashMap<String,Object>();
		try {
			String path=request.getSession().getServletContext().getRealPath("\\static\\login\\upload\\");
			String image=UploadController.uploadFile(file, path);
			request.getSession().setAttribute("imageName", image);
			allImg.add(image);
			request.getSession().setAttribute("allImg",allImg);
			map.put("code", 0);
			map.put("image", image);
		} catch (Exception e) {
			map.put("code", 1);
			e.printStackTrace();
		}
		return map;
	}
	
	@RequestMapping(value="/image1",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> image1(MultipartFile file,HttpServletRequest request){
		Map<String, Object> map=new HashMap<String,Object>();
		try {
			String path=request.getSession().getServletContext().getRealPath("\\static\\login\\upload\\");
			String image=UploadController.uploadFile(file, path);
			request.getSession().setAttribute("imageName1", image);
			img1All.add(image);
			request.getSession().setAttribute("img1All",img1All);
			map.put("code", 0);
			map.put("image1", image);
		} catch (Exception e) {
			map.put("code", 1);
			e.printStackTrace();
		}
		return map;
	}
	
	
	@RequestMapping(value="/image2",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> image2(MultipartFile file,HttpServletRequest request){
		Map<String, Object> map=new HashMap<String,Object>();
		try {
			String path=request.getSession().getServletContext().getRealPath("\\static\\login\\upload\\");
			String image=UploadController.uploadFile(file, path);
			request.getSession().setAttribute("imageName2", image);
			img2All.add(image);
			request.getSession().setAttribute("img2All",img2All);
			map.put("code", 0);
			map.put("image2", image);
		} catch (Exception e) {
			map.put("code", 1);
			e.printStackTrace();
		}
		return map;
	}
	
	@RequestMapping(value="/image3",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> image3(MultipartFile file,HttpServletRequest request){
		Map<String, Object> map=new HashMap<String,Object>();
		try {
			String path=request.getSession().getServletContext().getRealPath("\\static\\login\\upload\\");
			String image=UploadController.uploadFile(file, path);
			request.getSession().setAttribute("imageName3", image);
			img3All.add(image);
			request.getSession().setAttribute("img3All",img3All);
			map.put("code", 0);
			map.put("image3", image);
		} catch (Exception e) {
			map.put("code", 1);
			e.printStackTrace();
		}
		return map;
	}
	
	
	public static String uploadFile(MultipartFile file,String path)throws IOException{
		String name=file.getOriginalFilename();//上传文件的真实名称
		String suffixName=name.substring(name.lastIndexOf("."));//获取后缀名
		String fileName = UUID.randomUUID().toString().replace("-", "").toLowerCase()+suffixName;
		File tempFile=new File(path,fileName);
		if (!tempFile.getParentFile().exists()) {
			tempFile.getParentFile().mkdirs();
		}
		file.transferTo(tempFile);
		return tempFile.getName();
	}
	
}
