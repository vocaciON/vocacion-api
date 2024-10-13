package com.vocaciON.vocacion_service.service;

import com.vocaciON.vocacion_service.model.entity.ResultadoPrueba;
import java.util.List;

public interface AdminResultadoPruebaService {

    //Listar
    List<ResultadoPrueba> getAll();

    //Crear objeto
    ResultadoPrueba create(ResultadoPrueba resultadoPrueba);

    //Buscar por ID
    ResultadoPrueba findById(Long id);

    //Actualiacion iformación
    ResultadoPrueba update(Long id, ResultadoPrueba updateResultadoPrueba);

    //Eliminar objeto
    void delete(Long id);

}