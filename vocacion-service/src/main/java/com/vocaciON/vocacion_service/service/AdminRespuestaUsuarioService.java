package com.vocaciON.vocacion_service.service;

import com.vocaciON.vocacion_service.model.entity.RespuestaUsuario;

import java.util.List;

public interface AdminRespuestaUsuarioService {
    //Obtener un listado de todos los expertos
    List<RespuestaUsuario> getAll();
    //Metodo de la creacion de un objeto de tipo Experto
    RespuestaUsuario create(RespuestaUsuario respuestaUsuario);
    //Metodo para buscar mediante ID
    RespuestaUsuario findById(Long id);
    //Actualiacion de la iformacion de los expertos
    RespuestaUsuario update(Long id, RespuestaUsuario updateRespuestaUsuario);
    //Eliminacion del objeto Experto
    void delete(Long id);

}
