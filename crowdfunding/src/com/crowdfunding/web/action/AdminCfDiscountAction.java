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


import com.crowdfunding.core.condition.CfDiscountCondition;
import com.crowdfunding.core.domain.CfDiscount;
import com.crowdfunding.core.service.ICfDiscountService;
import com.crowdfunding.web.common.Authority;
import com.crowdfunding.web.common.BaseAction;

public class AdminCfDiscountAction extends BaseAction{
	public static Logger logger = Logger.getLogger(AdminCfDiscountAction.class);
	
	private ICfDiscountService cfDiscountService;
	
	private CfDiscountCondition cfDiscountCondition;

	private CfDiscount cfDiscount;
	
	
	/**
	 * 入口
	 * @return
	 */
	@Authority(operator=EOperator.SELECT)
	public String index() {
		return "cfDiscount-index";
	}
	/**
	 * 列表
	 * @return
	 */
	@Authority(operator=EOperator.SELECT)
	public String data(){
		try{
			page=cfDiscountService.queryCfDiscountPage(cfDiscountCondition);
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
		return "cfDiscount-add";
	}
	/**
	 * 跳转到编辑页面
	 * @return
	 */
	@Authority(operator=EOperator.MODIFY)
	public String toEdit() {
		try{
			cfDiscount=cfDiscountService.queryCfDiscountById(cfDiscount.getId());
		}catch (Exception e) {
			logger.error(e);
		}
		return "cfDiscount-edit";
	}
	
	
	
	/**
	 * 新增保存
	 * @return
	 */
	@Authority(operator=EOperator.ADD)
	public String doAdd() {
		try{
			result=cfDiscountService.addCfDiscount(cfDiscount);
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
			result=cfDiscountService.modifyCfDiscount(cfDiscount);
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
			result=cfDiscountService.removeCfDiscount(cfDiscount);
		}catch(Exception e){
			logger.error(e);
			result=new Result<Object>(false,EMessageCode.EXCEPTION.getCode());
		}
		return "json-result";
	}
	
	/** 
	 * get set 
	 **/
	public void setCfDiscountService(ICfDiscountService service) {
		this.cfDiscountService = service;
	}
	
	public ICfDiscountService getCfDiscountService() {
		return this.cfDiscountService;
	}
	
	public void setCfDiscount(CfDiscount cfDiscount){
		this.cfDiscount=cfDiscount;
	}
	
	public CfDiscount getCfDiscount(){
		return cfDiscount;
	}
	
	public void setCfDiscountCondition(CfDiscountCondition cfDiscountCondition){
		this.cfDiscountCondition=cfDiscountCondition;
	}
	
	public CfDiscountCondition getCfDiscountCondition(){
		return cfDiscountCondition;
	}
	
	
}

