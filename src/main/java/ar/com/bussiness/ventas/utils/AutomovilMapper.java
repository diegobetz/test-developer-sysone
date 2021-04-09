package ar.com.bussiness.ventas.utils;

import org.springframework.stereotype.Component;

import ar.com.bussiness.ventas.entity.Automovil;
import ar.com.bussiness.ventas.entity.Modelo;
import ar.com.bussiness.ventas.request.AutomovilAddResponse;
import ar.com.bussiness.ventas.request.AutomovilUpdateRequest;

@Component
public class AutomovilMapper {

	public void updateAutomovilFromRequest(Automovil automovil, AutomovilUpdateRequest request) {
		automovil.setGarantiaAniosDefault(request.getGarantiaAniosDefault());
		automovil.setGarantiaKmsDefault(request.getGarantiaKmsDefault());
		automovil.setUnidadesDisponibles(request.getUnidadesDisponibles());

	}

	public void setAutomovilAddResponse(Automovil automovil, AutomovilAddResponse automovilAddResponse) {
		Modelo modelo =automovil.getModelo();
		automovilAddResponse.setModeloId(modelo.getId());
		automovilAddResponse.setGarantiaAniosDefault(automovilAddResponse.getGarantiaAniosDefault());
		automovilAddResponse.setGarantiaKmsDefault(automovilAddResponse.getGarantiaKmsDefault());
		automovilAddResponse.setUnidadesDisponibles(automovilAddResponse.getUnidadesDisponibles());
		automovilAddResponse.setModeloDescripcion(modelo.getDescripcion());
		automovilAddResponse.setModeloVariante(modelo.getVariante());

	}

	
	



}

