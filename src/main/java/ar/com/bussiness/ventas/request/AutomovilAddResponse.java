package ar.com.bussiness.ventas.request;

/**
 * Representa request para alta de automoviles
 * @author Diego
 *
 */
public class AutomovilAddResponse {

	
	private Long modeloId;
	
	private String modeloDescripcion;
	
	private String modeloVariante;
	
	private Integer garantiaKmsDefault;
	
	private Integer garantiaAniosDefault;
	
	private Long unidadesDisponibles;
	

	public Long getModeloId() {
		return modeloId;
	}

	public void setModeloId(Long modeloId) {
		this.modeloId = modeloId;
	}

	public Integer getGarantiaKmsDefault() {
		return garantiaKmsDefault;
	}

	public void setGarantiaKmsDefault(Integer garantiaKmsDefault) {
		this.garantiaKmsDefault = garantiaKmsDefault;
	}

	public Integer getGarantiaAniosDefault() {
		return garantiaAniosDefault;
	}

	public void setGarantiaAniosDefault(Integer garantiaAniosDefault) {
		this.garantiaAniosDefault = garantiaAniosDefault;
	}

	public Long getUnidadesDisponibles() {
		return unidadesDisponibles;
	}

	public void setUnidadesDisponibles(Long unidadesDisponibles) {
		this.unidadesDisponibles = unidadesDisponibles;
	}

	public String getModeloDescripcion() {
		return modeloDescripcion;
	}

	public void setModeloDescripcion(String modeloDescripcion) {
		this.modeloDescripcion = modeloDescripcion;
	}

	public String getModeloVariante() {
		return modeloVariante;
	}

	public void setModeloVariante(String modeloVariante) {
		this.modeloVariante = modeloVariante;
	}

	
	


}
