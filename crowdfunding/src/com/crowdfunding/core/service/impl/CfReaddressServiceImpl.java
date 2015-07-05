/*
 * Powered By [up72-framework]
 * Web Site: http://www.up72.com
 * Since 2006 - 2015
 */

package com.crowdfunding.core.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.crowdfunding.core.domain.CfReaddress;

import com.crowdfunding.core.common.Page;
import com.crowdfunding.core.common.Result;
import com.crowdfunding.core.dao.IBaseDao;
import com.crowdfunding.core.exception.NameIsExistException;
import com.crowdfunding.core.exception.ParamIsNullException;
import com.crowdfunding.core.service.ICfReaddressService;
import com.crowdfunding.core.condition.CfReaddressCondition;
import com.crowdfunding.core.util.ExcelWritePoiUtil;

/**
 * InnoDB free: 10240 kB业务处理
 * 
 * @author alive auto create
 * @version 1.0
 * @since 1.0
 */

public class CfReaddressServiceImpl implements ICfReaddressService{
	private final static Logger logger=Logger.getLogger(CfReaddressServiceImpl.class);
	private IBaseDao dao;

	
	/**
	 * 保存 CfReaddress
	 */
	public Result<String> addCfReaddress(CfReaddress cfReaddress) {
		Result<String> result=new Result<String>(true); 
			String id=dao.addObject(cfReaddress);
			result.setData(id);
		return result;
	}
	
	/**
	 * 删除 CfReaddress
	 */
	public Result<String> removeCfReaddress(CfReaddress cfReaddress) {
		Result<String> result=new Result<String>(true); 
		dao.deleteObject(cfReaddress);
		return new Result(true);
	}
	
	/**
	 * 更新 CfReaddress
	 */
	public  Result<String>  modifyCfReaddress(CfReaddress cfReaddress) {
		Result<String> result=new Result<String>(true); 
		this.dao.updateObject(cfReaddress);
		return new Result(true);
	}
	
	/**
	 * 查询列表
	 */

	public List queryCfReaddressList(CfReaddressCondition condition) {
		return dao.queryObjectList(condition);
	}
	
	/**
	 * 分页查询
	 */
	public Page queryCfReaddressPage(CfReaddressCondition condition){
		return dao.queryPage(condition);
	}
	
	/**
	 * 根据Id 查询
	 */
	public CfReaddress queryCfReaddressById(Long id){
		return dao.getObject(CfReaddress.class, id);
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
