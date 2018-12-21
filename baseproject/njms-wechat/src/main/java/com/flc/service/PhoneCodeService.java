package com.flc.service;

import com.flc.entity.PhoneCode;

public interface PhoneCodeService {
	/**
	 * 发送验证码
	 * @param wdgw_phonecode 
	 * @return 
	 */
	int sendCode(PhoneCode wdgw_phonecode);
	/**
	 * 修改手机号+验证码
	 * @param wdgw_phonecode 
	 * @return 数据库受影响行数
	 */
	int update(PhoneCode wdgw_phonecode);
	/**
	 * 根据条件获取手机号+验证码
	 * @param conditon 条件
	 * @return 手机号+验证码
	 */
	PhoneCode select(PhoneCode wdgw_phonecode);
	/**
	 * 根据条件删除
	 * @param conditon 条件
	 * @return 数据库受影响行数
	 */
	int delete(String phone_number);
}
