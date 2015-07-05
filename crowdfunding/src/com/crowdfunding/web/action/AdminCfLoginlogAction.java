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


import com.crowdfunding.core.condition.CfLoginlogCondition;
import com.crowdfunding.core.domain.CfLoginlog;
import com.crowdfunding.core.service.ICfLoginlogService;
import com.crowdfunding.web.common.Authority;
import com.crowdfunding.web.common.BaseAction;

public class AdminCfLoginlogAction extends BaseAction{
	public static Logger logger = Logger.getLogger(AdminCfLoginlogAction.class);
	
	private ICfLoginlogService cfLoginlogService;
	
	private CfLoginlogCondition cfLoginlogCondition;

	private CfLoginlog cfLoginlog;
	
	
	/**
	 * 入口
	 * @return
	 */
	@Authority(operator=EOperator.SELECT)
	public String index() {
		return "cfLoginlog-index";
	}
	/**
	 * 列表
	 * @return
	 */
	@Authority(operator=EOperator.SELECT)
	public String data(){
		try{
			page=cfLoginlogService.queryCfLoginlogPage(cfLoginlogCondition);
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
		return "cfLoginlog-add";
	}
	/**
	 * 跳转到编辑页面
	 * @return
	 */
	@Authority(operator=EOperator.MODIFY)
	public String toEdit() {
		try{
			cfLoginlog=cfLoginlogService.queryCfLoginlogById(cfLoginlog.getId());
		}catch (Exception e) {
			logger.error(e);
		}
		return "cfLoginlog-edit";
	}
	
	
	
	/**
	 * 新增保存
	 * @return
	 */
	@Authority(operator=EOperator.ADD)
	public String doAdd() {
		try{
			result=cfLoginlogService.addCfLoginlog(cfLoginlog);
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
			result=cfLoginlogService.modifyCfLoginlog(cfLoginlog);
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
			result=cfLoginlogService.removeCfLoginlog(cfLoginlog);
		}catch(Exception e){
			logger.error(e);
			result=new Result<Object>(false,EMessageCode.EXCEPTION.getCode());
		}
		return "json-result";
	}
	
	/** 
	 * get set 
	 **/
	public void setCfLoginlogService(ICfLoginlogService service) {
		this.cfLoginlogService = service;
	}
	
	public ICfLoginlogService getCfLoginlogService() {
		return this.cfLoginlogService;
	}
	
	public void setCfLoginlog(CfLoginlog cfLoginlog){
		this.cfLoginlog=cfLoginlog;
	}
	
	public CfLoginlog getCfLoginlog(){
		return cfLoginlog;
	}
	
	public void setCfLoginlogCondition(CfLoginlogCondition cfLoginlogCondition){
		this.cfLoginlogCondition=cfLoginlogCondition;
	}
	
	public CfLoginlogCondition getCfLoginlogCondition(){
		return cfLoginlogCondition;
	}
	
	
}

