package com.proyecto.CasaPro.repositorios;

import com.proyecto.CasaPro.entidades.RowPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryRowPedido extends JpaRepository<RowPedido,Integer> {

}
