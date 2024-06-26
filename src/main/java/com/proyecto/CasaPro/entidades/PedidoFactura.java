package com.proyecto.CasaPro.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    @PrePersist
    public void insertardateactual(){
        fecha=new Date();
    }

    public  PedidoFactura(){
        this.rowPedidos=new ArrayList<RowPedido>();
    }

   @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"pedidoFacturas","hibernateLazyInitializer","handler"})
    public  ClientePersona clientePersona;



  /*   @JsonIgnoreProperties({"pedidoFacturas", "hibernateLazyInitializer", "handler"})
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public ClientePersona clientePersona;
*/

    @JsonIgnoreProperties({"pedidoFacturas","hibernateLazyInitializer","handler"})
    @OneToMany(cascade = {CascadeType.ALL, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "codPedidofactura")
    public List<RowPedido> rowPedidos;

    @JsonIgnoreProperties({ "hibernateLazyInitializer","handler"})
    @OneToOne(cascade = {CascadeType.ALL, CascadeType.MERGE},fetch = FetchType.LAZY)
    public TipoEntrega tipoEntrega;

    @JsonIgnoreProperties({ "hibernateLazyInitializer","handler"})
    @ManyToOne
    private Estado estado;







}
