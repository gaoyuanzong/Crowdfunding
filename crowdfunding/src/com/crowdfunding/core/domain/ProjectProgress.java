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

public class ProjectProgress implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	

	//columns START
	/** 进度Id*/
	private java.lang.Long id;
	
	/** 项目发起人*/
	private java.lang.String userId;
	
	/** 项目ID*/
	private java.lang.Long projectId;
	
	/** 项目名称*/
	private java.lang.String projectName;
	
	/** 进度内容*/
	private java.lang.String progressContent;
	
	/** 图片*/
	private java.lang.String progressImage;
	
	/** 创建时间*/
	private java.util.Date createTime;
	
	/** 缩略图*/
	private java.lang.String progressThumImage;
	
	//columns END


	public ProjectProgress(){
	}

	public ProjectProgress(
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
	
	public java.lang.String getProjectName() {
		return this.projectName;
	}
	
	public void setProjectName(java.lang.String value) {
		this.projectName = value;
	}
	
	public java.lang.String getProgressContent() {
		return this.progressContent;
	}
	
	public void setProgressContent(java.lang.String value) {
		this.progressContent = value;
	}
	
	public java.lang.String getProgressImage() {
		return this.progressImage;
	}
	
	public void setProgressImage(java.lang.String value) {
		this.progressImage = value;
	}
	
	public java.util.Date getCreateTime() {
		return this.createTime;
	}
	
	public void setCreateTime(java.util.Date value) {
		this.createTime = value;
	}
	
	public java.lang.String getProgressThumImage() {
		return this.progressThumImage;
	}
	
	public void setProgressThumImage(java.lang.String value) {
		this.progressThumImage = value;
	}
	
	
	
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("UserId",getUserId())
			.append("ProjectId",getProjectId())
			.append("ProjectName",getProjectName())
			.append("ProgressContent",getProgressContent())
			.append("ProgressImage",getProgressImage())
			.append("CreateTime",getCreateTime())
			.append("ProgressThumImage",getProgressThumImage())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof ProjectProgress == false) return false;
		if(this == obj) return true;
		ProjectProgress other = (ProjectProgress)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

