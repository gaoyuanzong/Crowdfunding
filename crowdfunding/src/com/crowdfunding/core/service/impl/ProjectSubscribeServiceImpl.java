/*
 * Powered By [up72-framework]
 * Web Site: http://www.up72.com
 * Since 2006 - 2015
 */

package com.crowdfunding.core.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.crowdfunding.core.domain.ProjectSubscribe;

import com.crowdfunding.core.common.Page;
import com.crowdfunding.core.common.Result;
import com.crowdfunding.core.dao.IBaseDao;
import com.crowdfunding.core.exception.NameIsExistException;
import com.crowdfunding.core.exception.ParamIsNullException;
import com.crowdfunding.core.service.IProjectSubscribeService;
import com.crowdfunding.core.condition.ProjectSubscribeCondition;
import com.crowdfunding.core.util.ExcelWritePoiUtil;

/**
 * 订单业务处理
 * 
 * @author alive auto create
 * @version 1.0
 * @since 1.0
 */

public class ProjectSubscribeServiceImpl implements IProjectSubscribeService{
	private final static Logger logger=Logger.getLogger(ProjectSubscribeServiceImpl.class);
	private IBaseDao dao;

	
	/**
	 * 保存 ProjectSubscribe
	 */
	public Result<String> addProjectSubscribe(ProjectSubscribe projectSubscribe) {
		Result<String> result=new Result<String>(true); 
			String id=dao.addObject(projectSubscribe);
			result.setData(id);
		return result;
	}
	
	/**
	 * 删除 ProjectSubscribe
	 */
	public Result<String> removeProjectSubscribe(ProjectSubscribe projectSubscribe) {
		Result<String> result=new Result<String>(true); 
		dao.deleteObject(projectSubscribe);
		return new Result(true);
	}
	
	/**
	 * 更新 ProjectSubscribe
	 */
	public  Result<String>  modifyProjectSubscribe(ProjectSubscribe projectSubscribe) {
		Result<String> result=new Result<String>(true); 
		this.dao.updateObject(projectSubscribe);
		return new Result(true);
	}
	
	/**
	 * 查询列表
	 */

	public List queryProjectSubscribeList(ProjectSubscribeCondition condition) {
		return dao.queryObjectList(condition);
	}
	
	/**
	 * 分页查询
	 */
	public Page queryProjectSubscribePage(ProjectSubscribeCondition condition){
		return dao.queryPage(condition);
	}
	
	/**
	 * 根据Id 查询
	 */
	public ProjectSubscribe queryProjectSubscribeById(Long id){
		return dao.getObject(ProjectSubscribe.class, id);
	}
	
	/**
	 * get set  设置dao
	 */
	public IBaseDao getDao() {
		return dao;
	}

	public void setDao(IBaseDao dao) {
		this.dao = dao;
	}
}	
