package com.proyecto.CasaPro.Controllers;

import com.proyecto.CasaPro.entidades.PisosAndamio;
import com.proyecto.CasaPro.servicios.ServicioPiso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/piso")
public class ControllePiso {
//evaluar a elimianr no se usa
    @Autowired
    private ServicioPiso servicioPiso;

    @PostMapping
    public ResponseEntity<?>saveInfoPiso(@RequestBody PisosAndamio piso){

        return ResponseEntity.status(HttpStatus.CREATED).body(servicioPiso.guardarIformaciondePiso(piso));
    }

}
