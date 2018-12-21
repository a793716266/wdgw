package com.flc.service.system.wd_users.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.flc.dao.DaoSupport;
import com.flc.entity.Page;
import com.flc.util.PageData;
import com.flc.service.system.wd_users.WD_UsersManager;

/** 
 * 说明： 注册用户表
 * 创建人：FLC
 * 创建时间：2018-07-24
 * @version
 */
@Service("wd_usersService")
public class WD_UsersService implements WD_UsersManager{

	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	/**新增
	 * @param pd
	 * @throws Exception
	 */
	public void save(PageData pd)throws Exception{
		dao.save("WD_UsersMapper.save", pd);
	}
	
	/**删除
	 * @param pd
	 * @throws Exception
	 */
	public void delete(PageData pd)throws Exception{
		dao.delete("WD_UsersMapper.delete", pd);
	}
	
	/**修改
	 * @param pd
	 * @throws Exception
	 */
	public void edit(PageData pd)throws Exception{
		dao.update("WD_UsersMapper.edit", pd);
	}
	
	/**列表
	 * @param page
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> list(Page page)throws Exception{
		return (List<PageData>)dao.findForList("WD_UsersMapper.datalistPage", page);
	}
	
	/**列表(全部)
	 * @param pd
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> listAll(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("WD_UsersMapper.listAll", pd);
	}
	
	/**通过id获取数据
	 * @param pd
	 * @throws Exception
	 */
	public PageData findById(PageData pd)throws Exception{
		return (PageData)dao.findForObject("WD_UsersMapper.findById", pd);
	}
	
	/**批量删除
	 * @param ArrayDATA_IDS
	 * @throws Exception
	 */
	public void deleteAll(String[] ArrayDATA_IDS)throws Exception{
		dao.delete("WD_UsersMapper.deleteAll", ArrayDATA_IDS);
	}

	@Override
	public List<PageData> toBatchExcel(String[] ArrayDATA_IDS) throws Exception {
		return (List<PageData>)dao.findForList("WD_UsersMapper.toBatchExcel", ArrayDATA_IDS);
	}

	@Override
	public List<PageData> listAllAdmin(PageData pd) throws Exception {
		return (List<PageData>)dao.findForList("WD_UsersMapper.listAll", pd);
	}
	
}

