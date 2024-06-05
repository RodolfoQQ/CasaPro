package com.proyecto.CasaPro.servicios;

import com.proyecto.CasaPro.entidades.PisosAndamio;
import com.proyecto.CasaPro.repositorios.RepositoryPiso;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ServicioPiso {

    @Autowired
    private RepositoryPiso repositoryPiso;

    public PisosAndamio guardarIformaciondePiso(PisosAndamio piso){

        return repositoryPiso.save(piso);
    }

}
