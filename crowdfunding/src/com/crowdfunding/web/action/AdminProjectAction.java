/*
 * Powered By [up72-framework]
 * Web Site: http://www.up72.com
 * Since 2006 - 2015
 */


package com.crowdfunding.web.action;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.crowdfunding.core.common.Result;
import com.crowdfunding.core.condition.ProjectCategoryTagCondition;
import com.crowdfunding.core.condition.ProjectCondition;
import com.crowdfunding.core.constants.EMessageCode;
import com.crowdfunding.core.constants.EOperator;
import com.crowdfunding.core.constants.ProjectStatus;
import com.crowdfunding.core.domain.Project;
import com.crowdfunding.core.service.IProjectCategoryTagService;
import com.crowdfunding.core.service.IProjectService;
import com.crowdfunding.core.util.StringUtil;
import com.crowdfunding.web.common.Authority;
import com.crowdfunding.web.common.BaseAction;

public class AdminProjectAction extends BaseAction{
	private static final long serialVersionUID = 9044315705350662521L;

	public static Logger logger = Logger.getLogger(AdminProjectAction.class);
	
	private IProjectService projectService;
	
	private ProjectCondition projectCondition;

	private Project project;
	
	private IProjectCategoryTagService projectCategoryTagService;
	
	
	/**
	 * 入口
	 * @return
	 */
	@Authority(operator=EOperator.SELECT)
	public String index() {
		return "project-index";
	}
	
	
	/**
	 * 列表
	 * @return
	 */
	@Authority(operator=EOperator.SELECT)
	public String data(){
		try{
			page=projectService.queryProjectPage(projectCondition);
		}catch (Exception e) {
			logger.error(e);
		}
		return "json-page";
	}
	/**
	 * 跳转到增加页面
	 * @return
	 */
	@Authority(operator=EOperator.ADD)
	public String toAdd() {
		request.setAttribute("tagList", projectCategoryTagService.queryProjectCategoryTagList(new ProjectCategoryTagCondition()));
		return "project-add";
	}
	/**
	 * 跳转到编辑页面
	 * @return
	 */
	@Authority(operator=EOperator.MODIFY)
	public String toEdit() {
		try{
			project=projectService.queryProjectById(project.getId());
		}catch (Exception e) {
			logger.error(e);
		}
		return "project-edit";
	}
	
	
	
	/**
	 * 新增保存
	 * @return
	 */
	@Authority(operator=EOperator.ADD)
	public String doAdd() {
		try{
			String[] projectTags = request.getParameterValues("projectTags");
			project.setProjectTag(StringUtil.Array2String(projectTags));
			result=projectService.addProject(project);
		}catch (Exception e) {
			logger.error(e);
			result=new Result<Object>(false, EMessageCode.EXCEPTION.getCode());
		}
		return "json-result";
	}
	
	/**
	 * 
	 * @return
	 */
	@Authority(operator=EOperator.MODIFY)
	public String doEdit() {
		try{
			result=projectService.modifyProject(project);
		}catch (Exception e) {
			logger.error(e);
			result=new Result<Object>(false,EMessageCode.EXCEPTION.getCode());
		}
		return "json-result";
	}
	
	
	
	
	/**
	 * 删除
	 */
	@Authority(operator=EOperator.DELETE)
	public String doDelete(){
		try{
			result=projectService.removeProject(project);
		}catch(Exception e){
			logger.error(e);
			result=new Result<Object>(false,EMessageCode.EXCEPTION.getCode());
		}
		return "json-result";
	}
	
	
	/**
	 * 进入选择发起人
	 */
	@Authority(operator=EOperator.SELECT)
	public String toSelectUser(){
		return "project-selectUsers";
	}
	
	/**
	 * 项目审核视图
	 * @return
	 */
	@Authority(operator=EOperator.SELECT)
	public String projectAudit(){
		//查询出项目分类
		ProjectCategoryTagCondition condition = new ProjectCategoryTagCondition();
		condition.setType(0);
		request.setAttribute("projectCategoryList",projectCategoryTagService.queryProjectCategoryTagList(condition));
		return "project-audit";
	}
	
	/**
	 * 列表
	 * @return
	 */
	@Authority(operator=EOperator.SELECT)
	public String auditData(){
		try{
			projectCondition.setProjectStatus(ProjectStatus.UNCHECK.value());
			projectCondition.setSortname("updateTime");
			page=projectService.queryProjectPage(projectCondition);
		}catch (Exception e) {
			logger.error(e);
		}
		return "json-page";
	}
	
	/**
	 * 跳转到拒绝编辑页面
	 * @return
	 */
	@Authority(operator=EOperator.MODIFY)
	public String toRefuse() {
		try{
			project=projectService.queryProjectById(Long.parseLong((String)request.getParameter("projectId")));
			request.setAttribute("type",request.getParameter("type"));
		}catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return "project-refuse";
	}
	
	/**
	 * 拒绝项目
	 * @return
	 */
	@Authority(operator=EOperator.MODIFY)
	public String doRefuse() {
		try{
			Project p = projectService.queryProjectById(project.getId());
			String type = request.getParameter("type");
			if(null != type){
				p.setAuditReson(project.getAuditReson());
				if(type.equals("1")){
					p.setProjectStatus(ProjectStatus.CHECK_OVER.value());
				}else if(type.equals("0")){
					p.setProjectStatus(ProjectStatus.CHECK_REJECTED.value());
				}
				p.setAuditCount((null==project.getAuditCount()?0:project.getAuditCount())+1);
				result=projectService.modifyProject(p);
			}
		}catch (Exception e) {
			logger.error(e);
			result=new Result<Object>(false,EMessageCode.EXCEPTION.getCode());
		}
		return "json-result";
	}
	
	
	/**
	 * 跳转到通过编辑页面
	 * @return
	 */
	@Authority(operator=EOperator.MODIFY)
	public String toPass() {
		try{
			project=projectService.queryProjectById(Long.parseLong((String)request.getParameter("projectId")));
		}catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return "project-pass";
	}
	
	/**
	 * 通过项目
	 * @return
	 */
	@Authority(operator=EOperator.MODIFY)
	public String doPass() {
		try{
			Project p = projectService.queryProjectById(project.getId());
			p.setRate(project.getRate());
			p.setProjectStatus(ProjectStatus.CHECK_PASSED.value());
			p.setSalesTime(new Date());
			result=projectService.modifyProject(p);
		}catch (Exception e) {
			logger.error(e);
			result=new Result<Object>(false,EMessageCode.EXCEPTION.getCode());
		}
		return "json-result";
	}
	
	
	
	
	/** 
	 * get set 
	 **/
	public void setProjectService(IProjectService service) {
		this.projectService = service;
	}
	
	public IProjectService getProjectService() {
		return this.projectService;
	}
	
	public void setProject(Project project){
		this.project=project;
	}
	
	public Project getProject(){
		return project;
	}
	
	public void setProjectCondition(ProjectCondition projectCondition){
		this.projectCondition=projectCondition;
	}
	
	public ProjectCondition getProjectCondition(){
		return projectCondition;
	}
	public IProjectCategoryTagService getProjectCategoryTagService() {
		return projectCategoryTagService;
	}
	public void setProjectCategoryTagService(
			IProjectCategoryTagService projectCategoryTagService) {
		this.projectCategoryTagService = projectCategoryTagService;
	}


	
}

