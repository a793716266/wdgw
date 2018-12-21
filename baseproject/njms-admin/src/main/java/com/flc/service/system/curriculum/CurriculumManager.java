package com.flc.service.system.curriculum;

import java.util.List;
import com.flc.entity.Page;
import com.flc.util.PageData;

/** 
 * 说明： 课程类型表接口
 * 创建人：FLC
 * 创建时间：2018-07-24
 * @version
 */
public interface CurriculumManager{

	/**新增
	 * @param pd
	 * @throws Exception
	 */
	public void save(PageData pd)throws Exception;
	
	/**删除
	 * @param pd
	 * @throws Exception
	 */
	public void delete(PageData pd)throws Exception;
	
	/**修改
	 * @param pd
	 * @throws Exception
	 */
	public void edit(PageData pd)throws Exception;
	
	/**列表
	 * @param page
	 * @throws Exception
	 */
	public List<PageData> list(Page page)throws Exception;
	
	/**列表(全部)
	 * @param pd
	 * @throws Exception
	 */
	public List<PageData> listAll(PageData pd)throws Exception;
	
	/**通过id获取数据
	 * @param pd
	 * @throws Exception
	 */
	public PageData findById(PageData pd)throws Exception;
	
	/**批量删除
	 * @param ArrayDATA_IDS
	 * @throws Exception
	 */
	public void deleteAll(String[] ArrayDATA_IDS)throws Exception;
	
	/**批量下载
	 * @param ArrayDATA_IDS
	 * @throws Exception
	 */
	public List<PageData> toBatchExcel(String[] ArrayDATA_IDS)throws Exception;
}

