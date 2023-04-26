package dev.autentica.autenticapractical.mapper;

import dev.autentica.autenticapractical.dto.ApplicationDTO;
import dev.autentica.autenticapractical.model.Application;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ApplicationMapper {
    ApplicationMapper INSTANCE = Mappers.getMapper(ApplicationMapper.class);
    Application toModel(ApplicationDTO applicationDTO);
    ApplicationDTO toDTO(Application application);
}
