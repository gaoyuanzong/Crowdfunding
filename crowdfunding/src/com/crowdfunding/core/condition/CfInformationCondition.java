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



public class CfInformationCondition  extends Condition{
	

		//columns START
		/** */
		private java.lang.Long id;
		
		/** */
		private java.lang.String sendUserId;
		
		/** */
		private java.lang.String receiveUserId;
		
		/** */
		private java.lang.String content;
		
		/** */
		private java.util.Date createTime;
		
		//columns END
		public java.lang.String getSendUserId() {
			return this.sendUserId;
		}
		
		public void setSendUserId(java.lang.String value) {
			this.sendUserId = value;
		}
		
		public java.lang.String getReceiveUserId() {
			return this.receiveUserId;
		}
		
		public void setReceiveUserId(java.lang.String value) {
			this.receiveUserId = value;
		}
		
		public java.lang.String getContent() {
			return this.content;
		}
		
		public void setContent(java.lang.String value) {
			this.content = value;
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
		buffer.append("select t from CfInformation t where 1=1 ");
		
			if(id != null) {
	            buffer.append(" and  t.id = :id ");
	        }
	        if(StringUtils.isNotBlank(sendUserId)) {
	            buffer.append(" and  t.sendUserId = :sendUserId ");
	        }
	        if(StringUtils.isNotBlank(receiveUserId)) {
	            buffer.append(" and  t.receiveUserId = :receiveUserId ");
	        }
	        if(StringUtils.isNotBlank(content)) {
	            buffer.append(" and  t.content = :content ");
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
					if(StringUtils.isNotBlank(sendUserId)) {
						query.setParameter("sendUserId", sendUserId);
					}
					if(StringUtils.isNotBlank(receiveUserId)) {
						query.setParameter("receiveUserId", receiveUserId);
					}
					if(StringUtils.isNotBlank(content)) {
						query.setParameter("content", content);
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
