package com.business.ventas.controller.ventasAutomoviles;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import ar.com.bussiness.ventas.controller.AutomovilesController;
import ar.com.bussiness.ventas.request.AutomovilAddResponse;
import ar.com.bussiness.ventas.request.AutomovilRequest;
import ar.com.bussiness.ventas.request.ModeloRequest;
import ar.com.bussiness.ventas.service.AutomovilServiceImpl;


/**
 * Test para los servicio de la capa controllers. Solo cubre el flujo de funcionalidad de los controllers
 * @author Diego
 *
 */
@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)

public class AutomovilesControllerTests {
	
    @InjectMocks
	 AutomovilesController automovilesController;


    @Mock
     AutomovilServiceImpl automovilService;
	
	 
	 
	 @Test
		public void addModeloVariantesTest() {
	    	   List<String> variantes = new ArrayList<>();   	                      
	           ModeloRequest modeloRequest = new ModeloRequest();
	           modeloRequest.setModeloDescripcion("Mercedes Benz");
	           variantes.add("Familiar");
	           variantes.add("Coupe");
	           variantes.add("Sedan");
	           modeloRequest.setVariantes(variantes);
	           ResponseEntity<Object> responseEntity = automovilesController.addModeloVariantes(modeloRequest );
	           assertTrue(responseEntity.getStatusCodeValue() == 200);
	          // assertTrue(responseEntity.getBody().g);    	
		}

	 
    @Test
	public void addAutomovilTest() {           
           AutomovilRequest addAutomovilRequest = new AutomovilRequest();
           addAutomovilRequest.setModeloId(Long.valueOf(1));
           addAutomovilRequest.setGarantiaAniosDefault(3);
           addAutomovilRequest.setGarantiaKmsDefault(100000);
           AutomovilAddResponse response = new AutomovilAddResponse();
           response.setModeloDescripcion("Corsa");
           response.setModeloVariante("Sedan");
           assertDoesNotThrow(()->Mockito.when(automovilService.addAutomovil(addAutomovilRequest)).thenReturn(response));      
           ResponseEntity<Object> responseEntity = automovilesController.addAutomovil(addAutomovilRequest );
           assertTrue(responseEntity.getStatusCodeValue() == 200);
          // assertTrue(responseEntity.getBody().g);    	
	}

	
}