package dev.autentica.autenticapractical.service;

import dev.autentica.autenticapractical.dto.TechnologyDTO;

import java.util.List;

public interface TechnologyService {

    List<TechnologyDTO> getAllTechnologies();

    TechnologyDTO saveOrUpdateApplication(TechnologyDTO technologyDTO);

    void deleteTechnologyById(Integer id);
}
