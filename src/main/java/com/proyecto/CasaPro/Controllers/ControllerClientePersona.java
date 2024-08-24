package com.proyecto.CasaPro.Controllers;

import com.proyecto.CasaPro.entidades.ClientePersona;
import com.proyecto.CasaPro.exceptions.ResourceNotFoundException;
import com.proyecto.CasaPro.servicios.ServicePersona;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = {"http://localhost:4200"} ,originPatterns = {"*"})
@RestController
@RequestMapping("/api/persona")
@AllArgsConstructor
public class ControllerClientePersona {

    private ServicePersona servicePersona;

    @PostMapping
    public ResponseEntity<?> guardarPersona(@Valid @RequestBody ClientePersona persona, BindingResult bindingResult) {
        HashMap<String, Object> cliente = new HashMap<>();
        if (bindingResult.hasErrors()) {
            return validacion(bindingResult);
        }
        ClientePersona dniexiste = servicePersona.findbyDNI(persona.getDni());


        if (dniexiste != null) {
            cliente.put("error", "La persona ya se encuentra registrada, intente con otro DNI");
            return new ResponseEntity<>(cliente, HttpStatus.BAD_REQUEST);
        }

            ClientePersona personasaved = servicePersona.savePersona(persona);
            cliente.put("persona", personasaved);
            cliente.put("exito", "La persona ha sido guardada con éxito");
            return new ResponseEntity<>(cliente, HttpStatus.CREATED);

        }


    @PutMapping("/{codpersona}")
    public ResponseEntity<?> updatePersona(@Valid @PathVariable Integer codpersona, @RequestBody ClientePersona persona, BindingResult bindingResult) {

        if (bindingResult.hasErrors()){
            return validacion(bindingResult);
        }
           ClientePersona personaEncontrada= servicePersona.findBycod(codpersona).orElseThrow(()->new ResourceNotFoundException("no se encontro la persona por codigo"));
            personaEncontrada.setNombre(persona.getNombre());
            personaEncontrada.setApellidos(persona.getApellidos());
            personaEncontrada.setDni(persona.getDni());
            personaEncontrada.setDireccion(persona.getDireccion());
            personaEncontrada.setCorreo(persona.getCorreo());
        return ResponseEntity.status(HttpStatus.CREATED).body(servicePersona.savePersona(personaEncontrada));
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
        ClientePersona persona =servicePersona.findbyDNI(dni);
        return ResponseEntity.ok(persona);
    }

    @GetMapping("cod/{id}")
    public ResponseEntity<?> findbyID(@PathVariable Integer id){
        HashMap<String ,Object> response =new HashMap<>();
        ClientePersona persona =servicePersona.findBycod(id).orElseThrow(
                ()->new ResourceNotFoundException("no se encontro persona por cod"));
            if(persona==null){
            response.put("mensaje","persona no encontrada");
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }
        response.put("persona ",persona);
        System.out.println(response);
        return  new ResponseEntity<>(response,HttpStatus.OK);
    }


    private  ResponseEntity<?>validacion(BindingResult bindingResult){
        Map<String,String> maperrors=new HashMap<>();
        bindingResult.getFieldErrors().forEach(error->{
            maperrors.put(error.getField(),"El campo "+error.getField()+" "+error.getDefaultMessage());
        });

        return ResponseEntity.badRequest().body(maperrors);
    }

}
