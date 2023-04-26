package dev.autentica.autenticapractical.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StatusRequestDTO {

    @NotBlank(message = "Status must be provided")
    private String status;

    @NotNull(message = "Id cannot be null")
    @DecimalMin(value = "1", message = "Id must be at least 1")
    private Integer id;
}
