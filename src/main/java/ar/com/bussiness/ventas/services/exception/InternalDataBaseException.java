package ar.com.bussiness.ventas.services.exception;

public class InternalDataBaseException  extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -550638019206347270L;
	
	
	
	public InternalDataBaseException(Throwable e) {
		super(e);
	}
	
	public InternalDataBaseException(String message, Throwable e) {
		super(message,e);
	}


}
