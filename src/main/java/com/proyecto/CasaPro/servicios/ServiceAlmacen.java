package com.proyecto.CasaPro.servicios;

import com.proyecto.CasaPro.entidades.Andamio;
import com.proyecto.CasaPro.entidades.DTODetallessinubicacion;
import com.proyecto.CasaPro.repositorios.RepositoryAlmacen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceAlmacen {

    @Autowired
    private RepositoryAlmacen repositoryAlmacen;

    public List<Andamio> findAllandamio(){

        return repositoryAlmacen.findAll();
    }


    public List<DTODetallessinubicacion> listaObjetodetallesSinUbicacion(){
        List<Object[]> listadetallesinubicaciones=repositoryAlmacen.listaObjetodetallesSinUbicacion();

        return listadetallesinubicaciones.stream().map(listadto-> new DTODetallessinubicacion(
                (Integer) listadto[0],
                (Integer) listadto[1],
                (Integer) listadto[2],
                (String) listadto[3],
                (Integer) listadto[4],
                (String) listadto[5]
                )).collect(Collectors.toList());
    }
}
