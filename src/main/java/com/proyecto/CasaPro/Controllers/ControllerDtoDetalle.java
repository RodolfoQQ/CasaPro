package com.proyecto.CasaPro.Controllers;

import com.proyecto.CasaPro.entidades.dto.DtoAddDetalleubicacion;
import com.proyecto.CasaPro.servicios.ServiceDetalleUbicacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/api/dtodetalle")
public class ControllerDtoDetalle {

    @Autowired
    private ServiceDetalleUbicacion serviceDetalleUbicacion;

    @GetMapping("/{codcategoria}")
    public ResponseEntity<?> listaDetallesDisponibles(@PathVariable Integer codcategoria, DtoAddDetalleubicacion dtodetalle){
        List<DtoAddDetalleubicacion> response= serviceDetalleUbicacion.listaDetalleDisponibles(codcategoria);
        return new ResponseEntity<>( response, HttpStatus.OK);
    }

    @PutMapping("/{codubicacion}/{coddetalle}")
    public ResponseEntity<?> actualizarubicacionendetalle(@PathVariable Integer codubicacion, @PathVariable Integer coddetalle ){
                try{
                    serviceDetalleUbicacion.actualizarubicacionendetalle(codubicacion,coddetalle);
                    return ResponseEntity.ok().build();
                }catch (Exception e){

                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al acutlizar la ubicacion :"+e.getMessage());
                }
           }

}
