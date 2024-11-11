package com.vocaciON.vocacion_service.mapper;

import com.vocaciON.vocacion_service.dto.UsuarioDTO;
import com.vocaciON.vocacion_service.dto.UsuarioProfileDTO;
import com.vocaciON.vocacion_service.dto.UsuarioRegistrationDTO;
import com.vocaciON.vocacion_service.model.entity.Perfil;
import com.vocaciON.vocacion_service.model.entity.Usuario;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
public class UsuarioMapper {
    private final ModelMapper modelMapper;

    public UsuarioMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    // Mapea DTO de registro a entidad Usuario
    public Usuario toUsuarioEntity(UsuarioRegistrationDTO registrationDTO) {
        Usuario usuario = new Usuario();

        usuario.setEmail(registrationDTO.getEmail());
        usuario.setPassword(registrationDTO.getPassword());
        usuario.setNombre(registrationDTO.getNombre());
        usuario.setApellido(registrationDTO.getApellido());
        usuario.setTelefono(registrationDTO.getTelefono());
        usuario.setFechaNacimiento(registrationDTO.getFechaNacimiento());

        // Inicializar el perfil si es nulo
        if (usuario.getPerfil() == null) {
            usuario.setPerfil(new Perfil());
        }

        // Asignar valores del perfil
        if (registrationDTO.getGradoAcademico() != null) {
            usuario.getPerfil().setGradoAcademico(registrationDTO.getGradoAcademico());
        }
        if (registrationDTO.getDescripcion() != null) {
            usuario.getPerfil().setDescripcion(registrationDTO.getDescripcion());
        }

        return usuario;
    }

    // Mapea entidad Usuario a DTO de Perfil de Usuario
    public UsuarioProfileDTO toUsuarioProfileDTO(Usuario usuario) {
        UsuarioProfileDTO usuarioProfileDTO = new UsuarioProfileDTO();
        usuarioProfileDTO.setId(usuario.getId());
        usuarioProfileDTO.setNombre(usuario.getNombre());
        usuarioProfileDTO.setApellido(usuario.getApellido());
        usuarioProfileDTO.setTelefono(usuario.getTelefono());
        usuarioProfileDTO.setEmail(usuario.getEmail());
        usuarioProfileDTO.setFechaNacimiento(usuario.getFechaNacimiento());

        // Asignar el rol si existe
        if (usuario.getRole() != null) {
            usuarioProfileDTO.setRole(usuario.getRole().getName());
        }

        // Asignar los campos del perfil si existen
        if (usuario.getPerfil() != null) {
            usuarioProfileDTO.setGradoAcademico(usuario.getPerfil().getGradoAcademico());
            usuarioProfileDTO.setDescripcion(usuario.getPerfil().getDescripcion());
        }

        // Asignar los campos de experto si existen
        if (usuario.getExperto() != null) {
            usuarioProfileDTO.setEspecialidad(usuario.getExperto().getEspecialidad());
            usuarioProfileDTO.setInformacionPersonal(usuario.getExperto().getInformacionPersonal());
        }

        return usuarioProfileDTO;
    }
    //////////////////////////Metodo para el loginDTO y para el authresponseDTO
}


