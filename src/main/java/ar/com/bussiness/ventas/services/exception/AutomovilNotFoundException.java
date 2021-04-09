package ar.com.bussiness.ventas.services.exception;


public class AutomovilNotFoundException  extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -550638019206347270L;
	
	
	public AutomovilNotFoundException() {
		super();
	}
	
	public AutomovilNotFoundException(Throwable e) {
		super(e);
	}
	
	public AutomovilNotFoundException(String message, Throwable e) {
		super(message,e);
	}
	

	public AutomovilNotFoundException(String message) {
		super(message);
	}


}
