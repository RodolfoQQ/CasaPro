package com.proyecto.CasaPro.servicios;

import com.proyecto.CasaPro.entidades.*;
import com.proyecto.CasaPro.repositorios.RepositoryDetalleUbicacion;
import com.proyecto.CasaPro.repositorios.RepositoryPedidoFactura;
import com.proyecto.CasaPro.repositorios.RepositoryProducto;
import com.proyecto.CasaPro.repositorios.RepositoryUbicacion;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicePedidoFactura {

    @Autowired
    private RepositoryPedidoFactura service;

    @Autowired
    private RepositoryUbicacion repositoryUbicacion;

    @Autowired
    private RepositoryDetalleUbicacion repositoryDetalleUbicacion;

    @Transactional
    public PedidoFactura savePedido(PedidoFactura pedidoFactura){
        PedidoFactura dataPedidoFacturaSaved= service.save(pedidoFactura);

        List<RowPedido> rowPedidos=pedidoFactura.getRowPedidos();
        for (RowPedido row :rowPedidos){
            Producto producto =row.getProducto();
            Integer cantidad=row.getCantidad();

            DetalleUbicacion prodcutodelDetalle= repositoryDetalleUbicacion.buscaDetallePorProducto(producto.getCodProducto());
            if (prodcutodelDetalle !=null){
                    prodcutodelDetalle.setStock(prodcutodelDetalle.getStock()-cantidad);
                    repositoryDetalleUbicacion.save(prodcutodelDetalle);
            }
        }

      return dataPedidoFacturaSaved;
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
