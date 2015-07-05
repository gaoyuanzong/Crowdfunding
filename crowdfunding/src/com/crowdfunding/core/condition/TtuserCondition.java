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



public class TtuserCondition  extends Condition{
	

		//columns START
		/** */
		private java.lang.Integer id;
		
		/** */
		private java.lang.String name;
		
		/** */
		private java.lang.String password;
		
		/** */
		private java.lang.Boolean sex;
		
		/** */
		private java.lang.String address;
		
		//columns END
		public java.lang.String getName() {
			return this.name;
		}
		
		public void setName(java.lang.String value) {
			this.name = value;
		}
		
		public java.lang.String getPassword() {
			return this.password;
		}
		
		public void setPassword(java.lang.String value) {
			this.password = value;
		}
		
		public java.lang.Boolean getSex() {
			return this.sex;
		}
		
		public void setSex(java.lang.Boolean value) {
			this.sex = value;
		}
		
		public java.lang.String getAddress() {
			return this.address;
		}
		
		public void setAddress(java.lang.String value) {
			this.address = value;
		}
		

	
	@Override
	public String getInitialHql() {
		setIsSQL(false);
		StringBuffer buffer=new StringBuffer();
		buffer.append("select t from Ttuser t where 1=1 ");
		
			if(id != null) {
	            buffer.append(" and  t.id = :id ");
	        }
	        if(StringUtils.isNotBlank(name)) {
	            buffer.append(" and  t.name = :name ");
	        }
	        if(StringUtils.isNotBlank(password)) {
	            buffer.append(" and  t.password = :password ");
	        }
			if(sex != null) {
	            buffer.append(" and  t.sex = :sex ");
	        }
	        if(StringUtils.isNotBlank(address)) {
	            buffer.append(" and  t.address = :address ");
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
						query.setParameter("name", name);
					}
					if(StringUtils.isNotBlank(password)) {
						query.setParameter("password", password);
					}
					if(sex!=null) {
						query.setParameter("sex", sex);
					}
					if(StringUtils.isNotBlank(address)) {
						query.setParameter("address", address);
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
