package com.vocaciON.vocacion_service.service;

import com.vocaciON.vocacion_service.dto.ContenidoEducativoDTO;
import com.vocaciON.vocacion_service.model.entity.ContenidoEducativo;
import lombok.Data;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

public interface AdminContenidoEducativoService {

    // Obtener la lista completa de los contenidos educativos

    List<ContenidoEducativoDTO> getAll();//Obtener too

    // Crear el objeto Contenido educativo

    ContenidoEducativoDTO create(ContenidoEducativoDTO contenidoEducativo);

    //Buscar contenido educativo

    @Transactional
    ContenidoEducativo create(ContenidoEducativo contenidoEducativo);

    ContenidoEducativoDTO findById(Long id);

    // Actualizar contenido educativo
    ContenidoEducativoDTO update(Long id, ContenidoEducativoDTO updateContenidoEducativo);

    // Eliminar contenido educativo
    void delete(Long id);


}
