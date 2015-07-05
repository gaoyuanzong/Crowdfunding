/*
 * Powered By [up72-framework]
 * Web Site: http://www.up72.com
 * Since 2006 - 2015
 */

package com.crowdfunding.core.service;

import java.util.List;

import org.apache.log4j.Logger;
import com.crowdfunding.core.common.Page;
import com.crowdfunding.core.domain.ProjectRefund;
import com.crowdfunding.core.common.Result;

import com.crowdfunding.core.condition.ProjectRefundCondition;
/**
 * 退款业务处理
 * 
 * @author alive auto create
 * @version 1.0
 * @since 1.0
 */

public interface IProjectRefundService {
	public static Logger logger = Logger.getLogger(IProjectRefundService.class);
		
	/**
	 * 保存 ProjectRefund
	 */
	public Result addProjectRefund(ProjectRefund projectRefund);
	
	/**
	 * 删除 ProjectRefund
	 */
	public Result removeProjectRefund(ProjectRefund projectRefund);
	
	/**
	 * 更新 ProjectRefund
	 */
	public Result modifyProjectRefund(ProjectRefund projectRefund);
	/**
	 * 查询列表
	 */
	public List queryProjectRefundList(ProjectRefundCondition condition);
	/**
	 * 分页查询
	 */
	public Page queryProjectRefundPage(ProjectRefundCondition condition);
	
	
	public ProjectRefund queryProjectRefundById(Long id);	
	
}
