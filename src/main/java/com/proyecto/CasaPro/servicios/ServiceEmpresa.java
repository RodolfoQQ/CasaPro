package com.proyecto.CasaPro.servicios;

import com.proyecto.CasaPro.entidades.ClienteEmpresa;
import com.proyecto.CasaPro.entidades.ClientePersona;
import com.proyecto.CasaPro.repositorios.RepositoryClienteEmpresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceEmpresa {

    @Autowired
    private RepositoryClienteEmpresa serviceEmpresa;

    public ClienteEmpresa saveEmpresa(ClienteEmpresa empresa){

        return serviceEmpresa.save(empresa);
    }

    public List<ClienteEmpresa> findall(){
        return  serviceEmpresa.findAll();
    }

   public ClienteEmpresa finsByRuc(String ruc){
        return serviceEmpresa.findByRuc(ruc);
    }

    public  void deleteByid(Integer codEmpresa){

        serviceEmpresa.deleteById(codEmpresa);
    }




}
