/*
 * Powered By [up72-framework]
 * Web Site: http://www.up72.com
 * Since 2006 - 2015
 */

package com.crowdfunding.core.service;

import java.util.List;

import org.apache.log4j.Logger;
import com.crowdfunding.core.common.Page;
import com.crowdfunding.core.domain.ProjectProgress;
import com.crowdfunding.core.common.Result;

import com.crowdfunding.core.condition.ProjectProgressCondition;
/**
 * 项目进度业务处理
 * 
 * @author alive auto create
 * @version 1.0
 * @since 1.0
 */

public interface IProjectProgressService {
	public static Logger logger = Logger.getLogger(IProjectProgressService.class);
		
	/**
	 * 保存 ProjectProgress
	 */
	public Result addProjectProgress(ProjectProgress projectProgress);
	
	/**
	 * 删除 ProjectProgress
	 */
	public Result removeProjectProgress(ProjectProgress projectProgress);
	
	/**
	 * 更新 ProjectProgress
	 */
	public Result modifyProjectProgress(ProjectProgress projectProgress);
	/**
	 * 查询列表
	 */
	public List queryProjectProgressList(ProjectProgressCondition condition);
	/**
	 * 分页查询
	 */
	public Page queryProjectProgressPage(ProjectProgressCondition condition);
	
	
	public ProjectProgress queryProjectProgressById(Long id);	
	
}
