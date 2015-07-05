/*
 * Powered By [up72-framework]
 * Web Site: http://www.up72.com
 * Since 2006 - 2015
 */

package com.crowdfunding.core.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.crowdfunding.core.domain.CfInvitation;

import com.crowdfunding.core.common.Page;
import com.crowdfunding.core.common.Result;
import com.crowdfunding.core.dao.IBaseDao;
import com.crowdfunding.core.exception.NameIsExistException;
import com.crowdfunding.core.exception.ParamIsNullException;
import com.crowdfunding.core.service.ICfInvitationService;
import com.crowdfunding.core.condition.CfInvitationCondition;
import com.crowdfunding.core.util.ExcelWritePoiUtil;

/**
 * InnoDB free: 10240 kB业务处理
 * 
 * @author alive auto create
 * @version 1.0
 * @since 1.0
 */

public class CfInvitationServiceImpl implements ICfInvitationService{
	private final static Logger logger=Logger.getLogger(CfInvitationServiceImpl.class);
	private IBaseDao dao;

	
	/**
	 * 保存 CfInvitation
	 */
	public Result<String> addCfInvitation(CfInvitation cfInvitation) {
		Result<String> result=new Result<String>(true); 
			String id=dao.addObject(cfInvitation);
			result.setData(id);
		return result;
	}
	
	/**
	 * 删除 CfInvitation
	 */
	public Result<String> removeCfInvitation(CfInvitation cfInvitation) {
		Result<String> result=new Result<String>(true); 
		dao.deleteObject(cfInvitation);
		return new Result(true);
	}
	
	/**
	 * 更新 CfInvitation
	 */
	public  Result<String>  modifyCfInvitation(CfInvitation cfInvitation) {
		Result<String> result=new Result<String>(true); 
		this.dao.updateObject(cfInvitation);
		return new Result(true);
	}
	
	/**
	 * 查询列表
	 */

	public List queryCfInvitationList(CfInvitationCondition condition) {
		return dao.queryObjectList(condition);
	}
	
	/**
	 * 分页查询
	 */
	public Page queryCfInvitationPage(CfInvitationCondition condition){
		return dao.queryPage(condition);
	}
	
	/**
	 * 根据Id 查询
	 */
	public CfInvitation queryCfInvitationById(Long id){
		return dao.getObject(CfInvitation.class, id);
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
