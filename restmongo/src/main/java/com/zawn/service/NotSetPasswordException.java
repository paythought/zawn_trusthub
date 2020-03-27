package com.zawn.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NotSetPasswordException extends RuntimeException {

	  public NotSetPasswordException() {
	    super("The json key password not found in resetpassword request." );
	  }
	}