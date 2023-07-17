package fr.softway.medical.controller;

import fr.softway.medical.Exception.PatientException;
import fr.softway.medical.dto.PatientDTO;
import fr.softway.medical.service.PatientService;
import fr.softway.medical.valueobject.PatientVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class to manage patient-related operations.
 *
 * This class handles HTTP requests related to patient management. It provides endpoints for creating a new patient
 * and retrieving patient information based on their unique identifier (ID).
 */
@RestController
@RequestMapping(path = "/diagnose")
public class PatientController {

    /**
     * Service to handle patient-related operations.
     */
    @Autowired
    private PatientService patientService;

    /**
     * Creates a new patient and processes the health index.
     *
     * This endpoint receives a JSON representation of a PatientVO object and creates a new patient with the provided
     * information. The health index is then processed to determine the patient's pathologies. The resulting patient
     * information, along with the determined pathologies, is returned as a PatientDTO.
     *
     * @param patient The PatientVO object containing the data of the patient to be created.
     * @return ResponseEntity containing the newly created patient's information and HTTP status code.
     *         If the patient is successfully created, the response will have HTTP status code 201 (Created)
     *         and the patient's data in the body.
     * @throws PatientException If an error occurs during the patient creation process.
     *                         The exception will have a descriptive error message.
     */
    @PostMapping
    public ResponseEntity<PatientDTO> createPatient(@RequestBody PatientVO patient) {
        try {
            PatientDTO createdPatient = patientService.processHealthIndex(patient);
            return new ResponseEntity<>(createdPatient, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new PatientException("Error creating patient: " + e.getMessage());
        }
    }

    /**
     * Retrieves a patient's information by their unique identifier (ID).
     *
     * @param id The ID of the patient to be retrieved.
     * @return ResponseEntity containing the patient's information and HTTP status code.
     *         If successful, the response will have HTTP status code 200 (OK) and the patient's data.
     *         If an error occurs, the response will have HTTP status code 500 (Internal Server Error)
     *         and an error message indicating the issue.
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getPatientById(@PathVariable String id) {
        try {
            return new ResponseEntity<>(patientService.getPatientById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
