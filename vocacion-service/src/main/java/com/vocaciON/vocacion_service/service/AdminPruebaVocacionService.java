package com.vocaciON.vocacion_service.service;

import com.vocaciON.vocacion_service.dto.PruebaVocacionDTO;
import com.vocaciON.vocacion_service.model.entity.PruebaVocacion;

import java.util.List;

public interface AdminPruebaVocacionService {

    //optener la lista completa de prueba vocacion

    List<PruebaVocacionDTO> getAll();

    // Crear una prueba vocacion

    PruebaVocacionDTO create(PruebaVocacionDTO pruebaVocacionDTO);

    //Buscar las prueba vocacionales

    PruebaVocacionDTO findById(Long id);

    // Actualizar la prueba vocacional primero buscando el id

    PruebaVocacionDTO update(Long id, PruebaVocacionDTO updatePruebaVocacionDTO);

    // Eliminar La prueba vocacional

    void delete(Long id);






}
