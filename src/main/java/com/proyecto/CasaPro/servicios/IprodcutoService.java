package com.proyecto.CasaPro.servicios;

import com.proyecto.CasaPro.entidades.Categoria;
import com.proyecto.CasaPro.entidades.Producto;

import java.util.List;
import java.util.Optional;

public interface IprodcutoService {
    public Producto guardarProducto(Producto producto);
    public Optional<Producto> findByCodproducto(Integer codProducto);
    public List<Producto> findallProductos();
    public void productodeletebyid( Integer codProducto);
    public  List<Producto> autocompleteProdcuto(String term);

    public  List<Producto> listaProductoProcategoria(Categoria codCategoria);

}
