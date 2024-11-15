package com.vocaciON.vocacion_service.service;

import com.vocaciON.vocacion_service.dto.ResultadoPruebaDTO;
import com.vocaciON.vocacion_service.model.entity.ResultadoPrueba;

import java.util.List;

public interface AdminResultadoPruebaService {

    //obtener un listado de Resultado de pruebas

    List<ResultadoPruebaDTO> getAll();//obtener todos

    //Metodo para la creacion de un objeto Resultado de pruebas

    ResultadoPruebaDTO create(ResultadoPruebaDTO resultadoPrueba);

    //Vamos a realizar la busqueda mediente el id

    ResultadoPruebaDTO findById(Long id);

    // Vamos a realizar la actualizacion del Resultado de pruebas

    ResultadoPruebaDTO update(Long id, ResultadoPruebaDTO resultadoPruebaUpdate);

    // Vamos a realizar la eliminacion de Resultado de pruebas
    void delete(Long id);

}
