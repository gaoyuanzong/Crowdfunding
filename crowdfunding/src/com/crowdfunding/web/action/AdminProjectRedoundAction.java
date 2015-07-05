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


import com.crowdfunding.core.condition.ProjectRedoundCondition;
import com.crowdfunding.core.domain.ProjectRedound;
import com.crowdfunding.core.service.IProjectRedoundService;
import com.crowdfunding.web.common.Authority;
import com.crowdfunding.web.common.BaseAction;

public class AdminProjectRedoundAction extends BaseAction{
	public static Logger logger = Logger.getLogger(AdminProjectRedoundAction.class);
	
	private IProjectRedoundService projectRedoundService;
	
	private ProjectRedoundCondition projectRedoundCondition;

	private ProjectRedound projectRedound;
	
	
	/**
	 * 入口
	 * @return
	 */
	@Authority(operator=EOperator.SELECT)
	public String index() {
		return "projectRedound-index";
	}
	/**
	 * 列表
	 * @return
	 */
	@Authority(operator=EOperator.SELECT)
	public String data(){
		try{
			page=projectRedoundService.queryProjectRedoundPage(projectRedoundCondition);
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
		return "projectRedound-add";
	}
	/**
	 * 跳转到编辑页面
	 * @return
	 */
	@Authority(operator=EOperator.MODIFY)
	public String toEdit() {
		try{
			projectRedound=projectRedoundService.queryProjectRedoundById(projectRedound.getId());
		}catch (Exception e) {
			logger.error(e);
		}
		return "projectRedound-edit";
	}
	
	
	
	/**
	 * 新增保存
	 * @return
	 */
	@Authority(operator=EOperator.ADD)
	public String doAdd() {
		try{
			result=projectRedoundService.addProjectRedound(projectRedound);
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
			result=projectRedoundService.modifyProjectRedound(projectRedound);
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
			result=projectRedoundService.removeProjectRedound(projectRedound);
		}catch(Exception e){
			logger.error(e);
			result=new Result<Object>(false,EMessageCode.EXCEPTION.getCode());
		}
		return "json-result";
	}
	
	/** 
	 * get set 
	 **/
	public void setProjectRedoundService(IProjectRedoundService service) {
		this.projectRedoundService = service;
	}
	
	public IProjectRedoundService getProjectRedoundService() {
		return this.projectRedoundService;
	}
	
	public void setProjectRedound(ProjectRedound projectRedound){
		this.projectRedound=projectRedound;
	}
	
	public ProjectRedound getProjectRedound(){
		return projectRedound;
	}
	
	public void setProjectRedoundCondition(ProjectRedoundCondition projectRedoundCondition){
		this.projectRedoundCondition=projectRedoundCondition;
	}
	
	public ProjectRedoundCondition getProjectRedoundCondition(){
		return projectRedoundCondition;
	}
	
	
}

