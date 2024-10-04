package com.vocaciON.vocacion_service.service;

import com.vocaciON.vocacion_service.model.entity.Carrera;
import com.vocaciON.vocacion_service.dto.CarreraDTO;

import java.util.List;

public interface AdminCarreraService {
    //Obtener un listado de todos los expertos
    List<CarreraDTO> getAll();
    //Metodo de la creacion de un objeto de tipo Experto
    CarreraDTO create(CarreraDTO carreraDTO);
    //Metodo para buscar mediante ID
    CarreraDTO findById(Long id);
    //Actualiacion de la iformacion de los expertos
    CarreraDTO update(Long id, CarreraDTO updateCarreraDTO);
    //Eliminacion del objeto Experto
    void delete(Long id);


}
