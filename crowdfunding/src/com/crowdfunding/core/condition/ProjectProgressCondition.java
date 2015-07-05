/*
 * Powered By [up72-framework]
 * Web Site: http://www.up72.com
 * Since 2006 - 2015
 */

package com.crowdfunding.core.condition;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.crowdfunding.core.common.Condition;
import com.crowdfunding.core.constants.ESortType;



public class ProjectProgressCondition  extends Condition{
	

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
		

	
	@Override
	public String getInitialHql() {
		setIsSQL(false);
		StringBuffer buffer=new StringBuffer();
		buffer.append("select t from ProjectProgress t where 1=1 ");
		
			if(id != null) {
	            buffer.append(" and  t.id = :id ");
	        }
	        if(StringUtils.isNotBlank(userId)) {
	            buffer.append(" and  t.userId = :userId ");
	        }
			if(projectId != null) {
	            buffer.append(" and  t.projectId = :projectId ");
	        }
	        if(StringUtils.isNotBlank(projectName)) {
	            buffer.append(" and  t.projectName = :projectName ");
	        }
	        if(StringUtils.isNotBlank(progressContent)) {
	            buffer.append(" and  t.progressContent = :progressContent ");
	        }
	        if(StringUtils.isNotBlank(progressImage)) {
	            buffer.append(" and  t.progressImage = :progressImage ");
	        }
			if(createTime != null) {
	            buffer.append(" and  t.createTime = :createTime ");
	        }
	        if(StringUtils.isNotBlank(progressThumImage)) {
	            buffer.append(" and  t.progressThumImage = :progressThumImage ");
	        }
		return buffer.toString();
	}
	
		
	@Override
	public Query prepareParams(Query query) {
		try {
					if(id!=null) {
						query.setParameter("id", id);
					}
					if(StringUtils.isNotBlank(userId)) {
						query.setParameter("userId", userId);
					}
					if(projectId!=null) {
						query.setParameter("projectId", projectId);
					}
					if(StringUtils.isNotBlank(projectName)) {
						query.setParameter("projectName", projectName);
					}
					if(StringUtils.isNotBlank(progressContent)) {
						query.setParameter("progressContent", progressContent);
					}
					if(StringUtils.isNotBlank(progressImage)) {
						query.setParameter("progressImage", progressImage);
					}
					if(createTime!=null) {
						query.setParameter("createTime", createTime);
					}
					if(StringUtils.isNotBlank(progressThumImage)) {
						query.setParameter("progressThumImage", progressThumImage);
					}
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		return query;
	}
	
	@Override
	public String getSortname(){
		if(StringUtils.isBlank(super.getSortname())){
			super.setSortorder(ESortType.ASC.getCode());
			return "id";
		}
		return super.getSortname();
	}
	
	@Override
	public String getDataFilterSql() {
		long bit=getCityBitDataFilter();
		if(bit>0){
			return " and bitand(item.bit,"+bit+")<>0 ";
		}
		return "";
	}

}
