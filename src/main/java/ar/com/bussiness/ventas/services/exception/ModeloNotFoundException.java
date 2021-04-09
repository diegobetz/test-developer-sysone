package ar.com.bussiness.ventas.services.exception;


public class ModeloNotFoundException  extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -550638019206347270L;
	
	
	public ModeloNotFoundException() {
		super();
	}
	
	public ModeloNotFoundException(Throwable e) {
		super(e);
	}
	
	public ModeloNotFoundException(String message, Throwable e) {
		super(message,e);
	}
	

	public ModeloNotFoundException(String message) {
		super(message);
	}


}
