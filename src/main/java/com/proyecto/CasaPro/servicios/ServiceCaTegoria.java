package com.proyecto.CasaPro.servicios;

import com.proyecto.CasaPro.entidades.Categoria;
import com.proyecto.CasaPro.entidades.Producto;
import com.proyecto.CasaPro.repositorios.RepositoryCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceCaTegoria {

    @Autowired
    private RepositoryCategoria repositoryCategoria;

    public List<Categoria> listaCategoria(){
        return repositoryCategoria.findAll();
    }

    public  Optional<Categoria> filtrarProductosPorCategoria(Integer codCategoria){
        return repositoryCategoria.findById(codCategoria);
    }



}
