/*
 * Powered By [up72-framework]
 * Web Site: http://www.up72.com
 * Since 2006 - 2015
 */

package com.crowdfunding.core.service;

import java.util.List;

import org.apache.log4j.Logger;
import com.crowdfunding.core.common.Page;
import com.crowdfunding.core.domain.ProjectCategoryTag;
import com.crowdfunding.core.common.Result;

import com.crowdfunding.core.condition.ProjectCategoryTagCondition;
/**
 * 项目分类业务处理
 * 
 * @author alive auto create
 * @version 1.0
 * @since 1.0
 */

public interface IProjectCategoryTagService {
	public static Logger logger = Logger.getLogger(IProjectCategoryTagService.class);
		
	/**
	 * 保存 ProjectCategoryTag
	 */
	public Result addProjectCategoryTag(ProjectCategoryTag projectCategoryTag);
	
	/**
	 * 删除 ProjectCategoryTag
	 */
	public Result removeProjectCategoryTag(ProjectCategoryTag projectCategoryTag);
	
	/**
	 * 更新 ProjectCategoryTag
	 */
	public Result modifyProjectCategoryTag(ProjectCategoryTag projectCategoryTag);
	/**
	 * 查询列表
	 */
	public List queryProjectCategoryTagList(ProjectCategoryTagCondition condition);
	/**
	 * 分页查询
	 */
	public Page queryProjectCategoryTagPage(ProjectCategoryTagCondition condition);
	
	
	public ProjectCategoryTag queryProjectCategoryTagById(Long id);	
	
}
