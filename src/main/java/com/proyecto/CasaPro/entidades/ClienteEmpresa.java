package com.proyecto.CasaPro.entidades;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "clienteempresa")
@Data
public class ClienteEmpresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codEmpresa;

    private  String nombre;

    private String ruc;

    private String direccion;

    private String telefono;

    private  String correo;

}
