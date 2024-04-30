package com.proyecto.CasaPro.entidades;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

@Entity
@Table(name = "Clientpersona")
@Data
public class ClientePersona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codpersona;

    private  String nombre;

    private String dni;

    private String direccion;

    private String telefono;

    private  String correo;


}
