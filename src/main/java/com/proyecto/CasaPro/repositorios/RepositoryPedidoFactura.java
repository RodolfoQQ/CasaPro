package com.proyecto.CasaPro.repositorios;

import com.proyecto.CasaPro.entidades.PedidoFactura;
import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositoryPedidoFactura extends JpaRepository<PedidoFactura,Integer> {

    @Query(value="select cod_detalleub , stock,ubicacion_cod_ubicacion  from detalleubicacion where id_producto=:idproducto", nativeQuery = true)
   Optional<Object> cantidadDisponible(@Param("idproducto") Integer idproduct);
}
