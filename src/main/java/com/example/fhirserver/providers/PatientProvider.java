package com.example.fhirserver.providers;

import ca.uhn.fhir.rest.annotation.*;
import ca.uhn.fhir.rest.server.IResourceProvider;
import org.hl7.fhir.r4.model.IdType;
import org.hl7.fhir.r4.model.Patient;
import org.springframework.stereotype.Component;

@Component
public class PatientProvider implements IResourceProvider {

    @Override
	public Class<Patient> getResourceType() {
		return Patient.class;
	}

	@Read()
	public Patient read(@IdParam IdType theId) {

        // Create a dummy Patient resource to return
        // in reality, we'd use theId to query the database!
        Patient patient = new Patient();
        patient.addName().setFamily("Lord").addGiven("Farquaad");
        return patient;
	}

}
