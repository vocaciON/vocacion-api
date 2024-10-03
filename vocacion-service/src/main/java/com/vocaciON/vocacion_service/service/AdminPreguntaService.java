package com.vocaciON.vocacion_service.service;

import com.vocaciON.vocacion_service.model.entity.Pregunta;

import java.util.List;

public interface AdminPreguntaService {
    //Obtener un listado de todos los expertos
    List<Pregunta> getAll();
    //Metodo de la creacion de un objeto de tipo Experto
    Pregunta create(Pregunta pregunta);
    //Metodo para buscar mediante ID
    Pregunta findById(Long id);
    //Actualiacion de la iformacion de los expertos
    Pregunta update(Long id, Pregunta updatePregunta);
    //Eliminacion del objeto Experto
    void delete(Long id);

}
