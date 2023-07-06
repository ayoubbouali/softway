package fr.softway.medical.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
public class PatientDiagnoseHistoryDTO {
    private String idPatientHistory;
    private Date dateOfDiagnose;
    private int healthIndex;
}
