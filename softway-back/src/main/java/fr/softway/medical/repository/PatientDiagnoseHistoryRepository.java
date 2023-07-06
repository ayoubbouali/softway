package fr.softway.medical.repository;

import fr.softway.medical.entity.PatientDiagnoseHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientDiagnoseHistoryRepository extends JpaRepository<PatientDiagnoseHistoryEntity, String> {
}