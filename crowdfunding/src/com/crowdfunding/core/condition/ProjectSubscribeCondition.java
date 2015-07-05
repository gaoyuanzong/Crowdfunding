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



public class ProjectSubscribeCondition  extends Condition{
	

		//columns START
		/** 订购单ID*/
		private java.lang.Long id;
		
		/** 用户*/
		private java.lang.String userId;
		
		/** 项目ID*/
		private java.lang.Long projectId;
		
		/** 回报ID*/
		private java.lang.Long redoundId;
		
		/** 收获地址ID*/
		private java.lang.Long addressId;
		
		/** 认购状态*/
		private java.lang.Integer subscribeStatus;
		
		/** 运费*/
		private Long freight;
		
		/** 支持金额*/
		private Long supportAmount;
		
		/** 支付金额*/
		private Long payAmount;
		
		/** 支付时间*/
		private java.util.Date payedTime;
		
		/** 是否需要回报*/
		private java.lang.Integer isRedound;
		
		/** 订单号*/
		private java.lang.String orderId;
		
		/** 创建时间*/
		private java.util.Date createTime;
		
		/** 更新时间*/
		private java.util.Date ipdateTime;
		
		/** 快递公司*/
		private java.lang.String expressCompany;
		
		/** 运单号*/
		private java.lang.String expressNum;
		
		/** 备注*/
		private java.lang.String remarks;
		
		/** 交易单*/
		private java.lang.String transactionId;
		
		/** 支付状态*/
		private Integer payStatus;
		
		/** email*/
		private java.lang.String email;
		
		/** 项目标签*/
		private java.lang.String projectTag;
		
		/** 客服备注*/
		private java.lang.String csRemarks;
		
		/** 0-无需发票；1-需要发票*/
		private Integer invoiceFlag;
		
		/** 发票标题*/
		private java.lang.String invoiceTitle;
		
		/** 逻辑删除标志0正常1删除*/
		private Integer status;
		
		/** 0-未取消，1-单笔退款*/
		private java.lang.Integer cancelTag;
		
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
		
		public java.lang.Long getRedoundId() {
			return this.redoundId;
		}
		
		public void setRedoundId(java.lang.Long value) {
			this.redoundId = value;
		}
		
		public java.lang.Long getAddressId() {
			return this.addressId;
		}
		
		public void setAddressId(java.lang.Long value) {
			this.addressId = value;
		}
		
		public java.lang.Integer getSubscribeStatus() {
			return this.subscribeStatus;
		}
		
		public void setSubscribeStatus(java.lang.Integer value) {
			this.subscribeStatus = value;
		}
		
		public Long getFreight() {
			return this.freight;
		}
		
		public void setFreight(Long value) {
			this.freight = value;
		}
		
		public Long getSupportAmount() {
			return this.supportAmount;
		}
		
		public void setSupportAmount(Long value) {
			this.supportAmount = value;
		}
		
		public Long getPayAmount() {
			return this.payAmount;
		}
		
		public void setPayAmount(Long value) {
			this.payAmount = value;
		}
		
		public java.util.Date getPayedTime() {
			return this.payedTime;
		}
		
		public void setPayedTime(java.util.Date value) {
			this.payedTime = value;
		}
		
		public java.lang.Integer getIsRedound() {
			return this.isRedound;
		}
		
		public void setIsRedound(java.lang.Integer value) {
			this.isRedound = value;
		}
		
		public java.lang.String getOrderId() {
			return this.orderId;
		}
		
		public void setOrderId(java.lang.String value) {
			this.orderId = value;
		}
		
		public java.util.Date getCreateTime() {
			return this.createTime;
		}
		
		public void setCreateTime(java.util.Date value) {
			this.createTime = value;
		}
		
		public java.util.Date getIpdateTime() {
			return this.ipdateTime;
		}
		
		public void setIpdateTime(java.util.Date value) {
			this.ipdateTime = value;
		}
		
		public java.lang.String getExpressCompany() {
			return this.expressCompany;
		}
		
		public void setExpressCompany(java.lang.String value) {
			this.expressCompany = value;
		}
		
		public java.lang.String getExpressNum() {
			return this.expressNum;
		}
		
		public void setExpressNum(java.lang.String value) {
			this.expressNum = value;
		}
		
		public java.lang.String getRemarks() {
			return this.remarks;
		}
		
		public void setRemarks(java.lang.String value) {
			this.remarks = value;
		}
		
		public java.lang.String getTransactionId() {
			return this.transactionId;
		}
		
		public void setTransactionId(java.lang.String value) {
			this.transactionId = value;
		}
		
		public Integer getPayStatus() {
			return this.payStatus;
		}
		
		public void setPayStatus(Integer value) {
			this.payStatus = value;
		}
		
		public java.lang.String getEmail() {
			return this.email;
		}
		
		public void setEmail(java.lang.String value) {
			this.email = value;
		}
		
		public java.lang.String getProjectTag() {
			return this.projectTag;
		}
		
		public void setProjectTag(java.lang.String value) {
			this.projectTag = value;
		}
		
		public java.lang.String getCsRemarks() {
			return this.csRemarks;
		}
		
		public void setCsRemarks(java.lang.String value) {
			this.csRemarks = value;
		}
		
		public Integer getInvoiceFlag() {
			return this.invoiceFlag;
		}
		
		public void setInvoiceFlag(Integer value) {
			this.invoiceFlag = value;
		}
		
		public java.lang.String getInvoiceTitle() {
			return this.invoiceTitle;
		}
		
		public void setInvoiceTitle(java.lang.String value) {
			this.invoiceTitle = value;
		}
		
		public Integer getStatus() {
			return this.status;
		}
		
		public void setStatus(Integer value) {
			this.status = value;
		}
		
		public java.lang.Integer getCancelTag() {
			return this.cancelTag;
		}
		
		public void setCancelTag(java.lang.Integer value) {
			this.cancelTag = value;
		}
		

	
	@Override
	public String getInitialHql() {
		setIsSQL(false);
		StringBuffer buffer=new StringBuffer();
		buffer.append("select t from ProjectSubscribe t where 1=1 ");
		
			if(id != null) {
	            buffer.append(" and  t.id = :id ");
	        }
	        if(StringUtils.isNotBlank(userId)) {
	            buffer.append(" and  t.userId = :userId ");
	        }
			if(projectId != null) {
	            buffer.append(" and  t.projectId = :projectId ");
	        }
			if(redoundId != null) {
	            buffer.append(" and  t.redoundId = :redoundId ");
	        }
			if(addressId != null) {
	            buffer.append(" and  t.addressId = :addressId ");
	        }
			if(subscribeStatus != null) {
	            buffer.append(" and  t.subscribeStatus = :subscribeStatus ");
	        }
			if(freight != null) {
	            buffer.append(" and  t.freight = :freight ");
	        }
			if(supportAmount != null) {
	            buffer.append(" and  t.supportAmount = :supportAmount ");
	        }
			if(payAmount != null) {
	            buffer.append(" and  t.payAmount = :payAmount ");
	        }
			if(payedTime != null) {
	            buffer.append(" and  t.payedTime = :payedTime ");
	        }
			if(isRedound != null) {
	            buffer.append(" and  t.isRedound = :isRedound ");
	        }
	        if(StringUtils.isNotBlank(orderId)) {
	            buffer.append(" and  t.orderId = :orderId ");
	        }
			if(createTime != null) {
	            buffer.append(" and  t.createTime = :createTime ");
	        }
			if(ipdateTime != null) {
	            buffer.append(" and  t.ipdateTime = :ipdateTime ");
	        }
	        if(StringUtils.isNotBlank(expressCompany)) {
	            buffer.append(" and  t.expressCompany = :expressCompany ");
	        }
	        if(StringUtils.isNotBlank(expressNum)) {
	            buffer.append(" and  t.expressNum = :expressNum ");
	        }
	        if(StringUtils.isNotBlank(remarks)) {
	            buffer.append(" and  t.remarks = :remarks ");
	        }
	        if(StringUtils.isNotBlank(transactionId)) {
	            buffer.append(" and  t.transactionId = :transactionId ");
	        }
			if(payStatus != null) {
	            buffer.append(" and  t.payStatus = :payStatus ");
	        }
	        if(StringUtils.isNotBlank(email)) {
	            buffer.append(" and  t.email = :email ");
	        }
	        if(StringUtils.isNotBlank(projectTag)) {
	            buffer.append(" and  t.projectTag = :projectTag ");
	        }
	        if(StringUtils.isNotBlank(csRemarks)) {
	            buffer.append(" and  t.csRemarks = :csRemarks ");
	        }
			if(invoiceFlag != null) {
	            buffer.append(" and  t.invoiceFlag = :invoiceFlag ");
	        }
	        if(StringUtils.isNotBlank(invoiceTitle)) {
	            buffer.append(" and  t.invoiceTitle = :invoiceTitle ");
	        }
			if(status != null) {
	            buffer.append(" and  t.status = :status ");
	        }
			if(cancelTag != null) {
	            buffer.append(" and  t.cancelTag = :cancelTag ");
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
					if(redoundId!=null) {
						query.setParameter("redoundId", redoundId);
					}
					if(addressId!=null) {
						query.setParameter("addressId", addressId);
					}
					if(subscribeStatus!=null) {
						query.setParameter("subscribeStatus", subscribeStatus);
					}
					if(freight!=null) {
						query.setParameter("freight", freight);
					}
					if(supportAmount!=null) {
						query.setParameter("supportAmount", supportAmount);
					}
					if(payAmount!=null) {
						query.setParameter("payAmount", payAmount);
					}
					if(payedTime!=null) {
						query.setParameter("payedTime", payedTime);
					}
					if(isRedound!=null) {
						query.setParameter("isRedound", isRedound);
					}
					if(StringUtils.isNotBlank(orderId)) {
						query.setParameter("orderId", orderId);
					}
					if(createTime!=null) {
						query.setParameter("createTime", createTime);
					}
					if(ipdateTime!=null) {
						query.setParameter("ipdateTime", ipdateTime);
					}
					if(StringUtils.isNotBlank(expressCompany)) {
						query.setParameter("expressCompany", expressCompany);
					}
					if(StringUtils.isNotBlank(expressNum)) {
						query.setParameter("expressNum", expressNum);
					}
					if(StringUtils.isNotBlank(remarks)) {
						query.setParameter("remarks", remarks);
					}
					if(StringUtils.isNotBlank(transactionId)) {
						query.setParameter("transactionId", transactionId);
					}
					if(payStatus!=null) {
						query.setParameter("payStatus", payStatus);
					}
					if(StringUtils.isNotBlank(email)) {
						query.setParameter("email", email);
					}
					if(StringUtils.isNotBlank(projectTag)) {
						query.setParameter("projectTag", projectTag);
					}
					if(StringUtils.isNotBlank(csRemarks)) {
						query.setParameter("csRemarks", csRemarks);
					}
					if(invoiceFlag!=null) {
						query.setParameter("invoiceFlag", invoiceFlag);
					}
					if(StringUtils.isNotBlank(invoiceTitle)) {
						query.setParameter("invoiceTitle", invoiceTitle);
					}
					if(status!=null) {
						query.setParameter("status", status);
					}
					if(cancelTag!=null) {
						query.setParameter("cancelTag", cancelTag);
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
