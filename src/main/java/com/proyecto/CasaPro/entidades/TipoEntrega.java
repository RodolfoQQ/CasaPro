package com.proyecto.CasaPro.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Table
@Entity
@Data
public class TipoEntrega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codTipoentrga;

    private String descripcionEntrega;

    private String direccion;

    private String distrito;

    private  String telefonoreferencia;

    private  String personarecepcion;

    private  String parentesco;

   /* @JsonIgnoreProperties({ "hibernateLazyInitializer","handler"})
    @OneToOne( fetch = FetchType.LAZY)
    private  PedidoFactura pedidoFactura;*/

}
