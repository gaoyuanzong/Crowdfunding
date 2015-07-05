/*
 * Powered By [up72-framework]
 * Web Site: http://www.up72.com
 * Since 2006 - 2015
 */


package com.crowdfunding.web.action;

import org.apache.log4j.Logger;

import com.crowdfunding.core.common.Result;
import com.crowdfunding.core.condition.CfUserCondition;
import com.crowdfunding.core.constants.EMessageCode;
import com.crowdfunding.core.constants.EOperator;
import com.crowdfunding.core.domain.CfUser;
import com.crowdfunding.core.service.ICfUserService;
import com.crowdfunding.web.common.Authority;
import com.crowdfunding.web.common.BaseAction;

public class AdminCfUserAction extends BaseAction{
	private static final long serialVersionUID = -2196779895158438388L;

	public static Logger logger = Logger.getLogger(AdminCfUserAction.class);
	
	private ICfUserService cfUserService;
	
	private CfUserCondition cfUserCondition;

	private CfUser cfUser;
	
	
	/**
	 * 入口
	 * @return
	 */
	@Authority(operator=EOperator.SELECT)
	public String index() {
		return "cfUser-index";
	}
	/**
	 * 新增项目查询用户列表
	 * @return
	 */
	@Authority(operator=EOperator.SELECT)
	public String selectUsersData(){
		try{
			cfUserCondition.setIsLock(0);//没有锁定
			cfUserCondition.setIsActivate(1);//已经激活
			page=cfUserService.queryCfUserPage(cfUserCondition);
		}catch (Exception e) {
			logger.error(e);
		}
		return "json-page";
	}
	/**
	 * 列表
	 * @return
	 */
	@Authority(operator=EOperator.SELECT)
	public String data(){
		try{
			page=cfUserService.queryCfUserPage(cfUserCondition);
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
		return "cfUser-add";
	}
	/**
	 * 跳转到编辑页面
	 * @return
	 */
	@Authority(operator=EOperator.MODIFY)
	public String toEdit() {
		try{
			cfUser=cfUserService.queryCfUserById(cfUser.getId());
		}catch (Exception e) {
			logger.error(e);
		}
		return "cfUser-edit";
	}
	
	
	
	/**
	 * 新增保存
	 * @return
	 */
	@Authority(operator=EOperator.ADD)
	public String doAdd() {
		try{
			result=cfUserService.addCfUser(cfUser);
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
			result=cfUserService.modifyCfUser(cfUser);
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
			result=cfUserService.removeCfUser(cfUser);
		}catch(Exception e){
			logger.error(e);
			result=new Result<Object>(false,EMessageCode.EXCEPTION.getCode());
		}
		return "json-result";
	}
	
	/** 
	 * get set 
	 **/
	public void setCfUserService(ICfUserService service) {
		this.cfUserService = service;
	}
	
	public ICfUserService getCfUserService() {
		return this.cfUserService;
	}
	
	public void setCfUser(CfUser cfUser){
		this.cfUser=cfUser;
	}
	
	public CfUser getCfUser(){
		return cfUser;
	}
	
	public void setCfUserCondition(CfUserCondition cfUserCondition){
		this.cfUserCondition=cfUserCondition;
	}
	
	public CfUserCondition getCfUserCondition(){
		return cfUserCondition;
	}
	
	
}

