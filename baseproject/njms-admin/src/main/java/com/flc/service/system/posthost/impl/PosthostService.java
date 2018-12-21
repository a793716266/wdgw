package com.flc.service.system.posthost.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.flc.dao.DaoSupport;
import com.flc.entity.Page;
import com.flc.util.PageData;
import com.flc.service.system.posthost.PosthostManager;

/** 
 * 说明： 关注度最高帖子列表
 * 创建人：FLC
 * 创建时间：2018-09-28
 * @version
 */
@Service("posthostService")
public class PosthostService implements PosthostManager{

	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	/**新增
	 * @param pd
	 * @throws Exception
	 */
	public void save(PageData pd)throws Exception{
		dao.save("PosthostMapper.save", pd);
	}
	
	/**删除
	 * @param pd
	 * @throws Exception
	 */
	public void delete(PageData pd)throws Exception{
		dao.delete("PosthostMapper.delete", pd);
	}
	
	/**修改
	 * @param pd
	 * @throws Exception
	 */
	public void edit(PageData pd)throws Exception{
		dao.update("PosthostMapper.edit", pd);
	}
	
	/**列表
	 * @param page
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> list(Page page)throws Exception{
		return (List<PageData>)dao.findForList("PosthostMapper.datalistPage", page);
	}
	
	/**列表(全部)
	 * @param pd
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> listAll(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("PosthostMapper.listAll", pd);
	}
	
	/**通过id获取数据
	 * @param pd
	 * @throws Exception
	 */
	public PageData findById(PageData pd)throws Exception{
		return (PageData)dao.findForObject("PosthostMapper.findById", pd);
	}
	
	/**批量删除
	 * @param ArrayDATA_IDS
	 * @throws Exception
	 */
	public void deleteAll(String[] ArrayDATA_IDS)throws Exception{
		dao.delete("PosthostMapper.deleteAll", ArrayDATA_IDS);
	}

	@Override
	public PageData findByIdPostId(PageData pd) throws Exception {
		// TODO Auto-generated method stub
		 return (PageData)dao.findForObject("PosthostMapper.findByIdPostId", pd);
	}

	@Override
	public void deleteposthostresult(PageData pd) throws Exception {
		dao.delete("PosthostMapper.deleteposthostresult", pd);
	}

	@Override
	public void deleteAllposthostresult(String[] ArrayDATA_IDS) throws Exception {
		 
		dao.delete("PosthostMapper.deleteAllposthostresult", ArrayDATA_IDS);
	}

	@Override
	public void editStatus(PageData pd) throws Exception {
		dao.update("PosthostMapper.editstatus", pd);
		
	}

	@Override
	public void editAnimation(PageData pd) throws Exception {
		dao.update("PosthostMapper.editanimation", pd);
		
	}

	@Override
	public void editstatusiszero(PageData pd) throws Exception {
		// TODO Auto-generated method stub editstatusiszero
		dao.update("PosthostMapper.editstatusiszero",pd);
	}
	
	
	
}

