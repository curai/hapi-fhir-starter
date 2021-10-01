# hapi-fhir-starter
Starter repository for HAPI FHIR. This is a barebones HAPI FHIR server built on a Postgres database, supporting just one resource (Patient) and one operation (Read).

To see a breakdown of how this repo was built step-by-step, please see the commit history. Each commit is one atomic step!

## Sources
This was based on several tutorials I found online!

- Setting up Spring Boot JPA (routing handled by HAPI in step 2): https://spring.io/guides/gs/accessing-data-rest/
- Linking Spring Boot to Postgres: https://zetcode.com/springboot/postgresql/
- Wiring it up with FHIR routes: https://ordina-jworks.github.io/ehealth/2021/02/23/hapi-fhir.html
- Setting up custom serialization (to use the HAPI FHIR serializer):
    - Passing HAPI FHIR context around:
        - It’s expensive to create over and over, so we want to pass it around: https://hapifhir.io/hapi-fhir/apidocs/hapi-fhir-base/ca/uhn/fhir/context/FhirContext.html
        - Static Methods: https://www.tutorialspoint.com/Java-static-method and https://www.baeldung.com/java-static
    - Defining the serializer/deserializer: https://www.baeldung.com/jackson-custom-serialization#on-mapper
    - Connecting the serializer/deserializer: https://www.baeldung.com/spring-boot-customize-jackson-objectmapper#1-application-properties-and-custom-jackson-module
- Supporting JSONB type columns in the database https://vladmihalcea.com/how-to-map-json-objects-using-generic-hibernate-types/
