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



public class CfReaddressCondition  extends Condition{
	

		//columns START
		/** */
		private java.lang.Long id;
		
		/** */
		private java.lang.String userId;
		
		/** */
		private java.lang.String receivesName;
		
		/** */
		private java.lang.String receivesCity;
		
		/** */
		private java.lang.String receivesDetail;
		
		/** */
		private java.lang.String receivesCode;
		
		/** */
		private java.lang.String mobile;
		
		/** */
		private Integer isDefault;
		
		//columns END
		public java.lang.String getUserId() {
			return this.userId;
		}
		
		public void setUserId(java.lang.String value) {
			this.userId = value;
		}
		
		public java.lang.String getReceivesName() {
			return this.receivesName;
		}
		
		public void setReceivesName(java.lang.String value) {
			this.receivesName = value;
		}
		
		public java.lang.String getReceivesCity() {
			return this.receivesCity;
		}
		
		public void setReceivesCity(java.lang.String value) {
			this.receivesCity = value;
		}
		
		public java.lang.String getReceivesDetail() {
			return this.receivesDetail;
		}
		
		public void setReceivesDetail(java.lang.String value) {
			this.receivesDetail = value;
		}
		
		public java.lang.String getReceivesCode() {
			return this.receivesCode;
		}
		
		public void setReceivesCode(java.lang.String value) {
			this.receivesCode = value;
		}
		
		public java.lang.String getMobile() {
			return this.mobile;
		}
		
		public void setMobile(java.lang.String value) {
			this.mobile = value;
		}
		
		public Integer getIsDefault() {
			return this.isDefault;
		}
		
		public void setIsDefault(Integer value) {
			this.isDefault = value;
		}
		

	
	@Override
	public String getInitialHql() {
		setIsSQL(false);
		StringBuffer buffer=new StringBuffer();
		buffer.append("select t from CfReaddress t where 1=1 ");
		
			if(id != null) {
	            buffer.append(" and  t.id = :id ");
	        }
	        if(StringUtils.isNotBlank(userId)) {
	            buffer.append(" and  t.userId = :userId ");
	        }
	        if(StringUtils.isNotBlank(receivesName)) {
	            buffer.append(" and  t.receivesName = :receivesName ");
	        }
	        if(StringUtils.isNotBlank(receivesCity)) {
	            buffer.append(" and  t.receivesCity = :receivesCity ");
	        }
	        if(StringUtils.isNotBlank(receivesDetail)) {
	            buffer.append(" and  t.receivesDetail = :receivesDetail ");
	        }
	        if(StringUtils.isNotBlank(receivesCode)) {
	            buffer.append(" and  t.receivesCode = :receivesCode ");
	        }
	        if(StringUtils.isNotBlank(mobile)) {
	            buffer.append(" and  t.mobile = :mobile ");
	        }
			if(isDefault != null) {
	            buffer.append(" and  t.isDefault = :isDefault ");
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
					if(StringUtils.isNotBlank(receivesName)) {
						query.setParameter("receivesName", receivesName);
					}
					if(StringUtils.isNotBlank(receivesCity)) {
						query.setParameter("receivesCity", receivesCity);
					}
					if(StringUtils.isNotBlank(receivesDetail)) {
						query.setParameter("receivesDetail", receivesDetail);
					}
					if(StringUtils.isNotBlank(receivesCode)) {
						query.setParameter("receivesCode", receivesCode);
					}
					if(StringUtils.isNotBlank(mobile)) {
						query.setParameter("mobile", mobile);
					}
					if(isDefault!=null) {
						query.setParameter("isDefault", isDefault);
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
