package com.example.fhirserver.entities;

import com.vladmihalcea.hibernate.type.json.JsonType;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.hl7.fhir.r4.model.Patient;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@TypeDefs({ @TypeDef(name = "json", typeClass = JsonType.class) })
@Entity
@Table(name = "fhir_patient")
@EntityListeners(AuditingEntityListener.class)
public class PatientEntity implements Serializable {

	// we need _id to be generated safely in conjunction with other clients of
	// the postgres table.
	// To find your table's sequence, run:
	// select c.relname from pg_class c where c.relkind = 'S';
	@Id
	@Column(name = "_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patient_id_generator")
	@SequenceGenerator(name = "patient_id_generator", sequenceName = "fhir_patient__id_seq", allocationSize = 1)
	private long id;

	@Type(type = "json")
	@Column(name = "resource", nullable = false, columnDefinition = "jsonb")
	private Patient resource;

	public long getId() {
		return id;
	}

	public Patient getResource() {
		return resource;
	}
}
