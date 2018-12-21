package com.flc.service.system.wybj.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.flc.dao.DaoSupport;
import com.flc.entity.Page;
import com.flc.entity.system.Wybj;
import com.flc.util.PageData;
import com.flc.service.system.wybj.WybjManager;

/** 
 * 说明： 文案编辑
 * 创建人：FLC
 * 创建时间：2018-10-05
 * @version
 */
@Service("wybjService")
public class WybjService implements WybjManager{

	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	/**新增
	 * @param pd
	 * @throws Exception
	 */
	public void save(PageData pd)throws Exception{
		dao.save("WybjMapper.save", pd);
	}
	
	/**删除
	 * @param pd
	 * @throws Exception
	 */
	public void delete(PageData pd)throws Exception{
		dao.delete("WybjMapper.delete", pd);
	}
	
	/**修改
	 * @param pd
	 * @throws Exception
	 */
	public void edit(PageData pd)throws Exception{
		dao.update("WybjMapper.edit", pd);
	}
	
	/**列表
	 * @param page
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> list(Page page)throws Exception{
		return (List<PageData>)dao.findForList("WybjMapper.datalistPage", page);
	}
	
	/**列表(全部)
	 * @param pd
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> listAll(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("WybjMapper.listAll", pd);
	}
	
	/**通过id获取数据
	 * @param pd
	 * @throws Exception
	 */
	public PageData findById(PageData pd)throws Exception{
		return (PageData)dao.findForObject("WybjMapper.findById", pd);
	}

	/**
	 * 通过ID获取其子级列表
	 * @param parentId
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<Wybj> listByParentId(String parentId) throws Exception {
		return (List<Wybj>) dao.findForList("WybjMapper.listByParentId", parentId);
	}
	
	/**
	 * 获取所有数据并填充每条数据的子级列表(递归处理)
	 * @param MENU_ID
	 * @return
	 * @throws Exception
	 */
	public List<Wybj> listTree(String parentId) throws Exception {
		List<Wybj> valueList = this.listByParentId(parentId);
		for(Wybj fhentity : valueList){
			fhentity.setTreeurl("wybj/list.do?WYBJ_ID="+fhentity.getWYBJ_ID());
			fhentity.setSubWybj(this.listTree(fhentity.getWYBJ_ID()));
			fhentity.setTarget("treeFrame");
		}
		return valueList;
	}
		
}

