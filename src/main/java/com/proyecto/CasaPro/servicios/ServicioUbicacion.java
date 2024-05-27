package com.proyecto.CasaPro.servicios;

import com.proyecto.CasaPro.entidades.SloteUbicacion;
import com.proyecto.CasaPro.repositorios.RepositoryUbicacion;
import org.springframework.stereotype.Service;

@Service
public class ServicioUbicacion {

    private RepositoryUbicacion repository;


    public SloteUbicacion agregarProductoAubicacion(SloteUbicacion sloteUbicacion){

        return repository.save(sloteUbicacion);
    }

    public void eliminarUbicacion(Integer codUbicacion ){
        repository.deleteById(codUbicacion);
    }
}
