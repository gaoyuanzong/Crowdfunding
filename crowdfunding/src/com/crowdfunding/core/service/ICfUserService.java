/*
 * Powered By [up72-framework]
 * Web Site: http://www.up72.com
 * Since 2006 - 2015
 */

package com.crowdfunding.core.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.crowdfunding.core.common.Page;
import com.crowdfunding.core.domain.CfUser;
import com.crowdfunding.core.common.Result;
import com.crowdfunding.core.condition.CfUserCondition;
/**
 * InnoDB free: 10240 kB业务处理
 * 
 * @author alive auto create
 * @version 1.0
 * @since 1.0
 */

public interface ICfUserService {
	public static Logger logger = Logger.getLogger(ICfUserService.class);
		
	/**
	 * 保存 CfUser
	 */
	public Result addCfUser(CfUser cfUser);
	
	/**
	 * 删除 CfUser
	 */
	public Result removeCfUser(CfUser cfUser);
	
	/**
	 * 更新 CfUser
	 */
	public Result modifyCfUser(CfUser cfUser);
	/**
	 * 查询列表
	 */
	public List queryCfUserList(CfUserCondition condition);
	/**
	 * 分页查询
	 */
	public Page queryCfUserPage(CfUserCondition condition);
	
	
	public CfUser queryCfUserById(Long id);

	
}
