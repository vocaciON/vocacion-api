package com.vocaciON.vocacion_service.security;


import com.vocaciON.vocacion_service.model.entity.Usuario;

import com.vocaciON.vocacion_service.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con el email"+email));

        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_"+usuario.getRole().getName().name());


        return new UsuarioPrincipal(usuario.getId(),usuario.getEmail(),usuario.getPassword(),Collections.singletonList(authority),usuario);

    }
}
