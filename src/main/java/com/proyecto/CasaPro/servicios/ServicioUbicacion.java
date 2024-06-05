package com.proyecto.CasaPro.servicios;

import com.proyecto.CasaPro.entidades.Producto;
import com.proyecto.CasaPro.entidades.SloteUbicacion;
import com.proyecto.CasaPro.repositorios.RepositoryProducto;
import com.proyecto.CasaPro.repositorios.RepositoryUbicacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioUbicacion {

    @Autowired
    private RepositoryUbicacion repository;
    @Autowired
    private RepositoryProducto repositoryProducto;

/*
    public SloteUbicacion agregarProductoAubicacion(SloteUbicacion sloteUbicacion){

        return repository.save(sloteUbicacion);
    }*/

    public void eliminarUbicacion(Integer codUbicacion ){
        repository.deleteById(codUbicacion);
    }

    public SloteUbicacion actualizarProdcutoOnubicacion (Integer codUbicacion,Integer codPRoducto){
        Producto producto =repositoryProducto.findById(codPRoducto).orElseThrow(()-> new RuntimeException("Error en ecnotrar el producto"));
        SloteUbicacion ubicacion =repository.findById(codUbicacion).orElseThrow(()-> new RuntimeException("Error en encontrar ubicacion"));

        //ubicacion(producto);
        return repository.save(ubicacion);
    }

    public  SloteUbicacion findUbicacion(Integer codUbicacion){

        return repository.findById(codUbicacion).orElseThrow(()-> new RuntimeException("No se encontro la ubicacion"));
    }

}
