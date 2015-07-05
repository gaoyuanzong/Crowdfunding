/*
 * Powered By [up72-framework]
 * Web Site: http://www.up72.com
 * Since 2006 - 2015
 */

package com.crowdfunding.core.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.crowdfunding.core.domain.CfIntegral;

import com.crowdfunding.core.common.Page;
import com.crowdfunding.core.common.Result;
import com.crowdfunding.core.dao.IBaseDao;
import com.crowdfunding.core.exception.NameIsExistException;
import com.crowdfunding.core.exception.ParamIsNullException;
import com.crowdfunding.core.service.ICfIntegralService;
import com.crowdfunding.core.condition.CfIntegralCondition;
import com.crowdfunding.core.util.ExcelWritePoiUtil;

/**
 * InnoDB free: 10240 kB业务处理
 * 
 * @author alive auto create
 * @version 1.0
 * @since 1.0
 */

public class CfIntegralServiceImpl implements ICfIntegralService{
	private final static Logger logger=Logger.getLogger(CfIntegralServiceImpl.class);
	private IBaseDao dao;

	
	/**
	 * 保存 CfIntegral
	 */
	public Result<String> addCfIntegral(CfIntegral cfIntegral) {
		Result<String> result=new Result<String>(true); 
			String id=dao.addObject(cfIntegral);
			result.setData(id);
		return result;
	}
	
	/**
	 * 删除 CfIntegral
	 */
	public Result<String> removeCfIntegral(CfIntegral cfIntegral) {
		Result<String> result=new Result<String>(true); 
		dao.deleteObject(cfIntegral);
		return new Result(true);
	}
	
	/**
	 * 更新 CfIntegral
	 */
	public  Result<String>  modifyCfIntegral(CfIntegral cfIntegral) {
		Result<String> result=new Result<String>(true); 
		this.dao.updateObject(cfIntegral);
		return new Result(true);
	}
	
	/**
	 * 查询列表
	 */

	public List queryCfIntegralList(CfIntegralCondition condition) {
		return dao.queryObjectList(condition);
	}
	
	/**
	 * 分页查询
	 */
	public Page queryCfIntegralPage(CfIntegralCondition condition){
		return dao.queryPage(condition);
	}
	
	/**
	 * 根据Id 查询
	 */
	public CfIntegral queryCfIntegralById(Long id){
		return dao.getObject(CfIntegral.class, id);
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
