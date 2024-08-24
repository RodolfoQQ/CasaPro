package com.proyecto.CasaPro.Controllers;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.proyecto.CasaPro.entidades.Andamio;
import com.proyecto.CasaPro.exceptions.ResourceNotFoundException;
import com.proyecto.CasaPro.servicios.ServiceAlmacen;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
@CrossOrigin(origins={"http://localhost:4200"},originPatterns = {"*"})
@RestController
@AllArgsConstructor
@RequestMapping("/api/almacen")
public class ControllerAlmacen {


    private ServiceAlmacen service;


    @GetMapping
    public ResponseEntity<?>ListaAndamios(){

       List<Andamio> response= service.findAllandamio();

       if (!response.isEmpty()){
           return new ResponseEntity<>(response,HttpStatus.OK);
       }else {
           throw  new ResourceNotFoundException("Error");
       }


    }

    @GetMapping("/detallessinubicacion")
    public ResponseEntity<?> listaObjetodetallesSinUbicacion(){
        return ResponseEntity.ok(service.listaObjetodetallesSinUbicacion());
    }

    @PostMapping
    public ResponseEntity<Andamio> guardarAndamioconsusrelacioens(){
        Andamio guardarAndamio=service.saveAndamionConUbicaciones();
        return new ResponseEntity<>(guardarAndamio, HttpStatus.CREATED);
    }

    @DeleteMapping("/{codandamio}")
    public ResponseEntity<?> eliminaAndamioconrelaciones(@PathVariable Integer codandamio){

         service.eliminaAndamioyrelaciones(codandamio);
         return  ResponseEntity.noContent().build();
    }

    @PutMapping("/{coddetalleub}")
    public ResponseEntity<?>  actualizartosinDetalleubicacion(@PathVariable Integer coddetalleub){
        System.out.println( "cod detalle ub es ------> :"+ coddetalleub);
        service.actualizartosinDetalleubicacion(coddetalleub);
     return ResponseEntity.ok().build();
    }

}
