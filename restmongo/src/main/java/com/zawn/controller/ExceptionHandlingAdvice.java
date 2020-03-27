package com.zawn.controller;

import org.springframework.hateoas.mediatype.vnderrors.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.zawn.service.UserNotFoundException;
/**
 * Exception handler for pure HATEOAP application without DATA REST
 * @author home
 *
 */
@ControllerAdvice
public class ExceptionHandlingAdvice {

	@ResponseBody
	@ExceptionHandler(UserNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	ResponseEntity<?> employeeNotFoundHandler(UserNotFoundException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
	    .body(new VndErrors.VndError("UserNotFound", ex.getMessage()));
	}
}