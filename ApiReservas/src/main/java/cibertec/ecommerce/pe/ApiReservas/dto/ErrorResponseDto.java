package cibertec.ecommerce.pe.ApiReservas.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ErrorResponseDto {
    //indicar la fecha y hora del error
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date timeStamp;
    //ex 404, 401,200,201
    private int code;
    //Not found, not authorization, ok, etc
    private String status;
    //customizado
    private Object message;
    //todo el detalle de error
    private String stackTrace;

    public ErrorResponseDto(HttpStatus httpStatus, Object message, String stackTrace) {
        this.timeStamp = new Date();
        this.code = httpStatus.value();
        this.status = httpStatus.name();
        this.message = message;
        this.stackTrace = stackTrace;
    }
}
