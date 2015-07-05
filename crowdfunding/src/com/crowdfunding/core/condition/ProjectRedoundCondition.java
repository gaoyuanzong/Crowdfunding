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



public class ProjectRedoundCondition  extends Condition{
	

		//columns START
		/** 回报ID*/
		private java.lang.Long id;
		
		/** 项目ID*/
		private java.lang.Long projectId;
		
		/** 回报金额*/
		private Long amount;
		
		/** 回报类型*/
		private java.lang.Integer redoundType;
		
		/** 回报内容*/
		private java.lang.String redoundContent;
		
		/** 图片*/
		private java.lang.String redoundImage;
		
		/** 上限*/
		private java.lang.Integer limits;
		
		/** 运费*/
		private Long freight;
		
		/** 回报天次*/
		private java.lang.Integer redoundDays;
		
		/** 0-不可开发票，1-可开发票*/
		private java.lang.Integer invoiceStatus;
		
		/** 创建时间*/
		private java.util.Date createTime;
		
		/** 更新时间*/
		private java.util.Date updateTime;
		
		/** 排序*/
		private java.lang.Integer ind;
		
		//columns END
		public java.lang.Long getProjectId() {
			return this.projectId;
		}
		
		public void setProjectId(java.lang.Long value) {
			this.projectId = value;
		}
		
		public Long getAmount() {
			return this.amount;
		}
		
		public void setAmount(Long value) {
			this.amount = value;
		}
		
		public java.lang.Integer getRedoundType() {
			return this.redoundType;
		}
		
		public void setRedoundType(java.lang.Integer value) {
			this.redoundType = value;
		}
		
		public java.lang.String getRedoundContent() {
			return this.redoundContent;
		}
		
		public void setRedoundContent(java.lang.String value) {
			this.redoundContent = value;
		}
		
		public java.lang.String getRedoundImage() {
			return this.redoundImage;
		}
		
		public void setRedoundImage(java.lang.String value) {
			this.redoundImage = value;
		}
		
		public java.lang.Integer getLimits() {
			return this.limits;
		}
		
		public void setLimits(java.lang.Integer value) {
			this.limits = value;
		}
		
		public Long getFreight() {
			return this.freight;
		}
		
		public void setFreight(Long value) {
			this.freight = value;
		}
		
		public java.lang.Integer getRedoundDays() {
			return this.redoundDays;
		}
		
		public void setRedoundDays(java.lang.Integer value) {
			this.redoundDays = value;
		}
		
		public java.lang.Integer getInvoiceStatus() {
			return this.invoiceStatus;
		}
		
		public void setInvoiceStatus(java.lang.Integer value) {
			this.invoiceStatus = value;
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
		
		public java.lang.Integer getInd() {
			return this.ind;
		}
		
		public void setInd(java.lang.Integer value) {
			this.ind = value;
		}
		

	
	@Override
	public String getInitialHql() {
		setIsSQL(false);
		StringBuffer buffer=new StringBuffer();
		buffer.append("select t from ProjectRedound t where 1=1 ");
		
			if(id != null) {
	            buffer.append(" and  t.id = :id ");
	        }
			if(projectId != null) {
	            buffer.append(" and  t.projectId = :projectId ");
	        }
			if(amount != null) {
	            buffer.append(" and  t.amount = :amount ");
	        }
			if(redoundType != null) {
	            buffer.append(" and  t.redoundType = :redoundType ");
	        }
	        if(StringUtils.isNotBlank(redoundContent)) {
	            buffer.append(" and  t.redoundContent = :redoundContent ");
	        }
	        if(StringUtils.isNotBlank(redoundImage)) {
	            buffer.append(" and  t.redoundImage = :redoundImage ");
	        }
			if(limits != null) {
	            buffer.append(" and  t.limits = :limits ");
	        }
			if(freight != null) {
	            buffer.append(" and  t.freight = :freight ");
	        }
			if(redoundDays != null) {
	            buffer.append(" and  t.redoundDays = :redoundDays ");
	        }
			if(invoiceStatus != null) {
	            buffer.append(" and  t.invoiceStatus = :invoiceStatus ");
	        }
			if(createTime != null) {
	            buffer.append(" and  t.createTime = :createTime ");
	        }
			if(updateTime != null) {
	            buffer.append(" and  t.updateTime = :updateTime ");
	        }
			if(ind != null) {
	            buffer.append(" and  t.ind = :ind ");
	        }
		return buffer.toString();
	}
	
		
	@Override
	public Query prepareParams(Query query) {
		try {
					if(id!=null) {
						query.setParameter("id", id);
					}
					if(projectId!=null) {
						query.setParameter("projectId", projectId);
					}
					if(amount!=null) {
						query.setParameter("amount", amount);
					}
					if(redoundType!=null) {
						query.setParameter("redoundType", redoundType);
					}
					if(StringUtils.isNotBlank(redoundContent)) {
						query.setParameter("redoundContent", redoundContent);
					}
					if(StringUtils.isNotBlank(redoundImage)) {
						query.setParameter("redoundImage", redoundImage);
					}
					if(limits!=null) {
						query.setParameter("limits", limits);
					}
					if(freight!=null) {
						query.setParameter("freight", freight);
					}
					if(redoundDays!=null) {
						query.setParameter("redoundDays", redoundDays);
					}
					if(invoiceStatus!=null) {
						query.setParameter("invoiceStatus", invoiceStatus);
					}
					if(createTime!=null) {
						query.setParameter("createTime", createTime);
					}
					if(updateTime!=null) {
						query.setParameter("updateTime", updateTime);
					}
					if(ind!=null) {
						query.setParameter("ind", ind);
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
