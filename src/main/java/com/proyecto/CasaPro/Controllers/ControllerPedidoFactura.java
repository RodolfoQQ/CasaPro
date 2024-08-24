package com.proyecto.CasaPro.Controllers;

import com.proyecto.CasaPro.entidades.*;
import com.proyecto.CasaPro.servicios.ServiceDetalleUbicacion;
import com.proyecto.CasaPro.servicios.ServicePedidoFactura;
import com.proyecto.CasaPro.servicios.ServicioUbicacion;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@CrossOrigin(origins = {"http://localhost:4200"} ,originPatterns = {"*"})
@RestController
@RequestMapping("/api/pedido")
@AllArgsConstructor
public class ControllerPedidoFactura {


    private ServicePedidoFactura service;



    private ServiceDetalleUbicacion serviceDetalleUbicacion;

    @GetMapping
    public List<PedidoFactura> listarAllPedidosClientes(){

        return service.listaPedidosPersona();
    }

    @PostMapping
    public ResponseEntity<?> savePedido(@RequestBody PedidoFactura pedidoFactura) {
        HashMap<String, Object> response = new HashMap<>();
        Estado estado = new Estado();
        estado.setCodEstado(2);
        pedidoFactura.setEstado(estado);

        List<RowPedido> rowPedidos = pedidoFactura.getRowPedidos();

        // Verificación preliminar del stock
        for (RowPedido row : rowPedidos) {
            Producto producto = row.getProducto();
            Integer cantidad = row.getCantidad();

            DetalleUbicacion detalleUbicacion = serviceDetalleUbicacion.buscarDetallePorProducto(producto.getCodProducto());
            if (detalleUbicacion == null) {
                response.put("error", "Producto no encontrado en detalle de ubicacion");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
            }
            if (detalleUbicacion.getStock() < cantidad) {
                response.put("mensaje", "Stock insuficiente para el producto: " + producto.getNombreProducto());
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
            }
        }

        // Si toda la verificación es correcta, procedemos con la actualización y guardado
        for (RowPedido row : rowPedidos) {
            Producto producto = row.getProducto();
            Integer cantidad = row.getCantidad();

            DetalleUbicacion detalleUbicacion = serviceDetalleUbicacion.buscarDetallePorProducto(producto.getCodProducto());
            detalleUbicacion.setStock(detalleUbicacion.getStock() - cantidad);
            serviceDetalleUbicacion.saveDetalle(detalleUbicacion); // Guarda el detalle actualizado
        }

        PedidoFactura savePedido = service.savePedido(pedidoFactura);
        response.put("estado", estado);
        response.put("pedido", savePedido);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }




    @DeleteMapping("/{codPedido}")
    public ResponseEntity<?> eliminarPedido(@PathVariable Integer codPedido ){
        service.elimiarPedido(codPedido);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{codPedido}")
    public  ResponseEntity<?> findbycod(@PathVariable Integer codPedido){
        return ResponseEntity.ok().body(service.findbycodFactura(codPedido));
    }

    @PutMapping("/{codPedido}")
    public  ResponseEntity<?>updateEstadoPedido(@PathVariable Integer codPedido){
        PedidoFactura dataFided=service.findbycodFactura(codPedido);
        Estado estado=new Estado();
        estado.setCodEstado(1);

        dataFided.setEstado(estado);

            dataFided=service.savePedido(dataFided);
            HashMap<String,Object> response =new HashMap<>();
            response.put("estado",estado);
            response.put("pedido",dataFided);

        return  ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
