package com.vocaciON.vocacion_service.service;

import com.vocaciON.vocacion_service.dto.RespuestaDTO;
import com.vocaciON.vocacion_service.model.entity.Respuesta;

import java.util.List;

public interface AdminRespuestaService {
    //Obtener un listado de todos los expertos
    List<RespuestaDTO> getAll();
    //Metodo de la creacion de un objeto de tipo Experto
    RespuestaDTO create(RespuestaDTO respuesta);
    //Metodo para buscar mediante ID
    RespuestaDTO findById(Long id);
    //Actualiacion de la iformacion de los expertos
    RespuestaDTO update(Long id, RespuestaDTO updateRespuesta);
    //Eliminacion del objeto Experto
    void delete(Long id);


}
