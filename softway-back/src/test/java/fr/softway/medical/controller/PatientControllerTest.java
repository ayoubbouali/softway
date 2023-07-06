package fr.softway.medical.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.softway.medical.AbstractSoftwayTest;
import fr.softway.medical.valueobject.PatientVO;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class PatientControllerTest extends AbstractSoftwayTest {

    private final ObjectMapper mapper = new ObjectMapper();

    @BeforeAll
    public static void initData(){
        initData("patient.xml");
    }

    @AfterAll
    public static void resetData(){
        resetData("patient.xml");
    }

    @Test
    void getPatientById() throws Exception {
        String idUtilisateur = "FA4AC7F7-6493-4372-AFDA-0867AFEA9553";
        mockMvc.perform(get("/diagnose/{id}",
                        idUtilisateur))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void createPatientTest() throws Exception {
        PatientVO newPatient = PatientVO.builder().nom("nom").email("email").healthIndex(3).build();
        mockMvc.perform(post("/diagnose").contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsBytes(newPatient)))
                .andDo(print())
                .andExpect(status().isOk());
    }

}