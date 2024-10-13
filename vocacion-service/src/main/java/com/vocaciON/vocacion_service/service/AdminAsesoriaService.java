package com.vocaciON.vocacion_service.service;

import com.vocaciON.vocacion_service.model.entity.Asesoria;
import java.util.List;

public interface AdminAsesoriaService {

    //Listar
    List<Asesoria> getAll();

    //Crear objeto
    Asesoria create(Asesoria asesoria);

    //Buscar por ID
    Asesoria findById(Long id);

    //Actualiacion iformación
    Asesoria update(Long id, Asesoria updateAsesoria);

    //Eliminar objeto
    void delete(Long id);

}