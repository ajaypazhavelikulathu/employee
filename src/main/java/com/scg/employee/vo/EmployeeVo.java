package com.scg.employee.vo;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeVo {

	private int id;

	private String firstName;

	private String lastName;

	private String email;
	private EmployeeDetailsVo employeeDetails;

//	private DepartmentVo department;

	private List<ReviewVo> reviews;

}
