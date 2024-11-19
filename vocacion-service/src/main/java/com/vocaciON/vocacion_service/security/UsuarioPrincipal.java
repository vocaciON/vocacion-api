package com.vocaciON.vocacion_service.security;

import com.vocaciON.vocacion_service.model.entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UsuarioPrincipal implements UserDetails {

    private Long id;
    private String correo;
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    private Usuario usuario;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return correo ;
    }
}
