package com.flc.dao;

import java.util.List;
import java.util.Map;

import com.flc.entity.Datadownload;
import com.flc.util.PageData;

public interface DatadownloadDao {
	/**
	 * 查询所有的网盘
	 * @param DatadownloadMap
	 * @return
	 */
	public List<Datadownload> findDatadownload(Map<String, Object> map);
	
	/**
	 * 查询网盘总数
	 * @return
	 */
	public int countDatadownload();

}
