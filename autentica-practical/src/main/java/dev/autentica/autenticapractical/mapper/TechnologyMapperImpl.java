package dev.autentica.autenticapractical.mapper;

import dev.autentica.autenticapractical.dto.TechnologyDTO;
import dev.autentica.autenticapractical.model.Technology;
import org.springframework.stereotype.Service;

@Service
public class TechnologyMapperImpl implements TechnologyMapper {

    @Override
    public Technology toModel(TechnologyDTO technologyDTO) {
        if (technologyDTO == null) return null;
        return Technology.builder()
                .id(technologyDTO.getId())
                .type(technologyDTO.getType())
                .ram(technologyDTO.getRam())
                .cores(technologyDTO.getCores())
                .gpu(technologyDTO.getGpu())
                .motherboard(technologyDTO.getMotherboard())
                .build();
    }

    @Override
    public TechnologyDTO toDTO(Technology technology) {
        if (technology == null) return null;
        return TechnologyDTO.builder()
                .id(technology.getId())
                .type(technology.getType())
                .ram(technology.getRam())
                .cores(technology.getCores())
                .gpu(technology.getGpu())
                .motherboard(technology.getMotherboard())

                .build();
    }
}
