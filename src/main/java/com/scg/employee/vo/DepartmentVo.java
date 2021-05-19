package com.scg.employee.vo;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartmentVo {
	private int departmentId;
	private String departmentName;
	private List<EmployeeVo> employees;

}
