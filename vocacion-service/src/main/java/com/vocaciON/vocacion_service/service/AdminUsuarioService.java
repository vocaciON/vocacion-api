package com.vocaciON.vocacion_service.service;

import com.vocaciON.vocacion_service.dto.UsuarioDTO;
import com.vocaciON.vocacion_service.model.entity.Usuario;

import java.util.List;

public interface AdminUsuarioService {
    //Registro de usuario
    UsuarioDTO registrarUsuario(UsuarioDTO usuario);

    //obtener un listado de usuarios

    List<UsuarioDTO> getAll();//obtener todos

    //Metodo para la creacion de un objeto usuario

    UsuarioDTO create(UsuarioDTO usuario);

    //Vamos a realizar la busqueda mediente el id

    UsuarioDTO findById(Long id);

    // Vamos a realizar la actualizacion del usuario

    UsuarioDTO update(Long id, UsuarioDTO usuarioUpdate);

    // Vamos a realizar la eliminacion de usuarios
    void delete(Long id);

}
