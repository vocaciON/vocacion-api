package com.vocaciON.vocacion_service.service;

import com.vocaciON.vocacion_service.model.entity.PruebaVocacion;

import java.util.List;

public interface AdminPruebaVocacionService {

    //optener la lista completa de prueba vocacion

    List<PruebaVocacion> getAll();

    // Crear una prueba vocacion

    PruebaVocacion create(PruebaVocacion pruebaVocacion);

    //Buscar las prueba vocacionales

    PruebaVocacion findById(Long id);

    // Actualizar la prueba vocacional primero buscando el id

    PruebaVocacion update(Long id, PruebaVocacion UpdatePruebaVocacion);

    // Eliminar La prueba vocacional

    void delete(Long id);





}
