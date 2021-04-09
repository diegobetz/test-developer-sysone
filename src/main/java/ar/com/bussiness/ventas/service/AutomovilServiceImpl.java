package ar.com.bussiness.ventas.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import ar.com.bussiness.ventas.entity.Automovil;
import ar.com.bussiness.ventas.entity.Modelo;
import ar.com.bussiness.ventas.repository.AutomovilRepository;
import ar.com.bussiness.ventas.repository.ModeloRepository;
import ar.com.bussiness.ventas.request.AutomovilAddResponse;
import ar.com.bussiness.ventas.request.AutomovilRequest;
import ar.com.bussiness.ventas.request.AutomovilUpdateRequest;
import ar.com.bussiness.ventas.request.ModeloRequest;
import ar.com.bussiness.ventas.request.ModeloUpdateRequest;
import ar.com.bussiness.ventas.services.exception.AutomovilNotFoundException;
import ar.com.bussiness.ventas.services.exception.InternalDataBaseException;
import ar.com.bussiness.ventas.services.exception.ModeloExistException;
import ar.com.bussiness.ventas.services.exception.ModeloNotFoundException;
import ar.com.bussiness.ventas.utils.AutomovilMapper;

@Service
public class AutomovilServiceImpl implements AutomovilService {

	
	@Autowired
    private AutomovilRepository automovilRepository;
	
	@Autowired
    private ModeloRepository modeloRepository;
	
	@Autowired
	private AutomovilMapper mapper;

	
	
	@Override
	public List<Automovil> getAllAutomoviles() {
		
		return automovilRepository.findAll();
	}

	@Override
	public List<Modelo> getAllModelos() {
		
		return modeloRepository.findAll();
	}


	@Override
	public AutomovilAddResponse addAutomovil(AutomovilRequest car) throws InternalDataBaseException, ModeloNotFoundException, ModeloExistException {
		try {						
			AutomovilAddResponse automovilAddResponse = new AutomovilAddResponse();

			Automovil automovil = new Automovil();
			automovil.setGarantiaAniosDefault(car.getGarantiaAniosDefault());
			automovil.setGarantiaKmsDefault(car.getGarantiaKmsDefault());
			automovil.setModelo(getModeloById(car.getModeloId()));
			automovil.setUnidadesDisponibles(car.getUnidadesDisponibles());
			automovil =  this.automovilRepository.save(automovil);
			mapper.setAutomovilAddResponse(automovil,automovilAddResponse);
			return automovilAddResponse;
		}catch (DataIntegrityViolationException e) {
			throw new ModeloExistException("Ya se encuentra dado de alta el modelo solicitado",e);
		}catch (Exception e) {
			throw new InternalDataBaseException(e);
		}
		
	}
//	private void validarAddModelo(String modeloDescripcion, String variante) throws ModeloExistException {
//		modeloRepository.getModeloByDescripcionAndVariante(modeloDescripcion, variante).orElseThrow( () -> new ModeloExistException("ya existe el elemento que se desea agregar"));
//		
//
//	}
	
	
	@Override
	public List<Modelo> addModeloVariantes(ModeloRequest modeloRequest) throws InternalDataBaseException , ModeloExistException{
		try {
			
			List<Modelo> modelos = new ArrayList<Modelo>();
			modeloRequest.getVariantes().stream().forEach((x)->{
				Modelo modelo = new Modelo();
				modelo.setDescripcion(modeloRequest.getModeloDescripcion());
				modelo.setVariante(x);
				try {					
					this.modeloRepository.save(modelo);
					modelos.add(modelo);
				} catch (DataIntegrityViolationException e) {
					//VARIANTE REPETIDA
					//no se ingresa en base
				}
				
			});
			
			return modelos;
		}catch (Exception e) {
			throw new InternalDataBaseException(e);
		}
		
	}

		

	@Override
	public Automovil getAutomovilById(Long id) throws AutomovilNotFoundException {
		return this.automovilRepository.findById(id).orElseThrow(()->new AutomovilNotFoundException("Id:" +id +" exception not found"));
	}

	@Override
	public Modelo getModeloById(Long id) throws ModeloNotFoundException {
		return this.modeloRepository.findById(id).orElseThrow(()->new ModeloNotFoundException("Id:" +id +" exception not found"));

	}

	@Override
	public void deleteAutomovil(Long id) throws AutomovilNotFoundException {	
		this.automovilRepository.delete(this.getAutomovilById(id));		
	}

	@Override
	public void updateAutomovil(AutomovilUpdateRequest request) throws AutomovilNotFoundException {
		Automovil automovil = this.getAutomovilById(request.getId());
		mapper.updateAutomovilFromRequest(automovil, request);
		this.automovilRepository.save(automovil);
	}

	@Override
	public void deleteModelo(Long id) throws ModeloNotFoundException {
		this.modeloRepository.delete(this.getModeloById(id));
		
	}

	@Override
	public void removeUnidadDisponible(Automovil automovil) {
		automovil.setUnidadesDisponibles(automovil.getUnidadesDisponibles()-1);
		this.automovilRepository.save(automovil);
		
	}
	
	@Override
	public void updateModelo(ModeloUpdateRequest request) throws InternalDataBaseException, ModeloExistException {
		validarDescripcionExists(request);		
		try {
			this.modeloRepository.setDescripcion(request.getModeloDescripcionAnterior(), request.getModeloDescripcionNueva());

		}catch (Exception e) {
			throw new InternalDataBaseException("Excepcion al actualizar modelo",e);
		}
		
	}

	private void validarDescripcionExists(ModeloUpdateRequest request) throws ModeloExistException {
		if(modeloRepository.getModeloByDescripcion(request.getModeloDescripcionAnterior()).isEmpty()) {
			throw new ModeloExistException("no existe el elemento que se desea agregar");
		}
		
	}

	
	
	

}
