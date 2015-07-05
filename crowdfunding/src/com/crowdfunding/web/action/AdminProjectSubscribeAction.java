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


import com.crowdfunding.core.condition.ProjectSubscribeCondition;
import com.crowdfunding.core.domain.ProjectSubscribe;
import com.crowdfunding.core.service.IProjectSubscribeService;
import com.crowdfunding.web.common.Authority;
import com.crowdfunding.web.common.BaseAction;

public class AdminProjectSubscribeAction extends BaseAction{
	public static Logger logger = Logger.getLogger(AdminProjectSubscribeAction.class);
	
	private IProjectSubscribeService projectSubscribeService;
	
	private ProjectSubscribeCondition projectSubscribeCondition;

	private ProjectSubscribe projectSubscribe;
	
	
	/**
	 * 入口
	 * @return
	 */
	@Authority(operator=EOperator.SELECT)
	public String index() {
		return "projectSubscribe-index";
	}
	/**
	 * 列表
	 * @return
	 */
	@Authority(operator=EOperator.SELECT)
	public String data(){
		try{
			page=projectSubscribeService.queryProjectSubscribePage(projectSubscribeCondition);
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
		return "projectSubscribe-add";
	}
	/**
	 * 跳转到编辑页面
	 * @return
	 */
	@Authority(operator=EOperator.MODIFY)
	public String toEdit() {
		try{
			projectSubscribe=projectSubscribeService.queryProjectSubscribeById(projectSubscribe.getId());
		}catch (Exception e) {
			logger.error(e);
		}
		return "projectSubscribe-edit";
	}
	
	
	
	/**
	 * 新增保存
	 * @return
	 */
	@Authority(operator=EOperator.ADD)
	public String doAdd() {
		try{
			result=projectSubscribeService.addProjectSubscribe(projectSubscribe);
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
			result=projectSubscribeService.modifyProjectSubscribe(projectSubscribe);
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
			result=projectSubscribeService.removeProjectSubscribe(projectSubscribe);
		}catch(Exception e){
			logger.error(e);
			result=new Result<Object>(false,EMessageCode.EXCEPTION.getCode());
		}
		return "json-result";
	}
	
	/** 
	 * get set 
	 **/
	public void setProjectSubscribeService(IProjectSubscribeService service) {
		this.projectSubscribeService = service;
	}
	
	public IProjectSubscribeService getProjectSubscribeService() {
		return this.projectSubscribeService;
	}
	
	public void setProjectSubscribe(ProjectSubscribe projectSubscribe){
		this.projectSubscribe=projectSubscribe;
	}
	
	public ProjectSubscribe getProjectSubscribe(){
		return projectSubscribe;
	}
	
	public void setProjectSubscribeCondition(ProjectSubscribeCondition projectSubscribeCondition){
		this.projectSubscribeCondition=projectSubscribeCondition;
	}
	
	public ProjectSubscribeCondition getProjectSubscribeCondition(){
		return projectSubscribeCondition;
	}
	
	
}

