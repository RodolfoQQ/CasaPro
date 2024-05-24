package com.proyecto.CasaPro.entidades;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codEstado;

    private  String descripcionEstado;

    private String categoria;

}
