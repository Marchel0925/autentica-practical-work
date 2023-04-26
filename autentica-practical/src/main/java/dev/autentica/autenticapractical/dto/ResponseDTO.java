package dev.autentica.autenticapractical.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ResponseDTO {
    private int status;
    private String message;
    private Object data;
    private List<String> errors;
}
