package com.vocaciON.vocacion_service.service;

import com.vocaciON.vocacion_service.model.entity.Carrera;

import java.util.List;

public interface AdminCarreraService {
    //Obtener un listado de todos los expertos
    List<Carrera> getAll();
    //Metodo de la creacion de un objeto de tipo Experto
    Carrera create(Carrera carrera);
    //Metodo para buscar mediante ID
    Carrera findById(Long id);
    //Actualiacion de la iformacion de los expertos
    Carrera update(Long id, Carrera updateCarrera);
    //Eliminacion del objeto Experto
    void delete(Long id);

}
