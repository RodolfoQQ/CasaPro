package com.proyecto.CasaPro.exceptions;

public class ResourceNotFoundException extends  RuntimeException{
    public ResourceNotFoundException(String mensaje){
        super(mensaje);
    }
}
