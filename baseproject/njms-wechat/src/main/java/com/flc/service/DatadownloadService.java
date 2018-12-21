package com.flc.service;

import java.util.List;
import java.util.Map;

import com.flc.entity.Datadownload;

public interface DatadownloadService {
	/**
	 * 查询所有的网盘
	 * @param DatadownloadMap
	 * @return
	 */
	List<Datadownload> findDatadownload(Map  map);
	
	/**
	 * 查询网盘总数
	 * @return
	 */
	int countDatadownload();
}
