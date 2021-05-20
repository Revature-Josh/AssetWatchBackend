package com.revature.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.revature.dto.MessageDTO;
import com.revature.exceptions.UserCantLogInExpection;
import com.revature.exceptions.UserNotFoundException;
@SuppressWarnings({"unchecked","rawtypes"})
@ControllerAdvice
public class ExceptionControllers extends ResponseEntityExceptionHandler {
	@ExceptionHandler({ UserNotFoundException.class })
    public ResponseEntity<MessageDTO>  handleExceptionNotFound() {
		
		MessageDTO message= new MessageDTO("user can't be found");
		return new ResponseEntity(message,  HttpStatus.NOT_FOUND);
    }
	
	
	@ExceptionHandler({ UserCantLogInExpection.class })
    public ResponseEntity<MessageDTO>  handleExceptionCantLogIN() {
		
		MessageDTO message= new MessageDTO("Cannot log in user password and username can't validate Credentials");
		return new ResponseEntity(message,  HttpStatus.NOT_FOUND);
    }

}
