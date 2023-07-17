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

/**
 * Entity class representing patient information in the database.
 *
 * This class is mapped to the "Patient" table in the database and serves as an entity for storing patient information.
 * It includes fields to represent the patient ID, health index, email, name, as well as a transient field for pathologies,
 * and a one-to-many relationship with PatientDiagnoseHistoryEntity for representing patient diagnosis history entries.
 */
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Patient")
public class PatientEntity {
    /**
     * The unique identifier (ID) of the patient.
     */
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id_patient", nullable = false)
    private String idPatient;

    /**
     * The health index of the patient.
     */
    @Column(name = "healthIndex", nullable = false)
    private int healthIndex;

    /**
     * The name of the patient.
     */
    @Column(name = "nom")
    @Size(max= 30)
    private String nom;

    /**
     * The email address of the patient.
     */
    @Column(name = "email", nullable = false)
    @Size(max= 50)
    private String email;

    /**
     * A transient field representing a list of pathologies associated with the patient.
     */
    @Transient
    private List<String> pathologies;

    /**
     * One-to-many relationship with PatientDiagnoseHistoryEntity representing patient diagnosis history entries.
     * mappedBy indicates the name of the field in PatientDiagnoseHistoryEntity that owns the relationship.
     * cascade = CascadeType.ALL indicates that any changes to PatientEntity should cascade to its related
     * PatientDiagnoseHistoryEntity entries (e.g., if a patient is deleted, all related diagnosis history entries are also deleted).
     */
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<PatientDiagnoseHistoryEntity> listOfPatientDiagnoseHistory;
}