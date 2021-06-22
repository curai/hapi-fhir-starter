package com.example.fhirserver.repositories;

import com.example.fhirserver.entities.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<PatientEntity, Long> {}
