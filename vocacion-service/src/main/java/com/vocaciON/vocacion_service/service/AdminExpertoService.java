package com.vocaciON.vocacion_service.service;

import com.vocaciON.vocacion_service.model.entity.Experto;

import java.util.List;

public interface AdminExpertoService {

    //Obtener un listado de todos los expertos
    List<Experto> getAll();
    //Metodo de la creacion de un objeto de tipo Experto
    Experto create(Experto experto);
    //Metodo para buscar mediante ID
    Experto findById(Long id);
    //Actualiacion de la iformacion de los expertos
    Experto update(Long id, Experto updateExperto);
    //Eliminacion del objeto Experto
    void delete(Long id);




}
