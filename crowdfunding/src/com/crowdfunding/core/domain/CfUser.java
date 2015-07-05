/*
 * Powered By [up72-framework]
 * Web Site: http://www.up72.com
 * Since 2006 - 2015
 */

package com.crowdfunding.core.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class CfUser implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	

	//columns START
	/** */
	private java.lang.Long id;
	
	/** */
	private java.lang.String userName;
	
	/** */
	private java.lang.String petName;
	
	/** */
	private java.lang.String realName;
	
	/** */
	private java.lang.String phone;
	
	/** */
	private Integer isPhone;
	
	/** */
	private java.lang.String mail;
	
	/** */
	private Integer isMail;
	
	/** */
	private java.lang.String idNumber;
	
	/** */
	private java.lang.String backPath;
	
	/** */
	private java.lang.String frontPath;
	
	/** */
	private Integer isIdentity;
	
	/** */
	private java.lang.String province;
	
	/** */
	private java.lang.String citys;
	
	/** */
	private java.lang.String address;
	
	/** */
	private java.lang.String personalStatement;
	
	/** */
	private java.lang.String invitationCode;
	
	/** */
	private java.lang.String personalCode;
	
	/** */
	private java.lang.String filePath;
	
	/** */
	private Integer isLock;
	
	/** */
	private Integer isActivate;
	
	/** */
	private java.util.Date registerTime;
	
	/** */
	private java.util.Date lastLoginTime;
	
	//columns END


	public CfUser(){
	}

	public CfUser(
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
	
	public java.lang.String getUserName() {
		return this.userName;
	}
	
	public void setUserName(java.lang.String value) {
		this.userName = value;
	}
	
	public java.lang.String getPetName() {
		return this.petName;
	}
	
	public void setPetName(java.lang.String value) {
		this.petName = value;
	}
	
	public java.lang.String getRealName() {
		return this.realName;
	}
	
	public void setRealName(java.lang.String value) {
		this.realName = value;
	}
	
	public java.lang.String getPhone() {
		return this.phone;
	}
	
	public void setPhone(java.lang.String value) {
		this.phone = value;
	}
	
	public Integer getIsPhone() {
		return this.isPhone;
	}
	
	public void setIsPhone(Integer value) {
		this.isPhone = value;
	}
	
	public java.lang.String getMail() {
		return this.mail;
	}
	
	public void setMail(java.lang.String value) {
		this.mail = value;
	}
	
	public Integer getIsMail() {
		return this.isMail;
	}
	
	public void setIsMail(Integer value) {
		this.isMail = value;
	}
	
	public java.lang.String getIdNumber() {
		return this.idNumber;
	}
	
	public void setIdNumber(java.lang.String value) {
		this.idNumber = value;
	}
	
	public java.lang.String getBackPath() {
		return this.backPath;
	}
	
	public void setBackPath(java.lang.String value) {
		this.backPath = value;
	}
	
	public java.lang.String getFrontPath() {
		return this.frontPath;
	}
	
	public void setFrontPath(java.lang.String value) {
		this.frontPath = value;
	}
	
	public Integer getIsIdentity() {
		return this.isIdentity;
	}
	
	public void setIsIdentity(Integer value) {
		this.isIdentity = value;
	}
	
	public java.lang.String getProvince() {
		return this.province;
	}
	
	public void setProvince(java.lang.String value) {
		this.province = value;
	}
	
	public java.lang.String getCitys() {
		return this.citys;
	}
	
	public void setCitys(java.lang.String value) {
		this.citys = value;
	}
	
	public java.lang.String getAddress() {
		return this.address;
	}
	
	public void setAddress(java.lang.String value) {
		this.address = value;
	}
	
	public java.lang.String getPersonalStatement() {
		return this.personalStatement;
	}
	
	public void setPersonalStatement(java.lang.String value) {
		this.personalStatement = value;
	}
	
	public java.lang.String getInvitationCode() {
		return invitationCode;
	}

	public void setInvitationCode(java.lang.String invitationCode) {
		this.invitationCode = invitationCode;
	}

	public java.lang.String getPersonalCode() {
		return personalCode;
	}

	public void setPersonalCode(java.lang.String personalCode) {
		this.personalCode = personalCode;
	}

	public java.lang.String getFilePath() {
		return filePath;
	}

	public void setFilePath(java.lang.String filePath) {
		this.filePath = filePath;
	}

	public Integer getIsLock() {
		return this.isLock;
	}
	
	public void setIsLock(Integer value) {
		this.isLock = value;
	}
	
	public Integer getIsActivate() {
		return this.isActivate;
	}
	
	public void setIsActivate(Integer value) {
		this.isActivate = value;
	}
	
	public java.util.Date getRegisterTime() {
		return this.registerTime;
	}
	
	public void setRegisterTime(java.util.Date value) {
		this.registerTime = value;
	}
	
	public java.util.Date getLastLoginTime() {
		return this.lastLoginTime;
	}
	
	public void setLastLoginTime(java.util.Date value) {
		this.lastLoginTime = value;
	}
	
	
	
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("UserName",getUserName())
			.append("PetName",getPetName())
			.append("RealName",getRealName())
			.append("Phone",getPhone())
			.append("IsPhone",getIsPhone())
			.append("Mail",getMail())
			.append("IsMail",getIsMail())
			.append("IdNumber",getIdNumber())
			.append("BackPath",getBackPath())
			.append("FrontPath",getFrontPath())
			.append("IsIdentity",getIsIdentity())
			.append("Province",getProvince())
			.append("Citys",getCitys())
			.append("Address",getAddress())
			.append("PersonalStatement",getPersonalStatement())
			.append("InvitationCode",getInvitationCode())
			.append("PersonalCode",getPersonalCode())
			.append("FilePath",getFilePath())
			.append("IsLock",getIsLock())
			.append("IsActivate",getIsActivate())
			.append("RegisterTime",getRegisterTime())
			.append("LastLoginTime",getLastLoginTime())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof CfUser == false) return false;
		if(this == obj) return true;
		CfUser other = (CfUser)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

