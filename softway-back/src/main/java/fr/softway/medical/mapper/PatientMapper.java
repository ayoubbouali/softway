package fr.softway.medical.mapper;

import fr.softway.medical.dto.PatientDTO;
import fr.softway.medical.entity.PatientEntity;
import fr.softway.medical.valueobject.PatientVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MappingConfig.class)
public interface PatientMapper {
    PatientDTO toDto(PatientEntity entity);
    @Mapping(target = "pathologies", ignore = true)
    @Mapping(target = "listOfPatientDiagnoseHistory", ignore = true)
    PatientEntity voToEntity(PatientVO vo);
}
