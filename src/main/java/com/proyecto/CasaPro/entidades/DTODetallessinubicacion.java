package com.proyecto.CasaPro.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DTODetallessinubicacion {

    private Integer coddetalleub;

    private Integer codubicacion;

    private  Integer codproducto;

    private  String nombreproducto;

    private Integer codcategoria;

    private  String nombrcategoria;

}
