package fr.softway.medical.service;

import fr.softway.medical.AbstractSoftwayTest;
import fr.softway.medical.dto.PatientDTO;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PatientServiceTest extends AbstractSoftwayTest {

    @Autowired
    private PatientService patientService;

    @BeforeAll
    public static void initData(){
        initData("patient.xml");
    }

    @AfterAll
    public static void resetData(){
        resetData("patient.xml");
    }

    @Test
    void getPatientWithCardiologieTest() {
        PatientDTO patient = patientService.getPatientById("FA4AC7F7-6493-4372-AFDA-0867AFEA9553");
        assertEquals("FA4AC7F7-6493-4372-AFDA-0867AFEA9553", patient.getIdPatient());
        assertEquals("BOUALI", patient.getNom());
        assertEquals("BOUALI@gmail.com", patient.getEmail());
        assertEquals(33, patient.getHealthIndex());
        assertEquals(1, patient.getPathologies().size());
        assertEquals("Cardiologie", patient.getPathologies().get(0));
        assertEquals(1, patient.getListOfPatientDiagnoseHistory().size());
        assertEquals("FA4AC7F8-6493-4372-AFDA-0867AFEA9555", patient.getListOfPatientDiagnoseHistory().get(0).getIdPatientHistory());
    }

    @Test
    void getPatientWithTraumatologieTest() {
        PatientDTO patient = patientService.getPatientById("FA4AC7F7-6493-4372-AFDA-0867AFEA9554");
        assertEquals("FA4AC7F7-6493-4372-AFDA-0867AFEA9554", patient.getIdPatient());
        assertEquals("LAAZIRI", patient.getNom());
        assertEquals("LAAZIRI@gmail.com", patient.getEmail());
        assertEquals(55, patient.getHealthIndex());
        assertEquals(1, patient.getPathologies().size());
        assertEquals("Traumatologie", patient.getPathologies().get(0));
        assertEquals(1, patient.getListOfPatientDiagnoseHistory().size());
        assertEquals("FA4AC7F9-6493-4372-AFDA-0867AFEA9555", patient.getListOfPatientDiagnoseHistory().get(0).getIdPatientHistory());
    }

    @Test
    void getPatientWithCardiologieAndTraumatologieTest() {
        PatientDTO patient = patientService.getPatientById("FA4AC7F7-6493-4372-AFDA-0867AFEA9555");
        assertEquals("FA4AC7F7-6493-4372-AFDA-0867AFEA9555", patient.getIdPatient());
        assertEquals("REHOUMI", patient.getNom());
        assertEquals("REHOUMI@gmail.com", patient.getEmail());
        assertEquals(15, patient.getHealthIndex());
        assertEquals(2, patient.getPathologies().size());
        assertEquals("Cardiologie", patient.getPathologies().get(0));
        assertEquals("Traumatologie", patient.getPathologies().get(1));
        assertEquals(1, patient.getListOfPatientDiagnoseHistory().size());
        assertEquals("FA4AC7F5-6493-4372-AFDA-0867AFEA9555", patient.getListOfPatientDiagnoseHistory().get(0).getIdPatientHistory());
    }

}