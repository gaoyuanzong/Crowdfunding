/*
 * Powered By [up72-framework]
 * Web Site: http://www.up72.com
 * Since 2006 - 2015
 */

package com.crowdfunding.core.service;

import java.util.List;

import org.apache.log4j.Logger;
import com.crowdfunding.core.common.Page;
import com.crowdfunding.core.domain.CfInvitation;
import com.crowdfunding.core.common.Result;

import com.crowdfunding.core.condition.CfInvitationCondition;
/**
 * InnoDB free: 10240 kB业务处理
 * 
 * @author alive auto create
 * @version 1.0
 * @since 1.0
 */

public interface ICfInvitationService {
	public static Logger logger = Logger.getLogger(ICfInvitationService.class);
		
	/**
	 * 保存 CfInvitation
	 */
	public Result addCfInvitation(CfInvitation cfInvitation);
	
	/**
	 * 删除 CfInvitation
	 */
	public Result removeCfInvitation(CfInvitation cfInvitation);
	
	/**
	 * 更新 CfInvitation
	 */
	public Result modifyCfInvitation(CfInvitation cfInvitation);
	/**
	 * 查询列表
	 */
	public List queryCfInvitationList(CfInvitationCondition condition);
	/**
	 * 分页查询
	 */
	public Page queryCfInvitationPage(CfInvitationCondition condition);
	
	
	public CfInvitation queryCfInvitationById(Long id);	
	
}
