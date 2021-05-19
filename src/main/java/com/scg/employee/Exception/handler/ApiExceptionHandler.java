package com.scg.employee.Exception.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.scg.employee.Exception.ApiException;
import com.scg.employee.Exception.response.ErrorResponse;

@RestControllerAdvice
public class ApiExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleApiException(final ApiException exception) {
		final ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setDetail(exception.getMessage());
		errorResponse.setErrorCode(exception.getErrorCodeString());
		errorResponse.setMessage(exception.getLocalizedMessage());
		return null;

	}

}
