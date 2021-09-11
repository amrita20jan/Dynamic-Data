package com.dynamic.exception;

public class PasswordIncorrectException extends RuntimeException{

	private static final long serialVersionUID = -4499814679309162122L;

	public PasswordIncorrectException(String message) {
		super(message);
	}
	

}
