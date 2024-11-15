package com.vocaciON.vocacion_service.service;

import com.vocaciON.vocacion_service.dto.AsesoriaCreateUpdateDTO;
import com.vocaciON.vocacion_service.dto.AsesoriaDTO;
import com.vocaciON.vocacion_service.model.entity.Asesoria;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AdminAsesoriaService {
    //Obtener un listado de todos los expertos
    List<AsesoriaDTO> getAll();
    //Metodo de la creacion de un objeto de tipo Experto
    AsesoriaDTO create(AsesoriaCreateUpdateDTO asesoriaCreateUpdateDTO);
    //Metodo para buscar mediante ID
    AsesoriaDTO findById(Long id);
    //Actualiacion de la iformacion de los expertos
    AsesoriaDTO update(Long id, AsesoriaCreateUpdateDTO updateAsesoriaDTO);


    //Eliminacion del objeto Experto
    void delete(Long id);

}
