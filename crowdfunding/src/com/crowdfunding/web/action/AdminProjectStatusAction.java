
package com.crowdfunding.web.action;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.crowdfunding.core.common.Result;
import com.crowdfunding.core.condition.CfUserCondition;
import com.crowdfunding.core.condition.ProjectCategoryTagCondition;
import com.crowdfunding.core.condition.ProjectCondition;
import com.crowdfunding.core.constants.EMessageCode;
import com.crowdfunding.core.constants.EOperator;
import com.crowdfunding.core.constants.ProjectStatus;
import com.crowdfunding.core.domain.CfUser;
import com.crowdfunding.core.domain.Project;
import com.crowdfunding.core.service.ICfUserService;
import com.crowdfunding.core.service.IProjectCategoryTagService;
import com.crowdfunding.core.service.IProjectService;
import com.crowdfunding.web.common.Authority;
import com.crowdfunding.web.common.BaseAction;


/**
 * 众筹项目的各个状态
 * @author Alive
 *
 */
public class AdminProjectStatusAction extends BaseAction{
	public static Logger logger = Logger.getLogger(AdminProjectStatusAction.class);
	
	private IProjectService projectService;
	
	private ProjectCondition projectCondition;

	private Project project;
	
	private IProjectCategoryTagService projectCategoryTagService;
	
	private List<CfUser> CfUserList = null;
	
	private ICfUserService cfUserService;
	
	/**
	 * 众筹中入口
	 * @return
	 */
	@Authority(operator=EOperator.SELECT)
	public String projectIngIndex() {
		return "projectIng-index";
	}
	
	
	/**
	 * 列表
	 * @return
	 */
	@Authority(operator=EOperator.SELECT)
	public String ingData(){
		try{
			//众筹中的项目
			projectCondition.setProjectStatus(ProjectStatus.CHECK_PASSED.value());
			page=projectService.queryProjectPage(projectCondition);
		}catch (Exception e) {
			logger.error(e);
		}
		return "json-page";
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

