/**
*Generated by StarUML(tm) Java Add-In
*  @ Project : basis
*  @ File Name : RoletemplateServiceImpl.java
*  @ Date : 2012/9/21
*  @ Author : wxliu
*/



package com.crowdfunding.core.service.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.crowdfunding.core.common.Page;
import com.crowdfunding.core.common.Result;
import com.crowdfunding.core.condition.RoleCondition;
import com.crowdfunding.core.condition.RoletemplateCondition;
import com.crowdfunding.core.constants.EState;
import com.crowdfunding.core.dao.IBaseDao;
import com.crowdfunding.core.domain.Roletemplate;
import com.crowdfunding.core.domain.RoletemplateMenu;
import com.crowdfunding.core.exception.BasisException;
import com.crowdfunding.core.exception.NameIsExistException;
import com.crowdfunding.core.exception.ParamIsNullException;
import com.crowdfunding.core.util.BasisUtil;


public class RoletemplateServiceImpl implements com.crowdfunding.core.service.IRoletemplateService {
	private final static Logger logger=Logger.getLogger(RoletemplateServiceImpl.class);
	private IBaseDao dao;
	
	public void setDao(IBaseDao dao) {
		this.dao = dao;
	}

	public Roletemplate queryRoletemplateById(String id) {
		return dao.getObject(Roletemplate.class, id);
	}

	public Page<Roletemplate> queryRoletemplatePage(
			RoletemplateCondition condition) {
		return dao.queryPage(condition);
	}

	public Result<String> addRoletemplate(Roletemplate template) {
		/*
		 * 1.判断参数不能为空
		 * 2.判断名称是否有重复的
		 * 3.增加roleTemplate
		 * 4.增加roletemplateMenu
		 * 5.返回
		 */
		Result<String> result=new Result<String>(true);
		try{
			//判断参数不能为空
			BasisUtil.validParamsNotNull(template.getName());
			//判断名称是否有重复的
			dao.validHasSameName(Roletemplate.class, template.getName(), "where state=1");
			Set<RoletemplateMenu> rmset=template.getRoletemplateMenuSet();
			
			//增加roleTemplate
			int nextsort=dao.getNextSort(Roletemplate.class, "where state=1");
			template.setSort(nextsort);
			if(template.getState()==null){
				template.setState(EState.NORMAL.getCode());
			}
			template.setCreateTime(new Date());
			template.setRoletemplateMenuSet(null);
			String templateId=dao.addObject(template);
			
			//增加roletemplateMenu
			if(rmset!=null){
				Iterator<RoletemplateMenu> it=rmset.iterator();
				while(it.hasNext()){
					RoletemplateMenu rm=it.next();
					if(rm!=null){
						rm.setTemplateId(templateId);
						dao.addObject(rm);
					}
				}
			}
			result.setData(templateId);
			
		}catch (ParamIsNullException e) {
			logger.warn(e.getMessage());
			result.setSuccess(false);
			result.setCode(e.getCode());
		}catch (NameIsExistException e) {
			logger.warn(e.getMessage());
			result.setSuccess(false);
			result.setCode(e.getCode());
		}
		return result;
	}

	public Result<Object> removeRoletemplate(Roletemplate template) {
		/*
		 * 1.判断参数不能为空
		 * 2.判断是否被用户组引用
		 * 3.删除
		 * 4.返回结果
		 */
		Result<Object> result=new Result<Object>(true);
		try{
			//判断参数不能为空 id
			BasisUtil.validParamsNotNull(template.getId());
			//判断是否被用户组引用
			validBeanUsed(template);
			//删除
			Roletemplate dbTemplate=dao.getObject(Roletemplate.class, template.getId());
			if(StringUtils.isNotBlank(template.getModifyerId())){
				dbTemplate.setModifyerId(template.getModifyerId());
				dbTemplate.setModifyTime(new Date());
			}
			dbTemplate.setState(EState.DELETE.getCode());
		}catch (ParamIsNullException e) {
			logger.warn(e.getMessage());
			result.setSuccess(false);
			result.setCode(e.getCode());
		}catch (BasisException e) {
			logger.warn(e.getMessage());
			result.setSuccess(false);
			result.setCode(e.getCode());
		}
		return result;
	}

	public Result<Object> modifyRoletemplate(Roletemplate template) {
		/*
		 * 1.判断参数不能为空
		 * 2.判断名称不能重复
		 * 3.删除现有的版本-菜单关联关系
		 * 4.增加版本-菜单关联关系
		 * 5.修改基本信息
		 * 6.返回结果
		 */
		Result<Object> result=new Result<Object>(true);
		try{
			//判断参数不能为空
			BasisUtil.validParamsNotNull(template.getId(),template.getName());
			//判断名称是否有重复的
			dao.validHasSameName(Roletemplate.class, template.getName(), "where state=1 and id<>'"+template.getId()+"'");
			Roletemplate dbTemplate=dao.getObject(Roletemplate.class,template.getId());
			
			//删除现有的版本-菜单关联关系
			Set<RoletemplateMenu> dbRmset=dbTemplate.getRoletemplateMenuSet();
			Iterator<RoletemplateMenu> dbit=dbRmset.iterator();
			while(dbit.hasNext()){
				dao.deleteObject(dbit.next());
			}
			
			//增加版本-菜单关联关系
			Set<RoletemplateMenu> rmset=template.getRoletemplateMenuSet();
			if(rmset!=null){
				Iterator<RoletemplateMenu> it=rmset.iterator();
				while(it.hasNext()){
					RoletemplateMenu rm=it.next();
					if(rm!=null){
						rm.setTemplateId(template.getId());
						dao.addObject(rm);
					}
				}
			}
			
			//修改基本信息
			if(StringUtils.isNotBlank(template.getModifyerId())){
				dbTemplate.setModifyerId(template.getModifyerId());
				dbTemplate.setModifyTime(new Date());
			}
			dbTemplate.setName(template.getName());
		}catch (ParamIsNullException e) {
			logger.warn(e.getMessage());
			result.setSuccess(false);
			result.setCode(e.getCode());
		}catch (NameIsExistException e) {
			logger.warn(e.getMessage());
			result.setSuccess(false);
			result.setCode(e.getCode());
		}
		return result;
	}

	public List<Roletemplate> queryRoletemplateList(
			RoletemplateCondition condition) {
		return dao.queryObjectList(condition);
	}
	
	/**
	 * 验证是否被引用
	 * @param course
	 * @throws BasisException
	 */
	private void validBeanUsed(Roletemplate roletemplate)throws BasisException{
		RoleCondition roleCondition=new RoleCondition();
		roleCondition.setTemplateId(roletemplate.getId());
		long count=dao.queryCount(roleCondition);
		if(count>0){
			throw new BasisException("roletemplate.hadbeen.used","用户模板下存在用户组。");
		}
	}
}
