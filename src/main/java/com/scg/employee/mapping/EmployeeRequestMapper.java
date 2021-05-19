package com.scg.employee.mapping;

import java.util.List;

import org.mapstruct.Mapper;

import com.scg.employee.dao.entity.Employee;
import com.scg.employee.vo.EmployeeVo;

@Mapper(componentModel = "spring", uses = { EmployeeDetailsMapper.class, EmployeeReviewMapper.class })
public interface EmployeeRequestMapper {

	EmployeeVo toVO(Employee employee);

//	@Mapping(target = "department", expression = "java(toDepartmentEntity(employeeVo.getDepartment()))")
	Employee toEntity(EmployeeVo employeeVo);

	List<EmployeeVo> toVOList(List<Employee> employeeList);

	List<Employee> toEntityList(List<EmployeeVo> employeeVoList);

//	DepartmentVo toVO(Department department);
//
//	Department toEntity(DepartmentVo departmentVo);

}
