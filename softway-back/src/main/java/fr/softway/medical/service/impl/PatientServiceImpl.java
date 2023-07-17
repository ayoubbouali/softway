package fr.softway.medical.service.impl;

import fr.softway.medical.dto.PatientDTO;
import fr.softway.medical.entity.PatientDiagnoseHistoryEntity;
import fr.softway.medical.entity.PatientEntity;
import fr.softway.medical.enums.PatientResult;
import fr.softway.medical.mapper.PatientMapper;
import fr.softway.medical.repository.PatientDiagnoseHistoryRepository;
import fr.softway.medical.repository.PatientRepository;
import fr.softway.medical.service.PatientService;
import fr.softway.medical.valueobject.PatientVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Service implementation for managing patient-related operations.
 *
 * This service provides methods to create and retrieve patient information, as well as process health indexes and
 * determine pathologies.
 */
@Service
@Transactional(rollbackOn = Exception.class)
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientDiagnoseHistoryRepository patientDiagnoseHistoryRepository;

    private final PatientMapper mapper;

    /**
     * Processes the health index for a new or existing patient.
     *
     * If a patient with the provided email already exists in the database, the patient's ID is updated in the provided
     * PatientVO object to edit the existing patient. A new line in the patient's diagnosis history is added to record
     * the current health index.
     *
     * The method then saves the patient in the database and creates a corresponding entry in the diagnosis history.
     *
     * @param patient The PatientVO object containing patient information, including the health index to process.
     * @return A PatientDTO object containing the processed patient's information, along with any determined pathologies.
     */
    public PatientDTO processHealthIndex(PatientVO patient) {
        // Set ID if the email of patient already exists to edit patient and add new line in diagnosis history
        setPatientIdIfAlreadyExist(patient);

        // Save the patient
        PatientEntity createdPatient = patientRepository.save(mapper.voToEntity(patient));

        // Save patient history
        PatientDiagnoseHistoryEntity patientDiagnoseHistory = PatientDiagnoseHistoryEntity
                .builder().healthIndex(patient.getHealthIndex())
                .dateOfDiagnose(new Date())
                .patient(createdPatient)
                .build();
        patientDiagnoseHistoryRepository.save(patientDiagnoseHistory);
        return mapper.toDto(createdPatient);
    }

    /**
     * Sets the patient ID in the provided PatientVO object if a patient with the same email already exists in the database.
     *
     * @param patientVO The PatientVO object containing patient information, including the email for identification.
     * @return The method does not return anything; it updates the ID in the provided PatientVO if a matching patient is found.
     */
    private void setPatientIdIfAlreadyExist(PatientVO patientVO) {
        // Get the patient from the repository using the provided email.
        // If a matching patient is found, update the ID in the PatientVO object.
        this.patientRepository.getPatientByEmail(patientVO.getEmail())
                .ifPresent(patient -> patientVO.setIdPatient(patient.getIdPatient()));
    }

    /**
     * Retrieves a patient by their unique identifier (ID).
     *
     * @param id The unique identifier (ID) of the patient to be retrieved.
     * @return A PatientDTO object containing the patient's information.
     * @throws RuntimeException if no patient is found with the given ID.
     */
    public PatientDTO getPatientById(String id) {
        // Attempt to find the patient in the repository by their ID.
        // If the patient is not found, throw a RuntimeException with an error message.
        PatientEntity patientEntity = patientRepository.findById(id).orElseThrow(() -> new RuntimeException("PATIENT NOT FOUND"));

        // Set pathologie(s) if exist(s)
        // (Assuming the method `getPathologies` retrieves the pathologies based on the patient's health index)
        patientEntity.setPathologies(getPathologies(patientEntity.getHealthIndex()));

        // Convert the PatientEntity to a PatientDTO using the mapper.
        return mapper.toDto(patientEntity);
    }

    /**
     * Retrieves a list of pathologies based on the provided health index.
     *
     * @param healthIndex The health index used to determine the pathologies.
     * @return A list of strings representing the pathologies.
     */
    public List<String> getPathologies(int healthIndex) {
        List<String> pathologies = new ArrayList<>();

        // Check if the health index is divisible by 3. If true, add Cardiology to the list.
        if (healthIndex % 3 == 0) {
            pathologies.add(PatientResult.CARDIOLOGY.toString());
        }

        // Check if the health index is divisible by 5. If true, add Traumatology to the list.
        if (healthIndex % 5 == 0) {
            pathologies.add(PatientResult.TRAUMATOLOGY.toString());
        }

        return pathologies;
    }

}