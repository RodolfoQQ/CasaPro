package com.proyecto.CasaPro.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "andamio")
@Data
public class Andamio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codAndamio;

    private String descripcionandamio;

    @JsonIgnoreProperties({"andamio","hibernateLazyInitializer","handler"})
    @OneToMany(cascade = CascadeType.ALL,  fetch = FetchType.LAZY)
    @JoinColumn(name = "andamiofk")
    private List<PisosAndamio> piso;


}
