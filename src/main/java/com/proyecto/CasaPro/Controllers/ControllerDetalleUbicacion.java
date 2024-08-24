package com.proyecto.CasaPro.Controllers;

import com.proyecto.CasaPro.entidades.*;
import com.proyecto.CasaPro.servicios.ServiceDetalleUbicacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@CrossOrigin(origins={"http://localhost:4200"},originPatterns = {"*"})
@RestController
@RequestMapping("/api/detalleubicacion")
public class ControllerDetalleUbicacion {

    @Autowired
    private ServiceDetalleUbicacion serviceDetalleUbicacion;

   /* @GetMapping
    public ResponseEntity<?> listarDetalleUbicacion(){

        return ResponseEntity.ok().body(serviceDetalleUbicacion.listadetalledelasubicaciones());
    }*/

   /* @GetMapping("{codDetalleub}")
    public ResponseEntity<?> finddetalleubicacionbyid(@PathVariable Integer codDetalleub){

        return ResponseEntity.ok().body(serviceDetalleUbicacion.findbyidUbicacion(codDetalleub));
    }*/

    @PutMapping("/{codDetalle}/{codProduccto}")
    public ResponseEntity<?>saveDetalleUbicacion(@PathVariable Integer codDetalle, @PathVariable Integer codProduccto ){
        HashMap<String,String> hashMap= new HashMap<>();
    try {
        serviceDetalleUbicacion.updateProductoEnDetalle(codDetalle,codProduccto);
        hashMap.put("mensaje","actualizacion exitosa");
    return ResponseEntity.status(HttpStatus.OK).body(hashMap);
    }catch (Exception e){
        hashMap.put("error",e.getMessage());
    }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(hashMap);
    }




}
