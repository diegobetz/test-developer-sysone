package ar.com.bussiness.ventas.request;

/**
 * Representa request para alta de automoviles
 * @author Diego
 *
 */
public class AutomovilRequest {

	
	private Long modeloId;
	
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

	
	


}
