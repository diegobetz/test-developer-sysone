package ar.com.bussiness.ventas.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.bussiness.ventas.entity.PrecioAutomovil;
import ar.com.bussiness.ventas.repository.PreciosRepository;
import ar.com.bussiness.ventas.request.GetPrecioAtomovilRequest;
import ar.com.bussiness.ventas.request.PrecioAtomovilRequest;
import ar.com.bussiness.ventas.services.exception.AutomovilNotFoundException;
import ar.com.bussiness.ventas.services.exception.NotValidRangeDatePrecioException;
import ar.com.bussiness.ventas.services.exception.PrecioNotFoundException;

@Service
public class PrecioServiceImpl implements PrecioService {

	@Autowired
    private AutomovilService automovilService;
	
	@Autowired
    private PreciosRepository rangoPreciosRepository;
	
	
	@Override
	public List<PrecioAutomovil> getAllPrecios() {
		return this.rangoPreciosRepository.findAll();
	}

	@Override
	public PrecioAutomovil getPrecioById(Long id) throws PrecioNotFoundException {
		return this.rangoPreciosRepository.findById(id).orElseThrow(()->new PrecioNotFoundException("Id:" +id +" exception not found"));
	}

	@Override
	public PrecioAutomovil getPrecioAtomovilFecha(GetPrecioAtomovilRequest request) throws PrecioNotFoundException, AutomovilNotFoundException {
		validacionAutomovilGetPrecioFechaActual(request.getIdAutomovil());
		List<PrecioAutomovil> result = this.rangoPreciosRepository.getPrecioAtomovilByAutomovilAndDate(request.getIdAutomovil(),request.getFecha()).orElseThrow(()->new PrecioNotFoundException("Precio actual exception not found"));;
		return result.get(0);
	}

	private void validacionAutomovilGetPrecioFechaActual(Long idAutomovil) throws AutomovilNotFoundException {
		automovilService.getAutomovilById(idAutomovil);
		
	}

	@Override
	public PrecioAutomovil addPrecioAutomovil(PrecioAtomovilRequest addPrecioRequest) throws AutomovilNotFoundException, NotValidRangeDatePrecioException {
		//verificar si no se superponen fechas existentes para el precio del automovil
		
		validateRangeDate(addPrecioRequest);
		PrecioAutomovil precioAutomovil = new PrecioAutomovil();
		precioAutomovil.setAutomovil(automovilService.getAutomovilById(addPrecioRequest.getIdAutomovil()));
		precioAutomovil.setFechaMin(addPrecioRequest.getFechaMin());
		precioAutomovil.setFechaMax(addPrecioRequest.getFechaMax());
		precioAutomovil.setPrecioMin(addPrecioRequest.getPrecioMin());
		precioAutomovil.setPrecioMax(addPrecioRequest.getPrecioMax());
		this.rangoPreciosRepository.save(precioAutomovil);
		return precioAutomovil;
	}

	private void validateRangeDate(PrecioAtomovilRequest addPrecioRequest) throws NotValidRangeDatePrecioException {
		boolean noExistsRange = this.rangoPreciosRepository.getPrecioAtomovilIfExistsDateRange(
				addPrecioRequest.getIdAutomovil(),
				addPrecioRequest.getFechaMin(),
				addPrecioRequest.getFechaMax()).get().isEmpty();
		if(!noExistsRange) {
			throw new NotValidRangeDatePrecioException("Rango fechas existente");
		}
	}

	@Override
	public void deletePrecioAutomovil(Long id) throws PrecioNotFoundException {
		this.rangoPreciosRepository.delete(this.getPrecioById(id));
		
	}

	@Override
	public void updatePrecioAutomovil(PrecioAtomovilRequest request) throws NotValidRangeDatePrecioException, PrecioNotFoundException {
		validateRangeDate(request);
		PrecioAutomovil precio = this.getPrecioById(request.getId());
		
		precio.setFechaMax(request.getFechaMax()!=null?request.getFechaMax():precio.getFechaMax());
		precio.setFechaMin(request.getFechaMin()!=null?request.getFechaMin():precio.getFechaMin());
		precio.setPrecioMax(request.getPrecioMax()!=null?request.getPrecioMax():precio.getPrecioMax());
		precio.setPrecioMin(request.getPrecioMin()!=null?request.getPrecioMin():precio.getPrecioMin());
		this.rangoPreciosRepository.save(precio);
		
				
	}

	@Override
	public Optional<PrecioAutomovil> getRangoPrecioExistente(BigDecimal precio, Date date) {
		return rangoPreciosRepository.getPrecioAtomovilIfExistsDateRange(precio, date);
		
	}
	
	

	
	
	
	

}
