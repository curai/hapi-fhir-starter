package com.example.fhirserver.serializers;

import com.example.fhirserver.FhirContextHolder;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.hl7.fhir.r4.model.Patient;

public class FhirDeserializer extends StdDeserializer<Patient> {

	public FhirDeserializer() {
		this(null);
	}

	public FhirDeserializer(Class<Patient> t) {
		super(t);
	}

	@Override
	public Patient deserialize(JsonParser parser, DeserializationContext deserializer) {
		return (Patient) FhirContextHolder.getCtx().newJsonParser()
				.parseResource(parser.getCurrentLocation().getSourceRef().toString());
	}

}
