package ar.com.bussiness.ventas.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import ar.com.bussiness.ventas.controller.exception.ResourceNotFoundException;
import ar.com.bussiness.ventas.controller.exception.ValidationException;
import ar.com.bussiness.ventas.entity.PrecioAutomovil;
import ar.com.bussiness.ventas.request.GetPrecioAtomovilRequest;
import ar.com.bussiness.ventas.request.PrecioAtomovilRequest;
import ar.com.bussiness.ventas.service.PrecioService;
import ar.com.bussiness.ventas.services.exception.AutomovilNotFoundException;
import ar.com.bussiness.ventas.services.exception.NotValidRangeDatePrecioException;
import ar.com.bussiness.ventas.services.exception.PrecioNotFoundException;

@RestController
@RequestMapping(path = "/")
public class PreciosController {

	@Autowired
    private PrecioService precioServices;
	
	/**
	 * Consulta de todos los rangos de precios de todos los automoviles cargados en el sistema
	 * @return List<PrecioAutomovil>
	 */
	@GetMapping(value = "/price", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PrecioAutomovil>> getAllPreciosAutomoviles() {
		List<PrecioAutomovil> precios = precioServices.getAllPrecios();
		return ResponseEntity.ok().body(precios);
    }
	
	/**
	 * Consulta de un rango de precio 
	 * @param id
	 * @return PrecioAutomovil
	 */
	@GetMapping(value = "/price/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PrecioAutomovil> getPrecioAutomovil(@PathVariable Long id) {
		
		try {
			
			PrecioAutomovil precio = precioServices.getPrecioById(id);
			return ResponseEntity.ok().body(precio);

		} catch (PrecioNotFoundException e) {
			throw new ResourceNotFoundException("No se ha encontrado el automovil solicitado",e);
		}
		
    }
	
	/**
	 * Consulta de precio de un automovil para el dia de la fecha actual
	 * @param request
	 * @return PrecioAutomovil
	 */
	@PostMapping(value = "/price/date/car", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PrecioAutomovil> getPrecioAutomovilActual(@RequestBody GetPrecioAtomovilRequest request) {
		PrecioAutomovil precio = null;
		
		try {
			precio = precioServices.getPrecioAtomovilFecha(request);
		
		} catch (PrecioNotFoundException e) {
			throw new ResourceNotFoundException("No se ha encontrado precio para la solicitud realizada",e);
		} catch (AutomovilNotFoundException e) {
			throw new ResourceNotFoundException("No se ha encontrado el automovil para la solicitud",e);

		}
		
		return ResponseEntity.ok().body(precio);
    }
	
	/**
	 * Agregar un rango de precios para un automovil
	 * @param addPrecioRequest
	 * @return
	 */
	@PostMapping(path= "/add/price", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> addPrecioAutomovil(@RequestBody PrecioAtomovilRequest addPrecioRequest) {
		ResponseEntity<Object> response = null;	
		 try {
			
			 PrecioAutomovil precio = this.precioServices.addPrecioAutomovil(addPrecioRequest);
			
			 URI location = ServletUriComponentsBuilder.fromCurrentRequest()
	                 .path("/{id}")
	                 .buildAndExpand(precio.getId())
	                 .toUri();
			 response = ResponseEntity.created(location).build();
		
		 } catch (AutomovilNotFoundException e) {
				throw new ResourceNotFoundException("No se ha encontrado el automovil solicitado",e);

		}catch (NotValidRangeDatePrecioException e) {
			 throw new ValidationException("Existe un registro para el rango de fechas ingresado",e);
		}
		 
		
		 return response;

	}
	
	/**
	 * Modificar rango de precio de un automovil
	 * @param id
	 * @param request
	 * @return
	 * @throws  
	 */
	@PostMapping(path= "/update/price/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<ResponseEntity<Object>> updateRangoPrecio(@RequestBody PrecioAtomovilRequest request) {
		 try {
			 List<ResponseEntity<Object>>  response = new ArrayList<ResponseEntity<Object>>();
			 this.precioServices.updatePrecioAutomovil(request);			
			 response.add(ResponseEntity.ok("La actualizacion se ha realizado con exito"));
			 return response;
		 
		} catch (NotValidRangeDatePrecioException e) {
			 throw new ValidationException("Existe un registro para el rango de fechas ingresado",e);
		} catch (PrecioNotFoundException e) {
			throw new ResourceNotFoundException("No se ha encontrado precio para la solicitud realizada",e);

		}		

	}		
	
	/**
	 * Consulta de precio por id
	 * @param id
	 * @return
	 */
	@DeleteMapping(path= "/delete/price/{id}")
	public List<ResponseEntity<Object>> deleteRangoPrecio(@PathVariable Long id) {
		 try {
			 List<ResponseEntity<Object>>  response = new ArrayList<ResponseEntity<Object>>();
			 this.precioServices.deletePrecioAutomovil(id);			
			 response.add(ResponseEntity.ok("Se elimino el rango de precio del automovil correctamente"));
			 return response;
		 } catch (PrecioNotFoundException e) {
				throw new ResourceNotFoundException("No se ha encontrado precio para la solicitud realizada",e);

		}
		

	}
	
		
	

}
