package dev.autentica.autenticapractical.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import dev.autentica.autenticapractical.constraints.TechnologyTypeConstraint;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TechnologyDTO {

    private Integer id;

    @TechnologyTypeConstraint
    @NotNull(message = "Technology type is required")
    private String type;

    @NotNull(message = "Technology ram is required")
    @DecimalMin(value = "1", message = "Ram should be more than 1")
    @DecimalMax(value = "128", message = "Ram should be less than 128")
    private Integer ram;

    @NotNull(message = "Technology cores is required")
    @DecimalMin(value = "1", message = "Cores should be more than 1")
    @DecimalMax(value = "128", message = "Cores should be less than 128")
    private Integer cores;

    @NotNull(message = "Technology motherboard is required")
    private String motherboard;

    @NotNull(message = "Technology gpu is required")
    private String gpu;
}
