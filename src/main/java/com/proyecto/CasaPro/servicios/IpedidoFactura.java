package com.proyecto.CasaPro.servicios;

import com.proyecto.CasaPro.entidades.PedidoFactura;

import java.util.List;

public interface IpedidoFactura {

    public PedidoFactura savePedido(PedidoFactura pedidoFactura);

    public List<PedidoFactura> listaPedidosPersona();

    public void elimiarPedido( Integer codPedido );
}

