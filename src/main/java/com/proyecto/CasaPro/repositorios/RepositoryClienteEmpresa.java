package com.proyecto.CasaPro.repositorios;

import com.proyecto.CasaPro.entidades.ClienteEmpresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryClienteEmpresa extends JpaRepository<ClienteEmpresa,Integer> {


    ClienteEmpresa findByRuc(String ruc);


}
