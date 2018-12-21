package com.flc.service.impl;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.flc.dao.StudentinfoDao;
import com.flc.entity.Studentinfo;
import com.flc.service.StudentinfoService;

@Service
public class StudentinfoServiceImpl implements StudentinfoService{

	@Resource
	private StudentinfoDao dao;
	
	@Override
	public List<Studentinfo> findTop10() {
		return dao.findTop10();
	}

	/**
	 * 查询近期就业学生
	 * @return 返回近期就业学生集合
	 */
	public List<Studentinfo> findJobStudent(Map<String, Object> map){
		map.put("time", time());
		return dao.findJobStudent(map);
	}
	
	/**
	 * 查询近期就业学生总数
	 * @return
	 */
	@Override
	public int countJobStudent() {
		return dao.countJobStudent(time())%8==0?dao.countJobStudent(time())/8:dao.countJobStudent(time())/8+1;
	}
	
	//获取三月前的时间
	private String time(){
		String time = "";
		//首先获取一个实例化的对象，由于Calendar是抽象类，因此不能new    
		Calendar calendar =Calendar.getInstance();  
		//获取年份  
		int year = calendar.get(Calendar.YEAR);  
		//获取月份(月份的话需要在原来的基础上+1)  
		int month = calendar.get(Calendar.MONTH)+ 1; 
		
		if(month<3){
			month = 9+month;
			year = year - 1;
		}else if(month==3){
			month=12;
		}else{
			month = month-3;
		}
		
		if(month<10){
			time = year+"-0"+month;
		}else{
			time = year+"-"+month;
		}
		
		return time;
	}

	
	
	
}
