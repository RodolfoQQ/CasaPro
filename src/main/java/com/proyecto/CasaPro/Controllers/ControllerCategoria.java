package com.proyecto.CasaPro.Controllers;

import com.proyecto.CasaPro.entidades.Categoria;
import com.proyecto.CasaPro.servicios.ServiceCaTegoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/categoria")
public class ControllerCategoria {

    @Autowired
    private ServiceCaTegoria serviceCaTegoria;

    @GetMapping
    public ResponseEntity<List<Categoria>> ListaCategorias() {
        List<Categoria> categorias = serviceCaTegoria.listaCategoria();
        return new ResponseEntity<>(categorias, HttpStatus.OK);
    }
}
