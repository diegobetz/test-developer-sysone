package ar.com.bussiness.ventas.request;

/**
 *  * Representa request para update de automoviles
 * @author Diego
 *
 */
public class AutomovilUpdateRequest {


	private Long id;
	
	private Integer garantiaKmsDefault;
	
	private Integer garantiaAniosDefault;
	
	private Long unidadesDisponibles;

	 
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
}
