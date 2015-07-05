/*
 * Powered By [up72-framework]
 * Web Site: http://www.up72.com
 * Since 2006 - 2015
 */

package com.crowdfunding.core.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.crowdfunding.core.domain.CfQuestion;

import com.crowdfunding.core.common.Page;
import com.crowdfunding.core.common.Result;
import com.crowdfunding.core.dao.IBaseDao;
import com.crowdfunding.core.exception.NameIsExistException;
import com.crowdfunding.core.exception.ParamIsNullException;
import com.crowdfunding.core.service.ICfQuestionService;
import com.crowdfunding.core.condition.CfQuestionCondition;
import com.crowdfunding.core.util.ExcelWritePoiUtil;

/**
 * InnoDB free: 10240 kB业务处理
 * 
 * @author alive auto create
 * @version 1.0
 * @since 1.0
 */

public class CfQuestionServiceImpl implements ICfQuestionService{
	private final static Logger logger=Logger.getLogger(CfQuestionServiceImpl.class);
	private IBaseDao dao;

	
	/**
	 * 保存 CfQuestion
	 */
	public Result<String> addCfQuestion(CfQuestion cfQuestion) {
		Result<String> result=new Result<String>(true); 
			String id=dao.addObject(cfQuestion);
			result.setData(id);
		return result;
	}
	
	/**
	 * 删除 CfQuestion
	 */
	public Result<String> removeCfQuestion(CfQuestion cfQuestion) {
		Result<String> result=new Result<String>(true); 
		dao.deleteObject(cfQuestion);
		return new Result(true);
	}
	
	/**
	 * 更新 CfQuestion
	 */
	public  Result<String>  modifyCfQuestion(CfQuestion cfQuestion) {
		Result<String> result=new Result<String>(true); 
		this.dao.updateObject(cfQuestion);
		return new Result(true);
	}
	
	/**
	 * 查询列表
	 */

	public List queryCfQuestionList(CfQuestionCondition condition) {
		return dao.queryObjectList(condition);
	}
	
	/**
	 * 分页查询
	 */
	public Page queryCfQuestionPage(CfQuestionCondition condition){
		return dao.queryPage(condition);
	}
	
	/**
	 * 根据Id 查询
	 */
	public CfQuestion queryCfQuestionById(Long id){
		return dao.getObject(CfQuestion.class, id);
	}
	
	/**
	 * get set  设置dao
	 */
	public IBaseDao getDao() {
		return dao;
	}

	public void setDao(IBaseDao dao) {
		this.dao = dao;
	}
}	
