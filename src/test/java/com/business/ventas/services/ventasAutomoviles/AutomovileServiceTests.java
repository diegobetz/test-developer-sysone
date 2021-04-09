package com.business.ventas.services.ventasAutomoviles;
//package com.business.ventas.services.ventasAutomoviles.copy;
//
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertTrue;
//import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.platform.runner.JUnitPlatform;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.http.ResponseEntity;
//import org.springframework.mock.web.MockHttpServletRequest;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import ar.com.bussiness.ventas.controller.AutomovilesController;
//import ar.com.bussiness.ventas.entity.Modelo;
//import ar.com.bussiness.ventas.repository.AutomovilRepository;
//import ar.com.bussiness.ventas.repository.ModeloRepository;
//import ar.com.bussiness.ventas.request.AutomovilAddResponse;
//import ar.com.bussiness.ventas.request.AutomovilRequest;
//import ar.com.bussiness.ventas.request.ModeloRequest;
//import ar.com.bussiness.ventas.service.AutomovilServiceImpl;
//
//@ExtendWith(MockitoExtension.class)
//@RunWith(JUnitPlatform.class)
//
//public class AutomovileServiceTests {
//	
//    
//	 @InjectMocks
//     AutomovilServiceImpl automovilService;
//	
//	 @Mock
//	 AutomovilRepository automovilRepo;
//	 
//	 @Mock
//	 ModeloRepository modeloRepo;
//	 
//	 
////	 @Test
////		public void addModeloTest() {
////	    	   MockHttpServletRequest request = new MockHttpServletRequest();
////	           RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
////	           List<String> variantes = new ArrayList<>();   	                      
////	           ModeloRequest modeloRequest = new ModeloRequest();
////	           modeloRequest.setModeloDescripcion("Mercedes Benz");
////	           variantes.add("Familiar");
////	           variantes.add("Coupe");
////	           variantes.add("Sedan");
////	           modeloRequest.setVariantes(variantes);
////	      //     ResponseEntity<Object> responseEntity =  assertDoesNotThrow(()->automovilesController.addModeloVariantes(modeloRequest ));
////	      //     assertTrue(responseEntity.getStatusCodeValue() == 200);
////	          // assertTrue(responseEntity.getBody().g);    	
////		}
//
//	 
//    @Test
//	public void addAutomovilTest() {
//    	 List<String> variantes = new ArrayList<>();   	                      
//         ModeloRequest modeloRequest = new ModeloRequest();
//         modeloRequest.setModeloDescripcion("Mercedes Benz");
//         variantes.add("Familiar");
//         variantes.add("Coupe");
//         variantes.add("Sedan");
//         modeloRequest.setVariantes(variantes);
//        List<Modelo> response = assertDoesNotThrow(()->this.automovilService.addModeloVariantes(modeloRequest ));
// 
////    	 Modelo modelo = new Modelo("Corsa","Sedan");
////           modelo= modeloRepo.saveAndFlush(modelo);
////           
//           AutomovilRequest addAutomovilRequest = new AutomovilRequest();
//           addAutomovilRequest.setGarantiaAniosDefault(3);
//           addAutomovilRequest.setGarantiaKmsDefault(100000);
//           addAutomovilRequest.setModeloId(response.get(0).getId());
//                    
//           AutomovilAddResponse response2 =  assertDoesNotThrow(()->automovilService.addAutomovil(addAutomovilRequest));
//           assertNotNull(response2);
//          // assertNotNull(response2.getModeloId()==  modelo.getId());
//          // assertTrue(responseEntity.getBody().g);    	
//	}
//
//    @Test
//  	public void getAllAutomovilesTest(){
//    	ModeloRequest modeloRequest = new ModeloRequest();
//        modeloRequest.setModeloDescripcion("Mercedes Benz");
//        List<String> variantes = new ArrayList<>();   	                      
//
//        variantes.add("Familiar");
//        variantes.add("Coupe");
//        variantes.add("Sedan");
//        modeloRequest.setVariantes(variantes);
//    	assertDoesNotThrow(()->automovilService.addModeloVariantes(modeloRequest));
//    	 List<Modelo> response = assertDoesNotThrow(()->automovilService.getAllModelos());
//         assertNotNull(response);
//
//   
//    }
//	
//}