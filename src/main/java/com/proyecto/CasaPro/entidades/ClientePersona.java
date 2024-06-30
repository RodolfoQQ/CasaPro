package com.proyecto.CasaPro.entidades;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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

    @NotBlank
    private  String nombre;

    @NotBlank
    private String apellidos;

    @NotBlank
    @Size(min = 8,max = 8)
    @Column(unique = true, nullable = false)
    private String dni;

    @NotBlank
    private String direccion;

    @NotBlank
    private String telefono;

    @NotBlank
    private  String correo;

    @JsonIgnoreProperties({"clientePersona","hibernateLazyInitializer","handler"})
    @OneToMany(mappedBy ="clientePersona", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PedidoFactura> pedidoFacturas;

  /*  @JsonIgnoreProperties({"clientePersona", "hibernateLazyInitializer", "handler"})
    @OneToMany(mappedBy = "clientePersona", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PedidoFactura> pedidoFacturas;
*/

  /*  public  ClientePersona(){
        pedidoFacturas=new ArrayList<PedidoFactura>();
    }

    @OneToMany(mappedBy = "clientePersona", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonBackReference
    private List<PedidoFactura> pedidoFacturas;
*/

}
