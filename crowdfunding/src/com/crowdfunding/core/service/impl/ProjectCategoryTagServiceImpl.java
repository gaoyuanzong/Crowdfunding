/*
 * Powered By [up72-framework]
 * Web Site: http://www.up72.com
 * Since 2006 - 2015
 */

package com.crowdfunding.core.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.crowdfunding.core.common.Page;
import com.crowdfunding.core.common.Result;
import com.crowdfunding.core.condition.ProjectCategoryTagCondition;
import com.crowdfunding.core.dao.IBaseDao;
import com.crowdfunding.core.domain.ProjectCategoryTag;
import com.crowdfunding.core.service.IProjectCategoryTagService;

/**
 * 项目分类业务处理
 * 
 * @author alive auto create
 * @version 1.0
 * @since 1.0
 */

public class ProjectCategoryTagServiceImpl implements IProjectCategoryTagService{
	private final static Logger logger=Logger.getLogger(ProjectCategoryTagServiceImpl.class);
	private IBaseDao dao;

	
	/**
	 * 保存 ProjectCategoryTag
	 */
	public Result<String> addProjectCategoryTag(ProjectCategoryTag projectCategoryTag) {
		Result<String> result=new Result<String>(true); 
			String id=dao.addObject(projectCategoryTag);
			result.setData(id);
		return result;
	}
	
	/**
	 * 删除 ProjectCategoryTag
	 */
	public Result<String> removeProjectCategoryTag(ProjectCategoryTag projectCategoryTag) {
		Result<String> result=new Result<String>(true); 
		dao.deleteObject(projectCategoryTag);
		return new Result(true);
	}
	
	/**
	 * 更新 ProjectCategoryTag
	 */
	public  Result<String>  modifyProjectCategoryTag(ProjectCategoryTag projectCategoryTag) {
		ProjectCategoryTag newProjectCategoryTag = this.queryProjectCategoryTagById(projectCategoryTag.getId());
		newProjectCategoryTag.setName(projectCategoryTag.getName());
		newProjectCategoryTag.setModifiedTime(new Date());
		this.dao.updateObject(newProjectCategoryTag);
		return new Result(true);
	}
	
	/**
	 * 查询列表
	 */

	public List queryProjectCategoryTagList(ProjectCategoryTagCondition condition) {
		return dao.queryObjectList(condition);
	}
	
	/**
	 * 分页查询
	 */
	public Page queryProjectCategoryTagPage(ProjectCategoryTagCondition condition){
		return dao.queryPage(condition);
	}
	
	/**
	 * 根据Id 查询
	 */
	public ProjectCategoryTag queryProjectCategoryTagById(Long id){
		return dao.getObject(ProjectCategoryTag.class, id);
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
