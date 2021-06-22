package com.example.fhirserver;

import ca.uhn.fhir.rest.server.RestfulServer;

import org.springframework.context.ApplicationContext;

import javax.servlet.annotation.WebServlet;

@WebServlet("/*")
public class FhirRestfulServer extends RestfulServer {

	private final ApplicationContext applicationContext;

	FhirRestfulServer(ApplicationContext context) {
		this.applicationContext = context;
	}
}
