package com.vocaciON.vocacion_service.service;

import com.vocaciON.vocacion_service.model.entity.PruebaVocacional;

import java.util.List;

public interface AdminExpertoService {

    //Obtener un listado de todos los expertos
    List<PruebaVocacional> getAll();
    //Metodo de la creacion de un objeto de tipo Experto
    PruebaVocacional create(PruebaVocacional experto);
    //Metodo para buscar mediante ID
    PruebaVocacional findById(Long id);
    //Actualiacion de la iformacion de los expertos
    PruebaVocacional update(Long id, PruebaVocacional updateExperto);
    //Eliminacion del objeto Experto
    void delete(Long id);




}
