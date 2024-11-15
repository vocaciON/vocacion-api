package com.vocaciON.vocacion_service.service;

import com.vocaciON.vocacion_service.dto.PerfilDTO;
import com.vocaciON.vocacion_service.model.entity.Perfil;

import java.util.List;

public interface AdminPerfilService {

    //Obtener un listado de todos los expertos
    List<PerfilDTO> getAll();
    //Metodo de la creacion de un objeto de tipo Experto
    PerfilDTO create(PerfilDTO perfilDTO);
    //Metodo para buscar mediante ID
    PerfilDTO findById(Long id);
    //Actualiacion de la iformacion de los expertos
    PerfilDTO update(Long id, PerfilDTO updatePerfilDTO);
    //Eliminacion del objeto Experto
    void delete(Long id);


}
