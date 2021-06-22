package com.example.fhirserver;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.rest.server.RestfulServer;

import com.example.fhirserver.providers.PatientProvider;

import org.springframework.context.ApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.util.Arrays;

@WebServlet("/*")
public class FhirRestfulServer extends RestfulServer {

	private final ApplicationContext applicationContext;

	FhirRestfulServer(ApplicationContext context) {
		this.applicationContext = context;
	}

	@Override
	protected void initialize() throws ServletException {
		super.initialize();
        // store context in our context holder
		FhirContext ctx = FhirContext.forR4();
		FhirContextHolder.setCtx(ctx);

        // register context with the server
		setFhirContext(ctx);

        // register all providers here
		setResourceProviders(Arrays.asList(applicationContext.getBean(PatientProvider.class)));
	}

}
