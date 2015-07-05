/*
 * Powered By [up72-framework]
 * Web Site: http://www.up72.com
 * Since 2006 - 2015
 */

package com.crowdfunding.core.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.crowdfunding.core.domain.ProjectRedound;

import com.crowdfunding.core.common.Page;
import com.crowdfunding.core.common.Result;
import com.crowdfunding.core.dao.IBaseDao;
import com.crowdfunding.core.exception.NameIsExistException;
import com.crowdfunding.core.exception.ParamIsNullException;
import com.crowdfunding.core.service.IProjectRedoundService;
import com.crowdfunding.core.condition.ProjectRedoundCondition;
import com.crowdfunding.core.util.ExcelWritePoiUtil;

/**
 * 项目回报业务处理
 * 
 * @author alive auto create
 * @version 1.0
 * @since 1.0
 */

public class ProjectRedoundServiceImpl implements IProjectRedoundService{
	private final static Logger logger=Logger.getLogger(ProjectRedoundServiceImpl.class);
	private IBaseDao dao;

	
	/**
	 * 保存 ProjectRedound
	 */
	public Result<String> addProjectRedound(ProjectRedound projectRedound) {
		Result<String> result=new Result<String>(true); 
			String id=dao.addObject(projectRedound);
			result.setData(id);
		return result;
	}
	
	/**
	 * 删除 ProjectRedound
	 */
	public Result<String> removeProjectRedound(ProjectRedound projectRedound) {
		Result<String> result=new Result<String>(true); 
		dao.deleteObject(projectRedound);
		return new Result(true);
	}
	
	/**
	 * 更新 ProjectRedound
	 */
	public  Result<String>  modifyProjectRedound(ProjectRedound projectRedound) {
		Result<String> result=new Result<String>(true); 
		this.dao.updateObject(projectRedound);
		return new Result(true);
	}
	
	/**
	 * 查询列表
	 */

	public List queryProjectRedoundList(ProjectRedoundCondition condition) {
		return dao.queryObjectList(condition);
	}
	
	/**
	 * 分页查询
	 */
	public Page queryProjectRedoundPage(ProjectRedoundCondition condition){
		return dao.queryPage(condition);
	}
	
	/**
	 * 根据Id 查询
	 */
	public ProjectRedound queryProjectRedoundById(Long id){
		return dao.getObject(ProjectRedound.class, id);
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
