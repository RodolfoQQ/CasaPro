package com.proyecto.CasaPro.entidades.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class MensajeErrorDto {
    private Integer codError;
    private Date fechaError;
   private String mensaje;
   private String descripcion;
}
