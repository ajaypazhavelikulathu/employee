package com.scg.employee.exception.response;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ErrorResponse {
	private HttpStatus status = HttpStatus.OK;
	private String errorCode;
	private String message;
	private String detail;
	private String exception;
//	List<String> errorMessages;

}
