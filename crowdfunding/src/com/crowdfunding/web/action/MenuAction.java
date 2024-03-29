/**
*Generated by StarUML(tm) Java Add-In
*  @ Project : basis
*  @ File Name : MenuAction.java
*  @ Date : 2012/9/21
*  @ Author : wxliu
*/


package com.crowdfunding.web.action;

import java.util.ArrayList;
import com.crowdfunding.core.condition.MenuCondition;
import com.crowdfunding.core.domain.Employee;
import com.crowdfunding.core.service.IMenuService;
import com.crowdfunding.web.common.BaseAction;


public class MenuAction extends BaseAction{
	
	private IMenuService menuService;
	private MenuCondition condition=new MenuCondition();
	
	public String data() {
		list=menuService.queryMenuList(condition);
		return "json-list";
	}
	/**
	 * 获取当前登录人的menu权限列表
	 * @return
	 */
	public String currentAuthorityMenuList() {
		Object session_menus=get(Employee.MENU_SESSION_KEY);
		list=session_menus==null?new ArrayList():(ArrayList)session_menus;
		return "json-list";
	}
	
	
	public MenuCondition getCondition() {
		return condition;
	}

	public void setCondition(MenuCondition condition) {
		this.condition = condition;
	}

	public void setMenuService(IMenuService menuService) {
		this.menuService = menuService;
	}
	
	
	
}
