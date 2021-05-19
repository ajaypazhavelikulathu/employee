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

import com.scg.employee.service.DepartmentService;
import com.scg.employee.vo.DepartmentVo;

@RestController
@RequestMapping("department")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@PostMapping
	public DepartmentVo saveDepartment(@RequestBody final DepartmentVo departmentVo) {
		return departmentService.saveDepartment(departmentVo);

	}

	@GetMapping
	public List<DepartmentVo> getDepartment() {
		return departmentService.getDepartment();

	}

	@GetMapping("/id/{id}")
	public DepartmentVo getDepartmentById(@PathVariable final int id) {
		return departmentService.getDepartmentById(id);

	}

	@GetMapping("/name/{name}")
	public DepartmentVo findByName(@PathVariable final String name) {
		return departmentService.findByName(name);
	}

	@DeleteMapping("/{id}")
	public String deleteEmployee(@PathVariable final int id) {
		return departmentService.deleteDepartment(id);

	}

	@PutMapping
	public DepartmentVo updateEmployeeById(@RequestBody final DepartmentVo DepartmentVo) {
		return departmentService.updateDepartmentById(DepartmentVo);
	}

}
