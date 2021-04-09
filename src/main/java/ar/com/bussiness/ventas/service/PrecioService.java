package ar.com.bussiness.ventas.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import ar.com.bussiness.ventas.entity.PrecioAutomovil;
import ar.com.bussiness.ventas.request.GetPrecioAtomovilRequest;
import ar.com.bussiness.ventas.request.PrecioAtomovilRequest;
import ar.com.bussiness.ventas.services.exception.AutomovilNotFoundException;
import ar.com.bussiness.ventas.services.exception.NotValidRangeDatePrecioException;
import ar.com.bussiness.ventas.services.exception.PrecioNotFoundException;


public interface PrecioService {
	
	public List<PrecioAutomovil> getAllPrecios();

	public PrecioAutomovil getPrecioById(Long id) throws PrecioNotFoundException;

	public PrecioAutomovil getPrecioAtomovilFecha(GetPrecioAtomovilRequest request) throws PrecioNotFoundException, AutomovilNotFoundException;

	public PrecioAutomovil addPrecioAutomovil(PrecioAtomovilRequest addPrecioRequest) throws AutomovilNotFoundException, NotValidRangeDatePrecioException;

	public void deletePrecioAutomovil(Long id) throws PrecioNotFoundException;

	public void updatePrecioAutomovil(PrecioAtomovilRequest request) throws NotValidRangeDatePrecioException, PrecioNotFoundException;

	public Optional<PrecioAutomovil> getRangoPrecioExistente(BigDecimal precio, Date time);

	

}
