package com.proyecto.CasaPro.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Table
@Data

public class Categoria implements  Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codCategoria;

    private  String nombrCategoria;

    @OneToMany(mappedBy ="categoria",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"categoria","handler", "hibernateLazyInitilizer"})
    private List<Producto> productos;






}
