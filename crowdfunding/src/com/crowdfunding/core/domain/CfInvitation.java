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

public class CfInvitation implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	

	//columns START
	/** */
	private java.lang.Long id;
	
	/** */
	private java.lang.String userId;
	
	/** */
	private java.lang.String beInvitedUserid;
	
	/** */
	private java.lang.String award;
	
	/** */
	private Integer isEffect;
	
	/** */
	private java.util.Date createTime;
	
	//columns END


	public CfInvitation(){
	}

	public CfInvitation(
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
	
	public java.lang.String getBeInvitedUserid() {
		return this.beInvitedUserid;
	}
	
	public void setBeInvitedUserid(java.lang.String value) {
		this.beInvitedUserid = value;
	}
	
	public java.lang.String getAward() {
		return this.award;
	}
	
	public void setAward(java.lang.String value) {
		this.award = value;
	}
	
	public Integer getIsEffect() {
		return this.isEffect;
	}
	
	public void setIsEffect(Integer value) {
		this.isEffect = value;
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
			.append("BeInvitedUserid",getBeInvitedUserid())
			.append("Award",getAward())
			.append("IsEffect",getIsEffect())
			.append("CreateTime",getCreateTime())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof CfInvitation == false) return false;
		if(this == obj) return true;
		CfInvitation other = (CfInvitation)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

