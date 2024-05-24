package com.proyecto.CasaPro.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "ubicacion")
@Data
public class SloteUbicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codUbicacion;

    private String descripcion;

    @OneToOne
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Producto productos;



}
