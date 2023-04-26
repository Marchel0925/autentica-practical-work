package dev.autentica.autenticapractical.mapper;

import dev.autentica.autenticapractical.dto.TechnologyDTO;
import dev.autentica.autenticapractical.model.Technology;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TechnologyMapper {
    TechnologyMapper INSTANCE = Mappers.getMapper(TechnologyMapper.class);
    Technology toModel(TechnologyDTO technologyDTO);
    TechnologyDTO toDTO(Technology technology);
}
