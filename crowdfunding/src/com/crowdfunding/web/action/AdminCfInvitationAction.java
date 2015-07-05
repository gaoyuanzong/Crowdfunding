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


import com.crowdfunding.core.condition.CfInvitationCondition;
import com.crowdfunding.core.domain.CfInvitation;
import com.crowdfunding.core.service.ICfInvitationService;
import com.crowdfunding.web.common.Authority;
import com.crowdfunding.web.common.BaseAction;

public class AdminCfInvitationAction extends BaseAction{
	public static Logger logger = Logger.getLogger(AdminCfInvitationAction.class);
	
	private ICfInvitationService cfInvitationService;
	
	private CfInvitationCondition cfInvitationCondition;

	private CfInvitation cfInvitation;
	
	
	/**
	 * 入口
	 * @return
	 */
	@Authority(operator=EOperator.SELECT)
	public String index() {
		return "cfInvitation-index";
	}
	/**
	 * 列表
	 * @return
	 */
	@Authority(operator=EOperator.SELECT)
	public String data(){
		try{
			page=cfInvitationService.queryCfInvitationPage(cfInvitationCondition);
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
		return "cfInvitation-add";
	}
	/**
	 * 跳转到编辑页面
	 * @return
	 */
	@Authority(operator=EOperator.MODIFY)
	public String toEdit() {
		try{
			cfInvitation=cfInvitationService.queryCfInvitationById(cfInvitation.getId());
		}catch (Exception e) {
			logger.error(e);
		}
		return "cfInvitation-edit";
	}
	
	
	
	/**
	 * 新增保存
	 * @return
	 */
	@Authority(operator=EOperator.ADD)
	public String doAdd() {
		try{
			result=cfInvitationService.addCfInvitation(cfInvitation);
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
			result=cfInvitationService.modifyCfInvitation(cfInvitation);
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
			result=cfInvitationService.removeCfInvitation(cfInvitation);
		}catch(Exception e){
			logger.error(e);
			result=new Result<Object>(false,EMessageCode.EXCEPTION.getCode());
		}
		return "json-result";
	}
	
	/** 
	 * get set 
	 **/
	public void setCfInvitationService(ICfInvitationService service) {
		this.cfInvitationService = service;
	}
	
	public ICfInvitationService getCfInvitationService() {
		return this.cfInvitationService;
	}
	
	public void setCfInvitation(CfInvitation cfInvitation){
		this.cfInvitation=cfInvitation;
	}
	
	public CfInvitation getCfInvitation(){
		return cfInvitation;
	}
	
	public void setCfInvitationCondition(CfInvitationCondition cfInvitationCondition){
		this.cfInvitationCondition=cfInvitationCondition;
	}
	
	public CfInvitationCondition getCfInvitationCondition(){
		return cfInvitationCondition;
	}
	
	
}

