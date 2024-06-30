package com.proyecto.CasaPro.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table
@Data
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codProducto;


    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JsonIgnoreProperties({"productos","hibernateLazyInitializer","handler"})
    private Categoria categoria;

    @NotBlank
    private String nombreProducto;

    @NotBlank
    private String descripcion;




}
