package com.proyecto.CasaPro.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name=" detalleubicacion")
@Data
public class DetalleUbicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codDetalleub;

    @ManyToOne(cascade = CascadeType.ALL)
  //@JsonIgnoreProperties({"","handler", "hibernateLazyInitializer"})
    @JoinColumn(name = "id_producto")
    private Producto productos;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"detalleUbicacion","handler", "hibernateLazyInitializer"})
    private SloteUbicacion ubicacion;


    private  Integer stock;



}
