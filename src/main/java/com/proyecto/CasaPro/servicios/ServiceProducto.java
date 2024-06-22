package com.proyecto.CasaPro.servicios;

import com.proyecto.CasaPro.entidades.Categoria;
import com.proyecto.CasaPro.entidades.DetalleUbicacion;
import com.proyecto.CasaPro.entidades.Producto;
import com.proyecto.CasaPro.entidades.SloteUbicacion;
import com.proyecto.CasaPro.exceptions.ResourceNotFoundException;
import com.proyecto.CasaPro.repositorios.RepositoryCategoria;
import com.proyecto.CasaPro.repositorios.RepositoryDetalleUbicacion;
import com.proyecto.CasaPro.repositorios.RepositoryProducto;
import com.proyecto.CasaPro.repositorios.RepositoryUbicacion;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ServiceProducto implements IprodcutoService{



    private RepositoryCategoria repositoryCategoria;
    private RepositoryProducto repositoryProducto;
    private RepositoryDetalleUbicacion repositoryDetalleUbicacion;
    private RepositoryUbicacion repositoryUbicacion;


    @Transactional
    public Producto guardarProducto(Producto producto){
        Integer catdeProducto=producto.getCategoria().getCodCategoria();
        Categoria codCategoria=repositoryCategoria.findById(catdeProducto).orElseThrow(()->new ResourceNotFoundException("categoria no encontrada"));

        producto.setCategoria(codCategoria);
/////luego registrar el prodcuto guada el prodcuto en detalleproducto y lo asigna al almacen como sinubicacion=cod 32
        DetalleUbicacion detalleUbicacion = new   DetalleUbicacion();
       producto.setCodProducto(producto.getCodProducto());

        SloteUbicacion ubicacion=repositoryUbicacion.findById(31).orElseThrow(()->new ResourceNotFoundException("no se encontro la ubicacion 31"));

        detalleUbicacion.setStock(0);
        detalleUbicacion.setUbicacion(ubicacion);
        detalleUbicacion.setProductos(producto);
        repositoryDetalleUbicacion.save(detalleUbicacion);
        return repositoryProducto.save(producto);
    }


    @Transactional
    public Producto actualizaProducto(Integer codProducto, Producto producto) {
        Producto productoencontrado = repositoryProducto.findById(codProducto).orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado"));

        productoencontrado.setNombreProducto(producto.getNombreProducto());
        productoencontrado.setDescripcion(producto.getDescripcion());
        Categoria categoria = repositoryCategoria.findById(producto.getCategoria().getCodCategoria()).orElseThrow(() -> new ResourceNotFoundException("Categoría no encontrada"));
        productoencontrado.setCategoria(categoria);

        return repositoryProducto.save(productoencontrado);
    }


    public Optional<Producto> findByCodproducto(Integer codProducto){

        return repositoryProducto.findById(codProducto);
    }


    public List<Producto> findallProductos(){
        return repositoryProducto.findAll();
    }

    public void productodeletebyid( Integer codProducto){
        Producto producto=repositoryProducto.findById(codProducto)
                        .orElseThrow(()->new RuntimeException("no se encontro el producto"));
       // repositoryDetalleUbicacion.deleteByProducto(producto);

        repositoryProducto.deleteById(codProducto);
    }

    public  List<Producto> autocompleteProdcuto(String term){
        return  repositoryProducto.findByNombreProductoContainingIgnoreCase(term);
    }

    public  List<Producto> listaProductoProcategoria(Categoria codCategoria){
        return  repositoryProducto.findByProductoPorCategoria(codCategoria);
    }



}
