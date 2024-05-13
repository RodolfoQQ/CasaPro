package com.proyecto.CasaPro.Controllers;

import com.proyecto.CasaPro.servicios.ServicePersonaYEmpresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/personaYempresa")
public class ControllerPersonaYEmpresa {

    @Autowired private ServicePersonaYEmpresa service;

    @GetMapping("/{rucODni}")
    public ResponseEntity<?> buscarcliente(@PathVariable String rucODni){

         Object cliente= service.buscarPorDNIoRUC(rucODni);

        HashMap<String,Object> hashMap =new HashMap<>();
        hashMap.put("cliente",cliente);


         if (cliente==null || cliente.equals("")){
             hashMap.put("mensaje","error");
         }
         
        return ResponseEntity.ok(hashMap);
    }
}
