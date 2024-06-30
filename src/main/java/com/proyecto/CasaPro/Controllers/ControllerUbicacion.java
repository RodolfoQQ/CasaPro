package com.proyecto.CasaPro.Controllers;

import com.proyecto.CasaPro.entidades.*;
import com.proyecto.CasaPro.servicios.ServiceProducto;
import com.proyecto.CasaPro.servicios.ServicioUbicacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;
//evaluar a eliminarno se usa
@CrossOrigin(origins ={"http://localhost:4200"})
@RestController
@RequestMapping("/api/ubicacion")
public class ControllerUbicacion {

    @Autowired
    private ServicioUbicacion service;



    @DeleteMapping("{codUbicacion}")
    public ResponseEntity<?> eliminarUbicacionconsuProducto(@PathVariable Integer codUbicacion){
        service.eliminarUbicacion(codUbicacion);
        return ResponseEntity.ok().build();

    }

    /*@PutMapping({"/{codUbicacion}/{codPRoducto}"})
    public  ResponseEntity<?> actualizarProdutoOnUbicacion(@PathVariable Integer codUbicacion,@PathVariable Integer codPRoducto){

            service.actualizarProdcutoOnubicacion(codUbicacion,codPRoducto);



        return  ResponseEntity.status(HttpStatus.OK).build();
    }*/


}
