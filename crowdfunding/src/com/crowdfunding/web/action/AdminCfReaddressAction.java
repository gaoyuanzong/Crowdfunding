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


import com.crowdfunding.core.condition.CfReaddressCondition;
import com.crowdfunding.core.domain.CfReaddress;
import com.crowdfunding.core.service.ICfReaddressService;
import com.crowdfunding.web.common.Authority;
import com.crowdfunding.web.common.BaseAction;

public class AdminCfReaddressAction extends BaseAction{
	public static Logger logger = Logger.getLogger(AdminCfReaddressAction.class);
	
	private ICfReaddressService cfReaddressService;
	
	private CfReaddressCondition cfReaddressCondition;

	private CfReaddress cfReaddress;
	
	
	/**
	 * 入口
	 * @return
	 */
	@Authority(operator=EOperator.SELECT)
	public String index() {
		return "cfReaddress-index";
	}
	/**
	 * 列表
	 * @return
	 */
	@Authority(operator=EOperator.SELECT)
	public String data(){
		try{
			page=cfReaddressService.queryCfReaddressPage(cfReaddressCondition);
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
		return "cfReaddress-add";
	}
	/**
	 * 跳转到编辑页面
	 * @return
	 */
	@Authority(operator=EOperator.MODIFY)
	public String toEdit() {
		try{
			cfReaddress=cfReaddressService.queryCfReaddressById(cfReaddress.getId());
		}catch (Exception e) {
			logger.error(e);
		}
		return "cfReaddress-edit";
	}
	
	
	
	/**
	 * 新增保存
	 * @return
	 */
	@Authority(operator=EOperator.ADD)
	public String doAdd() {
		try{
			result=cfReaddressService.addCfReaddress(cfReaddress);
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
			result=cfReaddressService.modifyCfReaddress(cfReaddress);
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
			result=cfReaddressService.removeCfReaddress(cfReaddress);
		}catch(Exception e){
			logger.error(e);
			result=new Result<Object>(false,EMessageCode.EXCEPTION.getCode());
		}
		return "json-result";
	}
	
	/** 
	 * get set 
	 **/
	public void setCfReaddressService(ICfReaddressService service) {
		this.cfReaddressService = service;
	}
	
	public ICfReaddressService getCfReaddressService() {
		return this.cfReaddressService;
	}
	
	public void setCfReaddress(CfReaddress cfReaddress){
		this.cfReaddress=cfReaddress;
	}
	
	public CfReaddress getCfReaddress(){
		return cfReaddress;
	}
	
	public void setCfReaddressCondition(CfReaddressCondition cfReaddressCondition){
		this.cfReaddressCondition=cfReaddressCondition;
	}
	
	public CfReaddressCondition getCfReaddressCondition(){
		return cfReaddressCondition;
	}
	
	
}

