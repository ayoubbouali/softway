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

@Service
@Transactional(rollbackOn = Exception.class)
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientDiagnoseHistoryRepository patientDiagnoseHistoryRepository;

    private final PatientMapper mapper;

    public PatientDTO processHealthIndex(PatientVO patient) {
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

    public PatientDTO getPatientById(String id) {
        PatientEntity patientEntity = patientRepository.findById(id).orElseThrow(() -> new RuntimeException("PATIENT NOT FOUND"));

        // Set pathologie(s) if exist(s)
        patientEntity.setPathologies(getPathologies(patientEntity.getHealthIndex()));

        return mapper.toDto(patientEntity);
    }

    public List<String> getPathologies(int healthIndex) {
        List<String> pathologies = new ArrayList<>();

        if (healthIndex % 3 == 0) {
            pathologies.add(PatientResult.CARDIOLOGY.toString());
        }

        if (healthIndex % 5 == 0) {
            pathologies.add(PatientResult.TRAUMATOLOGY.toString());
        }

        return pathologies;
    }

}