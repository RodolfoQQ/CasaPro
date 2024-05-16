package com.proyecto.CasaPro.entidades;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Clientpersona")
@Data
public class ClientePersona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codpersona;

    private  String nombre;

    private String apellidos;

    private String dni;

    private String direccion;

    private String telefono;

    private  String correo;

    @JsonIgnoreProperties({"clientePersona","hibernateLazyInitializer","handler"})
    @OneToMany(mappedBy ="clientePersona", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PedidoFactura> pedidoFacturas;

    public  ClientePersona(){
        pedidoFacturas=new ArrayList<PedidoFactura>();
    }

    public  void addPedido(PedidoFactura pedidoFactura){
        pedidoFacturas.add(pedidoFactura);
    }



}
