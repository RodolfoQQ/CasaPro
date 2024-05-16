package com.proyecto.CasaPro.repositorios;

import com.proyecto.CasaPro.entidades.PedidoFactura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryPedidoFactura extends JpaRepository<PedidoFactura,Integer> {

}
