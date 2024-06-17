package com.proyecto.CasaPro.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table
@Data
public class RowPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codrowpedido;

     private Integer cantidad;

    @JsonIgnoreProperties({"producto","hibernateLazyInitializer","handler"})
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_producto")
    private  Producto producto;

/*
    public  void restarCantidadRelinaAstockGeneraldeDetalle(){
        return cantidad
    }*/


}
