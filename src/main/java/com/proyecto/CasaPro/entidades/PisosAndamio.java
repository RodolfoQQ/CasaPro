package com.proyecto.CasaPro.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "piso")
@Data
public class PisosAndamio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codPisoAndamio;

    private String descripcionPiso;



    @OneToMany(cascade = {CascadeType.ALL,CascadeType.MERGE})
    @JsonIgnoreProperties({"piso","hibernateLazyInitializer","handler"})
    @JoinColumn(name = "pisofk")
    private List<SloteUbicacion> ubicacion;



}
