package ar.com.bussiness.ventas.request;

import java.util.List;

/**
 * Representa el request para el update de descripcion de Modelo
 * @author Diego
 *
 */
public class ModeloUpdateRequest {

	
	private String modeloDescripcionNueva;
	
	private String modeloDescripcionAnterior;
	
	
	

	public String getModeloDescripcionNueva() {
		return modeloDescripcionNueva;
	}

	public void setModeloDescripcionNueva(String modeloDescripcionNueva) {
		this.modeloDescripcionNueva = modeloDescripcionNueva;
	}

	public String getModeloDescripcionAnterior() {
		return modeloDescripcionAnterior;
	}

	public void setModeloDescripcionAnterior(String modeloDescripcionAnterior) {
		this.modeloDescripcionAnterior = modeloDescripcionAnterior;
	}

	
		

	
}
