package com.scg.employee.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.scg.employee.dao.EmployeeDAO;
import com.scg.employee.dao.entity.Employee;
import com.scg.employee.exception.ApiException;
import com.scg.employee.exception.errorcode.ErrorCode;
import com.scg.employee.mapping.EmployeeRequestMapper;
import com.scg.employee.repository.EmployeeRepository;
import com.scg.employee.vo.EmployeeVo;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j

public class EmployeeDAOImpl implements EmployeeDAO {

	@Value(("${spring.pagesize.value:3}"))
	private int pageSize;

	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired

	private EmployeeRequestMapper employeeRequestMapper;

//	@Autowired
//	DepartmentRepository departmentRepository;

	@Override
	public EmployeeVo saveEmployee(final EmployeeVo employeeVo) {

		final Employee employee = employeeRequestMapper.toEntity(employeeVo);

//		final Audit audit1 = addAuditDetailsInsert();
//		employee.setAudit(audit1);

//		departmentRepository.save(employee.getDepartment());

//		employee.setDepartment(departmentRepository.save(employee.getDepartment()));
		return employeeRequestMapper.toVO((employeeRepository.save(employee)));

//		Department department = departmentRepository.findById(employee.getDepartment().getDepartmentId()).orElse(null);
//		final Optional<Department> department = departmentRepository
//				.findById(employee.getDepartment().getDepartmentId());
//
//		if (department.isEmpty()) {
//			log.info("id not exixt");
//		}
//		if (null == department) {
//			department = new Department();
//			department.setDepartmentName(employee.getDepartment().getDepartmentName());
//		}
//		employee.setDepartment(department);
//		return employeeRequestMapper.toVO(employeeRepository.save(employee));

//		return employeeRequestMapper.toVO(repository.save(employeeRequestMapper.toEntity(employeeVo)));
//		final Employee employee = objMapper.readValue(employeeVo.toString(), Employee.class);
//		hello

	}

	@Override
	public List<EmployeeVo> getEmployees() {

		return employeeRequestMapper.toVOList(employeeRepository.findAll());

//		final List<Employee> listOfEntity = repository.findAll();
//		return listOfEntity.stream().map(employee -> employeeRequestMapper.toVO(employee)).collect(Collectors.toList());
//
	}

	@Override
	public List<EmployeeVo> getEmployeesByPagination(final int pageNumber) {

		final PageRequest pageable = PageRequest.of(pageNumber, pageSize);
		final Page<Employee> listOfEntity = employeeRepository.findAll(pageable);
		return employeeRequestMapper.toVOList(listOfEntity.getContent());

//		return listOfEntity.stream().map(employee -> employeeRequestMapper.toVO(employee)).collect(Collectors.toList());

	}

	@Override
	public List<EmployeeVo> findByFirstName(final String name) {

		return employeeRequestMapper.toVOList(employeeRepository.findByFirstName(name));

//		return listOfEntity.stream().map(employee -> employeeRequestMapper.toVO(employee)).collect(Collectors.toList());

	}

	@Override
	public EmployeeVo getEmployeeById(final int id) {

//		try {
//
//			final int a = 5 / 0;
//
//		} catch (final ArithmeticException e) {
//
//			log.error("Division by zero", e);
//			throw new ApiException(ErrorCode.DIVISION_BY_ZERO, e);
//
//		}

		final Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ApiException(ErrorCode.EMPLOYEE_NOT_FOUND));

		return employeeRequestMapper.toVO(employee);

	}

	@Override
	public String deleteEmployee(final int id) {
		employeeRepository.deleteById(id);
		return "Employee id : " + id + " Removed";
	}

	@Override
	public EmployeeVo updateEmployeeById(final EmployeeVo employeeVo) {
		final Employee employee = employeeRequestMapper.toEntity(employeeVo);

		final Employee existingEmployee = employeeRepository.findById(employee.getId())
				.orElseThrow(() -> new ApiException(ErrorCode.EMPLOYEE_NOT_FOUND));

		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		return employeeRequestMapper.toVO(employeeRepository.save(existingEmployee));

	}

}
