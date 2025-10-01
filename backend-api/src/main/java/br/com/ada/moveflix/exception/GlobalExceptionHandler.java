package br.com.ada.moveflix.exception;

import br.com.ada.moveflix.dto.ApiResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponseDTO> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String field = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put(field, message);
        });

        return ResponseEntity.badRequest()
                .body(new ApiResponseDTO("Erro de validação nos dados enviados.", errors));
    }

    @ExceptionHandler(GeneroInvalidoException.class)
    public ResponseEntity<ApiResponseDTO> handleException(GeneroInvalidoException ex) {
        ApiResponseDTO response = new ApiResponseDTO("Genero Inválido", null);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    // Captura qualquer outra Exception genérica
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponseDTO> handleException(Exception ex) {
        ApiResponseDTO response = new ApiResponseDTO("Erro interno no servidor", null);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}
