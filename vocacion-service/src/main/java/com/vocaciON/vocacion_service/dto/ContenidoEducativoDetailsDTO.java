package com.vocaciON.vocacion_service.dto;


import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ContenidoEducativoDetailsDTO {

    private Long id;
    private String tituloContenido;
    private String contenido;
    private Boolean favorito;
    private LocalDateTime fechaCreate;
    private String link;




}
