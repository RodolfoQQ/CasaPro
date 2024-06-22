package com.proyecto.CasaPro.repositorios;

import com.proyecto.CasaPro.entidades.DetalleUbicacion;
import com.proyecto.CasaPro.entidades.DtoAddDetalleubicacion;
import com.proyecto.CasaPro.entidades.Producto;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryDetalleUbicacion extends JpaRepository<DetalleUbicacion,Integer> {

@Query(value = "select d.cod_detalleub , d.ubicacion_cod_ubicacion ,p.cod_producto, p.nombre_producto, c.cod_categoria  from detalleubicacion d  inner join producto p on p.cod_producto =d.id_producto inner join categoria c " +
        "on c.cod_categoria =p.categoria_cod_categoria  where d.ubicacion_cod_ubicacion  =31 and c.cod_categoria = :codcategoria ", nativeQuery = true)
    List<Object[]> listaDetalleProdcutosdisponibles (@Param("codcategoria") Integer codcategoria);

@Modifying
@Query(value = "update  detalleubicacion set ubicacion_cod_ubicacion =:codubicacion  where cod_detalleub =:coddetalle", nativeQuery = true)
void updateUbicacionOndetalle (@Param("codubicacion") Integer codubicacion, @Param("coddetalle") Integer coddetalle );


    @Query(value = "select * from detalleubicacion d  where d.id_producto=:codprodcuto", nativeQuery = true)
    DetalleUbicacion buscaDetallePorProducto(@Param("codprodcuto")  Integer codprodcuto);

    @Modifying
    @Transactional
    @Query("DELETE FROM DetalleUbicacion d WHERE d.productos = :producto")
    void deleteByProducto(@Param("producto") Producto producto);

}


