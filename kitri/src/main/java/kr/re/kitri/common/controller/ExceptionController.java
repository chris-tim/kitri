package kr.re.kitri.common.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import javassist.NotFoundException;

@ControllerAdvice
public class ExceptionController {
	
	/*
	 * 자바에서 에러 발생시 아래 목록에 해당 에러 있으면 에러로그 페이지가 아닌 해당 페이지가 나옴
	 */
	
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
