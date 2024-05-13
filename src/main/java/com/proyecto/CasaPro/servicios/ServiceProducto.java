package com.proyecto.CasaPro.servicios;

import com.proyecto.CasaPro.entidades.Producto;
import com.proyecto.CasaPro.repositorios.RepositoryProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceProducto{


@Autowired
private RepositoryProducto repositoryProducto;

    public Producto guardarProducto(Producto producto){
       return repositoryProducto.save(producto);
    }

    public Optional<Producto> findByCodproducto(Integer codProducto){

        return repositoryProducto.findById(codProducto);
    }

    public List<Producto> findallProductos(){
        return repositoryProducto.findAll();
    }

    public void productodeletebyid( Integer codProducto){
        repositoryProducto.deleteById(codProducto);
    }

}
