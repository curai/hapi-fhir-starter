package com.example.fhirserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FhirServerApplication {

	@Autowired
	private ApplicationContext context;

	public static void main(String[] args) {
		SpringApplication.run(FhirServerApplication.class, args);
	}

	@Bean
	public ServletRegistrationBean ServletRegistrationBean() {
		ServletRegistrationBean registration = new ServletRegistrationBean(new FhirRestfulServer(context), "/*");
		registration.setName("FhirServlet");
		return registration;
	}

}
