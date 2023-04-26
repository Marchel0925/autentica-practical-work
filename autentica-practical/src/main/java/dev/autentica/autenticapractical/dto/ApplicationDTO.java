package dev.autentica.autenticapractical.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonInclude;
import dev.autentica.autenticapractical.constraints.StatusConstraint;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationDTO {
    private Integer id;

    private String description;

    @NotNull(message = "Status is required")
    @StatusConstraint
    private String status;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    private Long created;

    @NotNull(message = "Technology name is required")
    private Long neededTill;

    @NotNull(message = "Technology is required")
    @Valid
    private TechnologyDTO technology;
}
