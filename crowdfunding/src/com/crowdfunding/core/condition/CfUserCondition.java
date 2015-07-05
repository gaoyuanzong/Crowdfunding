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



public class CfUserCondition  extends Condition{
	

		//columns START
		/** */
		private java.lang.String id;
		
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
		public java.lang.String getId() {
				return id;
			}
	
			public void setId(java.lang.String id) {
				this.id = id;
			}

	@Override
	public String getInitialHql() {
		setIsSQL(false);
		StringBuffer buffer=new StringBuffer();
		buffer.append("select t from CfUser t where 1=1 ");
		
	        if(StringUtils.isNotBlank(id)) {
	            buffer.append(" and  t.id = :id ");
	        }
	        if(StringUtils.isNotBlank(userName)) {
	            buffer.append(" and  t.userName = :userName ");
	        }
	        if(StringUtils.isNotBlank(petName)) {
	            buffer.append(" and  t.petName = :petName ");
	        }
	        if(StringUtils.isNotBlank(realName)) {
	            buffer.append(" and  t.realName = :realName ");
	        }
	        if(StringUtils.isNotBlank(phone)) {
	            buffer.append(" and  t.phone = :phone ");
	        }
			if(isPhone != null) {
	            buffer.append(" and  t.isPhone = :isPhone ");
	        }
	        if(StringUtils.isNotBlank(mail)) {
	            buffer.append(" and  t.mail = :mail ");
	        }
			if(isMail != null) {
	            buffer.append(" and  t.isMail = :isMail ");
	        }
	        if(StringUtils.isNotBlank(idNumber)) {
	            buffer.append(" and  t.idNumber = :idNumber ");
	        }
	        if(StringUtils.isNotBlank(backPath)) {
	            buffer.append(" and  t.backPath = :backPath ");
	        }
	        if(StringUtils.isNotBlank(frontPath)) {
	            buffer.append(" and  t.frontPath = :frontPath ");
	        }
			if(isIdentity != null) {
	            buffer.append(" and  t.isIdentity = :isIdentity ");
	        }
	        if(StringUtils.isNotBlank(province)) {
	            buffer.append(" and  t.province = :province ");
	        }
	        if(StringUtils.isNotBlank(citys)) {
	            buffer.append(" and  t.citys = :citys ");
	        }
	        if(StringUtils.isNotBlank(address)) {
	            buffer.append(" and  t.address = :address ");
	        }
	        if(StringUtils.isNotBlank(personalStatement)) {
	            buffer.append(" and  t.personalStatement = :personalStatement ");
	        }
			if(StringUtils.isNotBlank(invitationCode)){
				buffer.append(" and  t.invitationCode = :invitationCode ");
			}
			if(StringUtils.isNotBlank(personalCode)){
				buffer.append(" and  t.personalCode = :personalCode ");
			}
			if(StringUtils.isNotBlank(filePath)){
				buffer.append(" and  t.filePath = :filePath ");
			}
			if(isLock != null) {
	            buffer.append(" and  t.isLock = :isLock ");
	        }
			if(isActivate != null) {
	            buffer.append(" and  t.isActivate = :isActivate ");
	        }
			if(registerTime != null) {
	            buffer.append(" and  t.registerTime = :registerTime ");
	        }
			if(lastLoginTime != null) {
	            buffer.append(" and  t.lastLoginTime = :lastLoginTime ");
	        }
		return buffer.toString();
	}
	
		
	@Override
	public Query prepareParams(Query query) {
		try {
					if(StringUtils.isNotBlank(id)) {
						query.setParameter("id", id);
					}
					if(StringUtils.isNotBlank(userName)) {
						query.setParameter("userName", userName);
					}
					if(StringUtils.isNotBlank(petName)) {
						query.setParameter("petName", petName);
					}
					if(StringUtils.isNotBlank(realName)) {
						query.setParameter("realName", realName);
					}
					if(StringUtils.isNotBlank(phone)) {
						query.setParameter("phone", phone);
					}
					if(isPhone!=null) {
						query.setParameter("isPhone", isPhone);
					}
					if(StringUtils.isNotBlank(mail)) {
						query.setParameter("mail", mail);
					}
					if(isMail!=null) {
						query.setParameter("isMail", isMail);
					}
					if(StringUtils.isNotBlank(idNumber)) {
						query.setParameter("idNumber", idNumber);
					}
					if(StringUtils.isNotBlank(backPath)) {
						query.setParameter("backPath", backPath);
					}
					if(StringUtils.isNotBlank(frontPath)) {
						query.setParameter("frontPath", frontPath);
					}
					if(isIdentity!=null) {
						query.setParameter("isIdentity", isIdentity);
					}
					if(StringUtils.isNotBlank(province)) {
						query.setParameter("province", province);
					}
					if(StringUtils.isNotBlank(citys)) {
						query.setParameter("citys", citys);
					}
					if(StringUtils.isNotBlank(address)) {
						query.setParameter("address", address);
					}
					if(StringUtils.isNotBlank(personalStatement)) {
						query.setParameter("personalStatement", personalStatement);
					}
					if(StringUtils.isNotBlank(invitationCode)) {
						query.setParameter("invitationCode", invitationCode);
					}
					if(StringUtils.isNotBlank(personalCode)) {
						query.setParameter("personalCode", personalCode);
					}
					if(StringUtils.isNotBlank(filePath)) {
						query.setParameter("filePath", filePath);
					}
					if(isLock!=null) {
						query.setParameter("isLock", isLock);
					}
					if(isActivate!=null) {
						query.setParameter("isActivate", isActivate);
					}
					if(registerTime!=null) {
						query.setParameter("registerTime", registerTime);
					}
					if(lastLoginTime!=null) {
						query.setParameter("lastLoginTime", lastLoginTime);
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
