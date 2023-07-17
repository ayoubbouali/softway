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

/**
 * Entity class representing patient's diagnosis history in the database.
 *
 * This class is mapped to the "PatientDiagnoseHistory" table in the database and serves as an entity for storing patient's
 * diagnosis history. It includes fields to represent the history ID, health index at the time of diagnosis, date of
 * diagnosis, and a many-to-one relationship with the PatientEntity representing the patient to which this history entry
 * belongs.
 */
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "PatientDiagnoseHistory")
public class PatientDiagnoseHistoryEntity {

    /**
     * The unique identifier (ID) of the patient's diagnosis history entry.
     */
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id_patient_history", nullable = false)
    private String idPatientHistory;

    /**
     * The health index at the time of diagnosis for the patient's history entry.
     */
    @Column(name = "healthIndex", nullable = false)
    private int healthIndex;

    /**
     * The date of diagnosis for the patient's history entry.
     */
    @Column(name = "dateOfDiagnose", nullable = false)
    private Date dateOfDiagnose;

    /**
     * Many-to-one relationship with PatientEntity representing the patient to which this history entry belongs.
     *
     * The fetch = FetchType.LAZY attribute specifies that the PatientEntity should be lazily fetched when needed.
     * The join column name "id_patient" is used to map the relationship with the "id_patient" column in the Patient table.
     * The referencedColumnName "id_patient" indicates that the relationship is based on the "id_patient" column in the PatientEntity.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_patient", referencedColumnName = "id_patient")
    private PatientEntity patient;
}