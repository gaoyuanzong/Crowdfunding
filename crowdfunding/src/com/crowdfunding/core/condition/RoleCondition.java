package com.crowdfunding.core.condition;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;

import com.crowdfunding.core.common.Condition;
import com.crowdfunding.core.constants.ESortType;

public class RoleCondition extends Condition{
	private String templateId;
	private String likename;
	
	@Override
	public String getInitialHql() {
		StringBuffer buffer =new StringBuffer();
		buffer.append("select role from Role role where role.state=1 ");
		if(StringUtils.isNotBlank(templateId)){
			buffer.append(" and role.templateId=:templateId ");
		}
		if(StringUtils.isNotBlank(likename)){
			buffer.append(" and role.name like :likename ");
		}
		return buffer.toString();
	}

	@Override
	public Query prepareParams(Query query) {
		if(StringUtils.isNotBlank(templateId)){
			query.setString("templateId", templateId);
		}
		if(StringUtils.isNotBlank(likename)){
			query.setString("likename", "%"+likename+"%");
		}
		return query;
	}
	@Override
	public String getSortname(){
		if(StringUtils.isBlank(super.getSortname())){
			super.setSortorder(ESortType.DESC.getCode());
			return "role.createTime";
		}
		return super.getSortname();
	}
	
	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	public String getLikename() {
		return likename;
	}

	public void setLikename(String likename) {
		this.likename = likename;
	}

	@Override
	public String getDataFilterSql() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
