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



public class CfInvitationCondition  extends Condition{
	

		//columns START
		/** */
		private java.lang.Long id;
		
		/** */
		private java.lang.String userId;
		
		/** */
		private java.lang.String beInvitedUserid;
		
		/** */
		private java.lang.String award;
		
		/** */
		private Integer isEffect;
		
		/** */
		private java.util.Date createTime;
		
		//columns END
		public java.lang.String getUserId() {
			return this.userId;
		}
		
		public void setUserId(java.lang.String value) {
			this.userId = value;
		}
		
		public java.lang.String getBeInvitedUserid() {
			return this.beInvitedUserid;
		}
		
		public void setBeInvitedUserid(java.lang.String value) {
			this.beInvitedUserid = value;
		}
		
		public java.lang.String getAward() {
			return this.award;
		}
		
		public void setAward(java.lang.String value) {
			this.award = value;
		}
		
		public Integer getIsEffect() {
			return this.isEffect;
		}
		
		public void setIsEffect(Integer value) {
			this.isEffect = value;
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
		buffer.append("select t from CfInvitation t where 1=1 ");
		
			if(id != null) {
	            buffer.append(" and  t.id = :id ");
	        }
	        if(StringUtils.isNotBlank(userId)) {
	            buffer.append(" and  t.userId = :userId ");
	        }
	        if(StringUtils.isNotBlank(beInvitedUserid)) {
	            buffer.append(" and  t.beInvitedUserid = :beInvitedUserid ");
	        }
	        if(StringUtils.isNotBlank(award)) {
	            buffer.append(" and  t.award = :award ");
	        }
			if(isEffect != null) {
	            buffer.append(" and  t.isEffect = :isEffect ");
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
					if(StringUtils.isNotBlank(beInvitedUserid)) {
						query.setParameter("beInvitedUserid", beInvitedUserid);
					}
					if(StringUtils.isNotBlank(award)) {
						query.setParameter("award", award);
					}
					if(isEffect!=null) {
						query.setParameter("isEffect", isEffect);
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
