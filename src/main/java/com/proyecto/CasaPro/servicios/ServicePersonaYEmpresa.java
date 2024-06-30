package com.proyecto.CasaPro.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicePersonaYEmpresa {

    @Autowired
    private ServicePersona persona;
    @Autowired
    private ServiceEmpresa empresa;
/*
    public Object buscarPorDNIoRUC (String rucODni){

            if (rucODni.length()>8){
                return empresa.finsByRuc(rucODni);
            }else {
                return persona.findbyDNI(rucODni);
            }

    }*/
}
