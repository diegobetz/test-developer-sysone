package ar.com.bussiness.ventas.request;

import java.math.BigDecimal;

/**
 * Representa request para altas y modificaciones de FacturaVenta
 * @author Diego
 *
 */
public class FacturaVentaRequest {
	
	private Long id;
	
	private String nombreComprador;
	
	private String apellidoComprador;
	
	private Long automovilId;
	
	private BigDecimal precioFinal;
	
	private String garantiaDescripcion;
	
	private Integer garantiaKms;
	
	private Integer garantiaAnios;
	
	public FacturaVentaRequest() {
		
	}

	public String getNombreComprador() {
		return nombreComprador;
	}

	public void setNombreComprador(String nombreComprador) {
		this.nombreComprador = nombreComprador;
	}

	public String getApellidoComprador() {
		return apellidoComprador;
	}

	public void setApellidoComprador(String apellidoComprador) {
		this.apellidoComprador = apellidoComprador;
	}

	public Long getAutomovilId() {
		return automovilId;
	}

	public void setAutomovilId(Long automovilId) {
		this.automovilId = automovilId;
	}

	public BigDecimal getPrecioFinal() {
		return precioFinal;
	}

	public void setPrecioFinal(BigDecimal precioFinal) {
		this.precioFinal = precioFinal;
	}

	public String getGarantiaDescripcion() {
		return garantiaDescripcion;
	}

	public void setGarantiaDescripcion(String garantiaDescripcion) {
		this.garantiaDescripcion = garantiaDescripcion;
	}

	public Integer getGarantiaKms() {
		return garantiaKms;
	}

	public void setGarantiaKms(Integer garantiaKms) {
		this.garantiaKms = garantiaKms;
	}

	public Integer getGarantiaAnios() {
		return garantiaAnios;
	}

	public void setGarantiaAnios(Integer garantiaAnios) {
		this.garantiaAnios = garantiaAnios;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
}
