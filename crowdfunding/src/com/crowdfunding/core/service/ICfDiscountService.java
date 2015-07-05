/*
 * Powered By [up72-framework]
 * Web Site: http://www.up72.com
 * Since 2006 - 2015
 */

package com.crowdfunding.core.service;

import java.util.List;

import org.apache.log4j.Logger;
import com.crowdfunding.core.common.Page;
import com.crowdfunding.core.domain.CfDiscount;
import com.crowdfunding.core.common.Result;

import com.crowdfunding.core.condition.CfDiscountCondition;
/**
 * InnoDB free: 10240 kB业务处理
 * 
 * @author alive auto create
 * @version 1.0
 * @since 1.0
 */

public interface ICfDiscountService {
	public static Logger logger = Logger.getLogger(ICfDiscountService.class);
		
	/**
	 * 保存 CfDiscount
	 */
	public Result addCfDiscount(CfDiscount cfDiscount);
	
	/**
	 * 删除 CfDiscount
	 */
	public Result removeCfDiscount(CfDiscount cfDiscount);
	
	/**
	 * 更新 CfDiscount
	 */
	public Result modifyCfDiscount(CfDiscount cfDiscount);
	/**
	 * 查询列表
	 */
	public List queryCfDiscountList(CfDiscountCondition condition);
	/**
	 * 分页查询
	 */
	public Page queryCfDiscountPage(CfDiscountCondition condition);
	
	
	public CfDiscount queryCfDiscountById(Long id);	
	
}
