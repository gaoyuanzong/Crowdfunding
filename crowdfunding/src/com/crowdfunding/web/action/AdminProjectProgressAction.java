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


import com.crowdfunding.core.condition.ProjectProgressCondition;
import com.crowdfunding.core.domain.ProjectProgress;
import com.crowdfunding.core.service.IProjectProgressService;
import com.crowdfunding.web.common.Authority;
import com.crowdfunding.web.common.BaseAction;

public class AdminProjectProgressAction extends BaseAction{
	public static Logger logger = Logger.getLogger(AdminProjectProgressAction.class);
	
	private IProjectProgressService projectProgressService;
	
	private ProjectProgressCondition projectProgressCondition;

	private ProjectProgress projectProgress;
	
	
	/**
	 * 入口
	 * @return
	 */
	@Authority(operator=EOperator.SELECT)
	public String index() {
		return "projectProgress-index";
	}
	/**
	 * 列表
	 * @return
	 */
	@Authority(operator=EOperator.SELECT)
	public String data(){
		try{
			page=projectProgressService.queryProjectProgressPage(projectProgressCondition);
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
		return "projectProgress-add";
	}
	/**
	 * 跳转到编辑页面
	 * @return
	 */
	@Authority(operator=EOperator.MODIFY)
	public String toEdit() {
		try{
			projectProgress=projectProgressService.queryProjectProgressById(projectProgress.getId());
		}catch (Exception e) {
			logger.error(e);
		}
		return "projectProgress-edit";
	}
	
	
	
	/**
	 * 新增保存
	 * @return
	 */
	@Authority(operator=EOperator.ADD)
	public String doAdd() {
		try{
			result=projectProgressService.addProjectProgress(projectProgress);
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
			result=projectProgressService.modifyProjectProgress(projectProgress);
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
			result=projectProgressService.removeProjectProgress(projectProgress);
		}catch(Exception e){
			logger.error(e);
			result=new Result<Object>(false,EMessageCode.EXCEPTION.getCode());
		}
		return "json-result";
	}
	
	/** 
	 * get set 
	 **/
	public void setProjectProgressService(IProjectProgressService service) {
		this.projectProgressService = service;
	}
	
	public IProjectProgressService getProjectProgressService() {
		return this.projectProgressService;
	}
	
	public void setProjectProgress(ProjectProgress projectProgress){
		this.projectProgress=projectProgress;
	}
	
	public ProjectProgress getProjectProgress(){
		return projectProgress;
	}
	
	public void setProjectProgressCondition(ProjectProgressCondition projectProgressCondition){
		this.projectProgressCondition=projectProgressCondition;
	}
	
	public ProjectProgressCondition getProjectProgressCondition(){
		return projectProgressCondition;
	}
	
	
}

