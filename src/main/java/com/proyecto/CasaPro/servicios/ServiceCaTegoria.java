package com.proyecto.CasaPro.servicios;

import com.proyecto.CasaPro.entidades.Categoria;
import com.proyecto.CasaPro.repositorios.RepositoryCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceCaTegoria {

    @Autowired
    private RepositoryCategoria repositoryCategoria;

    public List<Categoria> listaCategoria(){
        return repositoryCategoria.findAll();
    }



}
