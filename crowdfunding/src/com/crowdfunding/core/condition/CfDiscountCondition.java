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



public class CfDiscountCondition  extends Condition{
	

		//columns START
		/** */
		private java.lang.Long id;
		
		/** */
		private java.lang.String userId;
		
		/** */
		private java.lang.String discountKind;
		
		/** */
		private java.lang.String parValue;
		
		/** */
		private java.lang.Integer state;
		
		/** */
		private java.util.Date integralTime;
		
		/** */
		private java.util.Date overdueTime;
		
		/** */
		private java.lang.String useRole;
		
		/** */
		private java.lang.String remark;
		
		//columns END
		public java.lang.String getUserId() {
			return this.userId;
		}
		
		public void setUserId(java.lang.String value) {
			this.userId = value;
		}
		
		public java.lang.String getDiscountKind() {
			return this.discountKind;
		}
		
		public void setDiscountKind(java.lang.String value) {
			this.discountKind = value;
		}
		
		public java.lang.String getParValue() {
			return this.parValue;
		}
		
		public void setParValue(java.lang.String value) {
			this.parValue = value;
		}
		
		public java.lang.Integer getState() {
			return this.state;
		}
		
		public void setState(java.lang.Integer value) {
			this.state = value;
		}
		
		public java.util.Date getIntegralTime() {
			return this.integralTime;
		}
		
		public void setIntegralTime(java.util.Date value) {
			this.integralTime = value;
		}
		
		public java.util.Date getOverdueTime() {
			return this.overdueTime;
		}
		
		public void setOverdueTime(java.util.Date value) {
			this.overdueTime = value;
		}
		
		public java.lang.String getUseRole() {
			return this.useRole;
		}
		
		public void setUseRole(java.lang.String value) {
			this.useRole = value;
		}
		
		public java.lang.String getRemark() {
			return this.remark;
		}
		
		public void setRemark(java.lang.String value) {
			this.remark = value;
		}
		

	
	@Override
	public String getInitialHql() {
		setIsSQL(false);
		StringBuffer buffer=new StringBuffer();
		buffer.append("select t from CfDiscount t where 1=1 ");
		
			if(id != null) {
	            buffer.append(" and  t.id = :id ");
	        }
	        if(StringUtils.isNotBlank(userId)) {
	            buffer.append(" and  t.userId = :userId ");
	        }
	        if(StringUtils.isNotBlank(discountKind)) {
	            buffer.append(" and  t.discountKind = :discountKind ");
	        }
	        if(StringUtils.isNotBlank(parValue)) {
	            buffer.append(" and  t.parValue = :parValue ");
	        }
			if(state != null) {
	            buffer.append(" and  t.state = :state ");
	        }
			if(integralTime != null) {
	            buffer.append(" and  t.integralTime = :integralTime ");
	        }
			if(overdueTime != null) {
	            buffer.append(" and  t.overdueTime = :overdueTime ");
	        }
	        if(StringUtils.isNotBlank(useRole)) {
	            buffer.append(" and  t.useRole = :useRole ");
	        }
	        if(StringUtils.isNotBlank(remark)) {
	            buffer.append(" and  t.remark = :remark ");
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
					if(StringUtils.isNotBlank(discountKind)) {
						query.setParameter("discountKind", discountKind);
					}
					if(StringUtils.isNotBlank(parValue)) {
						query.setParameter("parValue", parValue);
					}
					if(state!=null) {
						query.setParameter("state", state);
					}
					if(integralTime!=null) {
						query.setParameter("integralTime", integralTime);
					}
					if(overdueTime!=null) {
						query.setParameter("overdueTime", overdueTime);
					}
					if(StringUtils.isNotBlank(useRole)) {
						query.setParameter("useRole", useRole);
					}
					if(StringUtils.isNotBlank(remark)) {
						query.setParameter("remark", remark);
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
