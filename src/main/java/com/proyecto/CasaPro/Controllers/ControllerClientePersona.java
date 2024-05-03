package com.proyecto.CasaPro.Controllers;

import com.proyecto.CasaPro.entidades.ClientePersona;
import com.proyecto.CasaPro.servicios.ServicePersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/persona")
public class ControllerClientePersona {

    @Autowired
    private ServicePersona servicePersona;

    @PostMapping
    public ResponseEntity<?> guardarPersona (@RequestBody ClientePersona persona){

        HashMap<String, Object> cliente=new HashMap<>();
        cliente.put("perosna",servicePersona.savePersona(persona));

        return  ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }

    @GetMapping
    public ResponseEntity <?>listall(){

      return  ResponseEntity.ok( servicePersona.findall() );
    }

    @DeleteMapping("/{codpersona}")
    public  ResponseEntity<?> delebyID(@PathVariable Integer codpersona){

        servicePersona.deletebyId(codpersona);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{dni}")
    public ResponseEntity<?> findbyDNI( @PathVariable String dni){
       List <ClientePersona>cliente=servicePersona.findbyDNI(dni);

       if (cliente.isEmpty()){
           return ResponseEntity.noContent().build();
       }

        return ResponseEntity.ok(cliente);
    }

    @PutMapping("/{codpersona}")
    public ResponseEntity<ClientePersona> updatePersona(@PathVariable Integer codpersona, @RequestBody ClientePersona persona){
           persona.setCodpersona(codpersona);
        return ResponseEntity.status(HttpStatus.CREATED).body(servicePersona.savePersona(persona));
    }


}
