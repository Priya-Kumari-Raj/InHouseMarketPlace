package com.cg.market.exception;

public class EmployeeAlreadyExistsException extends RuntimeException {

	public EmployeeAlreadyExistsException(String msg) {
		super(msg);
	}
}
