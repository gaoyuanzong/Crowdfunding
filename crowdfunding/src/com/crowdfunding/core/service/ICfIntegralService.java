/*
 * Powered By [up72-framework]
 * Web Site: http://www.up72.com
 * Since 2006 - 2015
 */

package com.crowdfunding.core.service;

import java.util.List;

import org.apache.log4j.Logger;
import com.crowdfunding.core.common.Page;
import com.crowdfunding.core.domain.CfIntegral;
import com.crowdfunding.core.common.Result;

import com.crowdfunding.core.condition.CfIntegralCondition;
/**
 * InnoDB free: 10240 kB业务处理
 * 
 * @author alive auto create
 * @version 1.0
 * @since 1.0
 */

public interface ICfIntegralService {
	public static Logger logger = Logger.getLogger(ICfIntegralService.class);
		
	/**
	 * 保存 CfIntegral
	 */
	public Result addCfIntegral(CfIntegral cfIntegral);
	
	/**
	 * 删除 CfIntegral
	 */
	public Result removeCfIntegral(CfIntegral cfIntegral);
	
	/**
	 * 更新 CfIntegral
	 */
	public Result modifyCfIntegral(CfIntegral cfIntegral);
	/**
	 * 查询列表
	 */
	public List queryCfIntegralList(CfIntegralCondition condition);
	/**
	 * 分页查询
	 */
	public Page queryCfIntegralPage(CfIntegralCondition condition);
	
	
	public CfIntegral queryCfIntegralById(Long id);	
	
}
