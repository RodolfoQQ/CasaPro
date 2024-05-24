package com.proyecto.CasaPro.repositorios;

import com.proyecto.CasaPro.entidades.SloteUbicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryUbicacion extends JpaRepository<SloteUbicacion,Integer> {
}
