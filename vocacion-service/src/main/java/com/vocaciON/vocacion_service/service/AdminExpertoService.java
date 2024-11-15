package com.vocaciON.vocacion_service.service;


import com.vocaciON.vocacion_service.dto.ExpertoCreateUpdateDTO;
import com.vocaciON.vocacion_service.dto.ExpertoDTO;

import java.util.List;

public interface AdminExpertoService {
    //Obtener un listado de todos los expertos
    List<ExpertoDTO> getAll();

    //Metodo de la creacion de un objeto de tipo Experto
    ExpertoDTO create(ExpertoCreateUpdateDTO expertoCreateUpdateDTO);

    //Metodo para buscar mediante ID
    ExpertoDTO findById(Long id);

    //Actualiacion de la iformacion de los expertos
    ExpertoDTO update(Long id, ExpertoCreateUpdateDTO expertoUpdateDTO);


    //Eliminacion del objeto Experto
    void delete(Long id);

}

