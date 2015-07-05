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

public class CfInformation implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	

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


	public CfInformation(){
	}

	public CfInformation(
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
	
	
	
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("SendUserId",getSendUserId())
			.append("ReceiveUserId",getReceiveUserId())
			.append("Content",getContent())
			.append("CreateTime",getCreateTime())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof CfInformation == false) return false;
		if(this == obj) return true;
		CfInformation other = (CfInformation)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

