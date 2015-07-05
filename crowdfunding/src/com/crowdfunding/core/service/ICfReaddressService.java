/*
 * Powered By [up72-framework]
 * Web Site: http://www.up72.com
 * Since 2006 - 2015
 */

package com.crowdfunding.core.service;

import java.util.List;

import org.apache.log4j.Logger;
import com.crowdfunding.core.common.Page;
import com.crowdfunding.core.domain.CfReaddress;
import com.crowdfunding.core.common.Result;

import com.crowdfunding.core.condition.CfReaddressCondition;
/**
 * InnoDB free: 10240 kB业务处理
 * 
 * @author alive auto create
 * @version 1.0
 * @since 1.0
 */

public interface ICfReaddressService {
	public static Logger logger = Logger.getLogger(ICfReaddressService.class);
		
	/**
	 * 保存 CfReaddress
	 */
	public Result addCfReaddress(CfReaddress cfReaddress);
	
	/**
	 * 删除 CfReaddress
	 */
	public Result removeCfReaddress(CfReaddress cfReaddress);
	
	/**
	 * 更新 CfReaddress
	 */
	public Result modifyCfReaddress(CfReaddress cfReaddress);
	/**
	 * 查询列表
	 */
	public List queryCfReaddressList(CfReaddressCondition condition);
	/**
	 * 分页查询
	 */
	public Page queryCfReaddressPage(CfReaddressCondition condition);
	
	
	public CfReaddress queryCfReaddressById(Long id);	
	
}
