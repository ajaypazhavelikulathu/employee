package com.scg.employee.advice;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component

public class SaveEmployeeAspect {
	@Before("execution(public java.util.List<com.scg.employee.vo.EmployeeVo> com.scg.employee.service.impl.EmployeeServiceImpl.getEmployees())")
	public void beforeSaveEmployee() {
		log.info("Before Calling Save Employee Method from service");
	}

	@After("execution(public * com.scg.employee.service.impl.EmployeeServiceImpl.getEmployees())")
	public void afterSaveEmployee() {
		log.info("After Calling Save Employee Method from Service");
	}

}
