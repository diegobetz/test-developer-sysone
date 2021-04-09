package ar.com.bussiness.ventas.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import ar.com.bussiness.ventas.controller.exception.ResourceNotFoundException;
import ar.com.bussiness.ventas.controller.exception.ValidationException;
import ar.com.bussiness.ventas.entity.Automovil;
import ar.com.bussiness.ventas.entity.Modelo;
import ar.com.bussiness.ventas.request.AutomovilAddResponse;
import ar.com.bussiness.ventas.request.AutomovilRequest;
import ar.com.bussiness.ventas.request.AutomovilUpdateRequest;
import ar.com.bussiness.ventas.request.ModeloRequest;
import ar.com.bussiness.ventas.request.ModeloUpdateRequest;
import ar.com.bussiness.ventas.service.AutomovilService;
import ar.com.bussiness.ventas.services.exception.AutomovilNotFoundException;
import ar.com.bussiness.ventas.services.exception.InternalDataBaseException;
import ar.com.bussiness.ventas.services.exception.ModeloExistException;
import ar.com.bussiness.ventas.services.exception.ModeloNotFoundException;

@RestController
@RequestMapping(path = "/")
public class AutomovilesController {

	@Autowired
    private AutomovilService automovilService;
	
	

	/**
	 * Alta de Modelo
	 * 
	 * @param modeloRequest
	 * @return resultado de la operacion
	 */
	@PostMapping(path= "/models", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> addModeloVariantes(@RequestBody ModeloRequest modeloRequest) {
		 try {
			ResponseEntity<Object>  response = null;
			this.automovilService.addModeloVariantes(modeloRequest);
				
			response = ResponseEntity.ok("Se han ingresado el modelo "+ modeloRequest.getModeloDescripcion() +" y sus variantes correctamente");
			
			 return response;

		 } catch (InternalDataBaseException e) {
			 throw new ResponseStatusException(
			           HttpStatus.INTERNAL_SERVER_ERROR, "Internal Error", e);
		} catch (ModeloExistException e) {
			throw new ValidationException("Ya se encuentra el modelo que desea agregar",e);

		}
		

	}

	
	/**
	 * Consulta de modelo por id 
	 * @param id
	 * @return Modelo
	 */
	@GetMapping(value = "/models/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Modelo> getModelo(@PathVariable Long id) {
		Modelo auto = null;
		
		try {
			auto = this.automovilService.getModeloById(id);
		
		} catch (ModeloNotFoundException e) {
			throw new ResourceNotFoundException("No se ha encontrado el automovil solicitado",e);
		}
		
		return ResponseEntity.ok().body(auto);
    }
	
	
	/**
	 * Consulta de todos los modelos existes con sus variantes
	 * @return
	 */
	@GetMapping(value = "/models", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Modelo>> getModelos() {
		List<Modelo> modelos = automovilService.getAllModelos();
		return ResponseEntity.ok().body(modelos);
    }
	
	
	/**
	 * Eliminar modelo por id
	 * @param id
	 * @return resultado de la operacion
	 */
	@DeleteMapping(path= "/models/{id}")
	public List<ResponseEntity<Object>> deleteModelo(@PathVariable Long id) {
		 try {
			 List<ResponseEntity<Object>>  response = new ArrayList<ResponseEntity<Object>>();
			 this.automovilService.deleteModelo(id);			
			 response.add(ResponseEntity.ok("Se elimino el modelo correctamente"));
			 return response;
		 
		} catch (ModeloNotFoundException e) {
			throw new ResourceNotFoundException("No se ha encontrado el modelo que desea eliminar",e);

		}
		

	}
	
	/**
	 * Alta de automovil
	 * @param car
	 * @return resultado de la operacion
	 */
	@PostMapping(path= "/add/cars", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> addAutomovil(@RequestBody AutomovilRequest car) {
		ResponseEntity<Object> response = null;	
		 try {
			
			 AutomovilAddResponse automovil = this.automovilService.addAutomovil(car);
			
			 response = ResponseEntity.ok("Se ha ingresado correctamente el Automovil:" +automovil.getModeloDescripcion() +" " + automovil.getModeloVariante());

		 } catch (InternalDataBaseException e) {
			 throw new ResponseStatusException(
			           HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage(), e);
		} catch (ModeloNotFoundException e) {
			throw new ResourceNotFoundException("No se ha encontrado el automovil solicitado",e);
		} catch (ModeloExistException e) {
			throw new ValidationException(e.getMessage(),e);
		}
		
		 return response;

	}
	
	/**Consulta de todos los automoviles existentes
	 * 
	 * @return Lista de automoviles
	 */
	@GetMapping(value = "/cars", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Automovil>> getAutomoviles() {
		List<Automovil> autos = automovilService.getAllAutomoviles();
		return ResponseEntity.ok().body(autos);
    }
	
	/**
	 * Consulta de Automovil por id
	 * @param id
	 * @return Automovil 
	 */
	@GetMapping(value = "/cars/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Automovil> getAutomovil(@PathVariable Long id) {
		Automovil auto = null;
		
		try {
			auto = automovilService.getAutomovilById(id);
		
		} catch (AutomovilNotFoundException e) {
			throw new ResourceNotFoundException("No se ha encontrado el automovil solicitado",e);
		}
		
		return ResponseEntity.ok().body(auto);
    }
	
	
		
	/**
	 * Eliminar automovil por id
	 * @param id
	 * @return resultado de la operacion
	 */
	@DeleteMapping(path= "/delete/car/{id}")
	public List<ResponseEntity<Object>> deleteAutomovil(@PathVariable Long id) {
		 try {
			 List<ResponseEntity<Object>>  response = new ArrayList<ResponseEntity<Object>>();
			 this.automovilService.deleteAutomovil(id);			
			 response.add(ResponseEntity.ok("Se elimino el automovil correctamente"));
			 return response;
		 } catch (AutomovilNotFoundException e) {
				throw new ResourceNotFoundException("No se ha encontrado el automovil que desea eliminar",e);

		}
		

	}
	
	/**
	 * Actualizacion del Automovil por id
	 * @param id
	 * @param car
	 * @return resultado de la operacion
	 */
	@PostMapping(path= "/update/car/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<ResponseEntity<Object>> updateAutomovil(@RequestBody AutomovilUpdateRequest car) {
		 try {
			 List<ResponseEntity<Object>>  response = new ArrayList<ResponseEntity<Object>>();
			 this.automovilService.updateAutomovil(car);			
			 response.add(ResponseEntity.ok("La actualizacion se ha realizado con exito"));
			 return response;
		 } catch (AutomovilNotFoundException e) {
				throw new ResourceNotFoundException("No se ha encontrado el automovil que desea actualizar",e);

		}		

	}
	
	@PostMapping(path= "/update/modelo", consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<ResponseEntity<Object>> updateModelo(@RequestBody ModeloUpdateRequest request) {
		 try {
			 List<ResponseEntity<Object>>  response = new ArrayList<ResponseEntity<Object>>();
			 this.automovilService.updateModelo(request);			
			 response.add(ResponseEntity.ok("La actualizacion se ha realizado con exito"));
			 return response;
		 } catch (InternalDataBaseException e) {
			 throw new ResponseStatusException(
			           HttpStatus.INTERNAL_SERVER_ERROR, "Internal Error", e);
		} catch (ModeloExistException e) {
			throw new ValidationException("No existe un modelo con la descripcion: "+request.getModeloDescripcionAnterior(),e);
		}		

	}


	public void setAutomovilService(AutomovilService automovilService) {
		this.automovilService = automovilService;
	}
	
	

		
		

}
