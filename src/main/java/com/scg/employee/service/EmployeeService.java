package com.scg.employee.service;

import java.util.List;

import com.scg.employee.vo.EmployeeVo;

public interface EmployeeService {
	EmployeeVo saveEmployee(final EmployeeVo employeeVo);

	List<EmployeeVo> getEmployees();

	EmployeeVo getEmployeeById(final int id);

	List<EmployeeVo> findByFirstName(final String name);

	String deleteEmployee(final int id);

	EmployeeVo updateEmployeeById(final EmployeeVo employeeVo);

	List<EmployeeVo> getEmployeesByPagination(final int pageNumber);

}
