package fr.softway.medical.service;

import fr.softway.medical.dto.PatientDTO;
import fr.softway.medical.valueobject.PatientVO;

/**
 * Interface for the Patient service.
 *
 * This interface defines the contract for a service that provides operations related to patient data. It declares two methods:
 * - processHealthIndex: Used to process the health index of a patient, save the patient data, and store diagnosis history.
 * - getPatientById: Used to retrieve patient information by their unique identifier (ID).
 */
public interface PatientService {
    /**
     * Process the health index of a patient, save the patient data, and store the diagnosis history.
     *
     * @param patient The PatientVO object containing patient information, including the health index to be processed.
     * @return A PatientDTO object containing the processed patient information after saving and diagnosis history storage.
     */
    PatientDTO processHealthIndex(PatientVO patient);
    /**
     * Retrieve patient information by their unique identifier (ID).
     *
     * @param id The unique identifier (ID) of the patient to be retrieved.
     * @return A PatientDTO object containing the patient's information.
     */
    PatientDTO getPatientById(String id);
}