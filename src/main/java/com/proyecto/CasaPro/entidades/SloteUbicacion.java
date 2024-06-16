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




    //private Integer stock;

    /*@OneToMany( fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "productofk")
    private List<Producto> productos = new ArrayList<>();
*/
    /*
    @OneToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"ubicacion","hibernateLazyInitializer","handler"})
    @JoinColumn(name = "productos_cod_producto")
    private Producto producto;
*//*
    public void restarCantidadaStock(Integer candiad){

        if (this.stock>candiad){
                this.stock-=candiad;
        }else {
            throw  new RuntimeException("Stock insificiente");
        }
    }*/


}
