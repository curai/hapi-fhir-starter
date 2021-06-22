package com.example.fhirserver.serializers;

import ca.uhn.fhir.parser.DataFormatException;
import com.example.fhirserver.FhirContextHolder;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.hl7.fhir.r4.model.Patient;

import java.io.IOException;

public class FhirSerializer extends StdSerializer<Patient> {

	public FhirSerializer() {
		this(null);
	}

	public FhirSerializer(Class<Patient> t) {
		super(t);
	}

	@Override
	public void serialize(Patient resource, JsonGenerator jsonGenerator, SerializerProvider serializer) {
		try {
			String result = FhirContextHolder.getCtx().newJsonParser().encodeResourceToString(resource);
			jsonGenerator.writeRaw(result);
		}
		catch (DataFormatException e) {
			e.printStackTrace();
		}
		catch (IOException ex) {
			System.out.println("ERROR");
			System.out.println(ex);
		}
	}

}
