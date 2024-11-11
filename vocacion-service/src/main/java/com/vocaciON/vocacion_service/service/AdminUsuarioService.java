package com.vocaciON.vocacion_service.service;

import com.vocaciON.vocacion_service.dto.UsuarioDTO;
import com.vocaciON.vocacion_service.dto.UsuarioProfileDTO;
import com.vocaciON.vocacion_service.dto.UsuarioRegistrationDTO;
import com.vocaciON.vocacion_service.model.entity.Usuario;

import java.util.List;

public interface AdminUsuarioService {
    //Registro de Cliente
    UsuarioProfileDTO registerPerfil(UsuarioRegistrationDTO usuarioRegistrationDTO);

    // Registro del Experto
    UsuarioProfileDTO registerExperto(UsuarioRegistrationDTO usuarioRegistrationDTO);

    // Actualizar el perfil del usuario
    UsuarioProfileDTO updateUsuarioProfile(Long id, UsuarioProfileDTO usuarioProfileDTO);

    //Optener la informarcion mediante el Id
    UsuarioProfileDTO getUsuarioProfileById(Long id);

}
