package com.proyecto.CasaPro.entidades;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "PedidoFactura")
public class PedidoFactura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   public Integer codPedido;

    @Temporal(TemporalType.DATE)
    public Date fecha;

    public void insertardateactual(){
        fecha=new Date();
    }

    public  PedidoFactura(){
        this.rowPedidos=new ArrayList<RowPedido>();
    }

    @ManyToOne(fetch = FetchType.LAZY)
    public  ClientePersona clientePersona;


    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "id_pedidos")
    public List<RowPedido> rowPedidos;


    public  void  addrowPedidos(RowPedido rowPedido){
        this.rowPedidos.add(rowPedido);

    }



}
