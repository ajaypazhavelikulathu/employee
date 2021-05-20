package com.scg.employee.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.scg.employee.exception.ApiException;
import com.scg.employee.exception.response.ErrorResponse;

@RestControllerAdvice
public class ApiExceptionHandler {

	@ExceptionHandler(ApiException.class)
	@ResponseBody
	public ResponseEntity<ErrorResponse> handleApiException(final ApiException exception) {
		final ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setDetail(exception.getErrorCode().getMessage());
		errorResponse.setErrorCode(exception.getErrorCodeString());
		errorResponse.setMessage(exception.getErrorCode().getCode());
		errorResponse.setException(exception.getException().toString());
		errorResponse.setStatus(HttpStatus.NOT_FOUND);

		return new ResponseEntity<>(errorResponse, errorResponse.getStatus());

//		return ResponseEntity.ok().body(errorResponse);

	}

}
