package ar.com.bussiness.ventas.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException  extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -550638019206347270L;
	
	
	
	public ResourceNotFoundException(Throwable e) {
		super(e);
	}
	
	public ResourceNotFoundException(String message, Throwable e) {
		super(message,e);
	}


}
