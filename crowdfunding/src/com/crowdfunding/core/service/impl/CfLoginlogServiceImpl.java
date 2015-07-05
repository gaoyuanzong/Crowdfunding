/*
 * Powered By [up72-framework]
 * Web Site: http://www.up72.com
 * Since 2006 - 2015
 */

package com.crowdfunding.core.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.crowdfunding.core.domain.CfLoginlog;

import com.crowdfunding.core.common.Page;
import com.crowdfunding.core.common.Result;
import com.crowdfunding.core.dao.IBaseDao;
import com.crowdfunding.core.exception.NameIsExistException;
import com.crowdfunding.core.exception.ParamIsNullException;
import com.crowdfunding.core.service.ICfLoginlogService;
import com.crowdfunding.core.condition.CfLoginlogCondition;
import com.crowdfunding.core.util.ExcelWritePoiUtil;

/**
 * InnoDB free: 10240 kB业务处理
 * 
 * @author alive auto create
 * @version 1.0
 * @since 1.0
 */

public class CfLoginlogServiceImpl implements ICfLoginlogService{
	private final static Logger logger=Logger.getLogger(CfLoginlogServiceImpl.class);
	private IBaseDao dao;

	
	/**
	 * 保存 CfLoginlog
	 */
	public Result<String> addCfLoginlog(CfLoginlog cfLoginlog) {
		Result<String> result=new Result<String>(true); 
			String id=dao.addObject(cfLoginlog);
			result.setData(id);
		return result;
	}
	
	/**
	 * 删除 CfLoginlog
	 */
	public Result<String> removeCfLoginlog(CfLoginlog cfLoginlog) {
		Result<String> result=new Result<String>(true); 
		dao.deleteObject(cfLoginlog);
		return new Result(true);
	}
	
	/**
	 * 更新 CfLoginlog
	 */
	public  Result<String>  modifyCfLoginlog(CfLoginlog cfLoginlog) {
		Result<String> result=new Result<String>(true); 
		this.dao.updateObject(cfLoginlog);
		return new Result(true);
	}
	
	/**
	 * 查询列表
	 */

	public List queryCfLoginlogList(CfLoginlogCondition condition) {
		return dao.queryObjectList(condition);
	}
	
	/**
	 * 分页查询
	 */
	public Page queryCfLoginlogPage(CfLoginlogCondition condition){
		return dao.queryPage(condition);
	}
	
	/**
	 * 根据Id 查询
	 */
	public CfLoginlog queryCfLoginlogById(Long id){
		return dao.getObject(CfLoginlog.class, id);
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
