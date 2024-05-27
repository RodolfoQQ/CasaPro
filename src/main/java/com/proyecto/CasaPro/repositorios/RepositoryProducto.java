package com.proyecto.CasaPro.repositorios;

import com.proyecto.CasaPro.entidades.Categoria;
import com.proyecto.CasaPro.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryProducto extends JpaRepository<Producto,Integer> {
//ClientePersona findByDniLikeIgnoreCase(String dni);

 //   public Producto findBycodProductoLikeIgnoreCase ( Integer codProducto);

    @Query("select p from Producto p where p.nombreProducto like %?1%")
    public List<Producto> findbynombreProducto(String term);


    @Query("select p from Producto p where p.nombreProducto like %?1%")
    public List<Producto> findByNombreProductoContainingIgnoreCase(String term);

    @Query("select p from Producto p where p.categoria = :codCategoria")
    public List<Producto>  findByProductoPorCategoria(@Param("codCategoria") Categoria codCategoria);
}
