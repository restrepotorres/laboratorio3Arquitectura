package com.udea.parcialfinal.service.patient;

import com.udea.parcialfinal.domain.model.Patient;
import com.udea.parcialfinal.persistance.repository.IPatientRepository;
import com.udea.parcialfinal.utils.exception.BusinessException;
import com.udea.parcialfinal.utils.exception.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PatientServiceImpl implements IPatientService {

    private final IPatientRepository patientRepository;

    /**
     * Constructs a new PatientServiceImpl with the specified patient repository.
     *
     * @param patientRepository the patient repository to be used by this service
     */
    @Autowired
    public PatientServiceImpl(IPatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    /**
     * Retrieves a Patient by their identification number.
     *
     * @param identification the identification number of the Patient
     * @return a ResponseEntity containing the Patient if found, or an appropriate HTTP status if not found
     * @throws DataNotFoundException    if the Patient with the specified identification number is not found
     * @throws BusinessException        if a data integrity violation or database access error occurs
     * @throws IllegalArgumentException if the provided argument is invalid
     */
    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<Patient> getPatientByIdentificationNumber(String identification) {
        try {
            Optional<Patient> patientOptional = patientRepository.findByIdentificationNumber(identification);
            if (patientOptional.isPresent()) {
                Patient patient = patientOptional.get();
                return ResponseEntity.ok(patient);
            } else {
                throw new DataNotFoundException("Patient with identification " + identification + " not found.");
            }
        } catch (DataIntegrityViolationException e) {
            // Handle data integrity violations
            throw new BusinessException("Data integrity violation");
        } catch (DataAccessException e) {
            // Handle database access errors
            throw new BusinessException("Database error");
        } catch (IllegalArgumentException e) {
            // Handle illegal argument exceptions
            throw new IllegalArgumentException("Invalid argument: " + e.getMessage(), e);
        }
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }
}
