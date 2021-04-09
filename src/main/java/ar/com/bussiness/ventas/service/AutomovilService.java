package ar.com.bussiness.ventas.service;

import java.util.List;

import ar.com.bussiness.ventas.entity.Automovil;
import ar.com.bussiness.ventas.entity.Modelo;
import ar.com.bussiness.ventas.request.AutomovilAddResponse;
import ar.com.bussiness.ventas.request.AutomovilRequest;
import ar.com.bussiness.ventas.request.AutomovilUpdateRequest;
import ar.com.bussiness.ventas.request.ModeloRequest;
import ar.com.bussiness.ventas.request.ModeloUpdateRequest;
import ar.com.bussiness.ventas.services.exception.AutomovilNotFoundException;
import ar.com.bussiness.ventas.services.exception.InternalDataBaseException;
import ar.com.bussiness.ventas.services.exception.ModeloExistException;
import ar.com.bussiness.ventas.services.exception.ModeloNotFoundException;


public interface AutomovilService {
	
	public List<Automovil> getAllAutomoviles();
	
	public List<Modelo> getAllModelos();

	public AutomovilAddResponse addAutomovil(AutomovilRequest car) throws InternalDataBaseException, ModeloNotFoundException, ModeloExistException;

	public List<Modelo> addModeloVariantes(ModeloRequest modeloRequest) throws InternalDataBaseException, ModeloExistException;

	public Automovil getAutomovilById(Long id) throws AutomovilNotFoundException;

	public Modelo getModeloById(Long id) throws ModeloNotFoundException;

	public void deleteAutomovil(Long id) throws AutomovilNotFoundException;

	public void updateAutomovil(AutomovilUpdateRequest car) throws AutomovilNotFoundException;
	
	public void deleteModelo(Long id) throws ModeloNotFoundException;

	public void removeUnidadDisponible(Automovil automovil);

	public void updateModelo(ModeloUpdateRequest request) throws InternalDataBaseException, ModeloExistException;

	

}
