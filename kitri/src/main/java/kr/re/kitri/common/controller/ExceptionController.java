package kr.re.kitri.common.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import javassist.NotFoundException;

@ControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(value = {NotFoundException.class})
	public String notFound(NotFoundException e) {
		e.printStackTrace();
		return "error/404";
	}
	
	@ExceptionHandler(value = {NoHandlerFoundException.class})
	public String noHandler(NoHandlerFoundException e) {
		e.printStackTrace();
		return "error/404";
	}

}
