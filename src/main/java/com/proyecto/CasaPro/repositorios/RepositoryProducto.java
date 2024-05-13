package com.proyecto.CasaPro.repositorios;

import com.proyecto.CasaPro.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryProducto extends JpaRepository<Producto,Integer> {
//ClientePersona findByDniLikeIgnoreCase(String dni);

 //   public Producto findBycodProductoLikeIgnoreCase ( Integer codProducto);



}
