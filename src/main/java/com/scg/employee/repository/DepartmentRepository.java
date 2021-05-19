package com.scg.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scg.employee.dao.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

	Department findByDepartmentName(String departmentName);

}
