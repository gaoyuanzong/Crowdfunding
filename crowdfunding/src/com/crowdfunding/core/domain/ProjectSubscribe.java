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

public class ProjectSubscribe implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	

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
	private java.math.BigDecimal freight;
	
	/** 支持金额*/
	private java.math.BigDecimal supportAmount;
	
	/** 支付金额*/
	private java.math.BigDecimal payAmount;
	
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


	public ProjectSubscribe(){
	}

	public ProjectSubscribe(
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
	
	public java.math.BigDecimal getFreight() {
		return this.freight;
	}
	
	public void setFreight(java.math.BigDecimal value) {
		this.freight = value;
	}
	
	public java.math.BigDecimal getSupportAmount() {
		return this.supportAmount;
	}
	
	public void setSupportAmount(java.math.BigDecimal value) {
		this.supportAmount = value;
	}
	
	public java.math.BigDecimal getPayAmount() {
		return this.payAmount;
	}
	
	public void setPayAmount(java.math.BigDecimal value) {
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
	
	
	
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("UserId",getUserId())
			.append("ProjectId",getProjectId())
			.append("RedoundId",getRedoundId())
			.append("AddressId",getAddressId())
			.append("SubscribeStatus",getSubscribeStatus())
			.append("Freight",getFreight())
			.append("SupportAmount",getSupportAmount())
			.append("PayAmount",getPayAmount())
			.append("PayedTime",getPayedTime())
			.append("IsRedound",getIsRedound())
			.append("OrderId",getOrderId())
			.append("CreateTime",getCreateTime())
			.append("IpdateTime",getIpdateTime())
			.append("ExpressCompany",getExpressCompany())
			.append("ExpressNum",getExpressNum())
			.append("Remarks",getRemarks())
			.append("TransactionId",getTransactionId())
			.append("PayStatus",getPayStatus())
			.append("Email",getEmail())
			.append("ProjectTag",getProjectTag())
			.append("CsRemarks",getCsRemarks())
			.append("InvoiceFlag",getInvoiceFlag())
			.append("InvoiceTitle",getInvoiceTitle())
			.append("Status",getStatus())
			.append("CancelTag",getCancelTag())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof ProjectSubscribe == false) return false;
		if(this == obj) return true;
		ProjectSubscribe other = (ProjectSubscribe)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

