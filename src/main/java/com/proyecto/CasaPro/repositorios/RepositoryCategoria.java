package com.proyecto.CasaPro.repositorios;


import com.proyecto.CasaPro.entidades.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryCategoria extends JpaRepository<Categoria,Integer> {

 /*   @Query("SELECT c.codCategoria, c.nombrCategoria FROM Categoria c")
    List<Object[]> findCodigosYNombresCategorias();
*/
}
