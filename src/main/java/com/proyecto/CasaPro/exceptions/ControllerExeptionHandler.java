package com.proyecto.CasaPro.exceptions;

import com.proyecto.CasaPro.entidades.dto.MensajeErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@RestControllerAdvice
public class ControllerExeptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public MensajeErrorDto resourcesnotFoudException(
            ResourceNotFoundException ex, WebRequest request){

        return  MensajeErrorDto.builder()
                .mensaje(ex.getMessage())
                .codError(HttpStatus.NOT_FOUND.value())
                .fechaError(new Date())
                .descripcion(request.getDescription(true))
                .build();
    }

}
