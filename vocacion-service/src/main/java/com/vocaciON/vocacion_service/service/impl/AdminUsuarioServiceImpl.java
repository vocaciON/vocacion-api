package com.vocaciON.vocacion_service.service.impl;

import com.vocaciON.vocacion_service.dto.AuthResponseDTO;
import com.vocaciON.vocacion_service.dto.LoginDTO;
import com.vocaciON.vocacion_service.dto.UsuarioProfileDTO;
import com.vocaciON.vocacion_service.dto.UsuarioRegistrationDTO;
import com.vocaciON.vocacion_service.exception.ResourceNotFoundException;
import com.vocaciON.vocacion_service.mapper.UsuarioMapper;
import com.vocaciON.vocacion_service.model.entity.Experto;
import com.vocaciON.vocacion_service.model.entity.Perfil;
import com.vocaciON.vocacion_service.model.entity.Role;
import com.vocaciON.vocacion_service.model.entity.Usuario;
import com.vocaciON.vocacion_service.model.enums.ERole;
import com.vocaciON.vocacion_service.repository.ExpertoRepository;
import com.vocaciON.vocacion_service.repository.PerfilRepository;
import com.vocaciON.vocacion_service.repository.RoleRepository;
import com.vocaciON.vocacion_service.repository.UsuarioRepository;
import com.vocaciON.vocacion_service.security.TokenProvider;
import com.vocaciON.vocacion_service.security.UsuarioPrincipal;
import com.vocaciON.vocacion_service.service.AdminUsuarioService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Data

public class AdminUsuarioServiceImpl implements AdminUsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PerfilRepository perfilRepository;
    private final ExpertoRepository expertoRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    private final UsuarioMapper usuarioMapper;

    private final AuthenticationManager authenticationManager;

    private final TokenProvider tokenProvider;

    @Transactional
    @Override
    public UsuarioProfileDTO registerPerfil(UsuarioRegistrationDTO usuarioRegistrationDTO) {
        return registerUsuarioWithRole(usuarioRegistrationDTO, ERole.USER);
    }
    @Transactional
    @Override
    public UsuarioProfileDTO registerExperto(UsuarioRegistrationDTO usuarioRegistrationDTO) {
        return registerUsuarioWithRole(usuarioRegistrationDTO, ERole.EXPERTO);
    }

    @Override
    public AuthResponseDTO login(LoginDTO loginDTO) {
        //Autenticar al usuario usando AuthenticationManagger

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword()));

        //Una vez autenticado, el objeto Authentication contiene la informacion del usuario autenticado

        UsuarioPrincipal usuarioPrincipal = (UsuarioPrincipal) authentication.getPrincipal();
        Usuario usuario = usuarioPrincipal.getUsuario();


        String token= tokenProvider.createAccessToken(authentication);

        AuthResponseDTO responseDTO = usuarioMapper.toAuthResponseDTO(usuario, token);



        return responseDTO;
    }

    @Override
    public UsuarioProfileDTO updateUsuarioProfile(Long id, UsuarioProfileDTO usuarioProfileDTO) {
        // Obtener el usuario existente de la base de datos
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario con id " + id + " no encontrado"));

        //Verifica si existe algun usuario con el mismo nombre apellido y numero celular
        boolean existsAsUsuario = usuarioRepository.existsByNombreAndApellidoAndTelefonoAndIdNot(usuarioProfileDTO.getNombre(), usuarioProfileDTO.getApellido(), usuarioProfileDTO.getTelefono(), usuario.getId());

        if (existsAsUsuario) {
            throw new ResourceNotFoundException("Ya existe un usuario con el mismo nombre, apellido y telefono");
        }

        if(usuario.getNombre()!= null){
            usuario.setNombre(usuarioProfileDTO.getNombre());
        }
        if(usuario.getApellido()!= null){
            usuario.setApellido(usuarioProfileDTO.getApellido());
        }
        if(usuario.getTelefono()!= null){
            usuario.setTelefono(usuarioProfileDTO.getTelefono());
        }

        if(usuario.getExperto()!= null){
            usuario.getExperto().setInformacionPersonal(usuarioProfileDTO.getInformacionPersonal());
            usuario.getExperto().setEspecialidad(usuarioProfileDTO.getEspecialidad());
        }
        if (usuario.getPerfil() != null) {
            usuario.getPerfil().setGradoAcademico(usuarioProfileDTO.getGradoAcademico());
            usuario.getPerfil().setDescripcion(usuarioProfileDTO.getDescripcion());
        }
        Usuario updatedUsuario = usuarioRepository.save(usuario);
        return usuarioMapper.toUsuarioProfileDTO(updatedUsuario);

    }


    @Override
    public UsuarioProfileDTO getUsuarioProfileById(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Usuario con id"+id+" no encontrado"));
        // Mapea el usuario a un DTO de perfil
        UsuarioProfileDTO usuarioProfileDTO = usuarioMapper.toUsuarioProfileDTO(usuario);

        // Si el usuario no tiene ni perfil ni experto, usuarioProfileDTO podría estar vacío
        if (usuarioProfileDTO.getEspecialidad() == null && usuarioProfileDTO.getGradoAcademico() == null) {
            return null;
        }

        return usuarioProfileDTO;
    }

    private UsuarioProfileDTO registerUsuarioWithRole(UsuarioRegistrationDTO usuarioRegistrationDTO, ERole roleEnum) {
        //vereficar el email
        boolean existsByEmail = usuarioRepository.existsByEmail(usuarioRegistrationDTO.getEmail());
        //verifica nombre apellido y telefono
        boolean existsAsUsuario = usuarioRepository
                .existsByNombreAndApellidoAndTelefono
                        (usuarioRegistrationDTO.getNombre()
                                , usuarioRegistrationDTO.getApellido()
                                , usuarioRegistrationDTO.getTelefono());

        if (existsByEmail) {
            throw new IllegalArgumentException("El email ya existe");
        }
        if (existsAsUsuario) {
            throw new IllegalArgumentException("El usuario ya existe");
        }

        // si en caso no cumple procedo a llamar al rol enum
        Role role = roleRepository.findByName(roleEnum)
                .orElseThrow(() -> new IllegalArgumentException("No existe el role"));

        //Cifrar la contaseña
        usuarioRegistrationDTO.setPassword(passwordEncoder.encode(usuarioRegistrationDTO.getPassword()));

        //Crear el objeto usuario
        Usuario usuario = usuarioMapper.toUsuarioEntity(usuarioRegistrationDTO);
        usuario.setRole(role);

        if (roleEnum == ERole.USER) {
            Perfil perfil = new Perfil();
            perfil.setGradoAcademico(usuarioRegistrationDTO.getGradoAcademico());
            perfil.setDescripcion(usuarioRegistrationDTO.getDescripcion());
            perfil.setFechaCreate(LocalDateTime.now());

            perfil.setUsuario(usuario);
            usuario.setPerfil(perfil);

        } else if (roleEnum == ERole.EXPERTO) {
            Experto experto = new Experto();
            experto.setEspecialidad(usuarioRegistrationDTO.getEspecialidad());
            experto.setInformacionPersonal(usuarioRegistrationDTO.getInformacionPersonal());
            experto.setFechaCreate(LocalDateTime.now());

            experto.setUsuario(usuario);
            usuario.setExperto(experto);

        }
        Usuario savedUsuario = usuarioRepository.save(usuario);
        return usuarioMapper.toUsuarioProfileDTO(savedUsuario);
    }
}
