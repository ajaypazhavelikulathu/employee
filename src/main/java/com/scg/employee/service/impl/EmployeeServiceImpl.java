package com.scg.employee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scg.employee.Exception.EmployeeNotFoundException;
import com.scg.employee.dao.EmployeeDAO;
import com.scg.employee.service.EmployeeService;
import com.scg.employee.vo.EmployeeVo;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	public EmployeeVo saveEmployee(final EmployeeVo employeeVo) {
		return employeeDAO.saveEmployee(employeeVo);

	}

	@Override
	public List<EmployeeVo> getEmployees() {
		return employeeDAO.getEmployees();
	}

	@Override
	public List<EmployeeVo> getEmployeesByPagination(final int pageNumber) {
		return employeeDAO.getEmployeesByPagination(pageNumber);
	}

	@Override
	public EmployeeVo getEmployeeById(final int id) throws EmployeeNotFoundException {
		return employeeDAO.getEmployeeById(id);
	}

	@Override
	public List<EmployeeVo> findByFirstName(final String name) {
		return employeeDAO.findByFirstName(name);
	}

	@Override
	public String deleteEmployee(final int id) {
		return employeeDAO.deleteEmployee(id);
	}

	@Override
	public EmployeeVo updateEmployeeById(final EmployeeVo employeeVo) throws EmployeeNotFoundException {
		return employeeDAO.updateEmployeeById(employeeVo);

	}

}
