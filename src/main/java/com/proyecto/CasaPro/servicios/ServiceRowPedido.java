package com.proyecto.CasaPro.servicios;

import com.proyecto.CasaPro.entidades.RowPedido;
import com.proyecto.CasaPro.repositorios.RepositoryRowPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceRowPedido {

@Autowired
    private RepositoryRowPedido service;

public List<RowPedido> listaRowPedidos (){

    return service.findAll();
}

}
