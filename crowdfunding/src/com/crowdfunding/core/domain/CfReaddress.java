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

public class CfReaddress implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	

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


	public CfReaddress(){
	}

	public CfReaddress(
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
	
	
	
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("UserId",getUserId())
			.append("ReceivesName",getReceivesName())
			.append("ReceivesCity",getReceivesCity())
			.append("ReceivesDetail",getReceivesDetail())
			.append("ReceivesCode",getReceivesCode())
			.append("Mobile",getMobile())
			.append("IsDefault",getIsDefault())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof CfReaddress == false) return false;
		if(this == obj) return true;
		CfReaddress other = (CfReaddress)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

