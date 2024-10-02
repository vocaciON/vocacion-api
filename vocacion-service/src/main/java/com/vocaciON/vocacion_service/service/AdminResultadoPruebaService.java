package com.vocaciON.vocacion_service.service;

import com.vocaciON.vocacion_service.model.entity.ResultadoPrueba;

import java.util.List;

public interface AdminResultadoPruebaService {

    //obtener un listado de Resultado de pruebas

    List<ResultadoPrueba> getAll();//obtener todos

    //Metodo para la creacion de un objeto Resultado de pruebas

    ResultadoPrueba create(ResultadoPrueba resultadoPrueba);

    //Vamos a realizar la busqueda mediente el id

    ResultadoPrueba findById(Long id);

    // Vamos a realizar la actualizacion del Resultado de pruebas

    ResultadoPrueba update(Long id, ResultadoPrueba resultadoPruebaUpdate);

    // Vamos a realizar la eliminacion de Resultado de pruebas
    void delete(Long id);
}
