package ar.com.bussiness.ventas.service;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.bussiness.ventas.entity.Automovil;
import ar.com.bussiness.ventas.entity.FacturaVenta;
import ar.com.bussiness.ventas.repository.FacturaVentaRepository;
import ar.com.bussiness.ventas.request.FacturaVentaRequest;
import ar.com.bussiness.ventas.services.exception.AutomovilNotFoundException;
import ar.com.bussiness.ventas.services.exception.FacturaVentaNotFoundException;
import ar.com.bussiness.ventas.services.exception.InternalDataBaseException;
import ar.com.bussiness.ventas.services.exception.ValidationPrecioVentaException;
import ar.com.bussiness.ventas.services.exception.ValidationVentaAutoDisponibleException;
import ar.com.bussiness.ventas.utils.FacturaMapper;

@Service
public class FacturaVentaServicesImpl implements FacturaVentaServices{

	

	@Autowired
    private FacturaVentaRepository facturaVentaRepository;
	
	@Autowired
    private AutomovilService automovilService;
	
	@Autowired
    private PrecioService precioService;
	
	@Autowired
	private FacturaMapper mapper;
	
	
	
	@Override
	public List<FacturaVenta> getAllFacturasVentas() {
		return this.facturaVentaRepository.findAll();
	}


	@Override
	public FacturaVenta getFacturaVentaById(Long id) throws FacturaVentaNotFoundException {
		return this.facturaVentaRepository.findById(id).orElseThrow(()->new FacturaVentaNotFoundException("Id:" +id +" exception not found"));

	}


	@Override
	public FacturaVenta addFacturaVenta(FacturaVentaRequest request) throws InternalDataBaseException, AutomovilNotFoundException, ValidationPrecioVentaException, ValidationVentaAutoDisponibleException {
		
		Automovil automovil = automovilService.getAutomovilById(request.getAutomovilId());
		validateIsAutomovilDisponible(automovil);
		validacionPrecioVenta(request);
		FacturaVenta factura = new FacturaVenta();
		mapper.setFacturaToAdd(factura,request,automovil);	

		try {
			FacturaVenta facturaVenta = this.facturaVentaRepository.save(factura);
			this.automovilService.removeUnidadDisponible(automovil);
			return facturaVenta;
		}catch (Exception e) {
				throw new InternalDataBaseException(e);
		}
		
	}


	

	private void validacionPrecioVenta(FacturaVentaRequest request) throws ValidationPrecioVentaException {
		precioService.getRangoPrecioExistente(request.getPrecioFinal(),Calendar.getInstance().getTime())
		.orElseThrow(()->new ValidationPrecioVentaException("Error validacion precio. Precio :"+request.getPrecioFinal()));
		
	}


	private void validateIsAutomovilDisponible(Automovil automovil) throws ValidationVentaAutoDisponibleException {
		if (automovil.getUnidadesDisponibles() == 0){
			throw new ValidationVentaAutoDisponibleException("Error valicacion venta. No hay unidades disponibles para la venta");
		}
	}


	@Override
	public List<FacturaVenta> getFacturaVentaByAutomovil(Long idAutomovil) throws AutomovilNotFoundException, FacturaVentaNotFoundException {
		Automovil automovil = this.automovilService.getAutomovilById(idAutomovil);
		this.facturaVentaRepository.findByAutomovil(automovil).orElseThrow(()-> new FacturaVentaNotFoundException(""));
		return null;
	}


	@Override
	public void deleteFactura(Long id) throws FacturaVentaNotFoundException {
		this.facturaVentaRepository.delete(this.getFacturaVentaById(id));
		
	}


	@Override
	public void updateFacturaVenta(FacturaVentaRequest request) throws FacturaVentaNotFoundException, AutomovilNotFoundException, ValidationPrecioVentaException {
		validacionPrecioVenta(request);
		FacturaVenta factura = this.getFacturaVentaById(request.getId());
		mapper.setFacturaToUpdate(factura, request);
		this.facturaVentaRepository.save(factura);
		
	}

}
