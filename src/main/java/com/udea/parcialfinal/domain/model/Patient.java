package com.udea.parcialfinal.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

/**
 * Entity class representing a Patient.
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "Patient")
public class Patient {

    /**
     * The primary key identifier for the Patient.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private Long patientId;

    /**
     * The first name of the Patient.
     * This field is mandatory.
     */
    @NotNull
    @Size(min = 1, max = 50)
    @Pattern(regexp = "^[^';]*$", message = "Invalid characters in first name")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    /**
     * The last name of the Patient.
     * This field is mandatory.
     */
    @NotNull
    @Size(min = 1, max = 50)
    @Pattern(regexp = "^[^';]*$", message = "Invalid characters in last name")
    @Column(name = "last_name", nullable = false)
    private String lastName;


    /**
     * The identification number of the Patient.
     * This field is mandatory, must be unique, and has a maximum length of 20 characters.
     */
    @NotNull
    @Size(min = 1, max = 20)
    @Pattern(regexp = "^[^';]*$", message = "Invalid characters in identification number")
    @Column(name = "identification_number", nullable = false, unique = true)
    private String identificationNumber;


    /**
     * The registration date of the Patient.
     * This field is mandatory.
     */
    @NotNull
    @Column(name = "registration_date", nullable = false)
    private Timestamp registrationDate;

    /**
     * The weight of the Patient (in kg).
     */
    @NotNull
    @Column(name = "weight", nullable = false)
    private Double weight;

    /**
     * The height of the Patient (in cm).
     */
    @NotNull
    @Column(name = "height", nullable = false)
    private Double height;

    /**
     * The arterial pressure of the Patient.
     */
    @Column(name = "arterial_pressure")
    private String arterialPressure;

    /**
     * The heart rate of the Patient.
     */
    @Column(name = "heart_rate")
    private Integer heartRate;

    /**
     * The medical history of the Patient.
     */
    @Column(name = "medical_history")
    private String medicalHistory;

    /**
     * The allergies of the Patient.
     */
    @Column(name = "allergies")
    private String allergies;

    /**
     * The current medications of the Patient.
     */
    @Column(name = "current_medications")
    private String currentMedications;

    /**
     * The diagnosis of the Patient.
     */
    @Column(name = "diagnosis")
    private String diagnosis;

    /**
     * The treatment prescribed for the Patient.
     */
    @Column(name = "treatment")
    private String treatment;

    /**
     * Additional observations for the Patient.
     */
    @Column(name = "observations")
    private String observations;

    /**
     * The doctor assigned to the Patient.
     * This establishes a many-to-one relationship with the Doctor entity.
     */
    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;
}

