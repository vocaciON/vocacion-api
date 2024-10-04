package com.vocaciON.vocacion_service.service;

import com.vocaciON.vocacion_service.dto.PreguntaDTO;
import com.vocaciON.vocacion_service.model.entity.Pregunta;

import java.util.List;

public interface AdminPreguntaService {
    //Obtener un listado de todos los expertos
    List<PreguntaDTO> getAll();
    //Metodo de la creacion de un objeto de tipo Experto
    PreguntaDTO create(PreguntaDTO pregunta);
    //Metodo para buscar mediante ID
    PreguntaDTO findById(Long id);
    //Actualiacion de la iformacion de los expertos
    PreguntaDTO update(Long id, PreguntaDTO updatePregunta);
    //Eliminacion del objeto Experto
    void delete(Long id);


}
