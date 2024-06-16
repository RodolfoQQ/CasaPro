package com.proyecto.CasaPro.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoAddDetalleubicacion {

    private Integer codDetalleUb;
    private Integer ubicacionCodUbicacion;
    private Integer codProducto;
    private String nombreProducto;
    private Integer codCategoria;

}
