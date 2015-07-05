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


import com.crowdfunding.core.condition.ProjectRefundCondition;
import com.crowdfunding.core.domain.ProjectRefund;
import com.crowdfunding.core.service.IProjectRefundService;
import com.crowdfunding.web.common.Authority;
import com.crowdfunding.web.common.BaseAction;

public class AdminProjectRefundAction extends BaseAction{
	public static Logger logger = Logger.getLogger(AdminProjectRefundAction.class);
	
	private IProjectRefundService projectRefundService;
	
	private ProjectRefundCondition projectRefundCondition;

	private ProjectRefund projectRefund;
	
	
	/**
	 * 入口
	 * @return
	 */
	@Authority(operator=EOperator.SELECT)
	public String index() {
		return "projectRefund-index";
	}
	/**
	 * 列表
	 * @return
	 */
	@Authority(operator=EOperator.SELECT)
	public String data(){
		try{
			page=projectRefundService.queryProjectRefundPage(projectRefundCondition);
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
		return "projectRefund-add";
	}
	/**
	 * 跳转到编辑页面
	 * @return
	 */
	@Authority(operator=EOperator.MODIFY)
	public String toEdit() {
		try{
			projectRefund=projectRefundService.queryProjectRefundById(projectRefund.getId());
		}catch (Exception e) {
			logger.error(e);
		}
		return "projectRefund-edit";
	}
	
	
	
	/**
	 * 新增保存
	 * @return
	 */
	@Authority(operator=EOperator.ADD)
	public String doAdd() {
		try{
			result=projectRefundService.addProjectRefund(projectRefund);
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
			result=projectRefundService.modifyProjectRefund(projectRefund);
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
			result=projectRefundService.removeProjectRefund(projectRefund);
		}catch(Exception e){
			logger.error(e);
			result=new Result<Object>(false,EMessageCode.EXCEPTION.getCode());
		}
		return "json-result";
	}
	
	/** 
	 * get set 
	 **/
	public void setProjectRefundService(IProjectRefundService service) {
		this.projectRefundService = service;
	}
	
	public IProjectRefundService getProjectRefundService() {
		return this.projectRefundService;
	}
	
	public void setProjectRefund(ProjectRefund projectRefund){
		this.projectRefund=projectRefund;
	}
	
	public ProjectRefund getProjectRefund(){
		return projectRefund;
	}
	
	public void setProjectRefundCondition(ProjectRefundCondition projectRefundCondition){
		this.projectRefundCondition=projectRefundCondition;
	}
	
	public ProjectRefundCondition getProjectRefundCondition(){
		return projectRefundCondition;
	}
	
	
}

