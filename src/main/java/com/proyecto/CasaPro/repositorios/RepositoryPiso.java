package com.proyecto.CasaPro.repositorios;

import com.proyecto.CasaPro.entidades.PisosAndamio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryPiso  extends JpaRepository <PisosAndamio,Integer> {
}
