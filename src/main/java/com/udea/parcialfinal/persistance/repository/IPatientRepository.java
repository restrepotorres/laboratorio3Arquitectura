package com.udea.parcialfinal.persistance.repository;

import com.udea.parcialfinal.domain.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Interface for accessing and managing Patient entities in the database.
 * Extends JpaRepository interface to inherit CRUD methods.
 */
public interface IPatientRepository  extends JpaRepository<Patient,Integer> {

    /**
     * Finds a Patient by their identification number.
     *
     * @param identificationNumber the identification number of the Patient.
     * @return an Optional containing the Patient if found, or empty if not found.
     */
    Optional<Patient> findByIdentificationNumber(String identificationNumber);
}
