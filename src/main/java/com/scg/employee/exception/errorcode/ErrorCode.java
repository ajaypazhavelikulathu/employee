package com.scg.employee.exception.errorcode;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ErrorCode implements BaseCode {

	EMPLOYEE_NOT_FOUND("No Employee in this id"), DEPARTMENT_NOT_FOUND("No Department in this id"),
	DIVISION_BY_ZERO("Division with zero error");

	private String message;

	@Override
	public String getCode() {

		return name();
	}

	@Override
	public int getHttpStatusCode() {
		return 200;
	}

	@Override
	public String getMessage() {
		return this.message;
	}

//	@Override
//	public String getMessageKey() {
//		return null;
//
//	}

}
