package fr.softway.medical.valueobject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Value Object class representing patient information.
 *
 * This class holds patient data including the patient ID, health index, email, and name. It is used as a container to
 * transfer patient-related data between different layers of the application.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PatientVO {
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
}
