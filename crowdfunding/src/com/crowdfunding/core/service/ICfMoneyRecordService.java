/*
 * Powered By [up72-framework]
 * Web Site: http://www.up72.com
 * Since 2006 - 2015
 */

package com.crowdfunding.core.service;

import java.util.List;

import org.apache.log4j.Logger;
import com.crowdfunding.core.common.Page;
import com.crowdfunding.core.domain.CfMoneyRecord;
import com.crowdfunding.core.common.Result;

import com.crowdfunding.core.condition.CfMoneyRecordCondition;
/**
 * InnoDB free: 10240 kB业务处理
 * 
 * @author alive auto create
 * @version 1.0
 * @since 1.0
 */

public interface ICfMoneyRecordService {
	public static Logger logger = Logger.getLogger(ICfMoneyRecordService.class);
		
	/**
	 * 保存 CfMoneyRecord
	 */
	public Result addCfMoneyRecord(CfMoneyRecord cfMoneyRecord);
	
	/**
	 * 删除 CfMoneyRecord
	 */
	public Result removeCfMoneyRecord(CfMoneyRecord cfMoneyRecord);
	
	/**
	 * 更新 CfMoneyRecord
	 */
	public Result modifyCfMoneyRecord(CfMoneyRecord cfMoneyRecord);
	/**
	 * 查询列表
	 */
	public List queryCfMoneyRecordList(CfMoneyRecordCondition condition);
	/**
	 * 分页查询
	 */
	public Page queryCfMoneyRecordPage(CfMoneyRecordCondition condition);
	
	
	public CfMoneyRecord queryCfMoneyRecordById(Long id);	
	
}
