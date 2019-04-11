package com.ex.spring.rest.exception;

public class EmployeeGenericException extends Exception{
	
	private int errorCode;
	
	private String errorMsg;

	public EmployeeGenericException() {
		super();
	}
	
	public EmployeeGenericException(Throwable ex) {
		super(ex);
	}
	
	public EmployeeGenericException(int errorCode, String errorMsg) {
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}
	
	public Error buildError() {
		Error error = new Error(errorCode, errorMsg);
		return error;
	}
	
}
