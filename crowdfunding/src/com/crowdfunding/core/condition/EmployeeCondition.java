package com.crowdfunding.core.condition;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;

import com.crowdfunding.core.common.Condition;
import com.crowdfunding.core.constants.EEmployeeState;

public class EmployeeCondition extends Condition{
	private String roleId;
	private String likename;
	private String name;
	private EEmployeeState state;
	private boolean includeAdmin=true;//是否包含管理员 
	
	@Override
	public String getInitialHql() {
		StringBuffer buffer=new StringBuffer();
		buffer.append("select employee from Employee employee where employee.state<>0 ");
		if(StringUtils.isNotBlank(roleId)){
			buffer.append(" and employee.roleId=:roleId ");
		}
		if(StringUtils.isNotBlank(likename)){
			buffer.append(" and employee.name like :likename ");
		}
		if(StringUtils.isNotBlank(name)){
			buffer.append(" and employee.name=:name ");
		}
		if(state!=null&&state!=EEmployeeState.ALL){
			buffer.append(" and employee.state=:state ");
		}
		if(!includeAdmin){
			buffer.append(" and employee.isadmin=0 ");
		}
		return buffer.toString();
	}

	@Override
	public Query prepareParams(Query query) {
		if(StringUtils.isNotBlank(roleId)){
			query.setString("roleId", roleId);
		}
		if(StringUtils.isNotBlank(likename)){
			query.setString("likename", "%"+likename+"%");
		}
		if(StringUtils.isNotBlank(name)){
			query.setString("name", name);
		}
		if(state!=null&&state!=EEmployeeState.ALL){
			query.setInteger("state", state.getCode());
		}
		return query;
	}
	
	@Override
	public String getDataFilterSql() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getLikename() {
		return likename;
	}

	public void setLikename(String likename) {
		this.likename = likename;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public EEmployeeState getState() {
		return state;
	}

	public void setState(EEmployeeState state) {
		this.state = state;
	}

	public boolean isIncludeAdmin() {
		return includeAdmin;
	}

	public void setIncludeAdmin(boolean includeAdmin) {
		this.includeAdmin = includeAdmin;
	}
	
	
}
