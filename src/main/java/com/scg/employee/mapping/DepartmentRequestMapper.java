package com.scg.employee.mapping;

import java.util.List;

import org.mapstruct.Mapper;

import com.scg.employee.dao.entity.Department;
import com.scg.employee.vo.DepartmentVo;

@Mapper(componentModel = "spring", uses = EmployeeRequestMapper.class)

public interface DepartmentRequestMapper {

	DepartmentVo toVO(Department department);

	Department toEntity(DepartmentVo departmentVo);

	List<DepartmentVo> toVOList(List<Department> departmentList);

	List<Department> toEntityList(List<DepartmentVo> departmentVoList);

}
