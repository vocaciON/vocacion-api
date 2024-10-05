package com.vocaciON.vocacion_service.service;

import com.vocaciON.vocacion_service.dto.RespuestaUsuarioDTO;
import com.vocaciON.vocacion_service.model.entity.RespuestaUsuario;

import java.util.List;

public interface AdminRespuestaUsuarioService {
    //Obtener un listado de todos los expertos
    List<RespuestaUsuarioDTO> getAll();
    //Metodo de la creacion de un objeto de tipo Experto
    RespuestaUsuarioDTO create(RespuestaUsuarioDTO respuestaUsuarioDTO);
    //Metodo para buscar mediante ID
    RespuestaUsuarioDTO findById(Long id);
    //Actualiacion de la iformacion de los expertos
    RespuestaUsuarioDTO update(Long id, RespuestaUsuarioDTO updateRespuestaUsuarioDTO);
    //Eliminacion del objeto Experto
    void delete(Long id);


}
