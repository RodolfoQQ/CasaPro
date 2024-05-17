package com.proyecto.CasaPro.Controllers;

import com.proyecto.CasaPro.entidades.PedidoFactura;
import com.proyecto.CasaPro.servicios.ServicePedidoFactura;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/pedido")
public class ControllerPedidoFactura {

    @Autowired
    private ServicePedidoFactura service;

    @GetMapping
    public List<PedidoFactura> listarAllPedidosClientes(){

        return service.listaPedidosPersona();
    }


    @PostMapping
    public  ResponseEntity<?>savePedido(@RequestBody PedidoFactura pedidoFactura ){

            PedidoFactura pedido= service.savePedido(pedidoFactura);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedido);
    }

}
