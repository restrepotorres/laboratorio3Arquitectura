package com.udea.parcialfinal.controller;

import com.udea.parcialfinal.domain.model.Patient;
import com.udea.parcialfinal.service.patient.IPatientService;
import com.udea.parcialfinal.utils.common.StandardResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

/**
 * REST controller for managing Patient entities.
 * Provides endpoints for retrieving patient information.
 */
@RestController
@RequestMapping("/patient")
@CrossOrigin("*")
@Tag(name = "Clinical history api", description = "Operations for patients")
public class PatientController {

    private final IPatientService patientService;

    /**
     * Constructs a new PatientController with the specified patient service.
     *
     * @param patientService the patient service to be used by this controller
     */
    @Autowired
    public PatientController(IPatientService patientService) {
        this.patientService = patientService;
    }

    /**
     * Retrieves a patient by their identification number.
     *
     * @param patientIdentificationNumber the identification number of the patient to retrieve
     * @return ResponseEntity containing the retrieved patient if found,
     *         else returns an appropriate error response
     * @throws IllegalArgumentException if an invalid argument is provided
     * @throws ResponseStatusException  if there is an unexpected error
     */
    @Operation(summary = "get a patient by identification number")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retrieve patient", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Patient.class)) }),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = StandardResponse.class)) }),
            @ApiResponse(responseCode = "404", description = "Boarding pass not found", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = StandardResponse.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = RuntimeException.class)) })
    })
    @GetMapping("/get-patient-by-identification/{patientIdentificationNumber}")
    public ResponseEntity<Patient> getBoardingPass (
            @Parameter(description = "The identification number of the patient to retrieve", example = "123")
            @PathVariable String patientIdentificationNumber
    ) { return this.patientService.getPatientByIdentificationNumber(patientIdentificationNumber); }


    @PostMapping(value = "/save", produces = "application/vnd.patient.v1+json")
        public Patient savePatient(@RequestBody Patient patient) {
        return patientService.savePatient(patient);
    }
}
