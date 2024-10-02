package com.vocaciON.vocacion_service.service;

import com.vocaciON.vocacion_service.model.entity.Asesoria;

import java.util.List;

public interface AdminAsesoriaService {
    //Obtener un listado de todos los expertos
    List<Asesoria> getAll();
    //Metodo de la creacion de un objeto de tipo Experto
    Asesoria create(Asesoria asesoria);
    //Metodo para buscar mediante ID
    Asesoria findById(Long id);
    //Actualiacion de la iformacion de los expertos
    Asesoria update(Long id, Asesoria updateAsesoria);
    //Eliminacion del objeto Experto
    void delete(Long id);

}
