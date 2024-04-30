package com.proyecto.CasaPro.servicios;

import com.proyecto.CasaPro.entidades.ClientePersona;
import com.proyecto.CasaPro.repositorios.RepositoryClientePersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicePersona {

    @Autowired
    private RepositoryClientePersona repository;

    public ClientePersona savePersona(ClientePersona persona){
        return  repository.save(persona);
    }

    public List<ClientePersona> findall(){

        return  repository.findAll();
    }

    public void deletebyId(Integer codpersona){
         repository.deleteById(codpersona);
    }

    public  List<ClientePersona>  findbyDNI(String dni){
        return  repository.findByDniLikeIgnoreCase(dni);
    }
}
