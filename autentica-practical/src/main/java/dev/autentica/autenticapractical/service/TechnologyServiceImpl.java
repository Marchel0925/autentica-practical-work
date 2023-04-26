package dev.autentica.autenticapractical.service;

import dev.autentica.autenticapractical.dto.TechnologyDTO;
import dev.autentica.autenticapractical.mapper.TechnologyMapper;
import dev.autentica.autenticapractical.model.Technology;
import dev.autentica.autenticapractical.repository.TechnologyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TechnologyServiceImpl implements TechnologyService {

    private TechnologyRepository technologyRepository;

    @Override
    public List<TechnologyDTO> getAllTechnologies() {
        return technologyRepository.findAll()
                .stream().map(TechnologyMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TechnologyDTO saveOrUpdateApplication(TechnologyDTO technologyDTO) {
        Technology technology = technologyRepository.save(TechnologyMapper.INSTANCE.toModel(technologyDTO));
        return TechnologyMapper.INSTANCE.toDTO(technology);
    }

    @Override
    public void deleteTechnologyById(Integer id) {
        technologyRepository.deleteById(id);
    }
}
