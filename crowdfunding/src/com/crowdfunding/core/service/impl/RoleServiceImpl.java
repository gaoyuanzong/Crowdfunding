/**
*Generated by StarUML(tm) Java Add-In
*  @ Project : basis
*  @ File Name : RoleServiceImpl.java
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
import com.crowdfunding.core.condition.EmployeeCondition;
import com.crowdfunding.core.condition.RoleCondition;
import com.crowdfunding.core.constants.EState;
import com.crowdfunding.core.dao.IBaseDao;
import com.crowdfunding.core.domain.Role;
import com.crowdfunding.core.domain.RoleMenu;
import com.crowdfunding.core.domain.Roletemplate;
import com.crowdfunding.core.exception.BasisException;
import com.crowdfunding.core.exception.NameIsExistException;
import com.crowdfunding.core.exception.ParamIsNullException;
import com.crowdfunding.core.util.BasisUtil;


public class RoleServiceImpl implements com.crowdfunding.core.service.IRoleService {
	private final static Logger logger=Logger.getLogger(RoleServiceImpl.class);
	private IBaseDao dao;
	
	public void setDao(IBaseDao dao) {
		this.dao = dao;
	}

	public Role queryRoleById(String id) {
		return dao.getObject(Role.class, id);
	}

	public Page<Role> queryRolePage(RoleCondition condition) {
		return dao.queryPage(condition);
	}

	public Result<Object> modifyRole(Role role) {
		/*
		 * 1.判断参数不能为空
		 * 2.判断名称不能重复
		 * 3.删除现有的用户组-菜单关联关系
		 * 4.增加用户组-菜单关联关系
		 * 5.修改基本信息
		 * 6.返回结果
		 */
		Result<Object> result=new Result<Object>(true);
		try{
			//判断参数不能为空
			BasisUtil.validParamsNotNull(role.getId(),role.getName());
			//判断名称是否有重复的
			dao.validHasSameName(Role.class, role.getName(), "where state=1 and id<>'"+role.getId()+"'");
			Role dbrole=dao.getObject(Role.class,role.getId());
			
			//删除现有的版本-菜单关联关系
			Set<RoleMenu> dbRmset=dbrole.getRoleMenuSet();
			Iterator<RoleMenu> dbit=dbRmset.iterator();
			while(dbit.hasNext()){
				dao.deleteObject(dbit.next());
			}
			
			//增加版本-菜单关联关系
			Set<RoleMenu> rmset=role.getRoleMenuSet();
			if(rmset!=null){
				Iterator<RoleMenu> it=rmset.iterator();
				while(it.hasNext()){
					RoleMenu rm=it.next();
					if(rm!=null){
						rm.setRoleId(role.getId());
						dao.addObject(rm);
					}
				}
			}
			//修改基本信息
			updateRole(role, dbrole);
			
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

	public Result<Object> removeRole(Role role) {
		/*
		 * 1.判断参数不能为空
		 * 2.判断是否被用户引用
		 * 3.删除
		 * 4.返回结果
		 */
		Result<Object> result=new Result<Object>(true);
		try{
			//判断参数不能为空 id
			BasisUtil.validParamsNotNull(role.getId());
			//判断是否被用户组引用
			validBeanUsed(role);
			//删除
			Role dbRole=dao.getObject(Role.class, role.getId());
			if(StringUtils.isNotBlank(role.getModifyerId())){
				dbRole.setModifyerId(role.getModifyerId());
				dbRole.setModifyTime(new Date());
			}
			dbRole.setState(EState.DELETE.getCode());
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

	public Result<String> addRole(Role role) {
		/*
		 * 1.判断参数不能为空
		 * 2.判断名称是否有重复的
		 * 3.增加role  初始化 cityName subjectName gradeGroupName
		 * 4.增加roleMenu
		 * 5.返回
		 */
		Result<String> result=new Result<String>(true);
		try{
			//判断参数不能为空
			BasisUtil.validParamsNotNull(role.getName());
			//判断名称是否有重复的
			dao.validHasSameName(Role.class, role.getName(), "where state=1");
			Set<RoleMenu> rmset=role.getRoleMenuSet();
			
			//增加role
			int nextsort=dao.getNextSort(Role.class, "where state=1");
			role.setSort(nextsort);
			if(role.getState()==null){
				role.setState(EState.NORMAL.getCode());
			}
			role.setCreateTime(new Date());
			role.setRoleMenuSet(null);
			
			//this.packageBasicItemInfo(role);//封装基本信息名称
			
			String roleId=dao.addObject(role);
			
			//增加roleMenu
			if(rmset!=null){
				Iterator<RoleMenu> it=rmset.iterator();
				while(it.hasNext()){
					RoleMenu rm=it.next();
					if(rm!=null){
						rm.setRoleId(roleId);
						dao.addObject(rm);
					}
				}
			}
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
	/**
	 * 更新修改信息到数据库中
	 */
	private void updateRole(Role role,Role dbrole){
		//packageBasicItemInfo(role);
		if(StringUtils.isNotBlank(role.getModifyerId())){
			dbrole.setModifyerId(role.getModifyerId());
			dbrole.setModifyTime(new Date());
		}
		dbrole.setName(role.getName());
		dbrole.setRemark(role.getRemark());
		if(StringUtils.isNotBlank(role.getTemplateId())){
			dbrole.setTemplateId(role.getTemplateId());
		}
		if(role.getState()!=null){
			dbrole.setState(role.getState());
		}
	}
	
	public List<Role> queryRoleList(RoleCondition condition) {
		return dao.queryObjectList(condition);
	}
	/**
	 * 验证是否被引用
	 * @param course
	 * @throws BasisException
	 */
	private void validBeanUsed(Role role)throws BasisException{
		EmployeeCondition employeeCondition=new EmployeeCondition();
		employeeCondition.setRoleId(role.getId());
		long usedCount=dao.queryCount(employeeCondition);
		if(usedCount>0){
			throw new BasisException("role.hadbeen.used","该用户组下存在用户。");
		}
	}
}
