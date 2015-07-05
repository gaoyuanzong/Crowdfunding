/**
*Generated by StarUML(tm) Java Add-In
*  @ Project : basis
*  @ File Name : IMenuService.java
*  @ Date : 2012/9/21
*  @ Author : wxliu
*/



package com.crowdfunding.core.service;

import java.util.List;

import com.crowdfunding.core.condition.MenuCondition;
import com.crowdfunding.core.domain.Menu;

/**
 * 菜单接口
 * @author wxliu
 *
 */
public interface IMenuService {
	/**
	 * 查询菜单
	 * @param id
	 */
	public Menu queryMenuById(String id);
	/**
	 * 查询菜单列表
	 * @param condition
	 */
	public List<Menu> queryMenuList(MenuCondition condition);
}