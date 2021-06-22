package com.example.fhirserver;

import ca.uhn.fhir.context.FhirContext;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FhirContextHolder {

	private static FhirContext ctx;

	public static FhirContext getCtx() {
		return ctx;
	}
	
	public static void setCtx(FhirContext ctx) {
		FhirContextHolder.ctx = ctx;
	}

}
