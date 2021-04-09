package ar.com.bussiness.ventas.services.exception;

public class InternalVentasException  extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -550638019206347270L;
	
	
	
	public InternalVentasException(Throwable e) {
		super(e);
	}
	
	public InternalVentasException(String message, Throwable e) {
		super(message,e);
	}


}
