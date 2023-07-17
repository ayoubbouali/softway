package fr.softway.medical.mapper;

import org.mapstruct.MapperConfig;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.ReportingPolicy;

/**
 * Configuration interface for MapStruct mappers.
 *
 * This interface is used to provide global configuration options for MapStruct mappers. It is annotated with @MapperConfig
 * to specify various settings for the mappers.
 *
 * - @MapperConfig(componentModel = "spring"): Indicates that Spring should be used as the component model for the generated
 *   mapper implementation. This allows the mappers to be managed and injected as Spring beans.
 *
 * - @MapperConfig(unmappedTargetPolicy = ReportingPolicy.ERROR): Specifies the reporting policy for unmapped properties.
 *   When set to ERROR, MapStruct will raise a compilation error if there are any properties in the source or target objects
 *   that cannot be mapped. This helps to catch potential mapping issues during the build process.
 *
 * - @MapperConfig(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL): Specifies the null value mapping
 *   strategy for properties with null values. When set to RETURN_NULL, if a property in the source object is null, the
 *   corresponding property in the target object will also be set to null during mapping.
 */
@MapperConfig(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL
)
public interface MappingConfig {}