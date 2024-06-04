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
     * The Patient's identification.
     * This field is mandatory.
     */
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "identification_type", nullable = false)
    private String identificationType;

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
     * The phone number of the Patient.
     */
    @Pattern(regexp = "^[^';]*$", message = "Invalid characters in phone number")
    @Column(name = "phone_number")
    private String phoneNumber;

    /**
     * The email address of the Patient.
     * This field is mandatory and must be unique.
     */
    @NotNull
    @Email
    @Column(name = "mail", nullable = false, unique = true)
    private String mail;

    /**
     * The registration date of the Patient.
     * This field is mandatory.
     */
    @NotNull
    @Column(name = "registration_date", nullable = false)
    private Timestamp registrationDate;

    /**
     * The doctor assigned to the Patient.
     * This establishes a many-to-one relationship with the Doctor entity.
     */
    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;
}

