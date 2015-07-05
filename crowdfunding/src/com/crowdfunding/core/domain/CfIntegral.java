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

public class CfIntegral implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	

	//columns START
	/** */
	private java.lang.Long id;
	
	/** */
	private java.lang.String userId;
	
	/** */
	private java.lang.String integralType;
	
	/** */
	private java.lang.String integralDetail;
	
	/** */
	private java.lang.String integralValue;
	
	/** */
	private java.util.Date createTime;
	
	//columns END


	public CfIntegral(){
	}

	public CfIntegral(
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
	
	public java.lang.String getIntegralType() {
		return this.integralType;
	}
	
	public void setIntegralType(java.lang.String value) {
		this.integralType = value;
	}
	
	public java.lang.String getIntegralDetail() {
		return this.integralDetail;
	}
	
	public void setIntegralDetail(java.lang.String value) {
		this.integralDetail = value;
	}
	
	public java.lang.String getIntegralValue() {
		return this.integralValue;
	}
	
	public void setIntegralValue(java.lang.String value) {
		this.integralValue = value;
	}
	
	public java.util.Date getCreateTime() {
		return this.createTime;
	}
	
	public void setCreateTime(java.util.Date value) {
		this.createTime = value;
	}
	
	
	
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("UserId",getUserId())
			.append("IntegralType",getIntegralType())
			.append("IntegralDetail",getIntegralDetail())
			.append("IntegralValue",getIntegralValue())
			.append("CreateTime",getCreateTime())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof CfIntegral == false) return false;
		if(this == obj) return true;
		CfIntegral other = (CfIntegral)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

