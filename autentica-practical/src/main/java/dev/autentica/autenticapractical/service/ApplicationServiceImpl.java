package dev.autentica.autenticapractical.service;

import dev.autentica.autenticapractical.dto.ApplicationDTO;
import dev.autentica.autenticapractical.dto.ResponseDTO;
import dev.autentica.autenticapractical.dto.StatusRequestDTO;
import dev.autentica.autenticapractical.exception.IdNotExistsException;
import dev.autentica.autenticapractical.exception.InvalidStatusException;
import dev.autentica.autenticapractical.mapper.ApplicationMapper;
import dev.autentica.autenticapractical.mapper.TechnologyMapper;
import dev.autentica.autenticapractical.model.Application;
import dev.autentica.autenticapractical.model.Technology;
import dev.autentica.autenticapractical.repository.ApplicationRepository;
import dev.autentica.autenticapractical.repository.TechnologyRepository;
import dev.autentica.autenticapractical.util.Status;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;


@Service
@AllArgsConstructor
@Slf4j
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final TechnologyRepository technologyRepository;

    @Override
    public ResponseDTO getAllApplications() {
        log.info("Fetching all applications");
        List<ApplicationDTO> applications = applicationRepository.findAll()
                .stream().map(ApplicationMapper.INSTANCE::toDTO)
                .toList();
        return ResponseDTO.builder()
                .status(HttpStatus.OK.value())
                .message("All applications fetched successfully")
                .data(applications)
                .build();
    }

    @Override
    public ResponseDTO saveApplication(ApplicationDTO applicationDTO) {
        log.info("Saving application");
        applicationDTO.setId(0);
        applicationDTO.setCreated(Instant.now().toEpochMilli());
        Technology technology = technologyRepository.save(TechnologyMapper.INSTANCE.toModel(applicationDTO.getTechnology()));
        applicationDTO.setTechnology(TechnologyMapper.INSTANCE.toDTO(technology));
        if (applicationDTO.getStatus().equalsIgnoreCase("sent")) {
            applicationDTO.setStatus(Status.PROCESSING.name());
        }
        Application application = applicationRepository.save(ApplicationMapper.INSTANCE.toModel(applicationDTO));
        return ResponseDTO.builder()
                .status(HttpStatus.CREATED.value())
                .message("Application created successfully")
                .data(ApplicationMapper.INSTANCE.toDTO(application))
                .build();
    }

    @Override
    public ResponseDTO updateApplicationStatus(StatusRequestDTO requestDTO) {
        log.info("Updating application status");
        if (!requestDTO.getStatus().equalsIgnoreCase("accept") &&
                !requestDTO.getStatus().equalsIgnoreCase("reject")) {
            log.error("Invalid status received: {}", requestDTO.getStatus());
            throw new InvalidStatusException();
        }
        Application application = applicationRepository.findById(requestDTO.getId()).orElse(null);
        if (application != null) {
            application.setStatus(
                    requestDTO
                            .getStatus()
                            .equalsIgnoreCase("accept") ?
                                Status.ACCEPTED.name() :
                                Status.REJECTED.name()
            );
            application = applicationRepository.save(application);
            log.info("Application status updated to: {}",
                    requestDTO.getStatus()
                            .equalsIgnoreCase("accept") ?
                                Status.ACCEPTED.name() :
                            Status.REJECTED.name()
            );
            return ResponseDTO.builder()
                    .status(HttpStatus.OK.value())
                    .message("Application " +
                            (requestDTO
                                    .getStatus()
                                    .equalsIgnoreCase("accept") ?
                                        "accepted" :
                                        "rejected"
                            )
                    )
                    .data(ApplicationMapper.INSTANCE.toDTO(application))
                    .build();

        } else {
            log.error("Invalid id provided: {}", requestDTO.getId());
            throw new IdNotExistsException(requestDTO.getId());
        }
    }

    @Override
    public ResponseDTO deleteApplicationById(Integer id) {
        try {
            applicationRepository.deleteById(id);
            log.info("Application deleted");
            return ResponseDTO.builder()
                    .status(HttpStatus.OK.value())
                    .message("Application deleted successfully")
                    .build();
        } catch (Exception e) {
            log.error("Invalid id provided: {}", id);
            throw new IdNotExistsException("Could not delete application");
        }
    }


}
