package com.proyecto.CasaPro.entidades;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class RowPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codPedido;

     private Integer cantidad;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "id_producto")
    private  Producto producto;




}
