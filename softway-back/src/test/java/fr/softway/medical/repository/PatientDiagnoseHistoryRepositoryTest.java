package fr.softway.medical.repository;

import fr.softway.medical.AbstractSoftwayTest;
import fr.softway.medical.entity.PatientDiagnoseHistoryEntity;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PatientDiagnoseHistoryRepositoryTest extends AbstractSoftwayTest {

    @Autowired
    private PatientDiagnoseHistoryRepository patientDiagnoseHistoryRepository;

    @BeforeAll
    public static void initData(){
        initData("patient.xml");
    }

    @AfterAll
    public static void resetData(){
        resetData("patient.xml");
    }

    @Test
    public void findAllTest() {
        final List<PatientDiagnoseHistoryEntity> elements = patientDiagnoseHistoryRepository.findAll();
        assertNotNull(elements);
        assertEquals(3, elements.size());
    }

    @Test
    void getPatientDiagnoseHistoryByIdTest() {
        Optional<PatientDiagnoseHistoryEntity> patient = patientDiagnoseHistoryRepository.findById("FA4AC7F9-6493-4372-AFDA-0867AFEA9555");
        assertEquals("FA4AC7F9-6493-4372-AFDA-0867AFEA9555", patient.get().getIdPatientHistory());
        assertEquals(15, patient.get().getHealthIndex());
    }

}
