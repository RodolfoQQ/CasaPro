package com.proyecto.CasaPro.servicios;

import com.proyecto.CasaPro.entidades.PedidoFactura;
import com.proyecto.CasaPro.repositorios.RepositoryPedidoFactura;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicePedidoFactura {

    @Autowired
    private RepositoryPedidoFactura service;

    @Transactional
    public PedidoFactura savePedido(PedidoFactura pedidoFactura){

        return service.save(pedidoFactura);
    }

    public List<PedidoFactura> listaPedidosPersona(){

        return  service.findAll();
    }




}
