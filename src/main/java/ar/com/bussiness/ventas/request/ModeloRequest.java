package ar.com.bussiness.ventas.request;

import java.util.List;

/**
 * Representa el request para el alta de Modelo
 * @author Diego
 *
 */
public class ModeloRequest {

	
	private String modeloDescripcion;
	
	private List<String> variantes;

	public String getModeloDescripcion() {
		return modeloDescripcion;
	}

	public void setModeloDescripcion(String modeloDescripcion) {
		this.modeloDescripcion = modeloDescripcion;
	}

	public List<String> getVariantes() {
		return variantes;
	}

	public void setVariantes(List<String> variantes) {
		this.variantes = variantes;
	}

	

	
}
