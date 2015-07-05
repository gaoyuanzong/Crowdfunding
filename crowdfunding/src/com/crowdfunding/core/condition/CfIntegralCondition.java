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



public class CfIntegralCondition  extends Condition{
	

		//columns START
		/** */
		private java.lang.Long id;
		
		/** */
		private java.lang.String userId;
		
		/** */
		private java.lang.String integralType;
		
		/** */
		private java.lang.String integralDetail;
		
		/** */
		private java.lang.String integralValue;
		
		/** */
		private java.util.Date createTime;
		
		//columns END
		public java.lang.String getUserId() {
			return this.userId;
		}
		
		public void setUserId(java.lang.String value) {
			this.userId = value;
		}
		
		public java.lang.String getIntegralType() {
			return this.integralType;
		}
		
		public void setIntegralType(java.lang.String value) {
			this.integralType = value;
		}
		
		public java.lang.String getIntegralDetail() {
			return this.integralDetail;
		}
		
		public void setIntegralDetail(java.lang.String value) {
			this.integralDetail = value;
		}
		
		public java.lang.String getIntegralValue() {
			return this.integralValue;
		}
		
		public void setIntegralValue(java.lang.String value) {
			this.integralValue = value;
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
		buffer.append("select t from CfIntegral t where 1=1 ");
		
			if(id != null) {
	            buffer.append(" and  t.id = :id ");
	        }
	        if(StringUtils.isNotBlank(userId)) {
	            buffer.append(" and  t.userId = :userId ");
	        }
	        if(StringUtils.isNotBlank(integralType)) {
	            buffer.append(" and  t.integralType = :integralType ");
	        }
	        if(StringUtils.isNotBlank(integralDetail)) {
	            buffer.append(" and  t.integralDetail = :integralDetail ");
	        }
	        if(StringUtils.isNotBlank(integralValue)) {
	            buffer.append(" and  t.integralValue = :integralValue ");
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
					if(StringUtils.isNotBlank(integralType)) {
						query.setParameter("integralType", integralType);
					}
					if(StringUtils.isNotBlank(integralDetail)) {
						query.setParameter("integralDetail", integralDetail);
					}
					if(StringUtils.isNotBlank(integralValue)) {
						query.setParameter("integralValue", integralValue);
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
