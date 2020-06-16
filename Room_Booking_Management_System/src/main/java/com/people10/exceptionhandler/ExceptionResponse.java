package com.people10.exceptionhandler;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExceptionResponse {

	private String message;
	
	private String statusCode;
}
