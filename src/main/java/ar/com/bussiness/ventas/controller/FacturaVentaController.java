package ar.com.bussiness.ventas.controller;

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
import ar.com.bussiness.ventas.entity.FacturaVenta;
import ar.com.bussiness.ventas.request.FacturaVentaRequest;
import ar.com.bussiness.ventas.service.FacturaVentaServices;
import ar.com.bussiness.ventas.services.exception.AutomovilNotFoundException;
import ar.com.bussiness.ventas.services.exception.FacturaVentaNotFoundException;
import ar.com.bussiness.ventas.services.exception.InternalDataBaseException;
import ar.com.bussiness.ventas.services.exception.ValidationPrecioVentaException;
import ar.com.bussiness.ventas.services.exception.ValidationVentaAutoDisponibleException;

@RestController
@RequestMapping(path = "/bill")
public class FacturaVentaController {

	@Autowired
    private FacturaVentaServices facturaVentaServices;
		
	/**
	 * Consulta de todas las facturas existentes
	 * @return todas las facturas
	 */
	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FacturaVenta>> getAllFacturasVenta() {
		List<FacturaVenta> bills = facturaVentaServices.getAllFacturasVentas();
		return ResponseEntity.ok().body(bills);
    }
	
	/**
	 *  Consulta factura por id
	 * @param id
	 * @return Factura
	 */
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FacturaVenta> getFacturaVenta(@PathVariable Long id) {
		FacturaVenta factura = null;
		
		try {
			factura = facturaVentaServices.getFacturaVentaById(id);
		
		} catch (FacturaVentaNotFoundException e) {
			throw new ResourceNotFoundException("No se ha encontrado la factura solicitada",e);
		}
		
		return ResponseEntity.ok().body(factura);
    }
	
	/**
	 * Consulta de Facturas por parametros
	 * @param request
	 * @return
	 */
	@GetMapping(value = "/automovil/{idAutomovil}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FacturaVenta>> getFacturasVentaPorAutomovil(@PathVariable Long idAutomovil) {
		List<FacturaVenta> facturas = null;
		
		try {
			facturas = facturaVentaServices.getFacturaVentaByAutomovil(idAutomovil);
		
		} catch (FacturaVentaNotFoundException e) {
			throw new ResourceNotFoundException("No se ha encontrado la facturas para el automovil",e);
		} catch (AutomovilNotFoundException e) {
			throw new ResourceNotFoundException("No se ha encontrado el automovil solicitadoO",e);
		}
		
		return ResponseEntity.ok().body(facturas);
    }
	
	/**
	 * Alta de factura
	 * @param request
	 * @return resultado de la operacion
	 */
	@PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> addFacturaVenta(@RequestBody FacturaVentaRequest request) {
		ResponseEntity<Object> response = null;	
		 try {
			
			 this.facturaVentaServices.addFacturaVenta(request);
			
			 response = ResponseEntity.ok("Se ingreso correctamente la factura de la venta realizada");

		
		 } catch (InternalDataBaseException e) {
			 throw new ResponseStatusException(
			           HttpStatus.INTERNAL_SERVER_ERROR, "Internal Error", e);
		} catch (AutomovilNotFoundException e) {
			throw new ResourceNotFoundException("No se ha encontrado el automovil solicitadoO",e);

		} catch (ValidationPrecioVentaException e) {
			throw new ValidationException("El valor del precio del automovil no se encuentra dentro del rango establecido",e);
		} catch (ValidationVentaAutoDisponibleException e) {
			throw new ValidationException("No existen unidades del automovil disponibles para la venta",e);
		}
		
		 return response;

    }
	
	
	/**
	 * Eliminar factura
	 * @param request
	 * @return resultado de la operacion
	 */
	@DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> cancelarFactura(@PathVariable Long id) {
		ResponseEntity<Object> response = null;	
		 try {
			
			 this.facturaVentaServices.deleteFactura(id);
			
			 response = ResponseEntity.ok("Se elimno correctamente la factura");

		
		 } catch (FacturaVentaNotFoundException e) {
				throw new ResourceNotFoundException("No es posible obtener la factura que desea eliminar",e);

		}
		 return response;

    }
	
	/**
	 * Modificar datos de factura
	 * @param request
	 * @return resultado de la operacion
	 */
	@PostMapping(value = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateFactura(@RequestBody FacturaVentaRequest request) {
		ResponseEntity<Object> response = null;	
		 try {
			 
			 this.facturaVentaServices.updateFacturaVenta(request);
			
			 response = ResponseEntity.ok("Se actualizo correctamente la factura de la venta realizada");

		
		 } catch (FacturaVentaNotFoundException e) {
				throw new ResourceNotFoundException("No es posible obtener la factura que desea eliminar",e);

		} catch (AutomovilNotFoundException e) {
			throw new ResourceNotFoundException("No es posible obtener la factura que desea eliminar",e);

		} catch (ValidationPrecioVentaException e) {
			throw new ResourceNotFoundException("El precio de venta no se encuentra entre los rangos preestablecidos",e);

		} 
		
		 return response;

    }
	
	
		
	

}
