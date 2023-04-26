package dev.autentica.autenticapractical.mapper;

import dev.autentica.autenticapractical.dto.ApplicationDTO;
import dev.autentica.autenticapractical.model.Application;
import org.springframework.stereotype.Service;

@Service
public class ApplicationMapperImpl implements ApplicationMapper {
    @Override
    public Application toModel(ApplicationDTO applicationDTO) {
        if (applicationDTO == null) return null;
        return Application.builder()
                .id(applicationDTO.getId())
                .created(applicationDTO.getCreated())
                .neededTill(applicationDTO.getNeededTill())
                .description(applicationDTO.getDescription())
                .email(applicationDTO.getEmail())
                .status(applicationDTO.getStatus())
                .technology(TechnologyMapper.INSTANCE.toModel(applicationDTO.getTechnology()))
                .build();
    }

    @Override
    public ApplicationDTO toDTO(Application application) {
        if (application == null) return null;
        return ApplicationDTO.builder()
                .id(application.getId())
                .created(application.getCreated())
                .neededTill(application.getNeededTill())
                .description(application.getDescription())
                .email(application.getEmail())
                .status(application.getStatus())
                .technology(TechnologyMapper.INSTANCE.toDTO(application.getTechnology()))
                .build();
    }
}
