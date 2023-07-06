package fr.softway.medical.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class PatientDTO {
    private String idPatient;
    private int healthIndex;
    private String email;
    private String nom;
    private List<String> pathologies;
    private List<PatientDiagnoseHistoryDTO> listOfPatientDiagnoseHistory;
}
