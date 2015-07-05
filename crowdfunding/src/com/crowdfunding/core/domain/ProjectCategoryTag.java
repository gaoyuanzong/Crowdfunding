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

public class ProjectCategoryTag implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	

	//columns START
	/** */
	private java.lang.Long id;
	
	/** 名称*/
	private String name;
	
	/** 0-分类 1-标签*/
	private java.lang.Integer type;
	
	/** 创建时间*/
	private java.util.Date createdTime;
	
	/** 修改时间*/
	private java.util.Date modifiedTime;
	
	/** 排序*/
	private java.lang.Integer sortId;
	
	//columns END


	public ProjectCategoryTag(){
	}

	public ProjectCategoryTag(
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
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public java.lang.Integer getType() {
		return this.type;
	}
	
	public void setType(java.lang.Integer value) {
		this.type = value;
	}
	
	public java.util.Date getCreatedTime() {
		return this.createdTime;
	}
	
	public void setCreatedTime(java.util.Date value) {
		this.createdTime = value;
	}
	
	public java.util.Date getModifiedTime() {
		return this.modifiedTime;
	}
	
	public void setModifiedTime(java.util.Date value) {
		this.modifiedTime = value;
	}
	
	public java.lang.Integer getSortId() {
		return this.sortId;
	}
	
	public void setSortId(java.lang.Integer value) {
		this.sortId = value;
	}
	
	
	
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("Name",getName())
			.append("Type",getType())
			.append("CreatedTime",getCreatedTime())
			.append("ModifiedTime",getModifiedTime())
			.append("SortId",getSortId())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof ProjectCategoryTag == false) return false;
		if(this == obj) return true;
		ProjectCategoryTag other = (ProjectCategoryTag)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

