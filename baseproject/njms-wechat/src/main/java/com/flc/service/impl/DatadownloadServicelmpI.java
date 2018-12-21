package com.flc.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flc.dao.DatadownloadDao;
import com.flc.entity.Datadownload;
import com.flc.service.DatadownloadService;

@Service
public class DatadownloadServicelmpI implements DatadownloadService {
	
	@Autowired
	private DatadownloadDao datadownloadDao;

	/**
	 * 查询所有的网盘
	 * @param DatadownloadMap
	 * @return
	 */
	@Override
	public List<Datadownload> findDatadownload(Map  map) {
		return datadownloadDao.findDatadownload(map);
	}

	/**
	 * 查询网盘总数（5条为一页）
	 * @return
	 */
	@Override
	public int countDatadownload() {
		
		return datadownloadDao.countDatadownload()%5==0?datadownloadDao.countDatadownload()/5:datadownloadDao.countDatadownload()/5+1;
	}

}
