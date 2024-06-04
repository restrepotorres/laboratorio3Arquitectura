package com.udea.parcialfinal.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Entity class representing a Doctor.
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "Doctor")
public class Doctor {

    /**
     * The primary key identifier for the Doctor.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctor_id")
    private Long doctorId;

    /**
     * The first name of the Doctor.
     * This field is mandatory and has a maximum length of 50 characters.
     */
    @NotNull
    @Size(min = 1, max = 50)
    @Pattern(regexp = "^[^';]*$", message = "Invalid characters in first name")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    /**
     * The last name of the Doctor.
     * This field is mandatory and has a maximum length of 50 characters.
     */
    @NotNull
    @Size(min = 1, max = 50)
    @Pattern(regexp = "^[^';]*$", message = "Invalid characters in last name")
    @Column(name = "last_name", nullable = false)
    private String lastName;

    /**
     * The medical specialty of the Doctor.
     * This field is mandatory and has a maximum length of 100 characters.
     */
    @NotNull
    @Size(min = 1, max = 100)
    @Pattern(regexp = "^[^';]*$", message = "Invalid characters in specialty")
    @Column(name = "specialty", nullable = false)
    private String specialty;

    /**
     * The email address of the Doctor.
     * This field is mandatory, must be unique, and should be a valid email format.
     */
    @NotNull
    @Email
    @Column(name = "mail", nullable = false, unique = true)
    private String mail;

    /**
     * The identifier type for the Doctor's identification.
     * This field is mandatory.
     */
    @NotNull
    @Column(name = "identification_type", nullable = false)
    private String identificationTypeId;

    /**
     * The identification number of the Doctor.
     * This field is mandatory, must be unique, and has a maximum length of 20 characters.
     */
    @NotNull
    @Size(min = 1, max = 20)
    @Pattern(regexp = "^[^';]*$", message = "Invalid characters in identification number")
    @Column(name = "identification_number", nullable = false, unique = true)
    private String identificationNumber;

    /**
     * List of patients assigned to this doctor.
     */
    @OneToMany(mappedBy = "doctor")
    private List<Patient> patients;
}

