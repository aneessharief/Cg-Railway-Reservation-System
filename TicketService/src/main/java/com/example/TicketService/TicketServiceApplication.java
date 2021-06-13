package com.example.TicketService;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import it.ozimov.springboot.mail.configuration.EnableEmailTools;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableEmailTools
public class TicketServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketServiceApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
	    return builder.build();
	}
	
	@Bean
	public Docket swaggerConfiguration()
	{
		return new Docket(DocumentationType.SWAGGER_2)
					.select()
					.paths(PathSelectors.any())
					.apis(RequestHandlerSelectors.basePackage("com.example.TicketService"))
					.build()
					.apiInfo(apiDetails());
		
	}

	private ApiInfo apiDetails() {
		return new ApiInfo(
				"Admin API Documentation",
				"API for Admin Microservice",
				"1.0",
				"Free to use",
				new springfox.documentation.service.Contact("Anees Sharief", "http://Youtube.com", "aneessharief5@gmail.com"),
				"API Licence",
				"http://youtbe.com",
				Collections.emptyList());
	}


}
