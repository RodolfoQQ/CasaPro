package com.proyecto.CasaPro.Controllers;

import com.proyecto.CasaPro.entidades.Andamio;
import com.proyecto.CasaPro.servicios.ServiceAlmacen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/api/almacen")
public class ControllerAlmacen {

    @Autowired
    private ServiceAlmacen service;

    @GetMapping
    public ResponseEntity<?>ListaAndamios(){

       List<Andamio> response= service.findAllandamio();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/detallessinubicacion")
    public ResponseEntity<?> listaObjetodetallesSinUbicacion(){
        return ResponseEntity.ok(service.listaObjetodetallesSinUbicacion());
    }
}
