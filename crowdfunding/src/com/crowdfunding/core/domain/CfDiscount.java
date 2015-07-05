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

public class CfDiscount implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	

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


	public CfDiscount(){
	}

	public CfDiscount(
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
	
	
	
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("UserId",getUserId())
			.append("DiscountKind",getDiscountKind())
			.append("ParValue",getParValue())
			.append("State",getState())
			.append("IntegralTime",getIntegralTime())
			.append("OverdueTime",getOverdueTime())
			.append("UseRole",getUseRole())
			.append("Remark",getRemark())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof CfDiscount == false) return false;
		if(this == obj) return true;
		CfDiscount other = (CfDiscount)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

