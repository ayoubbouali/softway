package fr.softway.medical.valueobject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PatientVO {
    private String idPatient;
    private int healthIndex;
    private String email;
    private String nom;
}
