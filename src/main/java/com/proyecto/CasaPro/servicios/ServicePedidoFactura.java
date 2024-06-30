package com.proyecto.CasaPro.servicios;

import com.proyecto.CasaPro.entidades.*;
import com.proyecto.CasaPro.repositorios.RepositoryDetalleUbicacion;
import com.proyecto.CasaPro.repositorios.RepositoryPedidoFactura;
import com.proyecto.CasaPro.repositorios.RepositoryProducto;
import com.proyecto.CasaPro.repositorios.RepositoryUbicacion;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ServicePedidoFactura implements IpedidoFactura {
    private RepositoryPedidoFactura service;
    private RepositoryDetalleUbicacion repositoryDetalleUbicacion;

    @Transactional
    public PedidoFactura savePedido(PedidoFactura pedidoFactura){
        return service.save(pedidoFactura);
    }


    public Optional<Object> cantidadDisponible (Integer idproduct){

        return service.cantidadDisponible(idproduct);
    }

    public List<PedidoFactura> listaPedidosPersona(){

        return  service.findAll();
    }

    public void elimiarPedido( Integer codPedido ){
        service.deleteById(codPedido);
    }

    public PedidoFactura findbycodFactura(Integer codPedido){
        return service.findById(codPedido).orElse(null);
    }





}
