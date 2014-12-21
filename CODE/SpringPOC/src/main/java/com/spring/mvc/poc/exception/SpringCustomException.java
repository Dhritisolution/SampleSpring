package com.spring.mvc.poc.exception;

public class SpringCustomException extends Exception{

	private String message = null;
	private String errorcode = null;
	 
    public SpringCustomException() {
        super();
    }
 
    public SpringCustomException(String message, String errorCode) {
        super(message);
        this.message = message;
        this.errorcode = errorCode;
    }
    
    public SpringCustomException(String message,String errorCode, Throwable  cause) {
        super(message, cause);
        this.message = message;
        this.errorcode = errorCode;
    }
 
    public SpringCustomException(Throwable cause) {
        super(cause);
    }
 
    @Override
    public String toString() {
        return "ERROR_CODE: "+errorcode+", ERROR: "+message;
    }
 
    @Override
    public String getMessage() {
        return message;
    }
}
