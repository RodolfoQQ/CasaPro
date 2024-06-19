package com.proyecto.CasaPro.repositorios;

import com.proyecto.CasaPro.entidades.Andamio;
import com.proyecto.CasaPro.entidades.Producto;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryAlmacen extends JpaRepository<Andamio,Integer> {

    @Query(value = "select d.cod_detalleub, d.ubicacion_cod_ubicacion ,p.cod_producto ,p.nombre_producto ,c.cod_categoria, c.nombr_categoria  \n" +
            "from detalleubicacion d  inner join producto p  on p.cod_producto =d.cod_detalleub \n" +
            "inner join  categoria c on c.cod_categoria =p.categoria_cod_categoria where d.ubicacion_cod_ubicacion =31  order by c.nombr_categoria  \n",nativeQuery = true)
    public List<Object[]> listaObjetodetallesSinUbicacion();


    //la  ubicacion ejmplo 31 dependee del lugar donde se alamcenaran los objetos sin ubicacion, en este caso se determino 31 el cual pertenece al andamio 2
    @Modifying
    @Transactional
    @Query(value = "UPDATE detalleubicacion SET ubicacion_cod_ubicacion = 31 WHERE cod_detalleub = :coddetalleub", nativeQuery = true)
    void actualizartosinDetalleubicacion(@Param("coddetalleub") Integer coddetalleub);
}
