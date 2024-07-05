package com.proyecto.CasaPro.servicios.seguridad;
/*
import com.proyecto.CasaPro.entidades.seguridad.Rol;
import com.proyecto.CasaPro.entidades.seguridad.Usuario;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class DetalleUsuarioService implements UserDetailsService {

    private  ServiceUsuario serviceUsuario;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario =serviceUsuario.buscarUsuarioPorNombre(username);

        return obtenerusuarioautenticado(usuario,obtenerListaRolesUsuario(usuario.getRoles()));
    }

    private List<GrantedAuthority> obtenerListaRolesUsuario(Set<Rol> listaRoles) {
       List<GrantedAuthority> listaroles= new ArrayList<>();
       for (Rol roles:listaRoles) {
           listaroles.add(new SimpleGrantedAuthority(roles.getNombrerol()));
       }
        return listaroles;
    }


    private UserDetails obtenerusuarioautenticado (Usuario usuario, List<GrantedAuthority> grantedAuthorityList) {

        return new User(usuario.getNomusuario(), usuario.getPassword(), usuario.getActivo(),true,true,true,grantedAuthorityList );
    }
}
*/