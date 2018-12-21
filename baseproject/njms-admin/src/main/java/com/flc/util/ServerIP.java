package com.flc.util;

import javax.servlet.http.HttpServletRequest;

public class ServerIP {
	/**
     * 获取服务器IP地址
     * @return
     */
    @SuppressWarnings("unchecked")
    public static String  getServerIp(HttpServletRequest request){
        String SERVER_IP = null;
        try {
        	SERVER_IP = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SERVER_IP;
    }
}
