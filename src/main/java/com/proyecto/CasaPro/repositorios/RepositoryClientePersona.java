package com.proyecto.CasaPro.repositorios;

import com.proyecto.CasaPro.entidades.ClientePersona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryClientePersona extends JpaRepository<ClientePersona,Integer> {


    public List<ClientePersona> findByDniLikeIgnoreCase(String dni);




}


