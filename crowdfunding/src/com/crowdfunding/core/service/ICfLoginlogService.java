/*
 * Powered By [up72-framework]
 * Web Site: http://www.up72.com
 * Since 2006 - 2015
 */

package com.crowdfunding.core.service;

import java.util.List;

import org.apache.log4j.Logger;
import com.crowdfunding.core.common.Page;
import com.crowdfunding.core.domain.CfLoginlog;
import com.crowdfunding.core.common.Result;

import com.crowdfunding.core.condition.CfLoginlogCondition;
/**
 * InnoDB free: 10240 kB业务处理
 * 
 * @author alive auto create
 * @version 1.0
 * @since 1.0
 */

public interface ICfLoginlogService {
	public static Logger logger = Logger.getLogger(ICfLoginlogService.class);
		
	/**
	 * 保存 CfLoginlog
	 */
	public Result addCfLoginlog(CfLoginlog cfLoginlog);
	
	/**
	 * 删除 CfLoginlog
	 */
	public Result removeCfLoginlog(CfLoginlog cfLoginlog);
	
	/**
	 * 更新 CfLoginlog
	 */
	public Result modifyCfLoginlog(CfLoginlog cfLoginlog);
	/**
	 * 查询列表
	 */
	public List queryCfLoginlogList(CfLoginlogCondition condition);
	/**
	 * 分页查询
	 */
	public Page queryCfLoginlogPage(CfLoginlogCondition condition);
	
	
	public CfLoginlog queryCfLoginlogById(Long id);	
	
}
