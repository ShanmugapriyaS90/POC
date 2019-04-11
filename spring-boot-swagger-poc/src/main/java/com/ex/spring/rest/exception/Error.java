package com.ex.spring.rest.exception;

public class Error {
	
	private int errorCode;
	
	private String errorMsg;
	
	public Error(int errorCode, String errorMsg) {
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	@Override
	public String toString() {
		return "Error [errorCode=" + errorCode + ", errorMsg=" + errorMsg + "]";
	}
	
}
