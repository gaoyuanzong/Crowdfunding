/*
 * Powered By [up72-framework]
 * Web Site: http://www.up72.com
 * Since 2006 - 2015
 */

package com.crowdfunding.core.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.apache.log4j.Logger;

import com.crowdfunding.core.domain.Project;

import com.crowdfunding.core.common.Page;
import com.crowdfunding.core.common.Result;
import com.crowdfunding.core.dao.IBaseDao;
import com.crowdfunding.core.exception.NameIsExistException;
import com.crowdfunding.core.exception.ParamIsNullException;
import com.crowdfunding.core.service.IProjectService;
import com.crowdfunding.core.condition.ProjectCondition;
import com.crowdfunding.core.constants.ProjectStatus;
import com.crowdfunding.core.util.ExcelWritePoiUtil;

/**
 * 项目业务处理
 * 
 * @author alive auto create
 * @version 1.0
 * @since 1.0
 */

public class ProjectServiceImpl implements IProjectService{
	private final static Logger logger=Logger.getLogger(ProjectServiceImpl.class);
	private IBaseDao dao;

	
	/**
	 * 保存 Project
	 */
	public Result<String> addProject(Project project) {
		Result<String> result=new Result<String>(true); 
		project.setProjectStatus(ProjectStatus.SAVED.value());//状态为已保存
		project.setCollectedAmount(new BigDecimal("0"));//已募集
		project.setVirtualCollectedAmount(new BigDecimal("0"));//虚拟募集金额
		project.setIsVirtualCollectedAmount(0);//是否开启虚拟募集
		project.setSupports(0);//支持人数
		project.setAuditCount(0);//审核次数
		project.setShipType(0);//未发货
		project.setLendingStatus(10);//未放款
		String id=dao.addObject(project);
		result.setData(id);
		return result;
	}
	
	/**
	 * 删除 Project
	 */
	public Result<String> removeProject(Project project) {
		Result<String> result=new Result<String>(true); 
		dao.deleteObject(project);
		return new Result(true);
	}
	
	/**
	 * 更新 Project
	 */
	public  Result<String>  modifyProject(Project project) {
		Result<String> result=new Result<String>(true); 
		this.dao.updateObject(project);
		return new Result(true);
	}
	
	/**
	 * 查询列表
	 */

	public List queryProjectList(ProjectCondition condition) {
		return dao.queryObjectList(condition);
	}
	
	/**
	 * 分页查询
	 */
	public Page queryProjectPage(ProjectCondition condition){
		return dao.queryPage(condition);
	}
	
	/**
	 * 根据Id 查询
	 */
	public Project queryProjectById(Long id){
		return dao.getObject(Project.class, id);
	}
	
	/**
	 * get set  设置dao
	 */
	public IBaseDao getDao() {
		return dao;
	}

	public void setDao(IBaseDao dao) {
		this.dao = dao;
	}
}	
