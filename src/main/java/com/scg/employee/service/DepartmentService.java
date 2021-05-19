package com.scg.employee.service;

import java.util.List;

import com.scg.employee.vo.DepartmentVo;

public interface DepartmentService {
	DepartmentVo saveDepartment(final DepartmentVo departmentVo);

	List<DepartmentVo> getDepartment();

	DepartmentVo getDepartmentById(final int id);

	String deleteDepartment(final int id);

	DepartmentVo updateDepartmentById(final DepartmentVo departmentVo);

	DepartmentVo findByName(String name);

}