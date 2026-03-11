package com.example.MobileCare.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(exception = NoResourceFoundException.class)
	public String noResourceFoundException(NoResourceFoundException ex) {
		return "404";
	}
}
