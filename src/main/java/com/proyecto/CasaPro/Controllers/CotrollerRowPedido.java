package com.proyecto.CasaPro.Controllers;

import com.proyecto.CasaPro.entidades.RowPedido;
import com.proyecto.CasaPro.servicios.ServiceRowPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"},originPatterns = {"*"})
@RestController
@RequestMapping("/api/row")
public class CotrollerRowPedido {

    @Autowired
    private ServiceRowPedido serviceRowPedido;

    @GetMapping
    public ResponseEntity<?> listaRowsPedido(){

        return ResponseEntity.ok(serviceRowPedido.listaRowPedidos());
    }
}
