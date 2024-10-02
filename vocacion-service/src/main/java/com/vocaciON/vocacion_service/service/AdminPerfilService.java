package com.vocaciON.vocacion_service.service;

import com.vocaciON.vocacion_service.model.entity.Perfil;

import java.util.List;

public interface AdminPerfilService {

    //Obtener un listado de todos los expertos
    List<Perfil> getAll();
    //Metodo de la creacion de un objeto de tipo Experto
    Perfil create(Perfil perfil);
    //Metodo para buscar mediante ID
    Perfil findById(Long id);
    //Actualiacion de la iformacion de los expertos
    Perfil update(Long id, Perfil updatePerfil);
    //Eliminacion del objeto Experto
    void delete(Long id);

}
