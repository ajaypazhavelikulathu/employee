package com.scg.employee.Exception.errorcode;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ErrorCode implements BaseCode {

	EMPLOYEE_NOT_FOUND("No Employee in this id"), DEPARTMENT_NOT_FOUND("No Department in this id");

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMessageKey() {
		return null;

	}

}
