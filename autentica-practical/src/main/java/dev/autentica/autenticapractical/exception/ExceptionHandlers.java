package dev.autentica.autenticapractical.exception;

import dev.autentica.autenticapractical.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(IdNotExistsException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ResponseDTO> handleIdNotExistsException(IdNotExistsException idNotExistsException) {
        return new ResponseEntity<>(
                ResponseDTO.builder()
                        .message(idNotExistsException.getMessage())
                        .status(HttpStatus.NOT_FOUND.value())
                        .build(),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(InvalidStatusException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ResponseDTO> handleInvalidStatusException(InvalidStatusException invalidStatusException) {
        return new ResponseEntity<>(
                ResponseDTO.builder()
                        .message(invalidStatusException.getMessage())
                        .status(HttpStatus.BAD_REQUEST.value())
                        .build(),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ResponseDTO> handleValidationErrors(MethodArgumentNotValidException exception) {
        List<String> errors = exception.getBindingResult().getFieldErrors()
                .stream().map(FieldError::getDefaultMessage).collect(Collectors.toList());
        ResponseDTO responseDTO = ResponseDTO.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message( "An validation error has occurred")
                .errors(errors)
                .build();
        return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
    }
}
