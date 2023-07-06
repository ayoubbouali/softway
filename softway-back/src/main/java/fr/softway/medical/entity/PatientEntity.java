package fr.softway.medical.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Patient")
public class PatientEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id_patient", nullable = false)
    private String idPatient;

    @Column(name = "healthIndex", nullable = false)
    private int healthIndex;

    @Column(name = "nom")
    @Size(max= 30)
    private String nom;

    @Column(name = "email", nullable = false)
    @Size(max= 50)
    private String email;

    @Transient
    private List<String> pathologies;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<PatientDiagnoseHistoryEntity> listOfPatientDiagnoseHistory;
}