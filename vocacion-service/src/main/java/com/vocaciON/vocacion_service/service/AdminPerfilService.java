package com.vocaciON.vocacion_service.service;

import com.vocaciON.vocacion_service.model.entity.Perfil;
import java.util.List;

public interface AdminPerfilService {

    //Listar
    List<Perfil> getAll();

    //Crear objeto
    Perfil create(Perfil perfil);

    //Buscar por ID
    Perfil findById(Long id);

    //Actualiacion iformación
    Perfil update(Long id, Perfil updatePerfil);

    //Eliminar objeto
    void delete(Long id);

}