package fr.softway.medical.mapper;

import fr.softway.medical.dto.PatientDTO;
import fr.softway.medical.entity.PatientEntity;
import fr.softway.medical.valueobject.PatientVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * MapStruct mapper interface for converting between PatientEntity and PatientDTO.
 *
 * - @Mapper(config = MappingConfig.class): Indicates that this interface is a MapStruct mapper. The `config` attribute
 *   specifies that the mapper should use the configuration defined in the MappingConfig interface for global settings.
 */
@Mapper(config = MappingConfig.class)
public interface PatientMapper {
    /**
     * Converts a PatientEntity object to a PatientDTO object.
     *
     * @param entity The PatientEntity object to be converted.
     * @return A PatientDTO object representing the converted data.
     */
    PatientDTO toDto(PatientEntity entity);
    /**
     * Converts a PatientVO object to a PatientEntity object.
     *
     * @param vo The PatientVO object to be converted.
     * @return A PatientEntity object representing the converted data.
     *
     * @Mapping(target = "pathologies", ignore = true): Specifies that the "pathologies" property in the target PatientEntity
     * should be ignored during mapping. This means that the "pathologies" property will not be copied from the PatientVO to
     * the PatientEntity. The data for "pathologies" is to be set separately after the conversion.
     *
     * @Mapping(target = "listOfPatientDiagnoseHistory", ignore = true): Specifies that the "listOfPatientDiagnoseHistory"
     * property in the target PatientEntity should be ignored during mapping. This means that the "listOfPatientDiagnoseHistory"
     * property will not be copied from the PatientVO to the PatientEntity. The data for "listOfPatientDiagnoseHistory" is
     * to be set separately after the conversion.
     */
    @Mapping(target = "pathologies", ignore = true)
    @Mapping(target = "listOfPatientDiagnoseHistory", ignore = true)
    PatientEntity voToEntity(PatientVO vo);
}
