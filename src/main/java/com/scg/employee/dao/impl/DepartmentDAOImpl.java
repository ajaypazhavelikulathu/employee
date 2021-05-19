package com.scg.employee.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.scg.employee.Exception.DepartmentNotFoundException;
import com.scg.employee.dao.DepartmentDAO;
import com.scg.employee.dao.entity.Department;
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
		try {
			final Department department = departmentRepository.findById(id)
					.orElseThrow(() -> new DepartmentNotFoundException("No Department found in this id"));

			return departmentRequestMapper.toVO(department);
		} catch (final Exception e) {
//			log.error("Empoloyee not found", e);
			System.out.println("Department not found" + e);
		}
		return null;
	}

	@Override
	public String deleteDepartment(final int id) {

		try {
			departmentRepository.findById(id)
					.orElseThrow(() -> new DepartmentNotFoundException("No Department found in this id"));

			departmentRepository.deleteById(id);
			return "Employee id : " + id + " Removed";

		} catch (final Exception e) {
//			log.error("Empoloyee not found", e);
			System.out.println("Department not found" + e);
		}
		return "Not deleted";

	}

	@Override
	public DepartmentVo updateDepartmentById(final DepartmentVo departmentVo) {

		Department department = departmentRequestMapper.toEntity(departmentVo);

		try {
			final Department existingDepartment = departmentRepository.findById(department.getDepartmentId())
					.orElseThrow(() -> new DepartmentNotFoundException("No Department found in this id"));
			existingDepartment.setDepartmentName(department.getDepartmentName());
			department = departmentRepository.save(existingDepartment);
			return departmentRequestMapper.toVO(department);

		} catch (final Exception e) {
//			log.error("User not found", e);
			System.out.println("user not found" + e);

		}
		return null;
	}

	@Override
	public DepartmentVo findByName(final String name) {
		return departmentRequestMapper.toVO(departmentRepository.findByDepartmentName(name));
	}

}
