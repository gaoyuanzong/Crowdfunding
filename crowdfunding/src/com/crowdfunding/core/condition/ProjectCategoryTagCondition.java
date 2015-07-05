/*
 * Powered By [up72-framework]
 * Web Site: http://www.up72.com
 * Since 2006 - 2015
 */

package com.crowdfunding.core.condition;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;

import com.crowdfunding.core.common.Condition;
import com.crowdfunding.core.constants.ESortType;



public class ProjectCategoryTagCondition  extends Condition{
	

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
		

	
	@Override
	public String getInitialHql() {
		setIsSQL(false);
		StringBuffer buffer=new StringBuffer();
		buffer.append("select t from ProjectCategoryTag t where 1=1 ");
		
			if(id != null) {
	            buffer.append(" and  t.id = :id ");
	        }
			if(StringUtils.isNotBlank(name)) {
	            buffer.append(" and  t.name like :name ");
	        }
			if(type != null) {
	            buffer.append(" and  t.type = :type ");
	        }
			if(createdTime != null) {
	            buffer.append(" and  t.createdTime = :createdTime ");
	        }
			if(modifiedTime != null) {
	            buffer.append(" and  t.modifiedTime = :modifiedTime ");
	        }
			if(sortId != null) {
	            buffer.append(" and  t.sortId = :sortId ");
	        }
		return buffer.toString();
	}
	
		
	@Override
	public Query prepareParams(Query query) {
		try {
					if(id!=null) {
						query.setParameter("id", id);
					}
					if(StringUtils.isNotBlank(name)) {
						query.setParameter("name",  "%"+name+"%");
					}

					if(type!=null) {
						query.setParameter("type", type);
					}
					if(createdTime!=null) {
						query.setParameter("createdTime", createdTime);
					}
					if(modifiedTime!=null) {
						query.setParameter("modifiedTime", modifiedTime);
					}
					if(sortId!=null) {
						query.setParameter("sortId", sortId);
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
