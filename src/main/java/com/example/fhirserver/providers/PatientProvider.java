package com.example.fhirserver.providers;

import ca.uhn.fhir.rest.annotation.*;
import ca.uhn.fhir.rest.server.IResourceProvider;
import ca.uhn.fhir.rest.server.exceptions.ResourceNotFoundException;
import com.example.fhirserver.repositories.PatientRepository;
import com.example.fhirserver.entities.PatientEntity;
import org.hl7.fhir.r4.model.IdType;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.ResourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PatientProvider implements IResourceProvider {

	@Autowired
	private PatientRepository patientRepository;

    @Override
	public Class<Patient> getResourceType() {
		return Patient.class;
	}

	@Read()
	public Patient read(@IdParam IdType theId) {
		Long resourceId = theId.getIdPartAsLong();
		return this.patientRepository.findById(resourceId).map(PatientEntity::getResource)
				.orElseThrow(() -> new ResourceNotFoundException(
						String.format("Could not find %s with id=%d", ResourceType.Patient.name(), resourceId)));
	}

}
