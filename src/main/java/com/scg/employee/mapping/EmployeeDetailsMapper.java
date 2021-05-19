package com.scg.employee.mapping;

import org.mapstruct.Mapper;

import com.scg.employee.dao.entity.EmployeeDetails;
import com.scg.employee.vo.EmployeeDetailsVo;

@Mapper(componentModel = "spring")

public interface EmployeeDetailsMapper {

	EmployeeDetailsVo toVo(EmployeeDetails employeeDetails);

	EmployeeDetails toEntity(EmployeeDetailsVo employeeDetailsVo);

}
