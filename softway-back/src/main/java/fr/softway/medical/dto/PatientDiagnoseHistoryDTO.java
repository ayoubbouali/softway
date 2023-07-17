package fr.softway.medical.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

/**
 * Data Transfer Object (DTO) class representing patient's diagnosis history.
 *
 * This class holds patient's diagnosis history data including the history ID, date of diagnosis, and health index at the
 * time of diagnosis. It is used as a container to transfer patient's diagnosis history data between different layers of the application.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PatientDiagnoseHistoryDTO {
    /**
     * The unique identifier (ID) of the patient's diagnosis history entry.
     */
    private String idPatientHistory;
    /**
     * The date of diagnosis for the patient's history entry.
     */
    private Date dateOfDiagnose;
    /**
     * The health index at the time of diagnosis for the patient's history entry.
     */
    private int healthIndex;
}
