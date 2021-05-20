package com.scg.employee.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.scg.employee.dao.DepartmentDAO;
import com.scg.employee.dao.entity.Department;
import com.scg.employee.exception.ApiException;
import com.scg.employee.exception.errorcode.ErrorCode;
import com.scg.employee.mapping.DepartmentRequestMapper;
import com.scg.employee.repository.DepartmentRepository;
import com.scg.employee.vo.DepartmentVo;

@Component
public class DepartmentDAOImpl implements DepartmentDAO {

	@Autowired
	DepartmentRequestMapper departmentRequestMapper;

	@Autowired
	DepartmentRepository departmentRepository;

	@Override
	public DepartmentVo saveDepartment(final DepartmentVo departmentVo) {
		final Department department = departmentRequestMapper.toEntity(departmentVo);
		return departmentRequestMapper.toVO(departmentRepository.save(department));

	}

	@Override
	public List<DepartmentVo> getDepartment() {
		return departmentRequestMapper.toVOList(departmentRepository.findAll());

	}

	@Override
	public DepartmentVo getDepartmentById(final int id) {

		final Department department = departmentRepository.findById(id)
				.orElseThrow(() -> new ApiException(ErrorCode.DEPARTMENT_NOT_FOUND));

		return departmentRequestMapper.toVO(department);

	}

	@Override
	public String deleteDepartment(final int id) {

		departmentRepository.findById(id).orElseThrow(() -> new ApiException(ErrorCode.DEPARTMENT_NOT_FOUND));

		departmentRepository.deleteById(id);
		return "Employee id : " + id + " Removed";

	}

	@Override
	public DepartmentVo updateDepartmentById(final DepartmentVo departmentVo) {

		Department department = departmentRequestMapper.toEntity(departmentVo);

		final Department existingDepartment = departmentRepository.findById(department.getDepartmentId())
				.orElseThrow(() -> new ApiException(ErrorCode.DEPARTMENT_NOT_FOUND));
		existingDepartment.setDepartmentName(department.getDepartmentName());
		department = departmentRepository.save(existingDepartment);
		return departmentRequestMapper.toVO(department);

	}

	@Override
	public DepartmentVo findByName(final String name) {
		return departmentRequestMapper.toVO(departmentRepository.findByDepartmentName(name));
	}

}
