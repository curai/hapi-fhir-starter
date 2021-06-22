package com.example.fhirserver.serializers;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.vladmihalcea.hibernate.type.util.ObjectMapperSupplier;
import org.hl7.fhir.r4.model.Patient;

import java.util.TimeZone;

/**
 * We want to override the Jackson serializer because we want to serialize JSON columns
 * into HAPI FHIR resources (as opposed to generic POJO's).
 *
 * Since we can only use one serializer (either Jackson or HAPI), we have to override the
 * default Jackson one with the HAPI FHIR one.
 */
public class CustomObjectMapperSupplier implements ObjectMapperSupplier {

	@Override
	public ObjectMapper get() {
		ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules();
		objectMapper.setTimeZone(TimeZone.getTimeZone("GMT"));
		SimpleModule simpleModule = new SimpleModule("SimpleModule", new Version(1, 0, 0, null, null, null));

		simpleModule.addSerializer(Patient.class, new FhirSerializer());
		simpleModule.addDeserializer(Patient.class, new FhirDeserializer());
		objectMapper.registerModule(simpleModule);

		return objectMapper;
	}

}
