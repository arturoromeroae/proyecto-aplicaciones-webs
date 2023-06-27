package cibertec.ecommerce.pe.ApiHoteles.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import cibertec.ecommerce.pe.ApiHoteles.dto.ErrorResponseDto;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponseDto>
            handleEntityNotFound(NotFoundException ex) {
        //404
        var status = HttpStatus.NOT_FOUND;
        var error = new ErrorResponseDto(status, ex.getMessage(),
                 ex.toString());

        return new ResponseEntity<>(error, status);

    }
}
