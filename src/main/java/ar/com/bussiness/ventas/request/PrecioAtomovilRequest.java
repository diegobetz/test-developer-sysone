package ar.com.bussiness.ventas.request;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Representa el request para agregar y modificar el precio de Automovil
 * @author Diego
 *
 */
public class PrecioAtomovilRequest {

	private Long id;
	private Long idAutomovil;
	private Date fechaMin;
	private Date fechaMax;
	private BigDecimal precioMin;
	private BigDecimal precioMax;
	
	
	public Long getIdAutomovil() {
		return idAutomovil;
	}
	public void setIdAutomovil(Long idAutomovil) {
		this.idAutomovil = idAutomovil;
	}
	public Date getFechaMin() {
		return fechaMin;
	}
	public void setFechaMin(Date fechaMin) {
		this.fechaMin = fechaMin;
	}
	public Date getFechaMax() {
		return fechaMax;
	}
	public void setFechaMax(Date fechaMax) {
		this.fechaMax = fechaMax;
	}
	
	public BigDecimal getPrecioMax() {
		return precioMax;
	}
	public void setPrecioMax(BigDecimal precioMax) {
		this.precioMax = precioMax;
	}
	public BigDecimal getPrecioMin() {
		return precioMin;
	}
	public void setPrecioMin(BigDecimal precioMin) {
		this.precioMin = precioMin;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}	
	
}
