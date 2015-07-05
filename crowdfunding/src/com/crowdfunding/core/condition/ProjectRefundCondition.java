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



public class ProjectRefundCondition  extends Condition{
	

		//columns START
		/** 退款id,自增*/
		private java.lang.Long id;
		
		/** 退款人*/
		private java.lang.String userId;
		
		/** 项目ID*/
		private java.lang.Long projectId;
		
		/** 认购单ID*/
		private java.lang.Long subscribeId;
		
		/** 支付订单号*/
		private java.lang.String orderId;
		
		/** 退款金额*/
		private Long refundAmount;
		
		/** 退款状态*/
		private java.lang.Integer refundStatus;
		
		/** 审核状态*/
		private java.lang.Integer checkStatus;
		
		/** 退款订单号*/
		private java.lang.String refundOrderId;
		
		/** 退款时间*/
		private java.util.Date refundTime;
		
		/** 创建时间*/
		private java.util.Date createTime;
		
		/** 更新时间*/
		private java.util.Date updateTime;
		
		/** 交易单号*/
		private java.lang.String transactionId;
		
		/** 退款类型：0整单退1部分退*/
		private java.lang.Integer refundType;
		
		/** 退款描述*/
		private java.lang.String refundDesc;
		
		/** 佣金状态：是否已经收取佣金 10 未收；20，已收（只有跳票项目的退款单这个字段才有对应值）*/
		private Integer commissionStatus;
		
		//columns END
		public java.lang.String getUserId() {
			return this.userId;
		}
		
		public void setUserId(java.lang.String value) {
			this.userId = value;
		}
		
		public java.lang.Long getProjectId() {
			return this.projectId;
		}
		
		public void setProjectId(java.lang.Long value) {
			this.projectId = value;
		}
		
		public java.lang.Long getSubscribeId() {
			return this.subscribeId;
		}
		
		public void setSubscribeId(java.lang.Long value) {
			this.subscribeId = value;
		}
		
		public java.lang.String getOrderId() {
			return this.orderId;
		}
		
		public void setOrderId(java.lang.String value) {
			this.orderId = value;
		}
		
		public Long getRefundAmount() {
			return this.refundAmount;
		}
		
		public void setRefundAmount(Long value) {
			this.refundAmount = value;
		}
		
		public java.lang.Integer getRefundStatus() {
			return this.refundStatus;
		}
		
		public void setRefundStatus(java.lang.Integer value) {
			this.refundStatus = value;
		}
		
		public java.lang.Integer getCheckStatus() {
			return this.checkStatus;
		}
		
		public void setCheckStatus(java.lang.Integer value) {
			this.checkStatus = value;
		}
		
		public java.lang.String getRefundOrderId() {
			return this.refundOrderId;
		}
		
		public void setRefundOrderId(java.lang.String value) {
			this.refundOrderId = value;
		}
		
		public java.util.Date getRefundTime() {
			return this.refundTime;
		}
		
		public void setRefundTime(java.util.Date value) {
			this.refundTime = value;
		}
		
		public java.util.Date getCreateTime() {
			return this.createTime;
		}
		
		public void setCreateTime(java.util.Date value) {
			this.createTime = value;
		}
		
		public java.util.Date getUpdateTime() {
			return this.updateTime;
		}
		
		public void setUpdateTime(java.util.Date value) {
			this.updateTime = value;
		}
		
		public java.lang.String getTransactionId() {
			return this.transactionId;
		}
		
		public void setTransactionId(java.lang.String value) {
			this.transactionId = value;
		}
		
		public java.lang.Integer getRefundType() {
			return this.refundType;
		}
		
		public void setRefundType(java.lang.Integer value) {
			this.refundType = value;
		}
		
		public java.lang.String getRefundDesc() {
			return this.refundDesc;
		}
		
		public void setRefundDesc(java.lang.String value) {
			this.refundDesc = value;
		}
		
		public Integer getCommissionStatus() {
			return this.commissionStatus;
		}
		
		public void setCommissionStatus(Integer value) {
			this.commissionStatus = value;
		}
		

	
	@Override
	public String getInitialHql() {
		setIsSQL(false);
		StringBuffer buffer=new StringBuffer();
		buffer.append("select t from ProjectRefund t where 1=1 ");
		
			if(id != null) {
	            buffer.append(" and  t.id = :id ");
	        }
	        if(StringUtils.isNotBlank(userId)) {
	            buffer.append(" and  t.userId = :userId ");
	        }
			if(projectId != null) {
	            buffer.append(" and  t.projectId = :projectId ");
	        }
			if(subscribeId != null) {
	            buffer.append(" and  t.subscribeId = :subscribeId ");
	        }
	        if(StringUtils.isNotBlank(orderId)) {
	            buffer.append(" and  t.orderId = :orderId ");
	        }
			if(refundAmount != null) {
	            buffer.append(" and  t.refundAmount = :refundAmount ");
	        }
			if(refundStatus != null) {
	            buffer.append(" and  t.refundStatus = :refundStatus ");
	        }
			if(checkStatus != null) {
	            buffer.append(" and  t.checkStatus = :checkStatus ");
	        }
	        if(StringUtils.isNotBlank(refundOrderId)) {
	            buffer.append(" and  t.refundOrderId = :refundOrderId ");
	        }
			if(refundTime != null) {
	            buffer.append(" and  t.refundTime = :refundTime ");
	        }
			if(createTime != null) {
	            buffer.append(" and  t.createTime = :createTime ");
	        }
			if(updateTime != null) {
	            buffer.append(" and  t.updateTime = :updateTime ");
	        }
	        if(StringUtils.isNotBlank(transactionId)) {
	            buffer.append(" and  t.transactionId = :transactionId ");
	        }
			if(refundType != null) {
	            buffer.append(" and  t.refundType = :refundType ");
	        }
	        if(StringUtils.isNotBlank(refundDesc)) {
	            buffer.append(" and  t.refundDesc = :refundDesc ");
	        }
			if(commissionStatus != null) {
	            buffer.append(" and  t.commissionStatus = :commissionStatus ");
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
					if(projectId!=null) {
						query.setParameter("projectId", projectId);
					}
					if(subscribeId!=null) {
						query.setParameter("subscribeId", subscribeId);
					}
					if(StringUtils.isNotBlank(orderId)) {
						query.setParameter("orderId", orderId);
					}
					if(refundAmount!=null) {
						query.setParameter("refundAmount", refundAmount);
					}
					if(refundStatus!=null) {
						query.setParameter("refundStatus", refundStatus);
					}
					if(checkStatus!=null) {
						query.setParameter("checkStatus", checkStatus);
					}
					if(StringUtils.isNotBlank(refundOrderId)) {
						query.setParameter("refundOrderId", refundOrderId);
					}
					if(refundTime!=null) {
						query.setParameter("refundTime", refundTime);
					}
					if(createTime!=null) {
						query.setParameter("createTime", createTime);
					}
					if(updateTime!=null) {
						query.setParameter("updateTime", updateTime);
					}
					if(StringUtils.isNotBlank(transactionId)) {
						query.setParameter("transactionId", transactionId);
					}
					if(refundType!=null) {
						query.setParameter("refundType", refundType);
					}
					if(StringUtils.isNotBlank(refundDesc)) {
						query.setParameter("refundDesc", refundDesc);
					}
					if(commissionStatus!=null) {
						query.setParameter("commissionStatus", commissionStatus);
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
