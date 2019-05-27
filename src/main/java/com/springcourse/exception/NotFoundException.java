package com.springcourse.exception;

public class NotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = -7870566725013816100L;

	public NotFoundException(String msg) {
		super(msg);
	}
	

}
