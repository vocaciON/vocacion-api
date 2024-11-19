package com.vocaciON.vocacion_service.service;

import com.vocaciON.vocacion_service.dto.CompraPlanCreateDTO;

import com.vocaciON.vocacion_service.dto.CompraPlanDTO;
import com.vocaciON.vocacion_service.model.entity.Usuario;

import java.util.List;

public interface AdminCompraPlanService {
    //Obtener un listado de todos los expertos
    List<CompraPlanDTO> getAll();
    //Metodo de la creacion de un objeto de tipo Experto
    CompraPlanDTO create(CompraPlanCreateDTO compraPlanCreateDTO);
    //Metodo para buscar mediante ID
    CompraPlanDTO findById(Long id);
    //Actualiacion de la iformacion de los planes
    CompraPlanDTO update(Long id, CompraPlanCreateDTO updatePlanDTO);



    //Eliminacion del objeto Experto
    void delete(Long id);
}
