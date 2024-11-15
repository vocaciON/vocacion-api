package com.vocaciON.vocacion_service.service;

import com.vocaciON.vocacion_service.dto.ExpertoDTO;
import com.vocaciON.vocacion_service.model.entity.Experto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AdminExpertoService {

    //Obtener un listado de todos los expertos
    List<ExpertoDTO> getAll();
    //Metodo de la creacion de un objeto de tipo Experto
    ExpertoDTO create(ExpertoDTO expertoDTO);
    //Metodo para buscar mediante ID
    ExpertoDTO findById(Long id);
    //Actualiacion de la iformacion de los expertos
    ExpertoDTO update(Long id, ExpertoDTO updateExpertoDTO);



    //Eliminacion del objeto Experto
    void delete(Long id);





}
