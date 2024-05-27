package com.proyecto.CasaPro.Controllers;

import com.proyecto.CasaPro.entidades.*;
import com.proyecto.CasaPro.servicios.ServiceProducto;
import com.proyecto.CasaPro.servicios.ServicioUbicacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

@CrossOrigin(origins ={"http://localhost:4200"})
@RestController
@RequestMapping("/api/ubicacion")
public class ControllerUbicacion {

    @Autowired
    private ServicioUbicacion service;

    @Autowired
    private ServiceProducto serviceProducto;

    /*@PostMapping
    public ResponseEntity<?> addUbicacion(@RequestBody SloteUbicacion ubicacion, @RequestBody PisosAndamio piso, @RequestBody Andamio andamio){
    ubicacion.setDescripcion("slot 11");
     piso.setCodPisoAndamio(2);
        Producto producto=new Producto();
        producto.setCodProducto(12);

        ubicacion.setProductos(producto);
        ubicacion.
        //SloteUbicacion saveubicacion=service.agregarProductoAubicacion(ubicacion);
        return ResponseEntity.ok().body(saveubicacion);
    }*/

    @GetMapping("{codCategoria}")
    public ResponseEntity<List<Producto>>  listaProductoPorCategoria(@PathVariable Categoria codCategoria ){

        return ResponseEntity.ok().body(serviceProducto.listaProductoProcategoria(codCategoria));
    }


}
