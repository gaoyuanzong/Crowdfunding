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


import com.crowdfunding.core.condition.CfQuestionCondition;
import com.crowdfunding.core.domain.CfQuestion;
import com.crowdfunding.core.service.ICfQuestionService;
import com.crowdfunding.web.common.Authority;
import com.crowdfunding.web.common.BaseAction;

public class AdminCfQuestionAction extends BaseAction{
	public static Logger logger = Logger.getLogger(AdminCfQuestionAction.class);
	
	private ICfQuestionService cfQuestionService;
	
	private CfQuestionCondition cfQuestionCondition;

	private CfQuestion cfQuestion;
	
	
	/**
	 * 入口
	 * @return
	 */
	@Authority(operator=EOperator.SELECT)
	public String index() {
		return "cfQuestion-index";
	}
	/**
	 * 列表
	 * @return
	 */
	@Authority(operator=EOperator.SELECT)
	public String data(){
		try{
			page=cfQuestionService.queryCfQuestionPage(cfQuestionCondition);
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
		return "cfQuestion-add";
	}
	/**
	 * 跳转到编辑页面
	 * @return
	 */
	@Authority(operator=EOperator.MODIFY)
	public String toEdit() {
		try{
			cfQuestion=cfQuestionService.queryCfQuestionById(cfQuestion.getId());
		}catch (Exception e) {
			logger.error(e);
		}
		return "cfQuestion-edit";
	}
	
	
	
	/**
	 * 新增保存
	 * @return
	 */
	@Authority(operator=EOperator.ADD)
	public String doAdd() {
		try{
			result=cfQuestionService.addCfQuestion(cfQuestion);
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
			result=cfQuestionService.modifyCfQuestion(cfQuestion);
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
			result=cfQuestionService.removeCfQuestion(cfQuestion);
		}catch(Exception e){
			logger.error(e);
			result=new Result<Object>(false,EMessageCode.EXCEPTION.getCode());
		}
		return "json-result";
	}
	
	/** 
	 * get set 
	 **/
	public void setCfQuestionService(ICfQuestionService service) {
		this.cfQuestionService = service;
	}
	
	public ICfQuestionService getCfQuestionService() {
		return this.cfQuestionService;
	}
	
	public void setCfQuestion(CfQuestion cfQuestion){
		this.cfQuestion=cfQuestion;
	}
	
	public CfQuestion getCfQuestion(){
		return cfQuestion;
	}
	
	public void setCfQuestionCondition(CfQuestionCondition cfQuestionCondition){
		this.cfQuestionCondition=cfQuestionCondition;
	}
	
	public CfQuestionCondition getCfQuestionCondition(){
		return cfQuestionCondition;
	}
	
	
}

