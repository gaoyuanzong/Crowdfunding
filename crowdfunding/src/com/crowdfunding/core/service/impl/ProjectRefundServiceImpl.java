/*
 * Powered By [up72-framework]
 * Web Site: http://www.up72.com
 * Since 2006 - 2015
 */

package com.crowdfunding.core.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.crowdfunding.core.domain.ProjectRefund;

import com.crowdfunding.core.common.Page;
import com.crowdfunding.core.common.Result;
import com.crowdfunding.core.dao.IBaseDao;
import com.crowdfunding.core.exception.NameIsExistException;
import com.crowdfunding.core.exception.ParamIsNullException;
import com.crowdfunding.core.service.IProjectRefundService;
import com.crowdfunding.core.condition.ProjectRefundCondition;
import com.crowdfunding.core.util.ExcelWritePoiUtil;

/**
 * 退款业务处理
 * 
 * @author alive auto create
 * @version 1.0
 * @since 1.0
 */

public class ProjectRefundServiceImpl implements IProjectRefundService{
	private final static Logger logger=Logger.getLogger(ProjectRefundServiceImpl.class);
	private IBaseDao dao;

	
	/**
	 * 保存 ProjectRefund
	 */
	public Result<String> addProjectRefund(ProjectRefund projectRefund) {
		Result<String> result=new Result<String>(true); 
			String id=dao.addObject(projectRefund);
			result.setData(id);
		return result;
	}
	
	/**
	 * 删除 ProjectRefund
	 */
	public Result<String> removeProjectRefund(ProjectRefund projectRefund) {
		Result<String> result=new Result<String>(true); 
		dao.deleteObject(projectRefund);
		return new Result(true);
	}
	
	/**
	 * 更新 ProjectRefund
	 */
	public  Result<String>  modifyProjectRefund(ProjectRefund projectRefund) {
		Result<String> result=new Result<String>(true); 
		this.dao.updateObject(projectRefund);
		return new Result(true);
	}
	
	/**
	 * 查询列表
	 */

	public List queryProjectRefundList(ProjectRefundCondition condition) {
		return dao.queryObjectList(condition);
	}
	
	/**
	 * 分页查询
	 */
	public Page queryProjectRefundPage(ProjectRefundCondition condition){
		return dao.queryPage(condition);
	}
	
	/**
	 * 根据Id 查询
	 */
	public ProjectRefund queryProjectRefundById(Long id){
		return dao.getObject(ProjectRefund.class, id);
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
