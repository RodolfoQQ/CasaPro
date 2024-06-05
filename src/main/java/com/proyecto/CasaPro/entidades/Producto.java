package com.proyecto.CasaPro.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
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

    private String nombreProducto;

    private String descripcion;


    @ManyToOne( fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"producto","hibernateLazyInitializer","handler"})
    @JoinColumn(name = "")
    private SloteUbicacion ubicacion;

    /*  @OneToOne(mappedBy = "producto", fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"producto","hibernateLazyInitializer","handler"})
    private SloteUbicacion ubicacion;
*/
}
