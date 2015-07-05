/*
 * Powered By [up72-framework]
 * Web Site: http://www.up72.com
 * Since 2006 - 2015
 */

package com.crowdfunding.core.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.crowdfunding.core.domain.CfDiscount;

import com.crowdfunding.core.common.Page;
import com.crowdfunding.core.common.Result;
import com.crowdfunding.core.dao.IBaseDao;
import com.crowdfunding.core.exception.NameIsExistException;
import com.crowdfunding.core.exception.ParamIsNullException;
import com.crowdfunding.core.service.ICfDiscountService;
import com.crowdfunding.core.condition.CfDiscountCondition;
import com.crowdfunding.core.util.ExcelWritePoiUtil;

/**
 * InnoDB free: 10240 kB业务处理
 * 
 * @author alive auto create
 * @version 1.0
 * @since 1.0
 */

public class CfDiscountServiceImpl implements ICfDiscountService{
	private final static Logger logger=Logger.getLogger(CfDiscountServiceImpl.class);
	private IBaseDao dao;

	
	/**
	 * 保存 CfDiscount
	 */
	public Result<String> addCfDiscount(CfDiscount cfDiscount) {
		Result<String> result=new Result<String>(true); 
			String id=dao.addObject(cfDiscount);
			result.setData(id);
		return result;
	}
	
	/**
	 * 删除 CfDiscount
	 */
	public Result<String> removeCfDiscount(CfDiscount cfDiscount) {
		Result<String> result=new Result<String>(true); 
		dao.deleteObject(cfDiscount);
		return new Result(true);
	}
	
	/**
	 * 更新 CfDiscount
	 */
	public  Result<String>  modifyCfDiscount(CfDiscount cfDiscount) {
		Result<String> result=new Result<String>(true); 
		this.dao.updateObject(cfDiscount);
		return new Result(true);
	}
	
	/**
	 * 查询列表
	 */

	public List queryCfDiscountList(CfDiscountCondition condition) {
		return dao.queryObjectList(condition);
	}
	
	/**
	 * 分页查询
	 */
	public Page queryCfDiscountPage(CfDiscountCondition condition){
		return dao.queryPage(condition);
	}
	
	/**
	 * 根据Id 查询
	 */
	public CfDiscount queryCfDiscountById(Long id){
		return dao.getObject(CfDiscount.class, id);
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
