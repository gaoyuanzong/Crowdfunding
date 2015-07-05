package com.crowdfunding.core.domain;

import java.util.Date;

import org.apache.struts2.json.annotations.JSON;

/**
 * Employee entity. @author MyEclipse Persistence Tools
 */

public class Employee implements java.io.Serializable {
	public final static String INITPASSWORD="111111";//初始化密码
	public final static String USER_SESSION_KEY="wallet.session.user";//用户登录后用户信息在Session里的key值
	public final static String AUTHORITY_SESSION_KEY="wallet.session.authority";//用户登录后用户权限在Session里的key值
	public final static String MENU_SESSION_KEY="wallet.session.menu";//用户登录后菜单在Session里的key值
	// Fields

	private String id;
	private String name;
	private String password;
	private Integer state;
	private Integer sort;
	private String createrId;
	private Date createTime;
	private String modifyerId;
	private Date modifyTime;
	private String roleId;
	private Employee creater;
	private Employee modifyer;
	private Role role;
	private Integer isadmin;
	
	private String repassword;

	// Constructors

	/** default constructor */
	public Employee() {
	}

	public Employee(String id, String name, String password,
			Integer state, Integer sort, String createrId, Date createTime,
			String modifyerId, Date modifyTime, String roleId) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.state = state;
		this.sort = sort;
		this.createrId = createrId;
		this.createTime = createTime;
		this.modifyerId = modifyerId;
		this.modifyTime = modifyTime;
		this.roleId = roleId;
	}

	public Employee getCreater() {
		return creater;
	}

	public void setCreater(Employee creater) {
		this.creater = creater;
	}

	public Employee getModifyer() {
		return modifyer;
	}

	public void setModifyer(Employee modifyer) {
		this.modifyer = modifyer;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getCreaterId() {
		return createrId;
	}

	public void setCreaterId(String createrId) {
		this.createrId = createrId;
	}
	@JSON(format="yyyy-MM-dd")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getModifyerId() {
		return modifyerId;
	}

	public void setModifyerId(String modifyerId) {
		this.modifyerId = modifyerId;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Integer getIsadmin() {
		return isadmin;
	}

	public void setIsadmin(Integer isadmin) {
		this.isadmin = isadmin;
	}
	public boolean isAdmin(){
		return this.isadmin==1;
	}
}