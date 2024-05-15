package com.proyecto.CasaPro.entidades;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data

public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codProducto;

    @ManyToOne
    private Categoria categoria;

    private String nombreProducto;

    private String descripcion;

}
