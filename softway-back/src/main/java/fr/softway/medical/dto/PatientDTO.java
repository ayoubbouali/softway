package fr.softway.medical.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Data Transfer Object (DTO) class representing patient information.
 *
 * This class holds patient data including the patient ID, health index, email, name, pathologies, and a list of patient
 * diagnosis history. It is used as a container to transfer patient-related data between different layers of the application.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PatientDTO {
    /**
     * The unique identifier (ID) of the patient.
     */
    private String idPatient;
    /**
     * The health index of the patient.
     */
    private int healthIndex;
    /**
     * The email address of the patient.
     */
    private String email;
    /**
     * The name of the patient.
     */
    private String nom;
    /**
     * A list of pathologies associated with the patient.
     */
    private List<String> pathologies;
    /**
     * A list of PatientDiagnoseHistoryDTO objects representing the patient's diagnosis history.
     */
    private List<PatientDiagnoseHistoryDTO> listOfPatientDiagnoseHistory;
}
