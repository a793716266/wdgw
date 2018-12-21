package com.flc.service.system.posthost;

import java.util.List;
import com.flc.entity.Page;
import com.flc.util.PageData;

/** 
 * 说明： 关注度最高帖子列表接口
 * 创建人：FLC
 * 创建时间：2018-09-28
 * @version
 */
public interface PosthostManager{

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
	
	/**删除posthostresult
	 * @param pd
	 * @throws Exception
	 */
	public void deleteposthostresult(PageData pd)throws Exception;
	/**修改
	 * @param pd
	 * @throws Exception
	 */
	public void edit(PageData pd)throws Exception;
	
	/**修改所有为0
	 * @param pd
	 * @throws Exception
	 */
	public void editstatusiszero(PageData pd)throws Exception;
	/**修改状态
	 * @param pd
	 * @throws Exception
	 */
	public void editStatus(PageData pd)throws Exception;
	
	/**修改动画
	 * @param pd
	 * @throws Exception
	 */
	public void editAnimation(PageData pd)throws Exception;
	
	/**列表
	 * @param page
	 * @throws Exception
	 */
	public List<PageData> list(Page page)throws Exception;
	
	
	/**帖子热度修改列表
	 * @param page
	 * @throws Exception
	 */
	public PageData findByIdPostId(PageData pd)throws Exception;
	
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
	
	/**批量删除 deleteAllposthostresult
	 * @param ArrayDATA_IDS
	 * @throws Exception
	 */
	public void deleteAllposthostresult(String[] ArrayDATA_IDS)throws Exception;
	
}

