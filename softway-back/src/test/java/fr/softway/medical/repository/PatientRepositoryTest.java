package fr.softway.medical.repository;

import fr.softway.medical.AbstractSoftwayTest;
import fr.softway.medical.entity.PatientEntity;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.Optional;

public class PatientRepositoryTest extends AbstractSoftwayTest {

    @Autowired
    private PatientRepository patientRepository;

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
        final List<PatientEntity> elements = patientRepository.findAll();
        assertNotNull(elements);
        assertEquals(3, elements.size());
    }

    @Test
    void getPatientByIdTest() {
        Optional<PatientEntity> patient = patientRepository.findById("FA4AC7F7-6493-4372-AFDA-0867AFEA9553");
        assertEquals("FA4AC7F7-6493-4372-AFDA-0867AFEA9553", patient.get().getIdPatient());
        assertEquals(33, patient.get().getHealthIndex());
    }

}
