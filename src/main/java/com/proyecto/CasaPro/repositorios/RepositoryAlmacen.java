package com.proyecto.CasaPro.repositorios;

import com.proyecto.CasaPro.entidades.Andamio;
import com.proyecto.CasaPro.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryAlmacen  extends JpaRepository<Andamio,Integer> {
}
