package com.crowdfunding.core.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.crowdfunding.core.common.Result;
import com.crowdfunding.core.condition.EmployeeCondition;
import com.crowdfunding.core.constants.EEmployeeState;
import com.crowdfunding.core.constants.EState;
import com.crowdfunding.core.dao.IBaseDao;
import com.crowdfunding.core.domain.Employee;
import com.crowdfunding.core.exception.BasisException;
import com.crowdfunding.core.exception.ParamIsNullException;
import com.crowdfunding.core.service.ILoginService;
import com.crowdfunding.core.util.BasisUtil;

public class LoginServiceImpl implements ILoginService {
	private final static Logger logger=Logger.getLogger(LoginServiceImpl.class);
	private IBaseDao dao;
	
	public void setDao(IBaseDao dao) {
		this.dao = dao;
	}


	public Result<Employee> queryEmployeeLogin(Employee employee) {
		/*
		 * 判断用户名、密码不能为空
		 * 判断用户名是否存在
		 * 判断密码是否正确
		 * 返回结果
		 */
		Result<Employee> result=new Result<Employee>(true);
		try{
			//判断用户名、密码不能为空
			BasisUtil.validParamsNotNull(employee);
			BasisUtil.validParamsNotNull(employee.getName(),employee.getPassword());
			//判断用户名是否存在
			EmployeeCondition condition=new EmployeeCondition();
			condition.setName(employee.getName());
			condition.setState(EEmployeeState.NORMAL);
			List<Employee> employeeList=dao.queryObjectList(condition);
			if(employeeList==null||employeeList.size()!=1){
				throw new BasisException("login.name.notexist","用户名不存在");
			}
			//判断密码是否正确
			Employee dbEmployee=employeeList.get(0);
			if(!BasisUtil.getMD5(employee.getPassword()).equals(dbEmployee.getPassword())){
				throw new BasisException("login.password.notright","密码不正确");
			}
			result.setData(dbEmployee);
		}catch (ParamIsNullException e) {
			logger.warn(e.getMessage());
			result.setSuccess(false);
			result.setCode(e.getCode());
		}catch (BasisException e) {
			logger.warn(e.getMessage());
			result.setSuccess(false);
			result.setCode(e.getCode());
		}
		return result;
	}

}
