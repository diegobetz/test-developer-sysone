package ar.com.bussiness.ventas.services.exception;


public class FacturaVentaNotFoundException  extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -550638019206347270L;
	
	
	public FacturaVentaNotFoundException() {
		super();
	}
	
	public FacturaVentaNotFoundException(Throwable e) {
		super(e);
	}
	
	public FacturaVentaNotFoundException(String message, Throwable e) {
		super(message,e);
	}
	

	public FacturaVentaNotFoundException(String message) {
		super(message);
	}


}
