package com.proyecto.CasaPro.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ubicacion")
@Data
public class SloteUbicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codUbicacion;

    private String descripcion;

    @OneToMany(mappedBy = "ubicacion", cascade = CascadeType.ALL)
     @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private List<DetalleUbicacion> detalleUbicacion;



}
