package com.proyecto.CasaPro.repositorios;

import com.proyecto.CasaPro.entidades.seguridad.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryUsuario extends JpaRepository<Usuario, Integer> {

    Usuario findByNomusuario(String nomusuario);
}
