package ar.com.bussiness.ventas.services.exception;


public class PrecioNotFoundException  extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -550638019206347270L;
	
	
	public PrecioNotFoundException() {
		super();
	}
	
	public PrecioNotFoundException(Throwable e) {
		super(e);
	}
	
	public PrecioNotFoundException(String message, Throwable e) {
		super(message,e);
	}
	

	public PrecioNotFoundException(String message) {
		super(message);
	}


}
