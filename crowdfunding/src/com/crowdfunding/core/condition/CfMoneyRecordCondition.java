/*
 * Powered By [up72-framework]
 * Web Site: http://www.up72.com
 * Since 2006 - 2015
 */

package com.crowdfunding.core.condition;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.crowdfunding.core.common.Condition;
import com.crowdfunding.core.constants.ESortType;



public class CfMoneyRecordCondition  extends Condition{
	

		//columns START
		/** */
		private java.lang.Long id;
		
		/** */
		private java.lang.String userId;
		
		/** */
		private java.lang.String recordKind;
		
		/** */
		private java.lang.Integer recordState;
		
		/** */
		private java.lang.String description;
		
		/** */
		private java.util.Date createTime;
		
		//columns END
		public java.lang.String getUserId() {
			return this.userId;
		}
		
		public void setUserId(java.lang.String value) {
			this.userId = value;
		}
		
		public java.lang.String getRecordKind() {
			return this.recordKind;
		}
		
		public void setRecordKind(java.lang.String value) {
			this.recordKind = value;
		}
		
		public java.lang.Integer getRecordState() {
			return this.recordState;
		}
		
		public void setRecordState(java.lang.Integer value) {
			this.recordState = value;
		}
		
		public java.lang.String getDescription() {
			return this.description;
		}
		
		public void setDescription(java.lang.String value) {
			this.description = value;
		}
		
		public java.util.Date getCreateTime() {
			return this.createTime;
		}
		
		public void setCreateTime(java.util.Date value) {
			this.createTime = value;
		}
		

	
	@Override
	public String getInitialHql() {
		setIsSQL(false);
		StringBuffer buffer=new StringBuffer();
		buffer.append("select t from CfMoneyRecord t where 1=1 ");
		
			if(id != null) {
	            buffer.append(" and  t.id = :id ");
	        }
	        if(StringUtils.isNotBlank(userId)) {
	            buffer.append(" and  t.userId = :userId ");
	        }
	        if(StringUtils.isNotBlank(recordKind)) {
	            buffer.append(" and  t.recordKind = :recordKind ");
	        }
			if(recordState != null) {
	            buffer.append(" and  t.recordState = :recordState ");
	        }
	        if(StringUtils.isNotBlank(description)) {
	            buffer.append(" and  t.description = :description ");
	        }
			if(createTime != null) {
	            buffer.append(" and  t.createTime = :createTime ");
	        }
		return buffer.toString();
	}
	
		
	@Override
	public Query prepareParams(Query query) {
		try {
					if(id!=null) {
						query.setParameter("id", id);
					}
					if(StringUtils.isNotBlank(userId)) {
						query.setParameter("userId", userId);
					}
					if(StringUtils.isNotBlank(recordKind)) {
						query.setParameter("recordKind", recordKind);
					}
					if(recordState!=null) {
						query.setParameter("recordState", recordState);
					}
					if(StringUtils.isNotBlank(description)) {
						query.setParameter("description", description);
					}
					if(createTime!=null) {
						query.setParameter("createTime", createTime);
					}
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		return query;
	}
	
	@Override
	public String getSortname(){
		if(StringUtils.isBlank(super.getSortname())){
			super.setSortorder(ESortType.ASC.getCode());
			return "id";
		}
		return super.getSortname();
	}
	
	@Override
	public String getDataFilterSql() {
		long bit=getCityBitDataFilter();
		if(bit>0){
			return " and bitand(item.bit,"+bit+")<>0 ";
		}
		return "";
	}

}
