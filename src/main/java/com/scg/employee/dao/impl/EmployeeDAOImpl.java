package com.scg.employee.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.scg.employee.Exception.EmployeeNotFoundException;
import com.scg.employee.dao.EmployeeDAO;
import com.scg.employee.dao.entity.Employee;
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

		try {
			final Employee employee = employeeRepository.findById(id)
					.orElseThrow(() -> new EmployeeNotFoundException("No Employe found in this id"));

			return employeeRequestMapper.toVO(employee);
		} catch (final Exception e) {
			log.error("Empoloyee not found", e);
			System.out.println("Employee not found" + e);
		}
		return null;
	}

	@Override
	public String deleteEmployee(final int id) {
		employeeRepository.deleteById(id);
		return "Employee id : " + id + " Removed";
	}

	@Override
	public EmployeeVo updateEmployeeById(final EmployeeVo employeeVo) {
		final Employee employee = employeeRequestMapper.toEntity(employeeVo);

		try {
			final Employee existingEmployee = employeeRepository.findById(employee.getId())
					.orElseThrow(() -> new EmployeeNotFoundException("No Employe found in this id"));

			existingEmployee.setFirstName(employee.getFirstName());
			existingEmployee.setLastName(employee.getLastName());
			existingEmployee.setEmail(employee.getEmail());
//			addAuditDetailsUpdate(existingEmployee);
			return employeeRequestMapper.toVO(employeeRepository.save(existingEmployee));

		} catch (final Exception e) {
//			log.error("User not found", e);
			System.out.println("user not found" + e);
		}
		return null;

	}

//	public Audit addAuditDetailsInsert() {
//		final Audit audit = new Audit();
//		audit.setCreatedTimestamp(LocalDateTime.now());
//		audit.setCreatedBy("ajay");
//		return audit;
//
//	}
//
//	public void addAuditDetailsUpdate(final Employee employee) {
//		employee.getAudit().setLastUpdatedBy("ajith");
//		employee.getAudit().setLastUpdatedTimestamp(LocalDateTime.now());
//
//	}

}
