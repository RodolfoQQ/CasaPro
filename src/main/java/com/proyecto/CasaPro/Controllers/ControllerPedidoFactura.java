package com.proyecto.CasaPro.Controllers;

import com.proyecto.CasaPro.entidades.Estado;
import com.proyecto.CasaPro.entidades.PedidoFactura;
import com.proyecto.CasaPro.servicios.ServicePedidoFactura;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

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
            Estado estado=new Estado();
                    estado.setCodEstado(2);
                    pedidoFactura.setEstado(estado);

                    PedidoFactura savepedido=service.savePedido(pedidoFactura);

            HashMap<String,Object> respose = new HashMap<>();
            respose.put("estado",estado);
            respose.put("pedio",savepedido);

        return ResponseEntity.status(HttpStatus.CREATED).body(respose);
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
