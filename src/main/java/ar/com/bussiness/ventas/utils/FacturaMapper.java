package ar.com.bussiness.ventas.utils;

import java.sql.Timestamp;
import java.util.Calendar;

import org.springframework.stereotype.Component;

import ar.com.bussiness.ventas.entity.Automovil;
import ar.com.bussiness.ventas.entity.FacturaVenta;
import ar.com.bussiness.ventas.request.FacturaVentaRequest;
import ar.com.bussiness.ventas.services.exception.AutomovilNotFoundException;
import ar.com.bussiness.ventas.services.exception.ValidationPrecioVentaException;
@Component
public  class FacturaMapper {

	/**
	 * Setea los valores de la factura a agregrar
	 * @param factura
	 * @param request
	 * @throws AutomovilNotFoundException
	 * @throws ValidationPrecioVentaException
	 */
	public void setFacturaToAdd(FacturaVenta factura, FacturaVentaRequest request, Automovil automovil) {
		
		factura.setApellidoComprador(request.getApellidoComprador());
		factura.setNombreComprador(request.getNombreComprador());
		factura.setAutomovil(automovil);
		factura.setGarantiaAnios(request.getGarantiaAnios());
		factura.setGarantiaKms(request.getGarantiaKms());
		factura.setPrecioFinal(request.getPrecioFinal());
		factura.setGarantiaDescripcion(request.getGarantiaDescripcion());
		factura.setFecha(new Timestamp(Calendar.getInstance().getTime().getTime()));

	}
	
	/**Setea los valores de la factura a actualizar
	 * 
	 * @param factura
	 * @param request
	 * @param automovil
	 */
	public void setFacturaToUpdate(FacturaVenta factura, FacturaVentaRequest request) {
		
		factura.setApellidoComprador(request.getApellidoComprador());
		factura.setNombreComprador(request.getNombreComprador());
		factura.setGarantiaAnios(request.getGarantiaAnios());
		factura.setGarantiaKms(request.getGarantiaKms());
		factura.setPrecioFinal(request.getPrecioFinal());
		factura.setGarantiaDescripcion(request.getGarantiaDescripcion());
		
		factura.setFechaModificacion(new Timestamp(Calendar.getInstance().getTime().getTime()));
	}
	
	



}

