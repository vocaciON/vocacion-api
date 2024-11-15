package com.vocaciON.vocacion_service.service;

import com.vocaciON.vocacion_service.dto.ContenidoEducativoCreateUpdateDTO;
import com.vocaciON.vocacion_service.dto.ContenidoEducativoDTO;
import com.vocaciON.vocacion_service.dto.ContenidoEducativoDetailsDTO;
import com.vocaciON.vocacion_service.model.entity.ContenidoEducativo;
import lombok.Data;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

public interface AdminContenidoEducativoService {

    // Obtener la lista completa de los contenidos educativos

    List<ContenidoEducativoDetailsDTO> findAll();//Obtener too

    // Crear el objeto Contenido educativo

    ContenidoEducativoDetailsDTO create(ContenidoEducativoCreateUpdateDTO contenidoEducativoCreateUpdateDTO);

     ContenidoEducativoDetailsDTO findById(Long id);

    // Actualizar contenido educativo
    ContenidoEducativoDetailsDTO update(Long id, ContenidoEducativoCreateUpdateDTO updateContenidoEducativoDTO);

    // Eliminar contenido educativo
    void delete(Long id);

    List<ContenidoEducativoDetailsDTO> findTop6ContenidoEducativoByCreatedAt();


}
