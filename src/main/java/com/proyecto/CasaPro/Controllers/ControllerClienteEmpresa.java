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



    @PutMapping("/{codEmpresa}")
    public ResponseEntity<ClienteEmpresa> updateClienteempresa(@PathVariable Integer codEmpresa, @RequestBody ClienteEmpresa empresa){



        empresa.setCodEmpresa(codEmpresa);

        return  ResponseEntity.status(HttpStatus.CREATED).body(serviceEmpresa.saveEmpresa(empresa));
    }

    @GetMapping
    public  ResponseEntity<?> findall(){

        return  ResponseEntity.ok( serviceEmpresa.findall());
    }

    @GetMapping("/{ruc}")
    public ResponseEntity<?> buscarClientePorRucODNI(@PathVariable String ruc){

       //Optional<ClienteEmpresa>  clienteEmpresa= Optional.ofNullable(serviceEmpresa.finsByRuc(ruc));
        ClienteEmpresa empresa=serviceEmpresa.finsByRuc(ruc);

        return ResponseEntity.ok(empresa);
    }

    @DeleteMapping("/{codEmpresa}")
    public ResponseEntity<?> deletedByid(@PathVariable Integer codEmpresa){

        serviceEmpresa.deleteByid(codEmpresa);
        return ResponseEntity.ok().build();
    }


}
