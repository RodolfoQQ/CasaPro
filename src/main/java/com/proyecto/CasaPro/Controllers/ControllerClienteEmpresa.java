package com.proyecto.CasaPro.Controllers;

import com.proyecto.CasaPro.entidades.ClienteEmpresa;
import com.proyecto.CasaPro.entidades.ClientePersona;
import com.proyecto.CasaPro.servicios.ServiceEmpresa;
import com.proyecto.CasaPro.servicios.ServicePersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/clienteEmpresa")
public class ControllerClienteEmpresa {

    @Autowired
    private ServiceEmpresa serviceEmpresa;





    @PostMapping
    public ResponseEntity<?> guardarClienteempresa(@RequestBody ClienteEmpresa empresa){

       HashMap<String, Object> cliente= new HashMap<>();
        cliente.put("empresa",serviceEmpresa.saveEmpresa(empresa));


          return  ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }

    @GetMapping
    public List<ClienteEmpresa> findall(){
        return  serviceEmpresa.findall();
    }

    @GetMapping("/{ruc}")
    public ResponseEntity<?> findbyRuc(@PathVariable String ruc){

     Optional<ClienteEmpresa>  clienteEmpresa= Optional.ofNullable(serviceEmpresa.finsByRuc(ruc));
        if (clienteEmpresa.isPresent()){
            return  ResponseEntity.ok(clienteEmpresa.orElseThrow());

        }

        return ResponseEntity.notFound().build();
    }


}
