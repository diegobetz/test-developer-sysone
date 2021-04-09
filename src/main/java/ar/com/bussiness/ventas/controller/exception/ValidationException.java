package ar.com.bussiness.ventas.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ValidationException  extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -550638019206347270L;
	
	
	
	public ValidationException(Throwable e) {
		super(e);
	}
	
	public ValidationException(String message, Throwable e) {
		super(message,e);
	}


}
