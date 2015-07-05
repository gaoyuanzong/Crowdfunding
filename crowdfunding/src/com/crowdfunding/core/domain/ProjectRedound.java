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

public class ProjectRedound implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	

	//columns START
	/** 回报ID*/
	private java.lang.Long id;
	
	/** 项目ID*/
	private java.lang.Long projectId;
	
	/** 回报金额*/
	private java.math.BigDecimal amount;
	
	/** 回报类型*/
	private java.lang.Integer redoundType;
	
	/** 回报内容*/
	private java.lang.String redoundContent;
	
	/** 图片*/
	private java.lang.String redoundImage;
	
	/** 上限*/
	private java.lang.Integer limits;
	
	/** 运费*/
	private java.math.BigDecimal freight;
	
	/** 回报天次*/
	private java.lang.Integer redoundDays;
	
	/** 0-不可开发票，1-可开发票*/
	private java.lang.Integer invoiceStatus;
	
	/** 创建时间*/
	private java.util.Date createTime;
	
	/** 更新时间*/
	private java.util.Date updateTime;
	
	/** 排序*/
	private java.lang.Integer ind;
	
	//columns END


	public ProjectRedound(){
	}

	public ProjectRedound(
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
	
	public java.lang.Long getProjectId() {
		return this.projectId;
	}
	
	public void setProjectId(java.lang.Long value) {
		this.projectId = value;
	}
	
	public java.math.BigDecimal getAmount() {
		return this.amount;
	}
	
	public void setAmount(java.math.BigDecimal value) {
		this.amount = value;
	}
	
	public java.lang.Integer getRedoundType() {
		return this.redoundType;
	}
	
	public void setRedoundType(java.lang.Integer value) {
		this.redoundType = value;
	}
	
	public java.lang.String getRedoundContent() {
		return this.redoundContent;
	}
	
	public void setRedoundContent(java.lang.String value) {
		this.redoundContent = value;
	}
	
	public java.lang.String getRedoundImage() {
		return this.redoundImage;
	}
	
	public void setRedoundImage(java.lang.String value) {
		this.redoundImage = value;
	}
	
	public java.lang.Integer getLimits() {
		return this.limits;
	}
	
	public void setLimits(java.lang.Integer value) {
		this.limits = value;
	}
	
	public java.math.BigDecimal getFreight() {
		return this.freight;
	}
	
	public void setFreight(java.math.BigDecimal value) {
		this.freight = value;
	}
	
	public java.lang.Integer getRedoundDays() {
		return this.redoundDays;
	}
	
	public void setRedoundDays(java.lang.Integer value) {
		this.redoundDays = value;
	}
	
	public java.lang.Integer getInvoiceStatus() {
		return this.invoiceStatus;
	}
	
	public void setInvoiceStatus(java.lang.Integer value) {
		this.invoiceStatus = value;
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
	
	public java.lang.Integer getInd() {
		return this.ind;
	}
	
	public void setInd(java.lang.Integer value) {
		this.ind = value;
	}
	
	
	
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("ProjectId",getProjectId())
			.append("Amount",getAmount())
			.append("RedoundType",getRedoundType())
			.append("RedoundContent",getRedoundContent())
			.append("RedoundImage",getRedoundImage())
			.append("Limits",getLimits())
			.append("Freight",getFreight())
			.append("RedoundDays",getRedoundDays())
			.append("InvoiceStatus",getInvoiceStatus())
			.append("CreateTime",getCreateTime())
			.append("UpdateTime",getUpdateTime())
			.append("Ind",getInd())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof ProjectRedound == false) return false;
		if(this == obj) return true;
		ProjectRedound other = (ProjectRedound)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

