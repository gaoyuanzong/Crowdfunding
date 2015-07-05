/*
 * Powered By [up72-framework]
 * Web Site: http://www.up72.com
 * Since 2006 - 2015
 */


package com.crowdfunding.web.action;

import org.apache.log4j.Logger;
import org.apache.commons.lang.StringUtils;

import com.crowdfunding.core.common.Result;
import com.crowdfunding.core.constants.EMessageCode;
import com.crowdfunding.core.constants.EOperator;


import com.crowdfunding.core.condition.ProjectCategoryTagCondition;
import com.crowdfunding.core.domain.ProjectCategoryTag;
import com.crowdfunding.core.service.IProjectCategoryTagService;
import com.crowdfunding.web.common.Authority;
import com.crowdfunding.web.common.BaseAction;

public class AdminProjectCategoryTagAction extends BaseAction{
	public static Logger logger = Logger.getLogger(AdminProjectCategoryTagAction.class);
	
	private IProjectCategoryTagService projectCategoryTagService;
	
	private ProjectCategoryTagCondition projectCategoryTagCondition;

	private ProjectCategoryTag projectCategoryTag;
	
	
	/**
	 * 入口
	 * @return
	 */
	@Authority(operator=EOperator.SELECT)
	public String index() {
		return "projectCategoryTag-index";
	}
	@Authority(operator=EOperator.SELECT)
	public String indexTag() {
		return "projectLableTag-index";
	}
	/**
	 * 列表
	 * @return
	 */
	@Authority(operator=EOperator.SELECT)
	public String data(){
		try{
			page=projectCategoryTagService.queryProjectCategoryTagPage(projectCategoryTagCondition);
		}catch (Exception e) {
			logger.error(e);
		}
		return "json-page";
	}
	/**
	 * 跳转到增加页面
	 * @return
	 */
	@Authority(operator=EOperator.ADD)
	public String toAdd() {
		return "projectCategoryTag-add";
	}
	@Authority(operator=EOperator.ADD)
	public String toAddLable() {
		return "projectLableTag-add";
	}
	/**
	 * 跳转到编辑页面
	 * @return
	 */
	@Authority(operator=EOperator.MODIFY)
	public String toEdit() {
		try{
			projectCategoryTag=projectCategoryTagService.queryProjectCategoryTagById(projectCategoryTag.getId());
		}catch (Exception e) {
			logger.error(e);
		}
		return "projectCategoryTag-edit";
	}
	@Authority(operator=EOperator.MODIFY)
	public String toEditLable() {
		try{
			projectCategoryTag=projectCategoryTagService.queryProjectCategoryTagById(projectCategoryTag.getId());
		}catch (Exception e) {
			logger.error(e);
		}
		return "projectLableTag-edit";
	}
	
	
	/**
	 * 新增保存
	 * @return
	 */
	@Authority(operator=EOperator.ADD)
	public String doAdd() {
		try{
			result=projectCategoryTagService.addProjectCategoryTag(projectCategoryTag);
		}catch (Exception e) {
			logger.error(e);
			result=new Result<Object>(false, EMessageCode.EXCEPTION.getCode());
		}
		return "json-result";
	}
	
	/**
	 * 
	 * @return
	 */
	@Authority(operator=EOperator.MODIFY)
	public String doEdit() {
		try{
			result=projectCategoryTagService.modifyProjectCategoryTag(projectCategoryTag);
		}catch (Exception e) {
			logger.error(e);
			result=new Result<Object>(false,EMessageCode.EXCEPTION.getCode());
		}
		return "json-result";
	}
	/**
	 * 删除
	 */
	@Authority(operator=EOperator.DELETE)
	public String doDelete(){
		try{
			result=projectCategoryTagService.removeProjectCategoryTag(projectCategoryTag);
		}catch(Exception e){
			logger.error(e);
			result=new Result<Object>(false,EMessageCode.EXCEPTION.getCode());
		}
		return "json-result";
	}
	
	/** 
	 * get set 
	 **/
	public void setProjectCategoryTagService(IProjectCategoryTagService service) {
		this.projectCategoryTagService = service;
	}
	
	public IProjectCategoryTagService getProjectCategoryTagService() {
		return this.projectCategoryTagService;
	}
	
	public void setProjectCategoryTag(ProjectCategoryTag projectCategoryTag){
		this.projectCategoryTag=projectCategoryTag;
	}
	
	public ProjectCategoryTag getProjectCategoryTag(){
		return projectCategoryTag;
	}
	
	public void setProjectCategoryTagCondition(ProjectCategoryTagCondition projectCategoryTagCondition){
		this.projectCategoryTagCondition=projectCategoryTagCondition;
	}
	
	public ProjectCategoryTagCondition getProjectCategoryTagCondition(){
		return projectCategoryTagCondition;
	}
	
	
}

