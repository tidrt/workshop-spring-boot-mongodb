package com.tidrt.workshopmongo.services.exception;

public class ObjectNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	// to throw our personalized exception when try to getting an user by an inexistent id
	public ObjectNotFoundException(String msg) {
		super (msg);
	}
}
