/*
 * Powered By [up72-framework]
 * Web Site: http://www.up72.com
 * Since 2006 - 2015
 */

package com.crowdfunding.core.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.crowdfunding.core.domain.CfInformation;

import com.crowdfunding.core.common.Page;
import com.crowdfunding.core.common.Result;
import com.crowdfunding.core.dao.IBaseDao;
import com.crowdfunding.core.exception.NameIsExistException;
import com.crowdfunding.core.exception.ParamIsNullException;
import com.crowdfunding.core.service.ICfInformationService;
import com.crowdfunding.core.condition.CfInformationCondition;
import com.crowdfunding.core.util.ExcelWritePoiUtil;

/**
 * InnoDB free: 10240 kB业务处理
 * 
 * @author alive auto create
 * @version 1.0
 * @since 1.0
 */

public class CfInformationServiceImpl implements ICfInformationService{
	private final static Logger logger=Logger.getLogger(CfInformationServiceImpl.class);
	private IBaseDao dao;

	
	/**
	 * 保存 CfInformation
	 */
	public Result<String> addCfInformation(CfInformation cfInformation) {
		Result<String> result=new Result<String>(true); 
			String id=dao.addObject(cfInformation);
			result.setData(id);
		return result;
	}
	
	/**
	 * 删除 CfInformation
	 */
	public Result<String> removeCfInformation(CfInformation cfInformation) {
		Result<String> result=new Result<String>(true); 
		dao.deleteObject(cfInformation);
		return new Result(true);
	}
	
	/**
	 * 更新 CfInformation
	 */
	public  Result<String>  modifyCfInformation(CfInformation cfInformation) {
		Result<String> result=new Result<String>(true); 
		this.dao.updateObject(cfInformation);
		return new Result(true);
	}
	
	/**
	 * 查询列表
	 */

	public List queryCfInformationList(CfInformationCondition condition) {
		return dao.queryObjectList(condition);
	}
	
	/**
	 * 分页查询
	 */
	public Page queryCfInformationPage(CfInformationCondition condition){
		return dao.queryPage(condition);
	}
	
	/**
	 * 根据Id 查询
	 */
	public CfInformation queryCfInformationById(Long id){
		return dao.getObject(CfInformation.class, id);
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
