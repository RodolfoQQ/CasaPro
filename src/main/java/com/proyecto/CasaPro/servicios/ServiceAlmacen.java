package com.proyecto.CasaPro.servicios;

import com.proyecto.CasaPro.entidades.Andamio;
import com.proyecto.CasaPro.entidades.dto.DTODetallessinubicacion;
import com.proyecto.CasaPro.entidades.PisosAndamio;
import com.proyecto.CasaPro.entidades.SloteUbicacion;
import com.proyecto.CasaPro.repositorios.RepositoryAlmacen;
import jakarta.transaction.Transactional;
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

    public Andamio saveAndamionConUbicaciones(){
        Andamio andamio= new Andamio();
        andamio.setDescripcionandamio("Andamio sin descripcion");
        List<PisosAndamio> pisos=new ArrayList<>();

        for (int i =0; i<3; i++){
        PisosAndamio piso=new PisosAndamio();
        piso.setDescripcionPiso("nivel "+(i+1));
        List<SloteUbicacion> ubicaciones= new ArrayList<>();

        for (int j =0; j<10; j++){
            SloteUbicacion ubicacion =new SloteUbicacion();
            ubicacion.setDescripcion("ubicacion "+(j+1));
            ubicaciones.add(ubicacion);
        }
        piso.setUbicacion(ubicaciones);
        pisos.add(piso);

        }
        andamio.setPiso(pisos);
        return repositoryAlmacen.save(andamio);
    }

    public void eliminaAndamioyrelaciones(Integer codAndamio) {

        repositoryAlmacen.deleteById(codAndamio);
    }

    @Transactional
    public void actualizartosinDetalleubicacion (Integer coddetalleub){


         repositoryAlmacen.actualizartosinDetalleubicacion(coddetalleub);
    }

}
