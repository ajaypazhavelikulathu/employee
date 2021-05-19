package com.scg.employee.dao;

import java.util.List;

import com.scg.employee.Exception.EmployeeNotFoundException;
import com.scg.employee.vo.EmployeeVo;

public interface EmployeeDAO {
	EmployeeVo saveEmployee(final EmployeeVo employeeVo);

	List<EmployeeVo> getEmployees();

	EmployeeVo getEmployeeById(final int id) throws EmployeeNotFoundException;

	List<EmployeeVo> findByFirstName(final String name);

	String deleteEmployee(final int id);

	EmployeeVo updateEmployeeById(final EmployeeVo employeeVo) throws EmployeeNotFoundException;

	List<EmployeeVo> getEmployeesByPagination(final int pageNumber);

}
