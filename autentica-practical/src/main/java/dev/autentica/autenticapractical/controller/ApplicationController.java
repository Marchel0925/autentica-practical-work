package dev.autentica.autenticapractical.controller;

import dev.autentica.autenticapractical.dto.ApplicationDTO;
import dev.autentica.autenticapractical.dto.ResponseDTO;
import dev.autentica.autenticapractical.dto.StatusRequestDTO;
import dev.autentica.autenticapractical.service.ApplicationService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/application")
@AllArgsConstructor
public class ApplicationController {

    private final ApplicationService applicationService;

    @GetMapping
    public ResponseEntity<ResponseDTO> getAllApplications() {
        return ResponseEntity.ok(applicationService.getAllApplications());
    }

    @PostMapping
    public ResponseEntity<ResponseDTO> createApplication(@Valid @RequestBody ApplicationDTO applicationDTO) {
        System.out.println(applicationDTO);
        return ResponseEntity.ok(applicationService.saveApplication(applicationDTO));
    }

    @PutMapping
    public ResponseEntity<ResponseDTO> updateApplicationStatus(@Valid @RequestBody StatusRequestDTO statusRequest) {
        return ResponseEntity.ok(applicationService.updateApplicationStatus(statusRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO> deleteApplication(@DecimalMin("1") @PathVariable Integer id) {
        return ResponseEntity.ok(applicationService.deleteApplicationById(id));
    }
}
