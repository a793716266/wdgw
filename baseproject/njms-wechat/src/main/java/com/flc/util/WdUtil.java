package com.flc.util;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

//文鼎官网工具类
public class WdUtil {
	public static String convertToJson(String attr, Object[] lists) {
		Map<String, Object> jsonMap = new HashMap<>();
		String[] attrs = attr.split(",");
		for (int i = 0; i < attrs.length; i++) {
			
			System.out.println(attrs[i]+"建值"+lists[i]+"数组的值");
			jsonMap.put(attrs[i], lists[i]);
		}
		return JSON.toJSONString(jsonMap);
	}

	public static int sendCode(String phoneNumber, int code) {
		// 设置超时时间-可自行调整
		System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
		System.setProperty("sun.net.client.defaultReadTimeout", "10000");
		// 初始化ascClient需要的几个参数
		final String product = "Dysmsapi";// 短信API产品名称（短信产品名固定，无需修改）
		final String domain = "dysmsapi.aliyuncs.com";// 短信API产品域名（接口地址固定，无需修改）
		// 替换成你的AK
		final String accessKeyId = "LTAIRdZ9jqr2SyGf";// 你的accessKeyId,参考本文档步骤2
		final String accessKeySecret = "Bnq3mV8Bf4hPYiV3QseXZE6cGF91Ud";// 你的accessKeySecret，参考本文档步骤2
		// 初始化ascClient,暂时不支持多region（请勿修改）
		IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
		try {
			DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
		} catch (ClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		IAcsClient acsClient = new DefaultAcsClient(profile);
		// 组装请求对象
		SendSmsRequest request = new SendSmsRequest();
		// 使用post提交
		request.setMethod(MethodType.POST);
		// 必填:待发送手机号。支持以逗号分隔的形式进行批量调用，批量上限为1000个手机号码,批量调用相对于单条调用及时性稍有延迟,验证码类型的短信推荐使用单条调用的方式；发送国际/港澳台消息时，接收号码格式为00+国际区号+号码，如“0085200000000”
		request.setPhoneNumbers(phoneNumber);
		// 必填:短信签名-可在短信控制台中找到
		request.setSignName("颜琳");
		// 必填:短信模板-可在短信控制台中找到，发送国际/港澳台消息时，请使用国际/港澳台短信模版
		request.setTemplateCode("SMS_126360111");
		// 可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
		// 友情提示:如果JSON中需要带换行符,请参照标准的JSON协议对换行符的要求,比如短信内容中包含\r\n的情况在JSON中需要表示成\\r\\n,否则会导致JSON在服务端解析失败
		request.setTemplateParam("{\"name\":\"Tom\", \"code\":\"" + code + "\"}");
		// 可选-上行短信扩展码(扩展码字段控制在7位或以下，无特殊需求用户请忽略此字段)
		// 可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
		request.setOutId("yourOutId");
		// 请求失败这里会抛ClientException异常
		SendSmsResponse sendSmsResponse = null;
		try {
			sendSmsResponse = acsClient.getAcsResponse(request);
		} catch (ServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (sendSmsResponse.getCode() != null) {
			String respCode = sendSmsResponse.getCode();
			if (respCode.equals("OK")) {
				return 0; // 发送成功
			} else if (respCode.equals("isv.MOBILE_NUMBER_ILLEGAL")) {
				return 1; // 非法手机号
			} else if (respCode.equals("isv.BUSINESS_LIMIT_CONTROL")) {
				return 2; // 业务限流(操作过于频繁)
			}
		}
		return 3; // 其他错误
	}

	public static String getVideoUrl(String videoId) {
		// 获取页面传来的id(腾讯视频前缀qqvid= 优酷视频前缀youkusid=)
		String videoUrl = ""; // 视频地址
		// 腾讯视频格式：http://v.qq.com/iframe/player.html?vid=${vid}&amp
		// 优酷视频格式：http://player.youku.com/${sid}
		String qqPrefix = "qqvid=";
		String youkuPrefix = "youkusid=";
		int qqIndex = videoId.indexOf(qqPrefix);
		int youkuIndex = videoId.indexOf(youkuPrefix);
		if (qqIndex > -1) {
			videoUrl = "http://v.qq.com/iframe/player.html?vid=" + videoId.substring(qqPrefix.length()) + "&amp";
		} else if (youkuIndex > -1) {
			videoUrl = "http://player.youku.com/embed/" + videoId.substring(youkuPrefix.length());
		}
		return videoUrl;
	}
}
