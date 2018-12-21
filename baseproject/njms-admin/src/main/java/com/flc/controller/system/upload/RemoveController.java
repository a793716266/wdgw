package com.flc.controller.system.upload;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
/**
 * 删除多余照片
 * 
 * @author 王尧宇
 *
 */
public class RemoveController {

	@SuppressWarnings("unchecked")
	public static void removeitMap(HttpServletRequest request) {
		List<String> listAllImg=(List<String>) request.getAttribute("listAllImg");
		if(listAllImg!=null){
			for (String img : listAllImg) {
				File file = new File(UploadController.getRealPath(request) + "\\" + img);// 获取服务器绝对路劲
				file.delete();
			}
		}
	}
	
	public static void removeOldMap(HttpServletRequest request) {
		HttpSession session=request.getSession();
		if(null!=request.getParameter("imageName")){
			if (!request.getParameter("imageName").equals(session.getAttribute("oldImg"))) {
				File file = new File(UploadController.getRealPath(request) + "\\" + session.getAttribute("oldImg"));// 获取服务器绝对路劲
				file.delete();
			}
		}
		if(null!=request.getParameter("imageName1")){
			if (!request.getParameter("imageName1").equals(session.getAttribute("oldImg1"))) {
				File file = new File(UploadController.getRealPath(request) + "\\" + session.getAttribute("oldImg1"));// 获取服务器绝对路劲
				file.delete();
			}
		}
		
		if(null!=request.getParameter("imageName2")){
			if (!request.getParameter("imageName2").equals(session.getAttribute("oldImg2"))) {
				File file = new File(UploadController.getRealPath(request) + "\\" + session.getAttribute("oldImg2"));// 获取服务器绝对路劲
				file.delete();
			}
		}
		
		if(null!=request.getParameter("imageName3")){
			if (!request.getParameter("imageName3").equals(session.getAttribute("oldImg3"))) {
				File file = new File(UploadController.getRealPath(request) + "\\" + session.getAttribute("oldImg3"));// 获取服务器绝对路劲
				file.delete();
			}
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public static void removeit(HttpServletRequest request) {
		List<String> all = (List<String>) request.getSession().getAttribute("allImg");
		if(all!=null){
			for (String image : all) {
				File file = new File(UploadController.getRealPath(request) + "\\" + image);// 获取服务器绝对路劲
				file.delete();
			}
		}
		UploadController.clearAllImg(request);
	}

	@SuppressWarnings("unchecked")
	public static void saveOrUpdateRemove(HttpServletRequest request) {
		HttpSession s = request.getSession();
		if (!s.getAttribute("imageName").equals(s.getAttribute("oldImg"))) {
			File file = new File(UploadController.getRealPath(request) + "\\" + s.getAttribute("oldImg"));// 获取服务器绝对路劲
			file.delete();
		}
		List<String> all = (List<String>) s.getAttribute("allImg");
		if (all != null) {
			for (int i = 0; i < all.size() - 1; i++) {
				File file = new File(UploadController.getRealPath(request) + "\\" + all.get(i));// 获取服务器绝对路劲
				file.delete();
			}
		}
		UploadController.clearAllImg(request);
	}
	
	public static void deleteOne(HttpServletRequest request,String name){
		File file=new File(UploadController.getRealPath(request)+"\\"+name);//获取服务器绝对路劲
		file.delete();
	}
	
	@SuppressWarnings("unchecked")
	public static void removeMap(HttpServletRequest request) {
		List<List<String>> imgMap = (List<List<String>>) request.getSession().getAttribute("imgMap");
		if (imgMap != null) {
			for (int i = 0; i < imgMap.size(); i++) {
				for (int j = 0; j < imgMap.get(i).size(); j++) {
					File file = new File(UploadController.getRealPath(request) + "\\" + imgMap.get(i).get(j));// 获取服务器绝对路劲
					file.delete();
				}
			}
		}
		UploadController.clearMapImg(request);
	}
	
	@SuppressWarnings("unchecked")
	public static void saveOrUpdateRemoveMap(HttpServletRequest request) {
		List<List<String>> imgMap = (List<List<String>>) request.getSession().getAttribute("imgMap");
		if (imgMap != null) {
			for (int i = 0; i < imgMap.size(); i++) {
				for (int j = 0; j < imgMap.get(i).size()-1; j++) {
					File file = new File(UploadController.getRealPath(request) + "\\" + imgMap.get(i).get(j));// 获取服务器绝对路劲
					file.delete();
				}
			}
		}
		UploadController.clearMapImg(request);
	}
	
}
