package fr.softway.medical.controller;

import fr.softway.medical.dto.PatientDTO;
import fr.softway.medical.service.PatientService;
import fr.softway.medical.valueobject.PatientVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/diagnose")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping
    public PatientDTO createPatient(@RequestBody PatientVO patient) {
        return patientService.processHealthIndex(patient);
    }

    @GetMapping("/{id}")
    public PatientDTO getPatientById(@PathVariable String id) {
        return patientService.getPatientById(id);
    }

}
