package com.proyecto.CasaPro.servicios;

import com.proyecto.CasaPro.entidades.PedidoFactura;
import com.proyecto.CasaPro.entidades.Producto;
import com.proyecto.CasaPro.entidades.RowPedido;
import com.proyecto.CasaPro.entidades.SloteUbicacion;
import com.proyecto.CasaPro.repositorios.RepositoryPedidoFactura;
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

    @Transactional
    public PedidoFactura savePedido(PedidoFactura pedidoFactura){
        PedidoFactura dataPedidoFacturaSaved= service.save(pedidoFactura);


        for (RowPedido rowPedido:pedidoFactura.getRowPedidos()){
            Producto producto=rowPedido.getProducto();
            SloteUbicacion ubicacion=producto.getUbicacion();

            if(ubicacion !=null){
                ubicacion.restarCantidadaStock(rowPedido.getCantidad());
                producto.setUbicacion(ubicacion);
                /*ubicacion.setProducto(producto);*/
                repositoryUbicacion.save(ubicacion);

                repositoryUbicacion.save(ubicacion);
            }else {
                throw  new RuntimeException("Producto "+producto.getNombreProducto()+" sin ubicacion ");
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
