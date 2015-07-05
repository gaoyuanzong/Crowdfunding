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


import com.crowdfunding.core.condition.CfIntegralCondition;
import com.crowdfunding.core.domain.CfIntegral;
import com.crowdfunding.core.service.ICfIntegralService;
import com.crowdfunding.web.common.Authority;
import com.crowdfunding.web.common.BaseAction;

public class AdminCfIntegralAction extends BaseAction{
	public static Logger logger = Logger.getLogger(AdminCfIntegralAction.class);
	
	private ICfIntegralService cfIntegralService;
	
	private CfIntegralCondition cfIntegralCondition;

	private CfIntegral cfIntegral;
	
	
	/**
	 * 入口
	 * @return
	 */
	@Authority(operator=EOperator.SELECT)
	public String index() {
		return "cfIntegral-index";
	}
	/**
	 * 列表
	 * @return
	 */
	@Authority(operator=EOperator.SELECT)
	public String data(){
		try{
			page=cfIntegralService.queryCfIntegralPage(cfIntegralCondition);
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
		return "cfIntegral-add";
	}
	/**
	 * 跳转到编辑页面
	 * @return
	 */
	@Authority(operator=EOperator.MODIFY)
	public String toEdit() {
		try{
			cfIntegral=cfIntegralService.queryCfIntegralById(cfIntegral.getId());
		}catch (Exception e) {
			logger.error(e);
		}
		return "cfIntegral-edit";
	}
	
	
	
	/**
	 * 新增保存
	 * @return
	 */
	@Authority(operator=EOperator.ADD)
	public String doAdd() {
		try{
			result=cfIntegralService.addCfIntegral(cfIntegral);
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
			result=cfIntegralService.modifyCfIntegral(cfIntegral);
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
			result=cfIntegralService.removeCfIntegral(cfIntegral);
		}catch(Exception e){
			logger.error(e);
			result=new Result<Object>(false,EMessageCode.EXCEPTION.getCode());
		}
		return "json-result";
	}
	
	/** 
	 * get set 
	 **/
	public void setCfIntegralService(ICfIntegralService service) {
		this.cfIntegralService = service;
	}
	
	public ICfIntegralService getCfIntegralService() {
		return this.cfIntegralService;
	}
	
	public void setCfIntegral(CfIntegral cfIntegral){
		this.cfIntegral=cfIntegral;
	}
	
	public CfIntegral getCfIntegral(){
		return cfIntegral;
	}
	
	public void setCfIntegralCondition(CfIntegralCondition cfIntegralCondition){
		this.cfIntegralCondition=cfIntegralCondition;
	}
	
	public CfIntegralCondition getCfIntegralCondition(){
		return cfIntegralCondition;
	}
	
	
}

