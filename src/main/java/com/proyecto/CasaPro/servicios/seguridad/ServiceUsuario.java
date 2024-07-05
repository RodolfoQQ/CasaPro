package com.proyecto.CasaPro.servicios.seguridad;

import com.proyecto.CasaPro.entidades.seguridad.Usuario;
import com.proyecto.CasaPro.repositorios.RepositoryUsuario;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ServiceUsuario implements IUsuario {

    private RepositoryUsuario repositoryUsuario;

    @Override
    public Usuario buscarUsuarioPorNombre(String nomusuario) {
        return repositoryUsuario.findByNomusuario(nomusuario);
    }

}
