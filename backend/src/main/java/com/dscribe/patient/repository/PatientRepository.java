package com.dscribe.patient.repository;
import com.dscribe.patient.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
public interface PatientRepository extends JpaRepository<Patient,Long>, JpaSpecificationExecutor<Patient> {}
