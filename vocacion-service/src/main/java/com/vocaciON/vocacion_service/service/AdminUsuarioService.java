package com.vocaciON.vocacion_service.service;

import com.vocaciON.vocacion_service.dto.*;
import com.vocaciON.vocacion_service.model.entity.Usuario;

import java.util.List;

public interface AdminUsuarioService {
    //Registro de Cliente
    UsuarioProfileDTO registerPerfil(UsuarioRegistrationDTO usuarioRegistrationDTO);

    // Registro del Experto
    UsuarioProfileDTO registerExperto(UsuarioRegistrationDTO usuarioRegistrationDTO);

    //metodo para la autenticacion en el login
    AuthResponseDTO login(LoginDTO loginDTO);

    // Actualizar el perfil del usuario
    UsuarioProfileDTO updateUsuarioProfile(Long id, UsuarioProfileDTO usuarioProfileDTO);

    //Optener la informarcion mediante el Id
    UsuarioProfileDTO getUsuarioProfileById(Long id);

}
