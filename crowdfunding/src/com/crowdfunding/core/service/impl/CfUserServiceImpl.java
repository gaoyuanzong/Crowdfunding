/*
 * Powered By [up72-framework]
 * Web Site: http://www.up72.com
 * Since 2006 - 2015
 */

package com.crowdfunding.core.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.crowdfunding.core.domain.CfUser;

import com.crowdfunding.core.common.Page;
import com.crowdfunding.core.common.Result;
import com.crowdfunding.core.dao.IBaseDao;
import com.crowdfunding.core.exception.NameIsExistException;
import com.crowdfunding.core.exception.ParamIsNullException;
import com.crowdfunding.core.service.ICfUserService;
import com.crowdfunding.core.condition.CfUserCondition;
import com.crowdfunding.core.util.ExcelWritePoiUtil;

/**
 * InnoDB free: 10240 kB业务处理
 * 
 * @author alive auto create
 * @version 1.0
 * @since 1.0
 */

public class CfUserServiceImpl implements ICfUserService{
	private final static Logger logger=Logger.getLogger(CfUserServiceImpl.class);
	private IBaseDao dao;

	
	/**
	 * 保存 CfUser
	 */
	public Result<String> addCfUser(CfUser cfUser) {
		Result<String> result=new Result<String>(true); 
			String id=dao.addObject(cfUser);
			result.setData(id);
		return result;
	}
	
	/**
	 * 删除 CfUser
	 */
	public Result<String> removeCfUser(CfUser cfUser) {
		Result<String> result=new Result<String>(true); 
		dao.deleteObject(cfUser);
		return new Result(true);
	}
	
	/**
	 * 更新 CfUser
	 */
	public  Result<String>  modifyCfUser(CfUser cfUser) {
		Result<String> result=new Result<String>(true); 
		this.dao.updateObject(cfUser);
		return new Result(true);
	}
	
	/**
	 * 查询列表
	 */

	public List queryCfUserList(CfUserCondition condition) {
		return dao.queryObjectList(condition);
	}
	
	/**
	 * 分页查询
	 */
	public Page queryCfUserPage(CfUserCondition condition){
		return dao.queryPage(condition);
	}
	
	/**
	 * 根据Id 查询
	 */
	public CfUser queryCfUserById(Long id){
		return dao.getObject(CfUser.class, id);
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
