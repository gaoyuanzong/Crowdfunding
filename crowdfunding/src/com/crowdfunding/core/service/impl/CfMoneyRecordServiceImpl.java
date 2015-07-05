/*
 * Powered By [up72-framework]
 * Web Site: http://www.up72.com
 * Since 2006 - 2015
 */

package com.crowdfunding.core.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.crowdfunding.core.domain.CfMoneyRecord;

import com.crowdfunding.core.common.Page;
import com.crowdfunding.core.common.Result;
import com.crowdfunding.core.dao.IBaseDao;
import com.crowdfunding.core.exception.NameIsExistException;
import com.crowdfunding.core.exception.ParamIsNullException;
import com.crowdfunding.core.service.ICfMoneyRecordService;
import com.crowdfunding.core.condition.CfMoneyRecordCondition;
import com.crowdfunding.core.util.ExcelWritePoiUtil;

/**
 * InnoDB free: 10240 kB业务处理
 * 
 * @author alive auto create
 * @version 1.0
 * @since 1.0
 */

public class CfMoneyRecordServiceImpl implements ICfMoneyRecordService{
	private final static Logger logger=Logger.getLogger(CfMoneyRecordServiceImpl.class);
	private IBaseDao dao;

	
	/**
	 * 保存 CfMoneyRecord
	 */
	public Result<String> addCfMoneyRecord(CfMoneyRecord cfMoneyRecord) {
		Result<String> result=new Result<String>(true); 
			String id=dao.addObject(cfMoneyRecord);
			result.setData(id);
		return result;
	}
	
	/**
	 * 删除 CfMoneyRecord
	 */
	public Result<String> removeCfMoneyRecord(CfMoneyRecord cfMoneyRecord) {
		Result<String> result=new Result<String>(true); 
		dao.deleteObject(cfMoneyRecord);
		return new Result(true);
	}
	
	/**
	 * 更新 CfMoneyRecord
	 */
	public  Result<String>  modifyCfMoneyRecord(CfMoneyRecord cfMoneyRecord) {
		Result<String> result=new Result<String>(true); 
		this.dao.updateObject(cfMoneyRecord);
		return new Result(true);
	}
	
	/**
	 * 查询列表
	 */

	public List queryCfMoneyRecordList(CfMoneyRecordCondition condition) {
		return dao.queryObjectList(condition);
	}
	
	/**
	 * 分页查询
	 */
	public Page queryCfMoneyRecordPage(CfMoneyRecordCondition condition){
		return dao.queryPage(condition);
	}
	
	/**
	 * 根据Id 查询
	 */
	public CfMoneyRecord queryCfMoneyRecordById(Long id){
		return dao.getObject(CfMoneyRecord.class, id);
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
