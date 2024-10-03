package com.vocaciON.vocacion_service.service;

import com.vocaciON.vocacion_service.model.entity.Respuesta;

import java.util.List;

public interface AdminRespuestaService {
    //Obtener un listado de todos los expertos
    List<Respuesta> getAll();
    //Metodo de la creacion de un objeto de tipo Experto
    Respuesta create(Respuesta respuesta);
    //Metodo para buscar mediante ID
    Respuesta findById(Long id);
    //Actualiacion de la iformacion de los expertos
    Respuesta update(Long id, Respuesta updateRespuesta);
    //Eliminacion del objeto Experto
    void delete(Long id);

}
