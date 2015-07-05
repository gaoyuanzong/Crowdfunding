/*
 * Powered By [up72-framework]
 * Web Site: http://www.up72.com
 * Since 2006 - 2015
 */

package com.crowdfunding.core.service;

import java.util.List;

import org.apache.log4j.Logger;
import com.crowdfunding.core.common.Page;
import com.crowdfunding.core.domain.Project;
import com.crowdfunding.core.common.Result;

import com.crowdfunding.core.condition.ProjectCondition;
/**
 * 项目业务处理
 * 
 * @author alive auto create
 * @version 1.0
 * @since 1.0
 */

public interface IProjectService {
	public static Logger logger = Logger.getLogger(IProjectService.class);
		
	/**
	 * 保存 Project
	 */
	public Result addProject(Project project);
	
	/**
	 * 删除 Project
	 */
	public Result removeProject(Project project);
	
	/**
	 * 更新 Project
	 */
	public Result modifyProject(Project project);
	/**
	 * 查询列表
	 */
	public List queryProjectList(ProjectCondition condition);
	/**
	 * 分页查询
	 */
	public Page queryProjectPage(ProjectCondition condition);
	
	
	public Project queryProjectById(Long id);	
	
}
