package fr.softway.medical.repository;

import fr.softway.medical.entity.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

/**
 * Spring Data JPA repository for managing patient data.
 *
 * This repository provides methods to perform CRUD (Create, Read, Update, Delete) operations on the patient entities.
 * It extends the JpaRepository interface, which includes built-in methods for common data manipulation such as saving,
 * updating, and deleting entities, as well as querying the database based on various criteria.
 *
 * The generic types JpaRepository<PatientEntity, String> specify that this repository deals with entities of type
 * PatientEntity, and the primary key (ID) of the entity is of type String.
 */
public interface PatientRepository extends JpaRepository<PatientEntity, String> {
    /**
     * Retrieves a patient entity based on the provided email.
     *
     * @param email The email address of the patient to be retrieved.
     * @return An Optional containing the patient entity if found, or an empty Optional if no patient is found with the given email.
     */
    Optional<PatientEntity> getPatientByEmail(String email);
}