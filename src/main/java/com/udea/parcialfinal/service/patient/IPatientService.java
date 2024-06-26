package com.udea.parcialfinal.service.patient;

import com.udea.parcialfinal.domain.model.Patient;
import org.springframework.http.ResponseEntity;

/**
 * Service interface for managing Patient entities.
 */
public interface IPatientService {

    /**
     * Retrieves a Patient by their identification number.
     *
     * @param identification the identification number of the Patient.
     * @return a ResponseEntity containing the Patient if found, or an appropriate HTTP status if not found.
     */
    ResponseEntity<Patient> getPatientByIdentificationNumber(String identification);

    /**
     * Saves a new Patient.
     *
     * @param patient the Patient object to be saved.
     * @return a ResponseEntity containing the saved Patient.
     */
    ResponseEntity<Patient> savePatient(Patient patient);
}
