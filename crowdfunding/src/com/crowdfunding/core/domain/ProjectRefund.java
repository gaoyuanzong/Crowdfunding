/*
 * Powered By [up72-framework]
 * Web Site: http://www.up72.com
 * Since 2006 - 2015
 */

package com.crowdfunding.core.domain;

import java.util.Date;
import java.util.Set;
import java.util.HashSet;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class ProjectRefund implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	

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
	private java.math.BigDecimal refundAmount;
	
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


	public ProjectRefund(){
	}

	public ProjectRefund(
		java.lang.Long id
	){
		this.id = id;
	}

	

	public void setId(java.lang.Long value) {
		this.id = value;
	}
	
	public java.lang.Long getId() {
		return this.id;
	}
	
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
	
	public java.math.BigDecimal getRefundAmount() {
		return this.refundAmount;
	}
	
	public void setRefundAmount(java.math.BigDecimal value) {
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
	
	
	
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("UserId",getUserId())
			.append("ProjectId",getProjectId())
			.append("SubscribeId",getSubscribeId())
			.append("OrderId",getOrderId())
			.append("RefundAmount",getRefundAmount())
			.append("RefundStatus",getRefundStatus())
			.append("CheckStatus",getCheckStatus())
			.append("RefundOrderId",getRefundOrderId())
			.append("RefundTime",getRefundTime())
			.append("CreateTime",getCreateTime())
			.append("UpdateTime",getUpdateTime())
			.append("TransactionId",getTransactionId())
			.append("RefundType",getRefundType())
			.append("RefundDesc",getRefundDesc())
			.append("CommissionStatus",getCommissionStatus())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof ProjectRefund == false) return false;
		if(this == obj) return true;
		ProjectRefund other = (ProjectRefund)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

