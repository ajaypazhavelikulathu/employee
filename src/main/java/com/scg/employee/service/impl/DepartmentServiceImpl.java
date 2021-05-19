package com.scg.employee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scg.employee.dao.DepartmentDAO;
import com.scg.employee.service.DepartmentService;
import com.scg.employee.vo.DepartmentVo;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	DepartmentDAO departmentDAO;

	@Override
	public DepartmentVo saveDepartment(final DepartmentVo departmentVo) {
		return departmentDAO.saveDepartment(departmentVo);
	}

	@Override
	public List<DepartmentVo> getDepartment() {
		return departmentDAO.getDepartment();
	}

	@Override
	public DepartmentVo getDepartmentById(final int id) {
		return departmentDAO.getDepartmentById(id);

	}

	@Override
	public String deleteDepartment(final int id) {
		return departmentDAO.deleteDepartment(id);

	}

	@Override
	public DepartmentVo updateDepartmentById(final DepartmentVo departmentVo) {
		return departmentDAO.updateDepartmentById(departmentVo);

	}

	@Override
	public DepartmentVo findByName(final String name) {
		return departmentDAO.findByName(name);
	}

}
