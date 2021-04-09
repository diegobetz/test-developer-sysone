package ar.com.bussiness.ventas.services.exception;


public class ModeloExistException  extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -550638019206347270L;
	
	
	public ModeloExistException() {
		super();
	}
	
	public ModeloExistException(Throwable e) {
		super(e);
	}
	
	public ModeloExistException(String message, Throwable e) {
		super(message,e);
	}
	

	public ModeloExistException(String message) {
		super(message);
	}


}
