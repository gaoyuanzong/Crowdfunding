/*
 * Powered By [up72-framework]
 * Web Site: http://www.up72.com
 * Since 2006 - 2015
 */

package com.crowdfunding.core.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.crowdfunding.core.domain.ProjectProgress;

import com.crowdfunding.core.common.Page;
import com.crowdfunding.core.common.Result;
import com.crowdfunding.core.dao.IBaseDao;
import com.crowdfunding.core.exception.NameIsExistException;
import com.crowdfunding.core.exception.ParamIsNullException;
import com.crowdfunding.core.service.IProjectProgressService;
import com.crowdfunding.core.condition.ProjectProgressCondition;
import com.crowdfunding.core.util.ExcelWritePoiUtil;

/**
 * 项目进度业务处理
 * 
 * @author alive auto create
 * @version 1.0
 * @since 1.0
 */

public class ProjectProgressServiceImpl implements IProjectProgressService{
	private final static Logger logger=Logger.getLogger(ProjectProgressServiceImpl.class);
	private IBaseDao dao;

	
	/**
	 * 保存 ProjectProgress
	 */
	public Result<String> addProjectProgress(ProjectProgress projectProgress) {
		Result<String> result=new Result<String>(true); 
			String id=dao.addObject(projectProgress);
			result.setData(id);
		return result;
	}
	
	/**
	 * 删除 ProjectProgress
	 */
	public Result<String> removeProjectProgress(ProjectProgress projectProgress) {
		Result<String> result=new Result<String>(true); 
		dao.deleteObject(projectProgress);
		return new Result(true);
	}
	
	/**
	 * 更新 ProjectProgress
	 */
	public  Result<String>  modifyProjectProgress(ProjectProgress projectProgress) {
		Result<String> result=new Result<String>(true); 
		this.dao.updateObject(projectProgress);
		return new Result(true);
	}
	
	/**
	 * 查询列表
	 */

	public List queryProjectProgressList(ProjectProgressCondition condition) {
		return dao.queryObjectList(condition);
	}
	
	/**
	 * 分页查询
	 */
	public Page queryProjectProgressPage(ProjectProgressCondition condition){
		return dao.queryPage(condition);
	}
	
	/**
	 * 根据Id 查询
	 */
	public ProjectProgress queryProjectProgressById(Long id){
		return dao.getObject(ProjectProgress.class, id);
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
