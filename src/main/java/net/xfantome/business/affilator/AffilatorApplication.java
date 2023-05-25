package net.xfantome.business.affilator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.CrossOrigin;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(
	    info = @Info(
	        title = "RECYCLING MARKET PLACE API",
	        version = "1.0.0",
	        description = "Manage data and services."
	    )
	)
@CrossOrigin(origins = "*", allowedHeaders = "*")
@EntityScan("net.xfantome.business.affilator.entity")
public class AffilatorApplication {
	public static void main(String[] args) {
		SpringApplication.run(AffilatorApplication.class, args);
		
		
		
	}

}
