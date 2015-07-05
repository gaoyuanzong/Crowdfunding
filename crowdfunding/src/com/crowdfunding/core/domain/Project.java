/*
 * Powered By [up72-framework]
 * Web Site: http://www.up72.com
 * Since 2006 - 2015
 */

package com.crowdfunding.core.domain;

import javax.persistence.Transient;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.crowdfunding.core.constants.ProjectStatus;
import com.crowdfunding.core.service.ICfUserService;
import com.crowdfunding.core.service.IProjectCategoryTagService;
import com.crowdfunding.core.util.ApplicationContextHolder;
import com.crowdfunding.core.util.DateUtil;
import com.crowdfunding.core.util.StringUtil;

public class Project implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	

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
	private java.lang.Long projectSponsor;
	
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


	public Project(){
	}

	public Project(
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
	
	public java.lang.Long getProjectSponsor() {
		return this.projectSponsor;
	}
	
	public void setProjectSponsor(java.lang.Long value) {
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
	
	
	
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("ProjectTag",getProjectTag())
			.append("ProjectName",getProjectName())
			.append("ProjectAdWord",getProjectAdWord())
			.append("ProjectType",getProjectType())
			.append("ProjectStatus",getProjectStatus())
			.append("Amount",getAmount())
			.append("CollectedAmount",getCollectedAmount())
			.append("VirtualCollectedAmount",getVirtualCollectedAmount())
			.append("IsVirtualCollectedAmount",getIsVirtualCollectedAmount())
			.append("TopLimit",getTopLimit())
			.append("CcollectDays",getCcollectDays())
			.append("ProjectSponsor",getProjectSponsor())
			.append("ProjectImage",getProjectImage())
			.append("ProjectThumImage",getProjectThumImage())
			.append("VideoAddr",getVideoAddr())
			.append("Supports",getSupports())
			.append("ProjectSummary",getProjectSummary())
			.append("ProjectDetails",getProjectDetails())
			.append("ProjectAddr",getProjectAddr())
			.append("ProjectAttachment",getProjectAttachment())
			.append("SalesTime",getSalesTime())
			.append("AuditCount",getAuditCount())
			.append("AuditReson",getAuditReson())
			.append("CreateTime",getCreateTime())
			.append("UpdateTime",getUpdateTime())
			.append("UserAlipayAccount",getUserAlipayAccount())
			.append("UserAlipayName",getUserAlipayName())
			.append("Rate",getRate())
			.append("UserType",getUserType())
			.append("Ind",getInd())
			.append("ClosureType",getClosureType())
			.append("Display",getDisplay())
			.append("ShipType",getShipType())
			.append("ShipTime",getShipTime())
			.append("ReviewProgress",getReviewProgress())
			.append("LendingStatus",getLendingStatus())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Project == false) return false;
		if(this == obj) return true;
		Project other = (Project)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
	
	
	/**
	 * 认投金额
	 */
	@Transient
	public Double getInvestorsMount(){
		return 0.0d;
	}
	
	
	/**
	 * 创建时间（显示）
	 */
	@Transient
	public String getCreateDateDisplay(){
		String result = "";
		if(null != createTime){
			result =  DateUtil.format(createTime, "yyyy-MM-dd HH:mm");
		}
		return result;
	}
	
	
	/**
	 * 审核时间（显示）
	 */
	@Transient
	public String getSalesTimeDisplay(){
		String result = "";
		if(null != salesTime){
			result =  DateUtil.format(salesTime, "yyyy-MM-dd HH:mm");
		}
		return result;
	}
	
	/**
	 * 查询项目类型名字
	 * @return
	 */
	@Transient
	public String getProjectCategotyName(){
		String result = "";
		if(null != projectType){
			IProjectCategoryTagService projectCategoryTagService = (IProjectCategoryTagService)ApplicationContextHolder.getBean("projectCategoryTagService");
			result = projectCategoryTagService.queryProjectCategoryTagById(projectType).getName();
		}
		return result;
	}
	
	/**
	 * 查询用户名字
	 * @return
	 */
	@Transient
	public String getCfUserName(){
		String result = "";
		if(null != projectSponsor){
			ICfUserService cfUserService = (ICfUserService)ApplicationContextHolder.getBean("cfUserService");
			result = cfUserService.queryCfUserById(projectSponsor).getUserName();
		}
		return result;
	}
	/**
	 * 格式化标签显示
	 * @return
	 */
	@Transient
	public java.lang.String getProjectTagNames() {
		if (!StringUtil.stringIsNull(this.projectTag)) {
			return this.projectTag.replaceAll("\\[", "").replaceAll("\\]", "");
		}
		return this.projectTag;
	}
	/**
	 * 状态显示名称
	 * @return
	 */
	@Transient
	public String getProjectStatusName(){
		String result = "";
		if(null != projectStatus){
			result = ProjectStatus.projectStatus.get(projectStatus);
		}
		return result;
	}
}

