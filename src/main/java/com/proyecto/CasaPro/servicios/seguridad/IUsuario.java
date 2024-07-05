package com.proyecto.CasaPro.servicios.seguridad;

import com.proyecto.CasaPro.entidades.seguridad.Usuario;

public interface IUsuario {

    Usuario buscarUsuarioPorNombre(String nomusuario);
}
