package fr.softway.medical.repository;

import fr.softway.medical.entity.PatientDiagnoseHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA repository for managing patient diagnosis history data.
 *
 * This repository provides methods to perform CRUD (Create, Read, Update, Delete) operations on the patient diagnosis
 * history entities. It extends the JpaRepository interface, which includes built-in methods for common data manipulation
 * such as saving, updating, and deleting entities, as well as querying the database based on various criteria.
 *
 * The generic types JpaRepository<PatientDiagnoseHistoryEntity, String> specify that this repository deals with entities
 * of type PatientDiagnoseHistoryEntity, and the primary key (ID) of the entity is of type String.
 */
public interface PatientDiagnoseHistoryRepository extends JpaRepository<PatientDiagnoseHistoryEntity, String> {
}