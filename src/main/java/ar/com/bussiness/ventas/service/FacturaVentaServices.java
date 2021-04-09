package ar.com.bussiness.ventas.service;

import java.util.List;

import ar.com.bussiness.ventas.entity.FacturaVenta;
import ar.com.bussiness.ventas.request.FacturaVentaRequest;
import ar.com.bussiness.ventas.services.exception.AutomovilNotFoundException;
import ar.com.bussiness.ventas.services.exception.FacturaVentaNotFoundException;
import ar.com.bussiness.ventas.services.exception.InternalDataBaseException;
import ar.com.bussiness.ventas.services.exception.ValidationPrecioVentaException;
import ar.com.bussiness.ventas.services.exception.ValidationVentaAutoDisponibleException;

public interface FacturaVentaServices {

	public List<FacturaVenta> getAllFacturasVentas();

	public FacturaVenta getFacturaVentaById(Long id) throws FacturaVentaNotFoundException;

	public FacturaVenta addFacturaVenta(FacturaVentaRequest request) throws InternalDataBaseException, AutomovilNotFoundException, ValidationPrecioVentaException, ValidationVentaAutoDisponibleException;

	public List<FacturaVenta> getFacturaVentaByAutomovil(Long idAutomovil) throws AutomovilNotFoundException, FacturaVentaNotFoundException;

	public void deleteFactura(Long id) throws FacturaVentaNotFoundException;

	public void updateFacturaVenta(FacturaVentaRequest request) throws FacturaVentaNotFoundException, AutomovilNotFoundException, ValidationPrecioVentaException;

}
