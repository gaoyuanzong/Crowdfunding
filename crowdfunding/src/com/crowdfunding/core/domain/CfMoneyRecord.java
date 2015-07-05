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

public class CfMoneyRecord implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	

	//columns START
	/** */
	private java.lang.Long id;
	
	/** */
	private java.lang.String userId;
	
	/** */
	private java.lang.String recordKind;
	
	/** */
	private java.lang.Integer recordState;
	
	/** */
	private java.lang.String description;
	
	/** */
	private java.util.Date createTime;
	
	//columns END


	public CfMoneyRecord(){
	}

	public CfMoneyRecord(
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
	
	public java.lang.String getRecordKind() {
		return this.recordKind;
	}
	
	public void setRecordKind(java.lang.String value) {
		this.recordKind = value;
	}
	
	public java.lang.Integer getRecordState() {
		return this.recordState;
	}
	
	public void setRecordState(java.lang.Integer value) {
		this.recordState = value;
	}
	
	public java.lang.String getDescription() {
		return this.description;
	}
	
	public void setDescription(java.lang.String value) {
		this.description = value;
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
			.append("RecordKind",getRecordKind())
			.append("RecordState",getRecordState())
			.append("Description",getDescription())
			.append("CreateTime",getCreateTime())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof CfMoneyRecord == false) return false;
		if(this == obj) return true;
		CfMoneyRecord other = (CfMoneyRecord)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

