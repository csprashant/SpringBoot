package com.nt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class StudntNotFoundException  extends RuntimeException{
	public StudntNotFoundException() {}

}
