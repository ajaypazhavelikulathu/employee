package com.scg.employee.exception;

import com.scg.employee.exception.errorcode.BaseCode;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiException extends RuntimeException {

	private BaseCode errorCode;
	private String errorCodeString;
	private Exception exception;

	public ApiException(final BaseCode errorCode) {
		super(errorCode.getMessage());
		this.exception = new RuntimeException(errorCode.getMessage());
		this.errorCode = errorCode;
		this.errorCodeString = errorCode.toString();

	}

	public ApiException(final BaseCode errorCode, final Exception exception) {
		super(String.join("_", errorCode.getMessage(), exception.getMessage()), exception);
		this.exception = exception;
		this.errorCode = errorCode;
		this.errorCodeString = errorCode.toString();

	}

	public ApiException(final BaseCode errorCode, final String message) {
		super(message);

		this.errorCode = errorCode;
		this.exception = new RuntimeException(errorCode.getMessage());
		this.errorCodeString = errorCodeString.toString();

	}

}
