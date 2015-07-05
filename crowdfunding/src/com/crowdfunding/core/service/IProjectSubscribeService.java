/*
 * Powered By [up72-framework]
 * Web Site: http://www.up72.com
 * Since 2006 - 2015
 */

package com.crowdfunding.core.service;

import java.util.List;

import org.apache.log4j.Logger;
import com.crowdfunding.core.common.Page;
import com.crowdfunding.core.domain.ProjectSubscribe;
import com.crowdfunding.core.common.Result;

import com.crowdfunding.core.condition.ProjectSubscribeCondition;
/**
 * 订单业务处理
 * 
 * @author alive auto create
 * @version 1.0
 * @since 1.0
 */

public interface IProjectSubscribeService {
	public static Logger logger = Logger.getLogger(IProjectSubscribeService.class);
		
	/**
	 * 保存 ProjectSubscribe
	 */
	public Result addProjectSubscribe(ProjectSubscribe projectSubscribe);
	
	/**
	 * 删除 ProjectSubscribe
	 */
	public Result removeProjectSubscribe(ProjectSubscribe projectSubscribe);
	
	/**
	 * 更新 ProjectSubscribe
	 */
	public Result modifyProjectSubscribe(ProjectSubscribe projectSubscribe);
	/**
	 * 查询列表
	 */
	public List queryProjectSubscribeList(ProjectSubscribeCondition condition);
	/**
	 * 分页查询
	 */
	public Page queryProjectSubscribePage(ProjectSubscribeCondition condition);
	
	
	public ProjectSubscribe queryProjectSubscribeById(Long id);	
	
}
