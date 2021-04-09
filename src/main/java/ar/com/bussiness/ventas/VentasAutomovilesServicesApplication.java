package ar.com.bussiness.ventas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;


@SpringBootApplication
@EnableAutoConfiguration
@PropertySources({
    @PropertySource(value="classpath:application.properties",ignoreResourceNotFound = true),
    @PropertySource(value = "${sysone.properties}", ignoreResourceNotFound = true)

})

public class VentasAutomovilesServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(VentasAutomovilesServicesApplication.class, args);
	}

}
