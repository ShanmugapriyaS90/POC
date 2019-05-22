package com.intertech.lab1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.http.config.EnableIntegrationGraphController;
//import org.springframework.integration.support.MessageBuilder;
//import org.springframework.messaging.Message;
//import org.springframework.messaging.MessageChannel;
import org.springframework.web.WebApplicationInitializer;

@SpringBootApplication
@ImportResource("classpath:spring-config.xml")
@EnableIntegrationGraphController
public class Startup extends SpringBootServletInitializer implements WebApplicationInitializer{

	public static void main(String[] args) throws Exception{
		SpringApplication.run(Startup.class,args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Startup.class);
	}
	
}
