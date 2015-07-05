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



public class ProjectCondition  extends Condition{
	

		//columns START
		/** 项目ID*/
		private java.lang.Long id;
		
		/** 项目标签*/
		private java.lang.String projectTag;
		
		/** 项目名称*/
		private java.lang.String projectName;
		
		/** 广告词*/
		private java.lang.String projectAdWord;
		
		/** 项目类型*/
		private java.lang.Long projectType;
		
		/** 项目状态*/
		private java.lang.Integer projectStatus;
		
		/** 募集金额*/
		private java.math.BigDecimal amount;
		
		/** 已募集金额*/
		private java.math.BigDecimal collectedAmount;
		
		/** 虚拟募集金额*/
		private java.math.BigDecimal virtualCollectedAmount;
		
		/** 是否开启虚拟募集金额*/
		private java.lang.Integer isVirtualCollectedAmount;
		
		/** 募集上限*/
		private java.lang.Integer topLimit;
		
		/** 募集天数*/
		private java.lang.Integer ccollectDays;
		
		/** 项目发起人*/
		private java.lang.String projectSponsor;
		
		/** 项目图片*/
		private java.lang.String projectImage;
		
		/** 主页图片*/
		private java.lang.String projectThumImage;
		
		/** 视频地址*/
		private java.lang.String videoAddr;
		
		/** 支持人数*/
		private java.lang.Integer supports;
		
		/** 项目简介*/
		private java.lang.String projectSummary;
		
		/** 项目详情*/
		private java.lang.String projectDetails;
		
		/** 项目地点*/
		private java.lang.String projectAddr;
		
		/** 项目附件*/
		private java.lang.String projectAttachment;
		
		/** 上架时间*/
		private java.util.Date salesTime;
		
		/** 审核次数*/
		private java.lang.Integer auditCount;
		
		/** 不通过原因*/
		private java.lang.String auditReson;
		
		/** 创建时间*/
		private java.util.Date createTime;
		
		/** 更新时间*/
		private java.util.Date updateTime;
		
		/** 发起人支付宝账户*/
		private java.lang.String userAlipayAccount;
		
		/** 支付宝账户名*/
		private java.lang.String userAlipayName;
		
		/** 佣金费率*/
		private java.math.BigDecimal rate;
		
		/** 发起人类型*/
		private Integer userType;
		
		/** 排序号*/
		private java.lang.Integer ind;
		
		/** 0-未结束，1-众筹成功结束，2-众筹失败结束*/
		private java.lang.Integer closureType;
		
		/** 是否在前端显示0是1否*/
		private Integer display;
		
		/** 0-未发货；1-已发货*/
		private java.lang.Integer shipType;
		
		/** 发货日期*/
		private java.util.Date shipTime;
		
		/** 审核进度：
0-未设标签;
1-已面签；
2-已初评；
3-已复评；
4-已签合同*/
		private java.lang.Long reviewProgress;
		
		/** 放款状态：10-未放款；20-已开始放款 ; 30-已放款完成*/
		private java.lang.Integer lendingStatus;
		
		//columns END
		public java.lang.String getProjectTag() {
			return this.projectTag;
		}
		
		public void setProjectTag(java.lang.String value) {
			this.projectTag = value;
		}
		
		public java.lang.String getProjectName() {
			return this.projectName;
		}
		
		public void setProjectName(java.lang.String value) {
			this.projectName = value;
		}
		
		public java.lang.String getProjectAdWord() {
			return this.projectAdWord;
		}
		
		public void setProjectAdWord(java.lang.String value) {
			this.projectAdWord = value;
		}
		
		public java.lang.Long getProjectType() {
			return this.projectType;
		}
		
		public void setProjectType(java.lang.Long value) {
			this.projectType = value;
		}
		
		public java.lang.Integer getProjectStatus() {
			return this.projectStatus;
		}
		
		public void setProjectStatus(java.lang.Integer value) {
			this.projectStatus = value;
		}
		
		public java.math.BigDecimal getAmount() {
			return this.amount;
		}
		
		public void setAmount(java.math.BigDecimal value) {
			this.amount = value;
		}
		
		public java.math.BigDecimal getCollectedAmount() {
			return this.collectedAmount;
		}
		
		public void setCollectedAmount(java.math.BigDecimal value) {
			this.collectedAmount = value;
		}
		
		public java.math.BigDecimal getVirtualCollectedAmount() {
			return this.virtualCollectedAmount;
		}
		
		public void setVirtualCollectedAmount(java.math.BigDecimal value) {
			this.virtualCollectedAmount = value;
		}
		
		public java.lang.Integer getIsVirtualCollectedAmount() {
			return this.isVirtualCollectedAmount;
		}
		
		public void setIsVirtualCollectedAmount(java.lang.Integer value) {
			this.isVirtualCollectedAmount = value;
		}
		
		public java.lang.Integer getTopLimit() {
			return this.topLimit;
		}
		
		public void setTopLimit(java.lang.Integer value) {
			this.topLimit = value;
		}
		
		public java.lang.Integer getCcollectDays() {
			return this.ccollectDays;
		}
		
		public void setCcollectDays(java.lang.Integer value) {
			this.ccollectDays = value;
		}
		
		public java.lang.String getProjectSponsor() {
			return this.projectSponsor;
		}
		
		public void setProjectSponsor(java.lang.String value) {
			this.projectSponsor = value;
		}
		
		public java.lang.String getProjectImage() {
			return this.projectImage;
		}
		
		public void setProjectImage(java.lang.String value) {
			this.projectImage = value;
		}
		
		public java.lang.String getProjectThumImage() {
			return this.projectThumImage;
		}
		
		public void setProjectThumImage(java.lang.String value) {
			this.projectThumImage = value;
		}
		
		public java.lang.String getVideoAddr() {
			return this.videoAddr;
		}
		
		public void setVideoAddr(java.lang.String value) {
			this.videoAddr = value;
		}
		
		public java.lang.Integer getSupports() {
			return this.supports;
		}
		
		public void setSupports(java.lang.Integer value) {
			this.supports = value;
		}
		
		public java.lang.String getProjectSummary() {
			return this.projectSummary;
		}
		
		public void setProjectSummary(java.lang.String value) {
			this.projectSummary = value;
		}
		
		public java.lang.String getProjectDetails() {
			return this.projectDetails;
		}
		
		public void setProjectDetails(java.lang.String value) {
			this.projectDetails = value;
		}
		
		public java.lang.String getProjectAddr() {
			return this.projectAddr;
		}
		
		public void setProjectAddr(java.lang.String value) {
			this.projectAddr = value;
		}
		
		public java.lang.String getProjectAttachment() {
			return this.projectAttachment;
		}
		
		public void setProjectAttachment(java.lang.String value) {
			this.projectAttachment = value;
		}
		
		public java.util.Date getSalesTime() {
			return this.salesTime;
		}
		
		public void setSalesTime(java.util.Date value) {
			this.salesTime = value;
		}
		
		public java.lang.Integer getAuditCount() {
			return this.auditCount;
		}
		
		public void setAuditCount(java.lang.Integer value) {
			this.auditCount = value;
		}
		
		public java.lang.String getAuditReson() {
			return this.auditReson;
		}
		
		public void setAuditReson(java.lang.String value) {
			this.auditReson = value;
		}
		
		public java.util.Date getCreateTime() {
			return this.createTime;
		}
		
		public void setCreateTime(java.util.Date value) {
			this.createTime = value;
		}
		
		public java.util.Date getUpdateTime() {
			return this.updateTime;
		}
		
		public void setUpdateTime(java.util.Date value) {
			this.updateTime = value;
		}
		
		public java.lang.String getUserAlipayAccount() {
			return this.userAlipayAccount;
		}
		
		public void setUserAlipayAccount(java.lang.String value) {
			this.userAlipayAccount = value;
		}
		
		public java.lang.String getUserAlipayName() {
			return this.userAlipayName;
		}
		
		public void setUserAlipayName(java.lang.String value) {
			this.userAlipayName = value;
		}
		
		public java.math.BigDecimal getRate() {
			return this.rate;
		}
		
		public void setRate(java.math.BigDecimal value) {
			this.rate = value;
		}
		
		public Integer getUserType() {
			return this.userType;
		}
		
		public void setUserType(Integer value) {
			this.userType = value;
		}
		
		public java.lang.Integer getInd() {
			return this.ind;
		}
		
		public void setInd(java.lang.Integer value) {
			this.ind = value;
		}
		
		public java.lang.Integer getClosureType() {
			return this.closureType;
		}
		
		public void setClosureType(java.lang.Integer value) {
			this.closureType = value;
		}
		
		public Integer getDisplay() {
			return this.display;
		}
		
		public void setDisplay(Integer value) {
			this.display = value;
		}
		
		public java.lang.Integer getShipType() {
			return this.shipType;
		}
		
		public void setShipType(java.lang.Integer value) {
			this.shipType = value;
		}
		
		public java.util.Date getShipTime() {
			return this.shipTime;
		}
		
		public void setShipTime(java.util.Date value) {
			this.shipTime = value;
		}
		
		public java.lang.Long getReviewProgress() {
			return this.reviewProgress;
		}
		
		public void setReviewProgress(java.lang.Long value) {
			this.reviewProgress = value;
		}
		
		public java.lang.Integer getLendingStatus() {
			return this.lendingStatus;
		}
		
		public void setLendingStatus(java.lang.Integer value) {
			this.lendingStatus = value;
		}
		

	
	@Override
	public String getInitialHql() {
		setIsSQL(false);
		StringBuffer buffer=new StringBuffer();
		buffer.append("select t from Project t where 1=1 ");
		
			if(id != null) {
	            buffer.append(" and  t.id = :id ");
	        }
	        if(StringUtils.isNotBlank(projectTag)) {
	            buffer.append(" and  t.projectTag = :projectTag ");
	        }
	        if(StringUtils.isNotBlank(projectName)) {
	            buffer.append(" and  t.projectName like :projectName ");
	        }
	        if(StringUtils.isNotBlank(projectAdWord)) {
	            buffer.append(" and  t.projectAdWord = :projectAdWord ");
	        }
			if(projectType != null) {
	            buffer.append(" and  t.projectType = :projectType ");
	        }
			if(projectStatus != null) {
	            buffer.append(" and  t.projectStatus = :projectStatus ");
	        }
			if(amount != null) {
	            buffer.append(" and  t.amount = :amount ");
	        }
			if(collectedAmount != null) {
	            buffer.append(" and  t.collectedAmount = :collectedAmount ");
	        }
			if(virtualCollectedAmount != null) {
	            buffer.append(" and  t.virtualCollectedAmount = :virtualCollectedAmount ");
	        }
			if(isVirtualCollectedAmount != null) {
	            buffer.append(" and  t.isVirtualCollectedAmount = :isVirtualCollectedAmount ");
	        }
			if(topLimit != null) {
	            buffer.append(" and  t.topLimit = :topLimit ");
	        }
			if(ccollectDays != null) {
	            buffer.append(" and  t.ccollectDays = :ccollectDays ");
	        }
	        if(StringUtils.isNotBlank(projectSponsor)) {
	            buffer.append(" and  t.projectSponsor = :projectSponsor ");
	        }
	        if(StringUtils.isNotBlank(projectImage)) {
	            buffer.append(" and  t.projectImage = :projectImage ");
	        }
	        if(StringUtils.isNotBlank(projectThumImage)) {
	            buffer.append(" and  t.projectThumImage = :projectThumImage ");
	        }
	        if(StringUtils.isNotBlank(videoAddr)) {
	            buffer.append(" and  t.videoAddr = :videoAddr ");
	        }
			if(supports != null) {
	            buffer.append(" and  t.supports = :supports ");
	        }
	        if(StringUtils.isNotBlank(projectSummary)) {
	            buffer.append(" and  t.projectSummary = :projectSummary ");
	        }
	        if(StringUtils.isNotBlank(projectDetails)) {
	            buffer.append(" and  t.projectDetails = :projectDetails ");
	        }
	        if(StringUtils.isNotBlank(projectAddr)) {
	            buffer.append(" and  t.projectAddr = :projectAddr ");
	        }
	        if(StringUtils.isNotBlank(projectAttachment)) {
	            buffer.append(" and  t.projectAttachment = :projectAttachment ");
	        }
			if(salesTime != null) {
	            buffer.append(" and  t.salesTime = :salesTime ");
	        }
			if(auditCount != null) {
	            buffer.append(" and  t.auditCount = :auditCount ");
	        }
	        if(StringUtils.isNotBlank(auditReson)) {
	            buffer.append(" and  t.auditReson = :auditReson ");
	        }
			if(createTime != null) {
	            buffer.append(" and  t.createTime = :createTime ");
	        }
			if(updateTime != null) {
	            buffer.append(" and  t.updateTime = :updateTime ");
	        }
	        if(StringUtils.isNotBlank(userAlipayAccount)) {
	            buffer.append(" and  t.userAlipayAccount = :userAlipayAccount ");
	        }
	        if(StringUtils.isNotBlank(userAlipayName)) {
	            buffer.append(" and  t.userAlipayName = :userAlipayName ");
	        }
			if(rate != null) {
	            buffer.append(" and  t.rate = :rate ");
	        }
			if(userType != null) {
	            buffer.append(" and  t.userType = :userType ");
	        }
			if(ind != null) {
	            buffer.append(" and  t.ind = :ind ");
	        }
			if(closureType != null) {
	            buffer.append(" and  t.closureType = :closureType ");
	        }
			if(display != null) {
	            buffer.append(" and  t.display = :display ");
	        }
			if(shipType != null) {
	            buffer.append(" and  t.shipType = :shipType ");
	        }
			if(shipTime != null) {
	            buffer.append(" and  t.shipTime = :shipTime ");
	        }
			if(reviewProgress != null) {
	            buffer.append(" and  t.reviewProgress = :reviewProgress ");
	        }
			if(lendingStatus != null) {
	            buffer.append(" and  t.lendingStatus = :lendingStatus ");
	        }
		return buffer.toString();
	}
	
		
	@Override
	public Query prepareParams(Query query) {
		try {
					if(id!=null) {
						query.setParameter("id", id);
					}
					if(StringUtils.isNotBlank(projectTag)) {
						query.setParameter("projectTag", projectTag);
					}
					if(StringUtils.isNotBlank(projectName)) {
						query.setParameter("projectName", "%"+projectName+"%");
					}
					if(StringUtils.isNotBlank(projectAdWord)) {
						query.setParameter("projectAdWord", projectAdWord);
					}
					if(projectType!=null) {
						query.setParameter("projectType", projectType);
					}
					if(projectStatus!=null) {
						query.setParameter("projectStatus", projectStatus);
					}
					if(amount!=null) {
						query.setParameter("amount", amount);
					}
					if(collectedAmount!=null) {
						query.setParameter("collectedAmount", collectedAmount);
					}
					if(virtualCollectedAmount!=null) {
						query.setParameter("virtualCollectedAmount", virtualCollectedAmount);
					}
					if(isVirtualCollectedAmount!=null) {
						query.setParameter("isVirtualCollectedAmount", isVirtualCollectedAmount);
					}
					if(topLimit!=null) {
						query.setParameter("topLimit", topLimit);
					}
					if(ccollectDays!=null) {
						query.setParameter("ccollectDays", ccollectDays);
					}
					if(StringUtils.isNotBlank(projectSponsor)) {
						query.setParameter("projectSponsor", projectSponsor);
					}
					if(StringUtils.isNotBlank(projectImage)) {
						query.setParameter("projectImage", projectImage);
					}
					if(StringUtils.isNotBlank(projectThumImage)) {
						query.setParameter("projectThumImage", projectThumImage);
					}
					if(StringUtils.isNotBlank(videoAddr)) {
						query.setParameter("videoAddr", videoAddr);
					}
					if(supports!=null) {
						query.setParameter("supports", supports);
					}
					if(StringUtils.isNotBlank(projectSummary)) {
						query.setParameter("projectSummary", projectSummary);
					}
					if(StringUtils.isNotBlank(projectDetails)) {
						query.setParameter("projectDetails", projectDetails);
					}
					if(StringUtils.isNotBlank(projectAddr)) {
						query.setParameter("projectAddr", projectAddr);
					}
					if(StringUtils.isNotBlank(projectAttachment)) {
						query.setParameter("projectAttachment", projectAttachment);
					}
					if(salesTime!=null) {
						query.setParameter("salesTime", salesTime);
					}
					if(auditCount!=null) {
						query.setParameter("auditCount", auditCount);
					}
					if(StringUtils.isNotBlank(auditReson)) {
						query.setParameter("auditReson", auditReson);
					}
					if(createTime!=null) {
						query.setParameter("createTime", createTime);
					}
					if(updateTime!=null) {
						query.setParameter("updateTime", updateTime);
					}
					if(StringUtils.isNotBlank(userAlipayAccount)) {
						query.setParameter("userAlipayAccount", userAlipayAccount);
					}
					if(StringUtils.isNotBlank(userAlipayName)) {
						query.setParameter("userAlipayName", userAlipayName);
					}
					if(rate!=null) {
						query.setParameter("rate", rate);
					}
					if(userType!=null) {
						query.setParameter("userType", userType);
					}
					if(ind!=null) {
						query.setParameter("ind", ind);
					}
					if(closureType!=null) {
						query.setParameter("closureType", closureType);
					}
					if(display!=null) {
						query.setParameter("display", display);
					}
					if(shipType!=null) {
						query.setParameter("shipType", shipType);
					}
					if(shipTime!=null) {
						query.setParameter("shipTime", shipTime);
					}
					if(reviewProgress!=null) {
						query.setParameter("reviewProgress", reviewProgress);
					}
					if(lendingStatus!=null) {
						query.setParameter("lendingStatus", lendingStatus);
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
