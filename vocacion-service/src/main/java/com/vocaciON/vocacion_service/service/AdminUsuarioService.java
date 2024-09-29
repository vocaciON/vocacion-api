package com.vocaciON.vocacion_service.service;

import com.vocaciON.vocacion_service.model.entity.Usuario;

import java.util.List;

public interface AdminUsuarioService {
    //obtener un listado de usuarios

    List<Usuario> getAll();//obtener todos

    //Metodo para la creacion de un objeto usuario

    Usuario create(Usuario usuario);

    //Vamos a realizar la busqueda mediente el id

    Usuario findById(Long id);

    // Vamos a realizar la actualizacion del usuario

    Usuario update(Long id, Usuario usuarioUpdate);

    // Vamos a realizar la eliminacion de usuarios
    void delete(Long id);
}
