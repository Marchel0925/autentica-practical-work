package dev.autentica.autenticapractical.service;

import dev.autentica.autenticapractical.dto.ApplicationDTO;
import dev.autentica.autenticapractical.dto.ResponseDTO;
import dev.autentica.autenticapractical.dto.StatusRequestDTO;

public interface ApplicationService {

    ResponseDTO getAllApplications();

    ResponseDTO saveApplication(ApplicationDTO applicationDTO);

    ResponseDTO updateApplicationStatus(StatusRequestDTO requestDTO);

    ResponseDTO deleteApplicationById(Integer id);
}
