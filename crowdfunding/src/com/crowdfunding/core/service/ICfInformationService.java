/*
 * Powered By [up72-framework]
 * Web Site: http://www.up72.com
 * Since 2006 - 2015
 */

package com.crowdfunding.core.service;

import java.util.List;

import org.apache.log4j.Logger;
import com.crowdfunding.core.common.Page;
import com.crowdfunding.core.domain.CfInformation;
import com.crowdfunding.core.common.Result;

import com.crowdfunding.core.condition.CfInformationCondition;
/**
 * InnoDB free: 10240 kB业务处理
 * 
 * @author alive auto create
 * @version 1.0
 * @since 1.0
 */

public interface ICfInformationService {
	public static Logger logger = Logger.getLogger(ICfInformationService.class);
		
	/**
	 * 保存 CfInformation
	 */
	public Result addCfInformation(CfInformation cfInformation);
	
	/**
	 * 删除 CfInformation
	 */
	public Result removeCfInformation(CfInformation cfInformation);
	
	/**
	 * 更新 CfInformation
	 */
	public Result modifyCfInformation(CfInformation cfInformation);
	/**
	 * 查询列表
	 */
	public List queryCfInformationList(CfInformationCondition condition);
	/**
	 * 分页查询
	 */
	public Page queryCfInformationPage(CfInformationCondition condition);
	
	
	public CfInformation queryCfInformationById(Long id);	
	
}
