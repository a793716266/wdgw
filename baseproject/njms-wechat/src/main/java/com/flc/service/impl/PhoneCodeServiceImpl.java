package com.flc.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.flc.dao.PhoneCodeDao;
import com.flc.entity.PhoneCode;
import com.flc.service.PhoneCodeService;
import com.flc.util.WdUtil;

@Service
public class PhoneCodeServiceImpl implements PhoneCodeService {
	@Resource
	private PhoneCodeDao phoneCodeDao;

	@Override
	public int sendCode(PhoneCode wdgw_phonecode) {
		int result = 0; // 返回结果状态码
		boolean isSend = false; // 是否发送
		String phoneNumber = wdgw_phonecode.getPhone_number(); // 获取页面传入手机号
		Map<String, Object> condition = new HashMap<String, Object>();// 创建条件Map
		condition.put("phone_number", phoneNumber); // 将手机号放入条件中
		// 查询数据库中是否存在该号码
		PhoneCode tempPhoneCode = phoneCodeDao.select(condition);
		// 不存在
		if (tempPhoneCode == null) {
			isSend = true; // 发送验证码
		} else {
			Long mesc = tempPhoneCode.getCreatetime().getTime();
			Long dvalue = new Date().getTime() - mesc;
			if (dvalue > 60000)
				isSend = true; // 发送验证码
			else
				result = -1;  //时间过短
		}
		if (isSend) {
			// 设置一个随机6位数验证码
			int code = (int) (Math.random() * 900000) + 100000;
			result = WdUtil.sendCode(phoneNumber,code); // 返回状态码
			if(result == 0) {
				wdgw_phonecode.setPhone_code(code+"");
				wdgw_phonecode.setCreatetime(new Date()); //创建时间
				wdgw_phonecode.setPhone_number(phoneNumber);
				if(tempPhoneCode == null) {
					String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
					wdgw_phonecode.setPhoneCode_id(uuid);
					phoneCodeDao.insert(wdgw_phonecode);
				}else {
					wdgw_phonecode.setPhoneCode_id(tempPhoneCode.getPhoneCode_id());
					this.update(wdgw_phonecode);
				}
			}
		}
		return result;
	}

	@Override
	public int update(PhoneCode wdgw_phonecode) {
		return phoneCodeDao.update(wdgw_phonecode);
	}

	@Override
	public PhoneCode select(PhoneCode wdgw_phonecode) {
		String phone_number = wdgw_phonecode.getPhone_number(); // 获取页面传入手机号
		Map<String, Object> condition = new HashMap<String, Object>();// 创建条件Map
		condition.put("phone_number", phone_number); // 将手机号放入条件中
		PhoneCode tempPhoneCode = phoneCodeDao.select(condition);
		return tempPhoneCode;
	}

	@Override
	public int delete(String phone_number) {
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("phone_number", phone_number);
		return phoneCodeDao.delete(condition);
	}

}
