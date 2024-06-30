package com.proyecto.CasaPro.servicios;

import com.proyecto.CasaPro.entidades.DetalleUbicacion;
import com.proyecto.CasaPro.entidades.dto.DtoAddDetalleubicacion;
import com.proyecto.CasaPro.entidades.Producto;
import com.proyecto.CasaPro.repositorios.RepositoryDetalleUbicacion;
import com.proyecto.CasaPro.repositorios.RepositoryProducto;
import com.proyecto.CasaPro.repositorios.RepositoryUbicacion;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceDetalleUbicacion {

    @Autowired
    private RepositoryDetalleUbicacion repositoryDetalleUbicacion;

    @Autowired
    private RepositoryUbicacion repositoryUbicacion;

    @Autowired
    private RepositoryProducto repositoryProducto;

    @Transactional
    public DetalleUbicacion saveDetalle (DetalleUbicacion detalleUbicacion){
        return  repositoryDetalleUbicacion.save(detalleUbicacion);
    }


    public DetalleUbicacion updateProductoEnDetalle(Integer codDetalle, Integer codproducto  ){

        DetalleUbicacion detalleUbicacion=repositoryDetalleUbicacion.findById(codDetalle).orElseThrow(()->new RuntimeException("no se encontro row Detalle"));
        Producto producto = repositoryProducto.findById(codproducto).orElseThrow(()->new RuntimeException("no se encontro el producto"));
        detalleUbicacion.setProductos(producto);


        return  repositoryDetalleUbicacion.save(detalleUbicacion);
    }

    public List<DtoAddDetalleubicacion> listaDetalleDisponibles(Integer codcategoria){
        List<Object[]> resultados=repositoryDetalleUbicacion.listaDetalleProdcutosdisponibles(codcategoria);
        return resultados.stream()
                .map(detalleubicacion-> new DtoAddDetalleubicacion(
                        (Integer) detalleubicacion[0],
                        (Integer) detalleubicacion[1],
                        (Integer) detalleubicacion[2],
                        detalleubicacion[3].toString(),
                        (Integer) detalleubicacion[4]
                )).collect(Collectors.toList());
    }
    @Transactional
    public void actualizarubicacionendetalle(Integer codubicacion, Integer coddetalle  ){

        repositoryDetalleUbicacion.updateUbicacionOndetalle(codubicacion, coddetalle);
    }

    public DetalleUbicacion buscarDetallePorProducto (Integer codProd){
        return  repositoryDetalleUbicacion.buscaDetallePorProducto(codProd);
    }



}
