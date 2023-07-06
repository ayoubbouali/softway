package fr.softway.medical.service;

import fr.softway.medical.dto.PatientDTO;
import fr.softway.medical.valueobject.PatientVO;

public interface PatientService {
    public PatientDTO processHealthIndex(PatientVO patient);
    public PatientDTO getPatientById(String id);
}