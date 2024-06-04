package com.udea.parcialfinal.service.patient;
import com.udea.parcialfinal.domain.model.Patient;
import com.udea.parcialfinal.persistance.repository.IPatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PatientServiceImpl {
    @Autowired
    private IPatientRepository patientRepository;

    public Patient savePatient (Patient patient){
        return patientRepository.save(patient);
    }
}
