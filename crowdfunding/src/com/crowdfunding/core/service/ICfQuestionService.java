/*
 * Powered By [up72-framework]
 * Web Site: http://www.up72.com
 * Since 2006 - 2015
 */

package com.crowdfunding.core.service;

import java.util.List;

import org.apache.log4j.Logger;
import com.crowdfunding.core.common.Page;
import com.crowdfunding.core.domain.CfQuestion;
import com.crowdfunding.core.common.Result;

import com.crowdfunding.core.condition.CfQuestionCondition;
/**
 * InnoDB free: 10240 kB业务处理
 * 
 * @author alive auto create
 * @version 1.0
 * @since 1.0
 */

public interface ICfQuestionService {
	public static Logger logger = Logger.getLogger(ICfQuestionService.class);
		
	/**
	 * 保存 CfQuestion
	 */
	public Result addCfQuestion(CfQuestion cfQuestion);
	
	/**
	 * 删除 CfQuestion
	 */
	public Result removeCfQuestion(CfQuestion cfQuestion);
	
	/**
	 * 更新 CfQuestion
	 */
	public Result modifyCfQuestion(CfQuestion cfQuestion);
	/**
	 * 查询列表
	 */
	public List queryCfQuestionList(CfQuestionCondition condition);
	/**
	 * 分页查询
	 */
	public Page queryCfQuestionPage(CfQuestionCondition condition);
	
	
	public CfQuestion queryCfQuestionById(Long id);	
	
}
