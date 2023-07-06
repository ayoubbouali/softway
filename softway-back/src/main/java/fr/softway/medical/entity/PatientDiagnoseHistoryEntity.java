package fr.softway.medical.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "PatientDiagnoseHistory")
public class PatientDiagnoseHistoryEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id_patient_history", nullable = false)
    private String idPatientHistory;

    @Column(name = "healthIndex", nullable = false)
    private int healthIndex;

    @Column(name = "dateOfDiagnose", nullable = false)
    private Date dateOfDiagnose;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_patient", referencedColumnName = "id_patient")
    private PatientEntity patient;
}