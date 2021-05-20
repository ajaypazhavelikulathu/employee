package com.scg.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scg.employee.advice.TrackExecutionTime;
import com.scg.employee.service.EmployeeService;
import com.scg.employee.vo.EmployeeVo;

@RestController
@RequestMapping("employees")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@PostMapping
	public EmployeeVo saveEmployee(@RequestBody final EmployeeVo employeeVo) {
		return employeeService.saveEmployee(employeeVo);

	}

	@GetMapping
	@TrackExecutionTime
	public List<EmployeeVo> getEmployees() {
		return employeeService.getEmployees();

	}

	@GetMapping("/page/{pageNumber}")
	public List<EmployeeVo> getEmployeesByPagination(@PathVariable final int pageNumber) {

		return employeeService.getEmployeesByPagination(pageNumber);

	}

	@GetMapping("/id/{id}")
	public EmployeeVo getEmployeeById(@PathVariable final int id) {
		return employeeService.getEmployeeById(id);

	}

	@GetMapping("/name/{name}")
	public List<EmployeeVo> findByName(@PathVariable final String name) {
		return employeeService.findByFirstName(name);
	}

	@DeleteMapping("/{id}")
	public String deleteEmployee(@PathVariable final int id) {
		return employeeService.deleteEmployee(id);

	}

	@PutMapping
	public EmployeeVo updateEmployeeById(@RequestBody final EmployeeVo employeeVo) {
		return employeeService.updateEmployeeById(employeeVo);
	}

}
