package com.vocaciON.vocacion_service.service;

import com.vocaciON.vocacion_service.model.entity.ContenidoEducativo;

import java.util.List;

public interface AdminContenidoEducativoService {

    // Obtener la lista completa de los contenidos educativos

    List<ContenidoEducativo> getAll();//Obtener too

    // Crear el objeto Contenido educativo

    ContenidoEducativo create(ContenidoEducativo contenidoEducativo);

    //Buscar contenido educativo

    ContenidoEducativo findById(Long id);

    // Actualizar contenido educativo
    ContenidoEducativo update(Long id, ContenidoEducativo updateContenidoEducativo);

    // Eliminar contenido educativo
    void delete(Long id);

}
