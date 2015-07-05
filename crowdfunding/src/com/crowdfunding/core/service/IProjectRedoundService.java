/*
 * Powered By [up72-framework]
 * Web Site: http://www.up72.com
 * Since 2006 - 2015
 */

package com.crowdfunding.core.service;

import java.util.List;

import org.apache.log4j.Logger;
import com.crowdfunding.core.common.Page;
import com.crowdfunding.core.domain.ProjectRedound;
import com.crowdfunding.core.common.Result;

import com.crowdfunding.core.condition.ProjectRedoundCondition;
/**
 * 项目回报业务处理
 * 
 * @author alive auto create
 * @version 1.0
 * @since 1.0
 */

public interface IProjectRedoundService {
	public static Logger logger = Logger.getLogger(IProjectRedoundService.class);
		
	/**
	 * 保存 ProjectRedound
	 */
	public Result addProjectRedound(ProjectRedound projectRedound);
	
	/**
	 * 删除 ProjectRedound
	 */
	public Result removeProjectRedound(ProjectRedound projectRedound);
	
	/**
	 * 更新 ProjectRedound
	 */
	public Result modifyProjectRedound(ProjectRedound projectRedound);
	/**
	 * 查询列表
	 */
	public List queryProjectRedoundList(ProjectRedoundCondition condition);
	/**
	 * 分页查询
	 */
	public Page queryProjectRedoundPage(ProjectRedoundCondition condition);
	
	
	public ProjectRedound queryProjectRedoundById(Long id);	
	
}
