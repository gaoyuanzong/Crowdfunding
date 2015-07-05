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


import com.crowdfunding.core.condition.CfInformationCondition;
import com.crowdfunding.core.domain.CfInformation;
import com.crowdfunding.core.service.ICfInformationService;
import com.crowdfunding.web.common.Authority;
import com.crowdfunding.web.common.BaseAction;

public class AdminCfInformationAction extends BaseAction{
	public static Logger logger = Logger.getLogger(AdminCfInformationAction.class);
	
	private ICfInformationService cfInformationService;
	
	private CfInformationCondition cfInformationCondition;

	private CfInformation cfInformation;
	
	
	/**
	 * 入口
	 * @return
	 */
	@Authority(operator=EOperator.SELECT)
	public String index() {
		return "cfInformation-index";
	}
	/**
	 * 列表
	 * @return
	 */
	@Authority(operator=EOperator.SELECT)
	public String data(){
		try{
			page=cfInformationService.queryCfInformationPage(cfInformationCondition);
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
		return "cfInformation-add";
	}
	/**
	 * 跳转到编辑页面
	 * @return
	 */
	@Authority(operator=EOperator.MODIFY)
	public String toEdit() {
		try{
			cfInformation=cfInformationService.queryCfInformationById(cfInformation.getId());
		}catch (Exception e) {
			logger.error(e);
		}
		return "cfInformation-edit";
	}
	
	
	
	/**
	 * 新增保存
	 * @return
	 */
	@Authority(operator=EOperator.ADD)
	public String doAdd() {
		try{
			result=cfInformationService.addCfInformation(cfInformation);
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
			result=cfInformationService.modifyCfInformation(cfInformation);
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
			result=cfInformationService.removeCfInformation(cfInformation);
		}catch(Exception e){
			logger.error(e);
			result=new Result<Object>(false,EMessageCode.EXCEPTION.getCode());
		}
		return "json-result";
	}
	
	/** 
	 * get set 
	 **/
	public void setCfInformationService(ICfInformationService service) {
		this.cfInformationService = service;
	}
	
	public ICfInformationService getCfInformationService() {
		return this.cfInformationService;
	}
	
	public void setCfInformation(CfInformation cfInformation){
		this.cfInformation=cfInformation;
	}
	
	public CfInformation getCfInformation(){
		return cfInformation;
	}
	
	public void setCfInformationCondition(CfInformationCondition cfInformationCondition){
		this.cfInformationCondition=cfInformationCondition;
	}
	
	public CfInformationCondition getCfInformationCondition(){
		return cfInformationCondition;
	}
	
	
}

