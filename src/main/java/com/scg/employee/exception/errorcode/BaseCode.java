package com.scg.employee.exception.errorcode;

import java.io.Serializable;

public interface BaseCode extends Serializable {

	String getCode();

	int getHttpStatusCode();

	String getMessage();

//	String getMessageKey();

}
