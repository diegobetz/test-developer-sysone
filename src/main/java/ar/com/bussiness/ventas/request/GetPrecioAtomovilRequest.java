package ar.com.bussiness.ventas.request;

import java.util.Date;

/**
 *  * Representa request para consulta de precio de automoviles
 * @author Diego
 *
 */
public class GetPrecioAtomovilRequest {

	
	private Long idAutomovil;
	private Date fecha;
		
	public Long getIdAutomovil() {
		return idAutomovil;
	}
	public void setIdAutomovil(Long idAutomovil) {
		this.idAutomovil = idAutomovil;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
}
