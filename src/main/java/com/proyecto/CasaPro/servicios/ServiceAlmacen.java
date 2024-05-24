package com.proyecto.CasaPro.servicios;

import com.proyecto.CasaPro.entidades.Andamio;
import com.proyecto.CasaPro.repositorios.RepositoryAlmacen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceAlmacen {

    @Autowired
    private RepositoryAlmacen andamio;

    public List<Andamio> findAllandamio(){

        return andamio.findAll();
    }
}
