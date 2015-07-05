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


import com.crowdfunding.core.condition.CfMoneyRecordCondition;
import com.crowdfunding.core.domain.CfMoneyRecord;
import com.crowdfunding.core.service.ICfMoneyRecordService;
import com.crowdfunding.web.common.Authority;
import com.crowdfunding.web.common.BaseAction;

public class AdminCfMoneyRecordAction extends BaseAction{
	public static Logger logger = Logger.getLogger(AdminCfMoneyRecordAction.class);
	
	private ICfMoneyRecordService cfMoneyRecordService;
	
	private CfMoneyRecordCondition cfMoneyRecordCondition;

	private CfMoneyRecord cfMoneyRecord;
	
	
	/**
	 * 入口
	 * @return
	 */
	@Authority(operator=EOperator.SELECT)
	public String index() {
		return "cfMoneyRecord-index";
	}
	/**
	 * 列表
	 * @return
	 */
	@Authority(operator=EOperator.SELECT)
	public String data(){
		try{
			page=cfMoneyRecordService.queryCfMoneyRecordPage(cfMoneyRecordCondition);
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
		return "cfMoneyRecord-add";
	}
	/**
	 * 跳转到编辑页面
	 * @return
	 */
	@Authority(operator=EOperator.MODIFY)
	public String toEdit() {
		try{
			cfMoneyRecord=cfMoneyRecordService.queryCfMoneyRecordById(cfMoneyRecord.getId());
		}catch (Exception e) {
			logger.error(e);
		}
		return "cfMoneyRecord-edit";
	}
	
	
	
	/**
	 * 新增保存
	 * @return
	 */
	@Authority(operator=EOperator.ADD)
	public String doAdd() {
		try{
			result=cfMoneyRecordService.addCfMoneyRecord(cfMoneyRecord);
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
			result=cfMoneyRecordService.modifyCfMoneyRecord(cfMoneyRecord);
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
			result=cfMoneyRecordService.removeCfMoneyRecord(cfMoneyRecord);
		}catch(Exception e){
			logger.error(e);
			result=new Result<Object>(false,EMessageCode.EXCEPTION.getCode());
		}
		return "json-result";
	}
	
	/** 
	 * get set 
	 **/
	public void setCfMoneyRecordService(ICfMoneyRecordService service) {
		this.cfMoneyRecordService = service;
	}
	
	public ICfMoneyRecordService getCfMoneyRecordService() {
		return this.cfMoneyRecordService;
	}
	
	public void setCfMoneyRecord(CfMoneyRecord cfMoneyRecord){
		this.cfMoneyRecord=cfMoneyRecord;
	}
	
	public CfMoneyRecord getCfMoneyRecord(){
		return cfMoneyRecord;
	}
	
	public void setCfMoneyRecordCondition(CfMoneyRecordCondition cfMoneyRecordCondition){
		this.cfMoneyRecordCondition=cfMoneyRecordCondition;
	}
	
	public CfMoneyRecordCondition getCfMoneyRecordCondition(){
		return cfMoneyRecordCondition;
	}
	
	
}

